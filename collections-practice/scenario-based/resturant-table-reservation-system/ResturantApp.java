import java.util.Scanner;
public class ResturantApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ResturantReservationSystem system = new ResturantReservationSystem();
        System.out.print("Enter number of tables: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter table number: ");
            int tableNumber = sc.nextInt();
            System.out.print("Enter table capacity: ");
            int capacity = sc.nextInt();
            system.addTable(new Table(tableNumber, capacity));
        }
        while (true) {
            System.out.println("\n1. Reserve Table");
            System.out.println("2. Cancel Reservation");
            System.out.println("3. Show Available Tables");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter table number: ");
                        int tno = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter customer name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter time slot: ");
                        String time = sc.nextLine();

                        system.reserveTable(tno, name, time);
                        break;

                    case 2:
                        System.out.print("Enter table number: ");
                        int cancelTable = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter time slot: ");
                        String cancelTime = sc.nextLine();

                        system.cancelReservation(cancelTable, cancelTime);
                        break;

                    case 3:
                        System.out.print("Enter time slot: ");
                        String slot = sc.nextLine();

                        system.showAvailableTables(slot);
                        break;

                    case 4:
                        System.out.println("Thank you!");
                        sc.close();
                        return;

                    default:
                        System.out.println(" Invalid choice!");
                }
            } catch (TableAlreadyReservedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
