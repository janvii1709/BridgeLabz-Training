public class AssignmentCourse extends CourseType {
    private int numAssignments;

    public AssignmentCourse(String courseName, int credits, int numAssignments) {
        super(courseName, credits);
        this.numAssignments = numAssignments;
    }

    @Override
    public void displayInfo() {
        System.out.println("Assignment-Based Course: " + courseName + ", Credits: " + credits + ", Number of Assignments: " + numAssignments);
    }
}
