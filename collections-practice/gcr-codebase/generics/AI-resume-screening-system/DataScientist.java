
public class DataScientist extends JobRole {
    public DataScientist(String name, int experience) {
        super(name, experience);
    }

    @Override
    public void requiredSkills() {
        System.out.println("Skills: Python, Machine Learning, Statistics, SQL");
    }
}
