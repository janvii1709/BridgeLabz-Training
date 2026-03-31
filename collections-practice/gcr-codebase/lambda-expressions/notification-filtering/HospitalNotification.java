import java.util.*;
import java.util.function.Predicate;
public class HospitalNotification {
    public static void main(String[] args) {
        List<Alert> alerts = List.of(new Alert("Emergency", "Patient heart rate critical"),new Alert("Medicine", "Take insulin at 8 AM"),new Alert("Test", "Blood report available"),new Alert("General", "Doctor appointment tomorrow"));
        // User preference: show only Emergency alerts
        Predicate<Alert> emergencyFilter = alert -> alert.type.equalsIgnoreCase("Emergency");
        System.out.println("Emergency Alerts:");
        filterAlerts(alerts, emergencyFilter);
        // User preference: show Medicine reminders
        Predicate<Alert> medicineFilter = alert -> alert.type.equalsIgnoreCase("Medicine");
        System.out.println("\nMedicine Alerts:");
        filterAlerts(alerts, medicineFilter);
    }
    static void filterAlerts(List<Alert> alerts, Predicate<Alert> predicate) {
        alerts.stream().filter(predicate).forEach(System.out::println);
    }
}
