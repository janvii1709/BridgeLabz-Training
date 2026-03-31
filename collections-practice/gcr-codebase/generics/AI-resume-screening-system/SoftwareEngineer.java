
public class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String name, int experience) {
        super(name, experience);
    }

    @Override
    public void requiredSkills() {
        System.out.println("Skills: Java, Data Structures, Algorithms, OOP");
    }
}
