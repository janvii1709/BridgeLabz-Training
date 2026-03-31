import java.util.*;
import java.text.*;

// Custom Exception
class InvalidEnergyReadingException extends Exception {
    public InvalidEnergyReadingException(String msg) {
        super(msg);
    }
}

// Energy Monitor Class
class EnergyMonitor {

    Map<Date, List<Double>> usageData = new HashMap<>();

    void addUsage(Date date, double usage) throws InvalidEnergyReadingException {
        if (usage < 0)
            throw new InvalidEnergyReadingException("Energy usage cannot be negative!");

        usageData.computeIfAbsent(date, k -> new ArrayList<>()).add(usage);
    }

    void calculateDailyAverage() {
        System.out.println("\n--- Daily Average Usage ---");
        for (Map.Entry<Date, List<Double>> entry : usageData.entrySet()) {
            double avg = entry.getValue().stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(0);
            System.out.println(entry.getKey() + " -> " + avg + " units");
        }
    }

    void calculateMonthlyAverage() {
        double total = 0;
        int count = 0;

        for (List<Double> values : usageData.values()) {
            for (double v : values) {
                total += v;
                count++;
            }
        }

        System.out.println("\n--- Monthly Average Usage ---");
        System.out.println(total / count + " units");
    }
}

public class SmartEnergyConsumptionMonitor {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        EnergyMonitor monitor = new EnergyMonitor();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        System.out.print("Enter number of days: ");
        int days = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < days; i++) {
            System.out.print("\nEnter Date (dd-MM-yyyy): ");
            Date date = sdf.parse(sc.nextLine());

            System.out.print("Enter number of readings: ");
            int readings = sc.nextInt();

            for (int j = 0; j < readings; j++) {
                System.out.print("Enter energy usage: ");
                double usage = sc.nextDouble();
                monitor.addUsage(date, usage);
            }
            sc.nextLine();
        }

        monitor.calculateDailyAverage();
        monitor.calculateMonthlyAverage();
    }
}
