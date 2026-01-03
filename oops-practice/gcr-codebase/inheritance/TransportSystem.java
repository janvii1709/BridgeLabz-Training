import java.util.Scanner;

// Superclass
class Vehicle {
    int maxSpeed;
    String fuelType;

    Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    void displayInfo() {
        System.out.println("Max Speed: " + maxSpeed + " km/h");
        System.out.println("Fuel Type: " + fuelType);
    }

    String getVehicleType() {
        return "Vehicle";
    }
}

// Car subclass
class Car extends Vehicle {
    int seatCapacity;

    Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    @Override
    void displayInfo() {
        System.out.println("Vehicle Type: Car");
        super.displayInfo();
        System.out.println("Seat Capacity: " + seatCapacity);
    }
}

// Truck subclass
class Truck extends Vehicle {
    double loadCapacity;

    Truck(int maxSpeed, String fuelType, double loadCapacity) {
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }

    @Override
    void displayInfo() {
        System.out.println("Vehicle Type: Truck");
        super.displayInfo();
        System.out.println("Load Capacity: " + loadCapacity + " tons");
    }
}

// Motorcycle subclass
class Motorcycle extends Vehicle {
    boolean hasGear;

    Motorcycle(int maxSpeed, String fuelType, boolean hasGear) {
        super(maxSpeed, fuelType);
        this.hasGear = hasGear;
    }

    @Override
    void displayInfo() {
        System.out.println("Vehicle Type: Motorcycle");
        super.displayInfo();
        System.out.println("Has Gear: " + hasGear);
    }
}

// Main class
public class TransportSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Vehicle[] vehicles = new Vehicle[3];

        // -------- Car Input --------
        System.out.println("Enter Car Details:");
        System.out.print("Max Speed: ");
        int carSpeed = sc.nextInt();
        sc.nextLine();
        System.out.print("Fuel Type: ");
        String carFuel = sc.nextLine();
        System.out.print("Seat Capacity: ");
        int seats = sc.nextInt();

        vehicles[0] = new Car(carSpeed, carFuel, seats);

        // -------- Truck Input --------
        System.out.println("\nEnter Truck Details:");
        System.out.print("Max Speed: ");
        int truckSpeed = sc.nextInt();
        sc.nextLine();
        System.out.print("Fuel Type: ");
        String truckFuel = sc.nextLine();
        System.out.print("Load Capacity (tons): ");
        double load = sc.nextDouble();

        vehicles[1] = new Truck(truckSpeed, truckFuel, load);

        // -------- Motorcycle Input --------
        System.out.println("\nEnter Motorcycle Details:");
        System.out.print("Max Speed: ");
        int bikeSpeed = sc.nextInt();
        sc.nextLine();
        System.out.print("Fuel Type: ");
        String bikeFuel = sc.nextLine();
        System.out.print("Has Gear (true/false): ");
        boolean gear = sc.nextBoolean();

        vehicles[2] = new Motorcycle(bikeSpeed, bikeFuel, gear);

        // -------- Polymorphic Display --------
        System.out.println("\n----- Vehicle Details -----");
        for (Vehicle v : vehicles) {
            System.out.println("-------------------------");
            v.displayInfo();   // Polymorphism
        }

    }
}
