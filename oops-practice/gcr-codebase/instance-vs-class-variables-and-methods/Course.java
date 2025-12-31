public class Course {
    // Instance variables (unique for each course)
    String courseName;
    int duration;       // duration in months
    double fee;
    // Class variable (same for all courses)
    static String instituteName = "ABC Institute";
    // Parameterized constructor
    // Used to initialize course details
    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }
    // Instance method
    // Displays details of a single course
    void displayCourseDetails() {
        System.out.println("Institute Name : " + instituteName);
        System.out.println("Course Name    : " + courseName);
        System.out.println("Duration       : " + duration + " months");
        System.out.println("Fee            : INR " + fee);
        System.out.println("---------------------------------------");
    }

    // Class (static) method
    // Updates institute name for all courses
    static void updateInstituteName(String newInstituteName) {
        instituteName = newInstituteName;
    }

    // Main method
    public static void main(String[] args) {

        // Creating course objects
        Course c1 = new Course("Java Full Stack", 6, 45000);
        Course c2 = new Course("Python Data Science", 5, 50000);

        // Display course details before update
        c1.displayCourseDetails();
        c2.displayCourseDetails();

        // Updating institute name for all courses
        Course.updateInstituteName("XYZ Online Academy");

        // Display course details after update
        c1.displayCourseDetails();
        c2.displayCourseDetails();
    }
}
