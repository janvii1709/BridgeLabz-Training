import java.text.SimpleDateFormat;
import java.util.*;

class TaskRunner implements Runnable {

    public void run() {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < 1000) {
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class StateMonitor implements Runnable {

    private Thread[] threads;
    private Map<String, Set<Thread.State>> stateMap = new HashMap<>();

    StateMonitor(Thread[] threads) {
        this.threads = threads;
        for (Thread t : threads) {
            stateMap.put(t.getName(), new HashSet<>());
        }
    }

    public void run() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        boolean active = true;
        while (active) {
            active = false;

            for (Thread t : threads) {
                Thread.State state = t.getState();
                stateMap.get(t.getName()).add(state);

                System.out.println("[Monitor] " + t.getName() +
                        " is in " + state +
                        " state at " + sdf.format(new Date()));

                if (state != Thread.State.TERMINATED) {
                    active = true;
                }
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nSummary:");
        for (String name : stateMap.keySet()) {
            System.out.println(name + " went through " +
                    stateMap.get(name).size() + " states");
        }
    }
}

public class ThreadStateMonitoringSystem {

    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of task threads: ");
        int n = sc.nextInt();
        sc.nextLine();

        Thread[] tasks = new Thread[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter task name: ");
            String name = sc.nextLine();
            tasks[i] = new Thread(new TaskRunner(), name);
        }

        Thread monitor = new Thread(new StateMonitor(tasks), "StateMonitor");

        monitor.start();

        Thread.sleep(300);

        for (Thread t : tasks) {
            t.start();
        }

        for (Thread t : tasks) {
            t.join();
        }

        monitor.join();
    }
}
