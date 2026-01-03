import java.util.Scanner;
// Superclass
class Device {
    String deviceId;
    String status; // ON or OFF
    Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }
    void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}
// Subclass
class Thermostat extends Device {
    double temperatureSetting;
    Thermostat(String deviceId, String status, double temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }
    @Override
    void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature Setting: " + temperatureSetting + " °C");
    }
}
// Main class
public class SmartHomeDevices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("----- Smart Home Device Setup -----");
        // Device ID (alphabets only)
        String deviceId;
        while (true) {
            System.out.print("Enter Device ID: ");
            deviceId = sc.nextLine();
            if (deviceId.matches("[A-Za-z]+")) {
                break;
            } else {
                System.out.println(" Device ID must contain only alphabets.");
            }
        }
        // Device Status (ON/OFF only)
        String status;
        while (true) {
            System.out.print("Enter Device Status (ON/OFF): ");
            status = sc.nextLine().toUpperCase();
            if (status.equals("ON") || status.equals("OFF")) {
                break;
            } else {
                System.out.println(" Status must be ON or OFF only.");
            }
        }
        // Temperature (numeric only)
        double temperature;
        while (true) {
            System.out.print("Enter Thermostat Temperature Setting (°C): ");
            if (sc.hasNextDouble()) {
                temperature = sc.nextDouble();
                break;
            } else {
                System.out.println(" Temperature must be a number.");
                sc.next(); // discard invalid input
            }
        }

        // Create object
        Thermostat thermostat = new Thermostat(deviceId, status, temperature);

        // Output
        System.out.println("\n----- Device Status -----");
        thermostat.displayStatus();
    }
}
