import java.util.*;

// Interface
// This interface is used to track vehicle location using GPS
interface GPS {
    String getCurrentLocation();     // Get current location of vehicle
    void updateLocation(String loc); // Update vehicle location
}
// abstract class
abstract class Vehicle{
    private int vehicleId;
    private String driverName;
    private double ratePerKm;

    // Constructor to initialize vehicle details
    Vehicle(int vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }
    // Getters (read-only access)
    public int getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    // Concrete method common to all vehicles
    public void getVehicleDetails() {
        System.out.println("Vehicle ID   : " + vehicleId);
        System.out.println("Driver Name  : " + driverName);
        System.out.println("Rate per Km  : " + ratePerKm);
    }

    // Abstract method to calculate fare
    abstract double calculateFare(double distance);
}
// Car Class
class Car extends Vehicle implements GPS {

    private String location = "Not Updated";

    Car(int id, String driver, double rate) {
        super(id, driver, rate);
    }

    // Car fare calculation (normal rate)
    double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    public String getCurrentLocation() {
        return location;
    }

    public void updateLocation(String loc) {
        location = loc;
    }
}

// Bike Class
class Bike extends Vehicle implements GPS {

    private String location = "Not Updated";

    Bike(int id, String driver, double rate) {
        super(id, driver, rate);
    }

    // Bike fare is cheaper (10% discount)
    double calculateFare(double distance) {
        return (getRatePerKm() * distance) * 0.90;
    }

    public String getCurrentLocation() {
        return location;
    }

    public void updateLocation(String loc) {
        location = loc;
    }
}

// Auto Class
class Auto extends Vehicle implements GPS {

    private String location = "Not Updated";

    Auto(int id, String driver, double rate) {
        super(id, driver, rate);
    }

    // Auto fare has extra charge (5% extra)
    double calculateFare(double distance) {
        return (getRatePerKm() * distance) * 1.05;
    }

    public String getCurrentLocation() {
        return location;
    }

    public void updateLocation(String loc) {
        location = loc;
    }
}

//Main Class
public class RideHailingApplication {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ArrayList to store multiple vehicles
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        System.out.print("Enter number of vehicles: ");
        int n = sc.nextInt();
        sc.nextLine();

        // Input details for each vehicle
        for (int i = 1; i <= n; i++) {

            System.out.println("\nEnter details for vehicle " + i);

            // Vehicle ID (numeric)
            System.out.print("Vehicle ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            // Driver name (alphabets only)
            String driver;
            while (true) {
                System.out.print("Driver Name : ");
                driver = sc.nextLine();
                if (driver.matches("[a-zA-Z ]+"))
                    break;
                System.out.println(" Driver name must contain only alphabets");
            }

            // Rate per km
            System.out.print("Rate per Km: ");
            double rate = sc.nextDouble();

            // Vehicle type selection
            int type;
            while (true) {
                System.out.println("Vehicle Type:");
                System.out.println("1. Car");
                System.out.println("2. Bike");
                System.out.println("3. Auto");
                type = sc.nextInt();

                if (type >= 1 && type <= 3)
                    break;
                System.out.println(" Invalid choice! Enter 1, 2, or 3");
            }
            sc.nextLine();

            Vehicle v;
            if (type == 1)
                v = new Car(id, driver, rate);
            else if (type == 2)
                v = new Bike(id, driver, rate);
            else
                v = new Auto(id, driver, rate);

            // GPS location update
            System.out.print("Enter current location: ");
            String loc = sc.nextLine();
            ((GPS) v).updateLocation(loc);

            vehicles.add(v);
        }

        //Fare Calculation
        System.out.print("\nEnter travel distance (in km): ");
        double distance = sc.nextDouble();

        System.out.println("\n----- Fare Details -----");

        // Polymorphism in action
        for (Vehicle v : vehicles) {

            v.getVehicleDetails();
            System.out.println("Current Location: " + ((GPS) v).getCurrentLocation());
            System.out.println("Distance (km)   : " + distance);
            System.out.println("Total Fare     : " + v.calculateFare(distance));
            System.out.println("------------------------");
        }

    }
}
