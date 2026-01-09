// OutPatient class
public class OutPatient extends Patient implements IPayable {

    private double consultationFee;

    public OutPatient(int patientId, String name, int age, Doctor doctor, double consultationFee) {
        super(patientId, name, age, doctor);
        this.consultationFee = consultationFee;
    }

    public double getConsultationFee() { return consultationFee; }
    public void setConsultationFee(double consultationFee) { this.consultationFee = consultationFee; }

    @Override
    public void displayInfo() {
        System.out.println(
                "OutPatient ID: " + patientId +
                " | Name: " + name +
                " | Age: " + age +
                " | Doctor: " + doctor.getName() +
                " | Consultation Fee: ₹" + calculateBill()
        );
    }

    @Override
    public double calculateBill() { return consultationFee; }
}
