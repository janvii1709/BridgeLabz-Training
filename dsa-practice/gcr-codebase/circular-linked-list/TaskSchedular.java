import java.util.Scanner;

public class TaskSchedular {

    // Task node for Circular Linked List
    static class Task {
        int taskId;          // Task ID
        String taskName;     // Task Name
        int priority;        // Task Priority
        String dueDate;      // Task Due Date
        Task next;           // Pointer to next task
    }

    // Head points to first task
    static Task head = null;

    //  ADD AT BEGINNING 
    static void addAtBeginning(int id, String name, int p, String date) {
        Task newTask = new Task();
        newTask.taskId = id;
        newTask.taskName = name;
        newTask.priority = p;
        newTask.dueDate = date;

        // If list is empty
        if (head == null) {
            head = newTask;
            newTask.next = head; // circular link
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newTask.next = head;
            temp.next = newTask;
            head = newTask;
        }

        System.out.println("Task added successfully");
    }

    //  ADD AT END 
    static void addAtEnd(int id, String name, int p, String date) {
        Task newTask = new Task();
        newTask.taskId = id;
        newTask.taskName = name;
        newTask.priority = p;
        newTask.dueDate = date;

        if (head == null) {
            head = newTask;
            newTask.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
        }

        System.out.println("Task added successfully");
    }

    //  ADD AT SPECIFIC POSITION
    static void addAtPosition(int pos, int id, String name, int p, String date) {

        if (pos == 1) {
            addAtBeginning(id, name, p, date);
            return;
        }

        Task temp = head;
        for (int i = 1; i < pos - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        Task newTask = new Task();
        newTask.taskId = id;
        newTask.taskName = name;
        newTask.priority = p;
        newTask.dueDate = date;

        newTask.next = temp.next;
        temp.next = newTask;

        System.out.println("Task added successfully");
    }

    //DELETE BY TASK ID 
    static void deleteByTaskId(int id) {

        if (head == null) {
            System.out.println("No tasks found");
            return;
        }

        // If only one node
        if (head.taskId == id && head.next == head) {
            head = null;
            System.out.println("Task removed successfully");
            return;
        }

        // If head needs to be deleted
        if (head.taskId == id) {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            head = head.next;
            temp.next = head;
            System.out.println("Task removed successfully");
            return;
        }

        Task curr = head;
        while (curr.next != head && curr.next.taskId != id) {
            curr = curr.next;
        }

        if (curr.next == head) {
            System.out.println("Task not found");
        } else {
            curr.next = curr.next.next;
            System.out.println("Task removed successfully");
        }
    }

    // VIEW CURRENT TASK & MOVE NEXT
    static void viewCurrentAndNext() {

        if (head == null) {
            System.out.println("No tasks available");
            return;
        }

        System.out.println("Current Task:");
        printTask(head);

        head = head.next; // move to next task
    }

    // DISPLAY ALL TASKS
    static void displayAll() {

        if (head == null) {
            System.out.println("No tasks available");
            return;
        }

        Task temp = head;
        System.out.println("All Tasks:");

        do {
            printTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // SEARCH BY PRIORITY 
    static void searchByPriority(int p) {

        if (head == null) {
            System.out.println("No tasks available");
            return;
        }

        Task temp = head;
        boolean found = false;

        do {
            if (temp.priority == p) {
                printTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No task found with this priority");
        }
    }

    // PRINT TASK DETAILS 
    static void printTask(Task t) {
        System.out.println("Task ID: " + t.taskId);
        System.out.println("Task Name: " + t.taskName);
        System.out.println("Priority: " + t.priority);
        System.out.println("Due Date: " + t.dueDate);
        System.out.println("---------------------------");
    }

    // MAIN METHOD 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Specific Position");
            System.out.println("4. Remove Task by Task ID");
            System.out.println("5. View Current Task & Move Next");
            System.out.println("6. Display All Tasks");
            System.out.println("7. Search Task by Priority");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter Task ID: ");
                    int id1 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Task Name: ");
                    String name1 = sc.nextLine();
                    System.out.print("Enter Priority: ");
                    int p1 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Due Date: ");
                    String d1 = sc.nextLine();
                    addAtBeginning(id1, name1, p1, d1);
                    break;

                case 2:
                    System.out.print("Enter Task ID: ");
                    int id2 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Task Name: ");
                    String name2 = sc.nextLine();
                    System.out.print("Enter Priority: ");
                    int p2 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Due Date: ");
                    String d2 = sc.nextLine();
                    addAtEnd(id2, name2, p2, d2);
                    break;

                case 3:
                    System.out.print("Enter Position: ");
                    int pos = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Task ID: ");
                    int id3 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Task Name: ");
                    String name3 = sc.nextLine();
                    System.out.print("Enter Priority: ");
                    int p3 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Due Date: ");
                    String d3 = sc.nextLine();
                    addAtPosition(pos, id3, name3, p3, d3);
                    break;

                case 4:
                    System.out.print("Enter Task ID to remove: ");
                    deleteByTaskId(sc.nextInt());
                    break;

                case 5:
                    viewCurrentAndNext();
                    break;

                case 6:
                    displayAll();
                    break;

                case 7:
                    System.out.print("Enter Priority to search: ");
                    searchByPriority(sc.nextInt());
                    break;

                case 8:
                    System.out.println("Exiting the program");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 8);
    }
}
