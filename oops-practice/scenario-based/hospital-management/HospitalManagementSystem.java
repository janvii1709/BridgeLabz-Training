import java.util.*;

public class HospitalManagementSystem {

    static Scanner sc = new Scanner(System.in);

    static List<Doctor> doctors = new ArrayList<>();
    static List<Patient> patients = new ArrayList<>();
    static int doctorCounter = 1;
    static int patientCounter = 1;

    public static void main(String[] args) {

        int choice;
        do {
            System.out.println("\n==========Hospital Patient Management System==========");
            System.out.println("1. Add Doctor (CREATE)");
            System.out.println("2. Add Patient (CREATE)");
            System.out.println("3. View Doctors (READ)");
            System.out.println("4. View Patients (READ)");
            System.out.println("5. Update Patient (UPDATE)");
            System.out.println("6. Delete Patient (DELETE)");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Enter numeric choice: ");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addDoctor();
                case 2 -> addPatient();
                case 3 -> viewDoctors();
                case 4 -> viewPatients();
                case 5 -> updatePatient();
                case 6 -> deletePatient();
                case 7 -> System.out.println("Exiting system. Thank you!");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 7);
    }

    // CREATE → Doctor
    static void addDoctor() {
        System.out.print("Doctor Name: ");
        String name = sc.nextLine();

        System.out.print("Specialization: ");
        String spec = sc.nextLine();

        doctors.add(new Doctor(doctorCounter++, name, spec));
        System.out.println("Doctor added successfully!");
    }

    // CREATE → Patient
    static void addPatient() {
        if (doctors.isEmpty()) {
            System.out.println("Please add at least one doctor first!");
            return;
        }

        System.out.println("Select Patient Type: 1. InPatient  2. OutPatient");
        int type;
        while (true) {
            while (!sc.hasNextInt()) {
                System.out.print("Enter 1 or 2: ");
                sc.next();
            }
            type = sc.nextInt();
            sc.nextLine();
            if (type == 1 || type == 2) break;
        }

        System.out.print("Patient Name: ");
        String name = sc.nextLine();

        System.out.print("Age: ");
        while (!sc.hasNextInt()) {
            System.out.print("Enter numeric age: ");
            sc.next();
        }
        int age = sc.nextInt();
        sc.nextLine();

        // Select Doctor
        System.out.println("Select Doctor by ID:");
        for (Doctor d : doctors) d.displayDoctor();
        System.out.print("Doctor ID: ");
        int docId = sc.nextInt();
        sc.nextLine();

        Doctor selectedDoctor = null;
        for (Doctor d : doctors) {
            if (d.getDoctorId() == docId) {
                selectedDoctor = d;
                break;
            }
        }
        if (selectedDoctor == null) {
            System.out.println("Invalid Doctor ID!");
            return;
        }

        if (type == 1) {
            System.out.print("Days Admitted: ");
            int days = sc.nextInt();
            System.out.print("Daily Charge: ");
            double charge = sc.nextDouble();
            sc.nextLine();
            patients.add(new InPatient(patientCounter++, name, age, selectedDoctor, days, charge));
        } else {
            System.out.print("Consultation Fee: ");
            double fee = sc.nextDouble();
            sc.nextLine();
            patients.add(new OutPatient(patientCounter++, name, age, selectedDoctor, fee));
        }

        System.out.println("Patient added successfully!");
    }

    // READ → Doctors
    static void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
            return;
        }
        for (Doctor d : doctors) d.displayDoctor();
    }

    // READ → Patients
    static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }
        for (Patient p : patients) p.displayInfo();
    }

    // UPDATE → Patient
    static void updatePatient() {
        System.out.print("Enter Patient ID to update: ");
        while (!sc.hasNextInt()) {
            System.out.print("Enter numeric Patient ID: ");
            sc.next();
        }
        int id = sc.nextInt();
        sc.nextLine();

        Patient selected = null;
        for (Patient p : patients) {
            if (p.getPatientId() == id) {
                selected = p;
                break;
            }
        }
        if (selected == null) {
            System.out.println("Patient not found!");
            return;
        }

        System.out.print("Enter new name: ");
        String newName = sc.nextLine();
        System.out.print("Enter new age: ");
        int newAge = sc.nextInt();
        sc.nextLine();
        selected.setName(newName);
        selected.setAge(newAge);

        if (selected instanceof InPatient ip) {
            System.out.print("Enter new days admitted: ");
            int days = sc.nextInt();
            System.out.print("Enter new daily charge: ");
            double charge = sc.nextDouble();
            sc.nextLine();
            ip.setDaysAdmitted(days);
            ip.setDailyCharge(charge);
        } else if (selected instanceof OutPatient op) {
            System.out.print("Enter new consultation fee: ");
            double fee = sc.nextDouble();
            sc.nextLine();
            op.setConsultationFee(fee);
        }

        System.out.println("Patient updated successfully!");
    }

    // DELETE → Patient
    static void deletePatient() {
        System.out.print("Enter Patient ID to delete: ");
        while (!sc.hasNextInt()) {
            System.out.print("Enter numeric Patient ID: ");
            sc.next();
        }
        int id = sc.nextInt();
        sc.nextLine();

        Iterator<Patient> it = patients.iterator();
        boolean removed = false;
        while (it.hasNext()) {
            if (it.next().getPatientId() == id) {
                it.remove();
                removed = true;
                System.out.println("Patient deleted successfully!");
                break;
            }
        }
        if (!removed) System.out.println("Patient ID not found!");
    }
}
