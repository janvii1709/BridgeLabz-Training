import java.util.*;
public class IoTSensorReadings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of sensor readings:");
        int n = sc.nextInt();
        double[] readings = new double[n];
        System.out.println("Enter sensor readings:");
        for (int i = 0; i < n; i++) {
            readings[i] = sc.nextDouble();
        }
        System.out.println("Enter threshold value:");
        double threshold = sc.nextDouble();
        System.out.println("\nSensor readings above threshold:");
        Arrays.stream(readings)
              .filter(r -> r > threshold)
              .forEach(r -> System.out.println(r));
    }
}
