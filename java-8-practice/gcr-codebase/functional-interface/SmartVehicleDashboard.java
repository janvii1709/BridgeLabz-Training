import java.util.Scanner;

interface Vehicle {
    void displaySpeed();

    default void displayBatteryPercentage() {
        System.out.println("Battery information not available for this vehicle.");
    }
}

class PetrolCar implements Vehicle {
    int speed;

    PetrolCar(int speed) {
        this.speed = speed;
    }

    public void displaySpeed() {
        System.out.println("Car Speed: " + speed + " km/h");
    }
}

class ElectricCar implements Vehicle {
    int speed;
    int battery;

    ElectricCar(int speed, int battery) {
        this.speed = speed;
        this.battery = battery;
    }

    public void displaySpeed() {
        System.out.println("Electric Car Speed: " + speed + " km/h");
    }

    public void displayBatteryPercentage() {
        System.out.println("Battery Percentage: " + battery + "%");
    }
}
public class SmartVehicleDashboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose Vehicle Type:");
        System.out.println("1. Petrol Car");
        System.out.println("2. Electric Car");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        Vehicle vehicle;
        if (choice == 1) {
            System.out.print("Enter car speed: ");
            int speed = sc.nextInt();
            vehicle = new PetrolCar(speed);
        } else {
            System.out.print("Enter electric car speed: ");
            int speed = sc.nextInt();
            System.out.print("Enter battery percentage: ");
            int battery = sc.nextInt();
            vehicle = new ElectricCar(speed, battery);
        }
        System.out.println("\n--- Vehicle Dashboard ---");
        vehicle.displaySpeed();
        vehicle.displayBatteryPercentage();
    }
}
