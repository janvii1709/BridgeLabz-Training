import java.util.Scanner;

public class TrafficManager {

    static Scanner sc = new Scanner(System.in);
    static Roundabout roundabout = new Roundabout();
    static VehicleQueue queue = new VehicleQueue(5); // queue capacity

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- Traffic Manager Menu ---");
            System.out.println("1. Add Vehicle to Waiting Queue");
            System.out.println("2. Move Vehicle from Queue to Roundabout");
            System.out.println("3. Remove Vehicle from Roundabout");
            System.out.println("4. Display Roundabout");
            System.out.println("5. Display Waiting Queue");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addToQueue();
                case 2 -> moveToRoundabout();
                case 3 -> removeFromRoundabout();
                case 4 -> roundabout.display();
                case 5 -> queue.displayQueue();
                case 6 -> {
                    System.out.println("Traffic system stopped");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void addToQueue() {
        System.out.print("Enter Vehicle ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Vehicle Name: ");
        String name = sc.nextLine();

        queue.enqueue(new Vehicle(id, name));
    }

    static void moveToRoundabout() {
        Vehicle v = queue.dequeue();
        if (v != null) {
            roundabout.addVehicle(v);
        }
    }

    static void removeFromRoundabout() {
        System.out.print("Enter Vehicle ID to remove: ");
        int id = sc.nextInt();
        roundabout.removeVehicle(id);
    }
}
