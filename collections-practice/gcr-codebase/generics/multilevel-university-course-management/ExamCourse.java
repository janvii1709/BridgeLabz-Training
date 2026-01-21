public class ExamCourse extends CourseType {
    private int examDuration; // in minutes

    public ExamCourse(String courseName, int credits, int examDuration) {
        super(courseName, credits);
        this.examDuration = examDuration;
    }

    @Override
    public void displayInfo() {
        System.out.println("Exam-Based Course: " + courseName + ", Credits: " + credits + ", Exam Duration: " + examDuration + " mins");
    }
}
