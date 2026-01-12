import java.util.ArrayList;
import java.util.Scanner;

public class CourseRegisteration {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        RegisterationService service = new RegisterationServiceImpl();

        while (true) {
            System.out.println("\n1. Register Student");
            System.out.println("2. Enroll Course");
            System.out.println("3. Drop Course");
            System.out.println("4. Add Grade");
            System.out.println("5. View Grades");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1: // Register Student
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    students.add(new Student(id, name));
                    System.out.println("Student registered");
                    break;

                case 2: // Enroll Course
                    Student s1 = getStudent(sc, students);
                    if (s1 != null) {
                        System.out.print("Enter Course Name: ");
                        String course = sc.nextLine();
                        try {
                            service.enrollCourse(s1, course);
                        } catch (CourseLimitExceededException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;

                case 3: // Drop Course
                    Student s2 = getStudent(sc, students);
                    if (s2 != null) {
                        System.out.print("Enter Course Name: ");
                        String dropCourse = sc.nextLine();
                        service.dropCourse(s2, dropCourse);
                    }
                    break;

                case 4: // Add Grade
                    Student s3 = getStudent(sc, students);
                    if (s3 != null) {
                        System.out.print("Enter Course Name: ");
                        String gradeCourse = sc.nextLine();
                        System.out.print("Enter Grade: ");
                        String grade = sc.nextLine();
                        s3.addGrade(gradeCourse, grade);
                    }
                    break;

                case 5: // View Grades
                    Student s4 = getStudent(sc, students);
                    if (s4 != null) {
                        s4.viewGrades();
                    }
                    break;

                case 6:
                    System.out.println("Exit");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    // helper method (simple, no extra logic)
    private static Student getStudent(Scanner sc, ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students registered");
            return null;
        }

        System.out.print("Enter Student ID: ");
        int sid = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {
            if (s.getId() == sid) {
                return s;
            }
        }

        System.out.println("Student not found");
        return null;
    }
}
