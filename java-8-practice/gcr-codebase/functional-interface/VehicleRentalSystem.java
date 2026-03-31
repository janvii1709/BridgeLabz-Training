import java.util.Scanner;
interface Vehicle {
    void rent();
    void returnVehicle();
}
class Car implements Vehicle {
    @Override
    public void rent() {
        System.out.println("Car has been rented.");
    }
    @Override
    public void returnVehicle() {
        System.out.println("Car has been returned.");
    }
}
class Bike implements Vehicle {
    @Override
    public void rent() {
        System.out.println("Bike has been rented.");
    }
    @Override
    public void returnVehicle() {
        System.out.println("Bike has been returned.");
    }
}
class Bus implements Vehicle {
    @Override
    public void rent() {
        System.out.println("Bus has been rented.");
    }
    @Override
    public void returnVehicle() {
        System.out.println("Bus has been returned.");
    }
}
public class VehicleRentalSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vehicle car = new Car();
        Vehicle bike = new Bike();
        Vehicle bus = new Bus();
        while (true) {
            System.out.println("\nSelect a vehicle:");
            System.out.println("1. Car");
            System.out.println("2. Bike");
            System.out.println("3. Bus");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int vehicleChoice = sc.nextInt();
            if (vehicleChoice == 4) {
                System.out.println("Exiting the system. Goodbye!");
                break;
            }
            System.out.println("1. Rent");
            System.out.println("2. Return");
            System.out.print("Enter action: ");
            int action = sc.nextInt();
            Vehicle vehicle = null;
            switch (vehicleChoice) {
                case 1 -> vehicle = car;
                case 2 -> vehicle = bike;
                case 3 -> vehicle = bus;
                default -> System.out.println("Invalid vehicle choice!");
            }
            if (vehicle != null) {
                switch (action) {
                    case 1 -> vehicle.rent();
                    case 2 -> vehicle.returnVehicle();
                    default -> System.out.println("Invalid action!");
                }
            }
        }
    }
}
