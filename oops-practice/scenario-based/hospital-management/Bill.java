// Bill class
public class Bill {

    private Patient patient;

    public Bill(Patient patient) { this.patient = patient; }

    public void displayBill() {
        System.out.println("----- Bill Details -----");
        patient.displayInfo();
        System.out.println("-----------------------");
    }
}
