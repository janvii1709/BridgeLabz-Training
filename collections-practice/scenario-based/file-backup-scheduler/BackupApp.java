import java.util.Scanner;
public class BackupApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FileBackupScheduler scheduler = new FileBackupScheduler();
        while (true) {
            System.out.println("\n1. Add Backup Task");
            System.out.println("2. Execute Backup Tasks");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter folder path: ");
                        String path = sc.nextLine();
                        System.out.print("Enter priority (1 = Low, 5 = Critical): ");
                        int priority = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter backup time: ");
                        String time = sc.nextLine();
                        scheduler.addBackupTask(path, priority, time);
                        break;
                    case 2:
                        scheduler.executeBackups();
                        break;
                    case 3:
                        System.out.println("Backup Scheduler Closed ");
                        sc.close();
                        return;
                    default:
                        System.out.println(" Invalid choice!");
                }
            } catch (InvalidBackupPathException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
