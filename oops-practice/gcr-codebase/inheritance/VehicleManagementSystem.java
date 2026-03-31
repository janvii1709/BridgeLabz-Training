import java.util.Scanner;

// Superclass
class Vehicle {
    int maxSpeed;
    String model;

    Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }

    void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

// Interface
interface Refuelable {
    void refuel();
}

// ElectricVehicle subclass
class ElectricVehicle extends Vehicle {

    ElectricVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    void charge() {
        System.out.println("Electric vehicle is charging...");
    }
}

// PetrolVehicle subclass (Hybrid Inheritance)
class PetrolVehicle extends Vehicle implements Refuelable {

    PetrolVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    public void refuel() {
        System.out.println("Petrol vehicle is refueling...");
    }
}

// Main class
public class VehicleManagementSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input for Electric Vehicle
        System.out.println("Enter Electric Vehicle details:");
        System.out.print("Model: ");
        String eModel = sc.nextLine();
        System.out.print("Max Speed: ");
        int eSpeed = sc.nextInt();
        sc.nextLine();

        ElectricVehicle ev = new ElectricVehicle(eSpeed, eModel);

        System.out.println("\nElectric Vehicle Details:");
        ev.displayInfo();
        ev.charge();

        // Input for Petrol Vehicle
        System.out.println("\nEnter Petrol Vehicle details:");
        System.out.print("Model: ");
        String pModel = sc.nextLine();
        System.out.print("Max Speed: ");
        int pSpeed = sc.nextInt();

        PetrolVehicle pv = new PetrolVehicle(pSpeed, pModel);

        System.out.println("\nPetrol Vehicle Details:");
        pv.displayInfo();
        pv.refuel();
    }
}
