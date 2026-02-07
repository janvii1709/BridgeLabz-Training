import java.util.Scanner;
interface SmartDevice {
    void turnOn();
    void turnOff();
}
class LightDevice implements SmartDevice {
    public void turnOn() { System.out.println("Light is turned ON"); }
    public void turnOff() { System.out.println("Light is turned OFF"); }
}
class ACDevice implements SmartDevice {
    public void turnOn() { System.out.println("AC is turned ON"); }
    public void turnOff() { System.out.println("AC is turned OFF"); }
}
class TVDevice implements SmartDevice {
    public void turnOn() { System.out.println("TV is turned ON"); }
    public void turnOff() { System.out.println("TV is turned OFF"); }
}
public class SmartHomeControl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SmartDevice light = new LightDevice();
        SmartDevice ac = new ACDevice();
        SmartDevice tv = new TVDevice();
        while (true) {
            System.out.println("\nChoose a device:");
            System.out.println("1. Light\n2. AC\n3. TV\n4. Exit");
            System.out.print("Enter choice: ");
            int deviceChoice = sc.nextInt();
            if (deviceChoice == 4) { 
                System.out.println("Exiting..."); 
                break; 
            }
            System.out.println("1. Turn ON\n2. Turn OFF");
            System.out.print("Enter action: ");
            int action = sc.nextInt();
            SmartDevice device = null;
            switch (deviceChoice) {
                case 1 -> device = light;
                case 2 -> device = ac;
                case 3 -> device = tv;
                default -> System.out.println("Invalid device!");
            }
            if (device != null) {
                switch (action) {
                    case 1 -> device.turnOn();
                    case 2 -> device.turnOff();
                    default -> System.out.println("Invalid action!");
                }
            }
        }
    }
}
