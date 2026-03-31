import java.util.*;

class Doctor {
    private String name;
    private String specialty;
    private boolean availableOnWeekend;

    Doctor(String name, String specialty, boolean availableOnWeekend) {
        this.name = name;
        this.specialty = specialty;
        this.availableOnWeekend = availableOnWeekend;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public boolean isAvailableOnWeekend() {
        return availableOnWeekend;
    }
}

public class DoctorAvailability {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of doctors:");
        int n = sc.nextInt();
        sc.nextLine(); 

        List<Doctor> doctors = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter Doctor " + (i + 1) + " Name:");
            String name = sc.nextLine();

            System.out.println("Enter Doctor " + (i + 1) + " Specialty:");
            String specialty = sc.nextLine();

            System.out.println("Is Doctor " + (i + 1) + " available on weekend? (true/false):");
            boolean available = sc.nextBoolean();
            sc.nextLine(); 

            doctors.add(new Doctor(name, specialty, available));
        }

        System.out.println("\nDoctors Available on Weekends (Sorted by Specialty):");

        doctors.stream()
               .filter(Doctor::isAvailableOnWeekend)
               .sorted(Comparator.comparing(Doctor::getSpecialty))
               .forEach(d -> System.out.println(
                   d.getName() + " | Specialty: " + d.getSpecialty()
               ));
    }
}
