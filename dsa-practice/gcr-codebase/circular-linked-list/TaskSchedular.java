import java.util.Scanner;

public class TaskSchedular {

    // Node of Circular Linked List
    static class Task {
        int taskId;
        String taskName;
        int priority;
        String dueDate;
        Task next;
    }

    // Head of circular list
    static Task head = null;

    // ADD TASK AT BEGINNING
    static void addTaskAtBeginning(int id, String name, int priority, String date) {
        Task newTask = new Task();
        newTask.taskId = id;
        newTask.taskName = name;
        newTask.priority = priority;
        newTask.dueDate = date;

        if (head == null) {
            head = newTask;
            newTask.next = head;
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

    // ADD TASK AT END
    static void addTaskAtEnd(int id, String name, int priority, String date) {
        Task newTask = new Task();
        newTask.taskId = id;
        newTask.taskName = name;
        newTask.priority = priority;
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

    // ADD TASK AT SPECIFIC POSITION
    static void addTaskAtPosition(int position, int id, String name, int priority, String date) {

        if (position == 1) {
            addTaskAtBeginning(id, name, priority, date);
            return;
        }

        Task temp = head;
        for (int i = 1; i < position - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        Task newTask = new Task();
        newTask.taskId = id;
        newTask.taskName = name;
        newTask.priority = priority;
        newTask.dueDate = date;

        newTask.next = temp.next;
        temp.next = newTask;

        System.out.println("Task added successfully");
    }

    // DELETE TASK BY ID
    static void deleteTaskById(int id) {

        if (head == null) {
            System.out.println("No tasks available");
            return;
        }

        if (head.taskId == id && head.next == head) {
            head = null;
            System.out.println("Task removed successfully");
            return;
        }

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

        Task current = head;
        while (current.next != head && current.next.taskId != id) {
            current = current.next;
        }

        if (current.next == head) {
            System.out.println("Task not found");
        } else {
            current.next = current.next.next;
            System.out.println("Task removed successfully");
        }
    }

    // VIEW CURRENT TASK AND MOVE TO NEXT
    static void viewCurrentTask() {
        if (head == null) {
            System.out.println("No tasks available");
            return;
        }

        System.out.println("Current Task:");
        printTask(head);
        head = head.next;
    }

    // DISPLAY ALL TASKS
    static void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks available");
            return;
        }

        Task temp = head;
        do {
            printTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // SEARCH TASK BY PRIORITY
    static void searchTaskByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available");
            return;
        }

        Task temp = head;
        boolean found = false;

        do {
            if (temp.priority == priority) {
                printTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No task found with given priority");
        }
    }

    // PRINT TASK DETAILS
    static void printTask(Task task) {
        System.out.println("Task ID: " + task.taskId);
        System.out.println("Task Name: " + task.taskName);
        System.out.println("Priority: " + task.priority);
        System.out.println("Due Date: " + task.dueDate);
        System.out.println("---------------------------");
    }

    // MAIN METHOD
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Position");
            System.out.println("4. Delete Task by ID");
            System.out.println("5. View Current Task");
            System.out.println("6. Display All Tasks");
            System.out.println("7. Search Task by Priority");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Task Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Priority: ");
                    int priority = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Due Date: ");
                    String date = sc.nextLine();
                    addTaskAtBeginning(id, name, priority, date);
                }
                case 2 -> {
                    System.out.print("Enter Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Task Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Priority: ");
                    int priority = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Due Date: ");
                    String date = sc.nextLine();
                    addTaskAtEnd(id, name, priority, date);
                }
                case 3 -> {
                    System.out.print("Enter Position: ");
                    int pos = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Task Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Priority: ");
                    int priority = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Due Date: ");
                    String date = sc.nextLine();
                    addTaskAtPosition(pos, id, name, priority, date);
                }
                case 4 -> {
                    System.out.print("Enter Task ID: ");
                    deleteTaskById(sc.nextInt());
                }
                case 5 -> viewCurrentTask();
                case 6 -> displayAllTasks();
                case 7 -> {
                    System.out.print("Enter Priority: ");
                    searchTaskByPriority(sc.nextInt());
                }
                case 8 -> System.out.println("Exiting program...");
                default -> System.out.println("Invalid choice");
            }

        } while (choice != 8);
    }
}
