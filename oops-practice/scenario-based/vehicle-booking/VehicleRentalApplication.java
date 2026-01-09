import java.util.*;

// Main class for running Vehicle Rental System
public class VehicleRentalApplication {

    static Scanner sc = new Scanner(System.in);

    static Vehicle[] vehicles;                 // Array of vehicles
    static List<Customer> customers = new ArrayList<>(); // List of rentals
    static int customerCounter = 1;

    public static void main(String[] args) {

        addVehicles(); // CREATE operation

        int choice;
        do {
            System.out.println("\n===== Vehicle Rental System (CRUD) =====");
            System.out.println("1. View Vehicles(READ)");
            System.out.println("2. Rent Vehicle(CREATE)");
            System.out.println("3. View Rentals(READ)");
            System.out.println("4. Cancel Rental(DELETE)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Enter a number: ");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> viewVehicles();
                case 2 -> rentVehicle();
                case 3 -> viewRentals();
                case 4 -> cancelRental();
                case 5 -> System.out.println("Thank you for using Vehicle Rental System!");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

    // CREATE → add vehicles
    static void addVehicles() {

        System.out.print("Enter number of vehicles: ");
        while (!sc.hasNextInt()) {
            System.out.print("Enter numeric value: ");
            sc.next();
        }
        int n = sc.nextInt();
        sc.nextLine();

        vehicles = new Vehicle[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nSelect Vehicle Type: 1. Bike  2. Car  3. Truck");
            int type;
            while (true) {
                while (!sc.hasNextInt()) {
                    System.out.print("Enter numeric choice (1/2/3): ");
                    sc.next();
                }
                type = sc.nextInt();
                sc.nextLine();
                if (type >= 1 && type <= 3) break;
                System.out.print("Invalid choice, enter 1, 2, or 3: ");
            }

            System.out.print("Vehicle ID: ");
            while (!sc.hasNextInt()) {
                System.out.print("Enter numeric Vehicle ID: ");
                sc.next();
            }
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Brand Name: ");
            String brand = sc.nextLine();

            System.out.print("Rent per day: ");
            while (!sc.hasNextDouble()) {
                System.out.print("Enter numeric rent per day: ");
                sc.next();
            }
            double rent = sc.nextDouble();
            sc.nextLine();

            if (type == 1) vehicles[i] = new Bike(id, brand, rent);
            else if (type == 2) vehicles[i] = new Car(id, brand, rent);
            else vehicles[i] = new Truck(id, brand, rent);
        }
    }

    // READ → view vehicles
    static void viewVehicles() {
        for (Vehicle v : vehicles) v.displayVehicle();
    }

    // CREATE → rent vehicle
    static void rentVehicle() {

        System.out.print("Enter Vehicle ID to rent: ");
        while (!sc.hasNextInt()) {
            System.out.print("Enter numeric Vehicle ID: ");
            sc.next();
        }
        int id = sc.nextInt();
        sc.nextLine();

        Vehicle selected = null;
        for (Vehicle v : vehicles) {
            if (v.vehicleId == id) {
                selected = v;
                break;
            }
        }

        if (selected == null) {
            System.out.println("Vehicle not found.");
            return;
        }

        System.out.print("Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Number of days: ");
        while (!sc.hasNextInt()) {
            System.out.print("Enter numeric number of days: ");
            sc.next();
        }
        int days = sc.nextInt();
        sc.nextLine();

        customers.add(new Customer(customerCounter++, name, selected, days));
        System.out.println("Vehicle rented successfully!");
    }

    // READ → view rentals
    static void viewRentals() {
        if (customers.isEmpty()) {
            System.out.println("No rentals available.");
            return;
        }
        for (Customer c : customers) c.displayRental();
    }

    // DELETE → cancel rental safely
    static void cancelRental() {

        System.out.print("Enter Customer ID to cancel rental: ");
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input! Enter numeric Customer ID: ");
            sc.next();
        }
        int id = sc.nextInt();
        sc.nextLine();

        Iterator<Customer> it = customers.iterator();
        boolean removed = false;

        while (it.hasNext()) {
            Customer c = it.next();
            if (c.customerId == id) {
                it.remove();
                removed = true;
                System.out.println("Rental cancelled successfully.");
                break;
            }
        }

        if (!removed) System.out.println("Customer ID not found.");
    }
}
