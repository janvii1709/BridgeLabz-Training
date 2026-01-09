// Abstract Patient class
public abstract class Patient {

    protected int patientId;
    protected String name;
    protected int age;
    protected Doctor doctor;

    public Patient(int patientId, String name, int age, Doctor doctor) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.doctor = doctor;
    }

    public int getPatientId() { return patientId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public abstract void displayInfo(); // Polymorphism
}
