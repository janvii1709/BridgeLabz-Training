import java.util.Scanner;

public class RoundRobinScheduling {

    // Node class
    class Process {
        private int pid;
        private int burstTime;
        private int remainingTime;
        private int priority;
        private int waitingTime;
        Process next;

        Process(int pid, int burstTime, int priority) {
            this.pid = pid;
            this.burstTime = burstTime;
            this.remainingTime = burstTime;
            this.priority = priority;
            this.waitingTime = 0;
            this.next = null;
        }

        int getPid() {
            return pid;
        }

        int getBurstTime() {
            return burstTime;
        }

        int getRemainingTime() {
            return remainingTime;
        }

        void reduceTime(int time) {
            remainingTime -= time;
        }

        void addWaiting(int time) {
            waitingTime += time;
        }

        int getWaitingTime() {
            return waitingTime;
        }
    }

    private Process head = null;
    private int pidCounter = 1;

    // Add process
    void addProcess(int burstTime, int priority) {
        Process p = new Process(pidCounter++, burstTime, priority);

        if (head == null) {
            head = p;
            p.next = head;
        } else {
            Process temp = head;
            while (temp.next != head)
                temp = temp.next;

            temp.next = p;
            p.next = head;
        }
        System.out.println("Process P" + p.getPid() + " added");
    }

    // Remove process by PID
    void removeProcess(int pid) {
        if (head == null) {
            System.out.println("Queue is empty");
            return;
        }

        Process curr = head;
        Process prev = null;

        do {
            if (curr.getPid() == pid) {

                if (curr == head && curr.next == head) {
                    head = null;
                } else {
                    if (curr == head)
                        head = head.next;

                    prev.next = curr.next;
                }

                System.out.println("Process P" + pid + " removed");
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);

        System.out.println("Process not found");
    }

    // Display queue
    void displayQueue() {
        if (head == null) {
            System.out.println("Queue Empty");
            return;
        }

        Process temp = head;
        System.out.print("Queue: ");
        do {
            System.out.print("P" + temp.getPid() +
                    "(RT:" + temp.getRemainingTime() + ") ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    // Round Robin Scheduling
    void runRoundRobin(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to execute");
            return;
        }

        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int completed = 0;

        Process curr = head;
        Process prev = null;

        while (head != null) {

            int execTime = Math.min(timeQuantum, curr.getRemainingTime());
            curr.reduceTime(execTime);

            Process temp = head;
            do {
                if (temp != curr)
                    temp.addWaiting(execTime);
                temp = temp.next;
            } while (temp != head);

            System.out.println("\nExecuting P" + curr.getPid() +
                    " for " + execTime + " units");
            displayQueue();

            if (curr.getRemainingTime() == 0) {
                int tat = curr.getWaitingTime() + curr.getBurstTime();

                totalWaitingTime += curr.getWaitingTime();
                totalTurnaroundTime += tat;
                completed++;

                System.out.println("Process P" + curr.getPid() + " completed");

                if (curr == head && curr.next == head) {
                    head = null;
                    break;
                }

                if (curr == head)
                    head = head.next;

                prev.next = curr.next;
                curr = prev.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        System.out.println("\nAll processes completed");
        System.out.println("Average Waiting Time = " +
                (double) totalWaitingTime / completed);
        System.out.println("Average Turnaround Time = " +
                (double) totalTurnaroundTime / completed);
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        RoundRobinScheduling scheduler = new RoundRobinScheduling();

        while (true) {
            System.out.println("\n1. Add Process");
            System.out.println("2. Remove Process by PID");
            System.out.println("3. Display Queue");
            System.out.println("4. Run Round Robin");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Burst Time: ");
                    int bt = sc.nextInt();
                    System.out.print("Enter Priority: ");
                    int pr = sc.nextInt();
                    scheduler.addProcess(bt, pr);
                    break;

                case 2:
                    System.out.print("Enter PID to remove: ");
                    scheduler.removeProcess(sc.nextInt());
                    break;

                case 3:
                    scheduler.displayQueue();
                    break;

                case 4:
                    System.out.print("Enter Time Quantum: ");
                    scheduler.runRoundRobin(sc.nextInt());
                    break;

                case 5:
                    System.out.println("Exit");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
