import java.util.*;

class PrintJob implements Runnable {

    private String jobName;
    private int pages;
    private int priority;

    private static final Object PRINTER = new Object();

    PrintJob(String jobName, int pages, int priority) {
        this.jobName = jobName;
        this.pages = pages;
        this.priority = priority;
    }

    @Override
    public void run() {
        synchronized (PRINTER) {
            for (int i = 1; i <= pages; i++) {
                try {
                    Thread.sleep(100); // 100ms per page
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(
                        "[" + priorityLabel() + "] Printing " +
                        jobName + " - Page " + i + " of " + pages
                );
            }
        }
    }

    private String priorityLabel() {
        if (priority >= 7) return "High Priority";
        if (priority >= 5) return "Medium Priority";
        return "Low Priority";
    }
}

public class PrintShopScheduler {

    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of print jobs: ");
        int n = sc.nextInt();
        sc.nextLine();

        PrintJob[] jobs = new PrintJob[n];
        Thread[] threads = new Thread[n];

        System.out.println("\nEnter job details:");
        for (int i = 0; i < n; i++) {
            System.out.print("Job name: ");
            String name = sc.nextLine();

            System.out.print("Pages: ");
            int pages = sc.nextInt();

            System.out.print("Priority (1 - 10): ");
            int priority = sc.nextInt();
            sc.nextLine();

            jobs[i] = new PrintJob(name, pages, priority);
            threads[i] = new Thread(jobs[i], "Thread-" + (i + 1));
            threads[i].setPriority(priority);
        }
        long startTime = System.currentTimeMillis();
        System.out.println("\nStarting print jobs...\n");

        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("\nAll jobs completed in " +
                (endTime - startTime) + "ms");
    }
}
