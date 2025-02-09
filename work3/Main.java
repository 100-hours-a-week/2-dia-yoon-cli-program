package work3;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        
        IncrementThread t1 = new IncrementThread(counter);
        IncrementThread t2 = new IncrementThread(counter);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Counter Value: " + counter.getValue());
        System.out.println("Expected Value: 2000 (If no race condition occurs)");
    }
}
