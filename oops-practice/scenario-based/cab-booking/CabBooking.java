import java.util.*;

public class CabBooking {

    static List<Driver> drivers = new ArrayList<>();
    static List<Ride> rides = new ArrayList<>();
    static Random random = new Random();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Driver (Create)");
            System.out.println("2. View All Drivers (Read)");
            System.out.println("3. Check Driver Status (Read)");
            System.out.println("4. Book Ride (Create)");
            System.out.println("5. View Ride History (Read)");
            System.out.println("6. Delete Ride (Delete)");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addDriver(sc);
                case 2 -> viewDrivers();
                case 3 -> checkDriverStatus(sc); // NEW option
                case 4 -> {
                    try {
                        bookRide(sc);
                    } catch (NoDriverAvailableException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 5 -> viewRideHistory();
                case 6 -> deleteRide(sc);
                case 7 -> {
                    System.out.println("Thank you!");
                    return;
                }
                default -> System.out.println("Enter a valid option from above");
            }
        }
    }

    // CREATE DRIVER
    static void addDriver(Scanner sc) {
        try {
            System.out.print("Driver ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Driver Name: ");
            String name = sc.nextLine();

            System.out.print("Phone Number: ");
            String phone = sc.nextLine();

            drivers.add(new Driver(id, name, phone));
            System.out.println("Driver added successfully");

        } catch (InvalidPhoneNumberException e) {
            System.out.println(e.getMessage());
        }
    }

    // VIEW ALL DRIVERS
    static void viewDrivers() {
        if (drivers.isEmpty()) {
            System.out.println("No drivers available.");
            return;
        }
        System.out.println("ID | Name | Status");
        for (Driver d : drivers) {
            System.out.println(
                d.driverId + " | " + d.name + " | " + (d.available ? "Available" : "Not Available")
            );
        }
    }

    // CHECK DRIVER STATUS (same as view but can be separated if needed)
    static void checkDriverStatus(Scanner sc) {
        if (drivers.isEmpty()) {
            System.out.println("No drivers available.");
            return;
        }
        System.out.println("Driver ID | Name | Status");
        for (Driver d : drivers) {
            System.out.println(
                d.driverId + " | " + d.name + " | " + (d.available ? "Available" : "Not Available")
            );
        }
    }

    // BOOK RIDE
    static void bookRide(Scanner sc) throws NoDriverAvailableException {
        sc.nextLine(); // consume newline
        System.out.print("User Name: ");
        String uname = sc.nextLine();

        System.out.print("User ID: ");
        int uid = sc.nextInt();

        User user = new User(uid, uname);

        Driver driver = null;
        for (Driver d : drivers) {
            if (d.available) {
                driver = d;
                break;
            }
        }

        if (driver == null)
            throw new NoDriverAvailableException("No driver available");

        System.out.print("Distance (km): ");
        double distance = sc.nextDouble();

        boolean peak = random.nextBoolean();
        FareCalculator fc = peak ? new PeakFare() : new NormalFare();
        double fare = fc.calculateFare(distance);

        driver.available = false; // automatically busy
        rides.add(new Ride(user, driver, fare, peak));

        System.out.println("Ride booked successfully");
        System.out.println("Driver: " + driver.name);
        System.out.println("Fare: INR " + fare);
        System.out.println("Peak time: " + peak);
        System.out.println("Driver Status: " + (driver.available ? "Available" : "Not Available"));
    }

    // VIEW RIDE HISTORY
    static void viewRideHistory() {
        if (rides.isEmpty()) {
            System.out.println("No rides booked yet.");
            return;
        }
        for (Ride r : rides) r.display();
    }

    // DELETE RIDE
    static void deleteRide(Scanner sc) {
        System.out.print("Enter User ID to delete ride: ");
        int uid = sc.nextInt();

        Iterator<Ride> it = rides.iterator();
        while (it.hasNext()) {
            Ride r = it.next();
            if (r.user.userId == uid) {
                r.driver.available = true; // automatically free
                it.remove();
                System.out.println("Ride deleted & Driver is now AVAILABLE");
                return;
            }
        }
        System.out.println("Ride not found");
    }
}
