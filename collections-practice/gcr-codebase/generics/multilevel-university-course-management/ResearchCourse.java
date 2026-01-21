public class ResearchCourse extends CourseType {
    private String researchField;

    public ResearchCourse(String courseName, int credits, String researchField) {
        super(courseName, credits);
        this.researchField = researchField;
    }

    @Override
    public void displayInfo() {
        System.out.println("Research-Based Course: " + courseName + ", Credits: " + credits + ", Research Field: " + researchField);
    }
}
