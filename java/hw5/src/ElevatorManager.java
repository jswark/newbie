import java.util.concurrent.ConcurrentLinkedQueue;

public class ElevatorManager implements Runnable {
    private final ConcurrentLinkedQueue<Call> queue;
    private int tick;
    private final long duration;
    private final long startTime;
    private final Elevator[] elevators;

    ElevatorManager(ConcurrentLinkedQueue<Call> queue, int elevatorsNum, long liveTime) {
        this.queue = queue;
        this.duration = liveTime;
        this.startTime = System.currentTimeMillis();
        this.elevators = new Elevator[elevatorsNum];
        for (int i = 0; i < elevatorsNum; ++i) {
            this.elevators[i] = new Elevator(i, 10);
        }
    }

    public enum ElevatorDirection {
        UP,
        DOWN
    }

    // Алгоритм выбора лифта для запроса
    /*
    Приоритетно выбираем лифт, который находится ближе к нужному этажу и движется в его направлении + имеет больше свободных мест.
     */

    private int chooseElevator(Elevator[] elevators, Call call) {
        int scheduleTo = 0;
        int priority = -1000;
        // Определяем направление вызова
        ElevatorDirection callDirection = (call.getFrom() - call.getTo() > 0) ? ElevatorDirection.DOWN : ElevatorDirection.UP;

        for (int i = 0; i < elevators.length; i++) {
            // Определяем направление движения лифта
            ElevatorDirection elevatorDirection = (elevators[i].getCurrent() - elevators[i].getDest() > 0) ? ElevatorDirection.DOWN : ElevatorDirection.UP;
            boolean isSameDirection = (callDirection == elevatorDirection);
            int priorityRate = 0;
            // Если лифт движется по пути с вызовом
            if (isSameDirection) {
                // Если лифт на этаже вызова и в нём достаточно места, то мы сразу отдаём ему этот вызов
                if (call.getFrom() == elevators[i].getCurrent() && elevators[i].isEnoughSpace()) {
                    return i;
                }
                // Понижаем приоритет на количество человек в лифте
                priorityRate -= elevators[i].getPassengerNumber();
                // Понижаем приоритет на расстояние между текущей точкой и точкой вызова
                priorityRate -= Math.abs(call.getFrom() - elevators[i].getCurrent());
                // Повышаем приоритет на расстояние, которое лифт уже гарантированно пройдёт
                priorityRate += Math.abs(elevators[i].getCurrent() - elevators[i].getDest());
                // Повышаем приоритет потому что лифт движется в нужном направлении
                priorityRate += 10;
            }
            // Если лифт движется в обратном направлении с вызовом
            else {
                // Понижаем приоритет на количество человек в лифте
                priorityRate -= elevators[i].getPassengerNumber();
                // Понижаем приоритет на расстояние, которое лифт уже гарантированно пройдёт
                priorityRate -= Math.abs(elevators[i].getCurrent() - elevators[i].getDest());
                // Понижаем приоритет на расстояние между точкой назначения лифта и точкой вызова
                priorityRate -= Math.abs(call.getFrom() - elevators[i].getDest());
            }
            // Выбираем лифт, который имеет бОльший приоритет в нашей системе
            if (priorityRate > priority) {
                priority = priorityRate;
                scheduleTo = i;
            }
        }
        return scheduleTo;
    }

    public void run() {
        int stillProcessing = 0;
        while (((System.currentTimeMillis() - startTime) < duration) || (stillProcessing > 0)) {
            stillProcessing = 0;
            try {
                Thread.sleep(500);
                System.out.println("\nTick " + tick + "\n");
                tick += 1;
                // Добавляем вызовы
                while (queue.peek() != null) {
                    Call call = queue.poll();
                    elevators[chooseElevator(elevators, call)].addCall(call);
                }
                for (Elevator elevator : elevators) {
                    // Изменяем состояние лифтов
                    elevator.tick();
                    stillProcessing += 5;
                }
            } catch (InterruptedException ignored) {
            }
        }
    }
}
