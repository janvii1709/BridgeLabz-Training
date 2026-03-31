import java.util.Scanner;
import java.util.function.Predicate;
public class TemperatureAlertSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Set the temperature threshold (°C): ");
        double threshold = sc.nextDouble();
        Predicate<Double> isTooHot = temp -> temp > threshold;
        while (true) {
            System.out.print("\nEnter current temperature (or -1 to exit): ");
            double currentTemp = sc.nextDouble();
            if (currentTemp == -1) {
                System.out.println("Exiting Temperature Alert System...");
                break;
            }
            if (isTooHot.test(currentTemp)) {
                System.out.println(" ALERT! Temperature " + currentTemp + "°C exceeds threshold of " + threshold + "°C!");
            } else {
                System.out.println("Temperature " + currentTemp + "°C is within safe range.");
            }
        }
    }
}
