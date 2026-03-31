import java.util.*;
class Patient {
    String name;
    int severity;
    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
    @Override
    public String toString() {
        return name + " (" + severity + ")";
    }
}
public class HospitalTriage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of patients: ");
        int n = sc.nextInt();
        sc.nextLine();
        PriorityQueue<Patient> queue = new PriorityQueue<>(
            (p1, p2) -> Integer.compare(p2.severity, p1.severity)
        );
        System.out.println("Enter patient name and severity:");
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int severity = sc.nextInt();
            queue.add(new Patient(name, severity));
        }
        System.out.println("\nTreatment order:");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll().name);
        }
    }
}
