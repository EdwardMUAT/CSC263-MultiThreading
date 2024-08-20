// Implementing the Runnable interface
class MyRunnable implements Runnable {
    private String threadName;

    public MyRunnable(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(threadName + " is running - count: " + i);
                Thread.sleep(500); // Sleep for 500 milliseconds
            }
        } catch (InterruptedException e) {
            System.out.println(threadName + " was interrupted.");
        }
        System.out.println(threadName + " has finished.");
    }
}

// Main class to run the threads
public class Threading {
    public static void main(String[] args) {
        // Create two Runnable objects
        Runnable runnable1 = new MyRunnable("Thread 1");
        Runnable runnable2 = new MyRunnable("Thread 2");

        // Create Thread objects and pass the Runnable objects
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        // Start the threads
        thread1.start();
        thread2.start();

        try {
            // Wait for both threads to finish
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }

        System.out.println("Both threads have finished.");
    }
}
