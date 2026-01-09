// InPatient class
public class InPatient extends Patient implements IPayable {

    private int daysAdmitted;
    private double dailyCharge;

    public InPatient(int patientId, String name, int age, Doctor doctor, int daysAdmitted, double dailyCharge) {
        super(patientId, name, age, doctor);
        this.daysAdmitted = daysAdmitted;
        this.dailyCharge = dailyCharge;
    }

    public int getDaysAdmitted() { return daysAdmitted; }
    public void setDaysAdmitted(int daysAdmitted) { this.daysAdmitted = daysAdmitted; }
    public double getDailyCharge() { return dailyCharge; }
    public void setDailyCharge(double dailyCharge) { this.dailyCharge = dailyCharge; }

    @Override
    public void displayInfo() {
        System.out.println(
                "InPatient ID: " + patientId +
                " | Name: " + name +
                " | Age: " + age +
                " | Doctor: " + doctor.getName() +
                " | Days Admitted: " + daysAdmitted +
                " | Bill: ₹" + calculateBill()
        );
    }

    @Override
    public double calculateBill() { return daysAdmitted * dailyCharge; }
}
