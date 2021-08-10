import java.util.ArrayList;

public class Elevator {
    private int currentFloor;
    private int destFloor;
    private final int num; // номер лифта
    private final int capacity;
    private int passengerNumber = 0; // текущее число людей в лифте
    private final ArrayList<Call> tasks; // задачи лифта

    Elevator(int num, int capacity) {
        this.num = num;
        this.tasks = new ArrayList<>();
        this.capacity = capacity;
    }

    public int getCurrent() {
        return currentFloor;
    }

    public int getDest() {
        return destFloor;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public boolean isEnoughSpace() {
        return passengerNumber < capacity;
    }

    // Добавление новой задачи
    public void addCall(Call call) {
        System.out.println("Call " + call.getNum() + " assigned to elevator " + num);
        // В зависимости от направления движения лифта, изменяем точку назначения
        if (currentFloor < destFloor) {
            if (call.getTo() > destFloor)
                destFloor = call.getTo();
        } else if (currentFloor > destFloor) {
            if (call.getTo() < destFloor)
                destFloor = call.getTo();
        } else {
            // Если лифт стоит, выбираем в качестве точки назначения самую удалённую из вызовов
            chooseFar();
        }
        tasks.add(call);
    }

    private void chooseFar() {
        int diff = 0;
        for (Call call : tasks) {
            if (Math.abs(currentFloor - call.getTo()) > diff) {
                diff = Math.abs(currentFloor - call.getTo());
                destFloor = call.getTo();
            }
        }
    }

    // Изменение состояния лифта
    public void tick() {
        for (int i = 0; i < tasks.size(); i++) {
            // Посадка
            if ((tasks.get(i).getFrom() == currentFloor) && (!tasks.get(i).isTaken()) && (passengerNumber < capacity)) {
                passengerNumber += 1;
                tasks.set(i, tasks.get(i).take());
                System.out.println("Passenger taken on floor " + tasks.get(i).getFrom() +
                        " by elevator " + num + " | call " + tasks.get(i).getNum());
            }

            // Высаживаем
            if ((tasks.get(i).getTo() == currentFloor) && (tasks.get(i).isTaken())) {
                passengerNumber -= 1;
                System.out.println("Passenger delivered to floor " + tasks.get(i).getTo() +
                        " by elevator " + num + " | call " + tasks.get(i).getNum());
                tasks.remove(i); // удаляем таску, если высадили пассажира
            }
        }
        // Двигаем лифт
        if (currentFloor < destFloor) {
            currentFloor += 1;
        } else if (currentFloor > destFloor) {
            currentFloor -= 1;
        } else {
            // Если лифт стоит, выбираем в качестве точки назначения самую удалённую из вызовов
            chooseFar();
        }
    }
}
