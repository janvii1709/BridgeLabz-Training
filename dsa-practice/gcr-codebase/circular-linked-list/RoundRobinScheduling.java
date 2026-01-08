import java.util.Scanner;

class RoundRobin {

    class Process {
        int pid, burst, remaining, priority, waiting = 0;
        Process next;

        Process(int pid, int burst, int priority) {
            this.pid = pid;
            this.burst = burst;
            this.remaining = burst;
            this.priority = priority;
        }
    }

    Process head = null;
    int pidCounter = 1;

    // ADD PROCESS
    void addProcess(int burst, int priority) {
        Process p = new Process(pidCounter++, burst, priority);

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
        System.out.println("Process P" + p.pid + " added");
    }

    // REMOVE PROCESS BY PID
    void removeProcessByPID(int pid) {
        if (head == null) {
            System.out.println("Queue empty");
            return;
        }

        Process curr = head, prev = null;

        do {
            if (curr.pid == pid) {

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

    // DISPLAY QUEUE
    void displayQueue() {
        if (head == null) {
            System.out.println("Queue Empty");
            return;
        }
        Process temp = head;
        System.out.print("Queue: ");
        do {
            System.out.print("P" + temp.pid + "(RT:" + temp.remaining + ") ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    // ROUND ROBIN
    void roundRobin(int tq) {
        if (head == null) {
            System.out.println("No processes to execute");
            return;
        }

        int totalWT = 0, totalTAT = 0, completed = 0;
        Process curr = head, prev = null;

        while (head != null) {

            int exec = Math.min(tq, curr.remaining);
            curr.remaining -= exec;

            Process temp = head;
            do {
                if (temp != curr)
                    temp.waiting += exec;
                temp = temp.next;
            } while (temp != head);

            System.out.println("\nExecuting P" + curr.pid + " for " + exec + " units");
            displayQueue();

            if (curr.remaining == 0) {
                int tat = curr.waiting + curr.burst;
                totalWT += curr.waiting;
                totalTAT += tat;
                completed++;

                System.out.println("Process P" + curr.pid + " completed");

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
        System.out.println("Average Waiting Time = " + (double) totalWT / completed);
        System.out.println("Average Turnaround Time = " + (double) totalTAT / completed);
    }

    // MAIN
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RoundRobin rr = new RoundRobin();

        while (true) {
            System.out.println("\n1.Add Process");
            System.out.println("2.Remove Process by PID");
            System.out.println("3.Display Queue");
            System.out.println("4.Run Round Robin");
            System.out.println("5.Exit");

            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter Burst Time: ");
                    int bt = sc.nextInt();
                    System.out.print("Enter Priority: ");
                    int pr = sc.nextInt();
                    rr.addProcess(bt, pr);
                    break;

                case 2:
                    System.out.print("Enter PID to remove: ");
                    int pid = sc.nextInt();
                    rr.removeProcessByPID(pid);
                    break;

                case 3:
                    rr.displayQueue();
                    break;

                case 4:
                    System.out.print("Enter Time Quantum: ");
                    int tq = sc.nextInt();
                    rr.roundRobin(tq);
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
