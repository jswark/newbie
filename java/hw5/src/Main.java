import java.util.concurrent.ConcurrentLinkedQueue;

class Main {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<Call> queue = new ConcurrentLinkedQueue<Call>();

        int nTicks = 200; // Количесво обновлений состояний лифтов, в течении которых будут генерироваться новые запросы
        int nFloors = 10; // Количество этажей в доме
        int nElevators = 10; // Количество лифтов в доме
        House myHome = new House(nTicks, nFloors, nElevators);

        CallCreator sender = new CallCreator(queue, myHome.getnFloors(), myHome.getnTicks() * 500); // nTicks * 500 задержка между обновлениями состояний
        ElevatorManager receiver = new ElevatorManager(queue, myHome.getnElevators(), myHome.getnTicks() * 500);

        new Thread(sender).start();
        new Thread(receiver).start();
    }
}
