import java.util.*;

//ABSTRACT CLASS
abstract class Vehicle {

    // Encapsulated fields
    private String vehicleNumber;
    private String type;
    protected double rentalRate;

    // Constructor
    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // Abstract method
    public abstract double calculateRentalCost(int days);

    // Concrete method
    public void displayDetails() {
        System.out.println("Vehicle Number : " + vehicleNumber);
        System.out.println("Vehicle Type   : " + type);
        System.out.println("Rental Rate    : " + rentalRate + " per day");
    }
}

// NTERFACE
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

//  CAR
class Car extends Vehicle implements Insurable {

    private String insurancePolicyNumber; // sensitive (encapsulated)

    public Car(String number, double rate, String policyNo) {
        super(number, "Car", rate);
        this.insurancePolicyNumber = policyNo;
    }

    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    public double calculateInsurance() {
        return rentalRate * 0.15;
    }

    public String getInsuranceDetails() {
        return "Car Insurance (Policy No hidden)";
    }
}

// BIKE
class Bike extends Vehicle implements Insurable {

    private String insurancePolicyNumber;

    public Bike(String number, double rate, String policyNo) {
        super(number, "Bike", rate);
        this.insurancePolicyNumber = policyNo;
    }

    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    public double calculateInsurance() {
        return rentalRate * 0.10;
    }

    public String getInsuranceDetails() {
        return "Bike Insurance (Policy No hidden)";
    }
}

//TRUCK
class Truck extends Vehicle implements Insurable {

    private String insurancePolicyNumber;

    public Truck(String number, double rate, String policyNo) {
        super(number, "Truck", rate);
        this.insurancePolicyNumber = policyNo;
    }

    public double calculateRentalCost(int days) {
        return rentalRate * days + 500; // extra loading charge
    }

    public double calculateInsurance() {
        return rentalRate * 0.20;
    }

    public String getInsuranceDetails() {
        return "Truck Insurance (Policy No hidden)";
    }
}

//MAIN CLASS
public class VehicleRentalSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Vehicle> vehicles = new ArrayList<>();

        System.out.print("Enter number of vehicles: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {

            System.out.println("\nVehicle " + i);
            System.out.println("1. Car");
            System.out.println("2. Bike");
            System.out.println("3. Truck");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            System.out.print("Vehicle Number: ");
            String number = sc.nextLine();

            System.out.print("Rental Rate per day: ");
            double rate = sc.nextDouble();
            sc.nextLine();

            System.out.print("Insurance Policy Number: ");
            String policy = sc.nextLine();

            if (choice == 1) {
                vehicles.add(new Car(number, rate, policy));
            }
            else if (choice == 2) {
                vehicles.add(new Bike(number, rate, policy));
            }
            else if (choice == 3) {
                vehicles.add(new Truck(number, rate, policy));
            }
            else {
                System.out.println("Invalid choice!");
                i--;
            }
        }

        System.out.print("\nEnter number of rental days: ");
        int days = sc.nextInt();

        //POLYMORPHISM
        System.out.println("\n===== RENTAL DETAILS =====");
        for (Vehicle v : vehicles) {

            v.displayDetails();

            double rentalCost = v.calculateRentalCost(days);
            System.out.println("Rental Cost  : " + rentalCost);

            if (v instanceof Insurable) {
                Insurable ins = (Insurable) v;
                System.out.println("Insurance    : " + ins.calculateInsurance());
                System.out.println("Insurance Info: " + ins.getInsuranceDetails());
            }

            System.out.println("---------------------------");
        }

    }
}
