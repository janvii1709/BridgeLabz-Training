public class BackgroundJobExecution {
    public static void main(String[] args) {
        Runnable task1 = () -> {
            System.out.println("Task 1 started...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Task 1 interrupted");
            }
            System.out.println("Task 1 completed.");
        };
        Runnable task2 = () -> {
            System.out.println("Task 2 started...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Task 2 interrupted");
            }
            System.out.println("Task 2 completed.");
        };
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        t1.start();
        t2.start();
        System.out.println("Main thread continues execution...");
    }
}
