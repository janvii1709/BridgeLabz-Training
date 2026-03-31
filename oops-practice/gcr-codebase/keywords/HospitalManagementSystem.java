// Patient class represents details of a hospital patient
class Patient {
    // Static variable shared by all patients
    // Same hospital name for everyone
    static String hospitalName = "City Hospital";
    // Static variable to count total patients admitted
    private static int totalPatients = 0;
    // Final variable so patient ID cannot be changed
    final String patientID;
    // Instance variables (different for each patient)
    String name;
    int age;
    String ailment;
    // Constructor to initialize patient details
    // 'this' keyword is used to refer to current object values
    Patient(String patientID, String name, int age, String ailment) {
        this.patientID = patientID;   // Assign patient ID
        this.name = name;             // Assign patient name
        this.age = age;               // Assign patient age
        this.ailment = ailment;       // Assign patient illness
        // Increase patient count whenever a new patient is created
        totalPatients++;
    }
    // Static method to return total number of patients
    static int getTotalPatients() {
        return totalPatients;
    }
    // Method to display patient details
    // instanceof is used to check object belongs to Patient class
    void displayDetails(Object obj) {
        if (obj instanceof Patient) {
            System.out.println("Hospital Name: " + hospitalName);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
        }
    }
}
// Main class for starting the execution of program
public class HospitalManagementSystem {
    public static void main(String[] args) {
        // Creating first patient object
        Patient patient1 = new Patient("P001", "Lathika", 30, "Flu");
        // Creating second patient object
        Patient patient2 = new Patient("P002", "Lidiya", 45, "Fracture");
        // Display total number of patients admitted
        System.out.println("Total Patients Admitted: " + Patient.getTotalPatients());
        // Display details of each patient
        patient1.displayDetails(patient1);
        patient2.displayDetails(patient2);
    }
}
