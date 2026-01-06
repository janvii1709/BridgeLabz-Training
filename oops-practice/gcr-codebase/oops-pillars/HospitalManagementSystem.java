import java.util.*;

//Interface
// This interface is used to manage patient medical records
interface MedicalRecord {
    void addRecord(String record);   // Add diagnosis or medical note
    void viewRecords();              // View medical history
}

// Abstract Class
// Parent class for all types of patients
abstract class Patient {

    // Basic patient details (protected via encapsulation)
    private int patientId;
    private String name;
    private int age;

    // Sensitive medical data (kept private)
    private ArrayList<String> medicalHistory = new ArrayList<>();

    // Constructor to initialize patient details
    Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Getters (read-only access)
    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Method to add medical record safely
    protected void addMedicalHistory(String record) {
        medicalHistory.add(record);
    }

    // Method to view medical records
    protected void showMedicalHistory() {
        if (medicalHistory.isEmpty()) {
            System.out.println("No medical records available");
        } else {
            System.out.println("Medical History:");
            for (String r : medicalHistory) {
                System.out.println("- " + r);
            }
        }
    }

    // Concrete method to display patient details
    public void getPatientDetails() {
        System.out.println("Patient ID : " + patientId);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
    }

    // Abstract method for bill calculation
    abstract double calculateBill();
}

// InPatient Class
// InPatient stays in hospital for multiple days
class InPatient extends Patient implements MedicalRecord {

    private int daysAdmitted;
    private double dailyCharge;

    InPatient(int id, String name, int age, int daysAdmitted, double dailyCharge) {
        super(id, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyCharge = dailyCharge;
    }

    // Bill = number of days × daily charge
    double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    // Add medical record
    public void addRecord(String record) {
        addMedicalHistory(record);
    }

    // View medical record
    public void viewRecords() {
        showMedicalHistory();
    }
}

// OutPatient Class
// OutPatient visits hospital for consultation only
class OutPatient extends Patient implements MedicalRecord {

    private double consultationFee;

    OutPatient(int id, String name, int age, double consultationFee) {
        super(id, name, age);
        this.consultationFee = consultationFee;
    }

    // Bill = consultation fee only
    double calculateBill() {
        return consultationFee;
    }

    public void addRecord(String record) {
        addMedicalHistory(record);
    }

    public void viewRecords() {
        showMedicalHistory();
    }
}

// Main Class
public class HospitalManagementSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ArrayList to store multiple patients
        ArrayList<Patient> patients = new ArrayList<>();

        System.out.print("Enter number of patients: ");
        int n = sc.nextInt();
        sc.nextLine();

        // Taking input for each patient
        for (int i = 1; i <= n; i++) {

            System.out.println("\nEnter details for patient " + i);

            // Patient ID (numeric)
            System.out.print("Patient ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            // Name 
            String name;
            while (true) {
                System.out.print("Name : ");
                name = sc.nextLine();
                if (name.matches("[a-zA-Z ]+"))
                    break;
                System.out.println("Name must contain only alphabets");
            }

            // Age 
            System.out.print("Age: ");
            int age = sc.nextInt();

            // Patient type selection
            int type;
            while (true) {
                System.out.println("Patient Type:");
                System.out.println("1. InPatient");
                System.out.println("2. OutPatient");
                type = sc.nextInt();

                if (type == 1 || type == 2)
                    break;
                System.out.println("Invalid choice! Enter 1 or 2");
            }

            Patient patient;

            if (type == 1) {
                System.out.print("Days Admitted: ");
                int days = sc.nextInt();
                System.out.print("Daily Charge: ");
                double charge = sc.nextDouble();

                patient = new InPatient(id, name, age, days, charge);
            } else {
                System.out.print("Consultation Fee: ");
                double fee = sc.nextDouble();

                patient = new OutPatient(id, name, age, fee);
            }

            sc.nextLine();

            // Adding medical record
            System.out.print("Enter diagnosis/medical note: ");
            String record = sc.nextLine();
            ((MedicalRecord) patient).addRecord(record);

            patients.add(patient);
        }

        //  Display Section
        System.out.println("\n----- Patient Billing Summary -----");

        // Polymorphism: same reference, different behavior
        for (Patient p : patients) {

            p.getPatientDetails();
            System.out.println("Total Bill : " + p.calculateBill());

            // Interface reference
            ((MedicalRecord) p).viewRecords();
            System.out.println("-------------------------------");
        }
    }
}
