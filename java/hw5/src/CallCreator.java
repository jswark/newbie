import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;

public class CallCreator implements Runnable {
    private final ConcurrentLinkedQueue<Call> queue;
    private final int floorNum;
    private int callNum;
    private final long duration;
    private final long startTime;

    CallCreator(ConcurrentLinkedQueue<Call> queue, int floorNum, long duration) {
        this.queue = queue;
        this.floorNum = floorNum;
        this.duration = duration;
        this.startTime = System.currentTimeMillis();
    }

    public void run() {
        while ((System.currentTimeMillis() - startTime) < duration) {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(0, 500 + 1));

                int from = ThreadLocalRandom.current().nextInt(0, floorNum + 1);
                int to = ThreadLocalRandom.current().nextInt(0, floorNum + 1);

                while (from == to) to = ThreadLocalRandom.current().nextInt(0, floorNum + 1);
                queue.add(new Call(from, to, callNum));
                callNum++;
            } catch (InterruptedException ignored) {
            }
        }
    }
}
