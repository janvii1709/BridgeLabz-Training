import java.util.Scanner;

public class UniversityMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Course<CourseType> allCourses = new Course<>();

        while (true) {
            System.out.println("\n--- University Course Management ---");
            System.out.println("1. Add Exam-Based Course");
            System.out.println("2. Add Assignment-Based Course");
            System.out.println("3. Add Research-Based Course");
            System.out.println("4. Display All Courses");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Course Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Credits: ");
                    int credits = sc.nextInt();
                    System.out.print("Enter Exam Duration (minutes): ");
                    int duration = sc.nextInt();
                    sc.nextLine();
                    ExamCourse examCourse = new ExamCourse(name, credits, duration);
                    allCourses.addCourse(examCourse);
                }
                case 2 -> {
                    System.out.print("Enter Course Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Credits: ");
                    int credits = sc.nextInt();
                    System.out.print("Enter Number of Assignments: ");
                    int numAssignments = sc.nextInt();
                    sc.nextLine();
                    AssignmentCourse assignmentCourse = new AssignmentCourse(name, credits, numAssignments);
                    allCourses.addCourse(assignmentCourse);
                }
                case 3 -> {
                    System.out.print("Enter Course Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Credits: ");
                    int credits = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Research Field: ");
                    String field = sc.nextLine();
                    ResearchCourse researchCourse = new ResearchCourse(name, credits, field);
                    allCourses.addCourse(researchCourse);
                }
                case 4 -> {
                    System.out.println("\n--- All Courses ---");
                    allCourses.displayCourses();
                }
                case 5 -> {
                    System.out.println("Exiting University System...");
                    return;
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
