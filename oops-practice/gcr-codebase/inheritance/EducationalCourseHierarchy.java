import java.util.Scanner;

// Base class: Course
class Course {
    String courseName;
    int duration; // in hours

    // Constructor
    Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    // Method to display course details
    void displayInfo() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " hours");
    }
}

// Subclass: OnlineCourse
class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    // Constructor
    OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration); // call parent constructor
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    // Override displayInfo to include online course details
    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

// Subclass: PaidOnlineCourse
class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount; // in percentage

    // Constructor
    PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    // Override displayInfo to include fee details
    @Override
    void displayInfo() {
        super.displayInfo();
        double finalFee = fee - (fee * discount / 100);
        System.out.println("Fee: INR " + fee);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Final Fee after discount: INR " + finalFee);
    }
}

// Main Class
public class EducationalCourseHierarchy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("----- Educational Course Setup -----");

            System.out.print("Enter Course Name: ");
            String courseName = sc.nextLine();

            System.out.print("Enter Course Duration (hours): ");
            int duration = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Enter Platform Name: ");
            String platform = sc.nextLine();

            System.out.print("Is the course recorded? (true/false): ");
            boolean isRecorded = sc.nextBoolean();

            System.out.print("Enter Course Fee: ");
            double fee = sc.nextDouble();

            System.out.print("Enter Discount Percentage: ");
            double discount = sc.nextDouble();

            // Create PaidOnlineCourse object
            PaidOnlineCourse course = new PaidOnlineCourse(courseName, duration, platform, isRecorded, fee, discount);

            System.out.println("\n----- Course Details -----");
            course.displayInfo();

        } catch (Exception e) {
            System.out.println("Invalid input! Please check your entries.");
        } finally {
        }
    }
}
