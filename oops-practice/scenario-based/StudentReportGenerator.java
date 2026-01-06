import java.util.*;
// Custom Exception
class InvalidMarkException extends Exception {
    public InvalidMarkException(String message) {
        super(message);
    }
}
// Student Class
class Student {
    String Name;
    int[] Marks;

    Student(String Name, int[] Marks) {
        this.Name = Name;
        this.Marks = Marks;
    }
}
// Report Utility Class
class ReportGenerator {
    // Validate marks
    public static void validateMarks(int[] Marks) throws InvalidMarkException {
        for (int M : Marks) {
            if (M < 0 || M > 100) {
                throw new InvalidMarkException("Marks should be between 0 and 100");
            }
        }
    }

    // Calculate average
    public static double CalculateAvg(int[] Marks) {
        int Sum = 0;
        for (int M : Marks) {
            Sum += M;
        }
        return (double) Sum / Marks.length;
    }

    // Assign grade
    public static String GetGrade(double Avg) {
        if (Avg >= 80) return "A";
        else if (Avg >= 60) return "B";
        else if (Avg >= 40) return "C";
        else return "Fail";
    }

    // Display report card
    public static void displayReport(Student Student, String[] Subjects)
            throws InvalidMarkException {

        validateMarks(Student.Marks);
        System.out.println("==========================================================");
        System.out.println("                    REPORT CARD               ");
        System.out.println("==========================================================");
        System.out.println("Student Name : " + Student.Name);
        System.out.println("----------------------------------------------------------");

        for (int i = 0; i < Subjects.length; i++) {
            System.out.printf("%-10s : %3d%n", Subjects[i], Student.Marks[i]);
        }

        double Avg = CalculateAvg(Student.Marks);
        String Grade = GetGrade(Avg);

        System.out.println("-----------------------------------------------------------");
        System.out.printf("Average     : %.2f%n", Avg);
        System.out.println("Grade       : " + Grade);
    }
}

// Main Class
public class StudentReportGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] Subjects = {"Maths", "Science", "English", "Computer"};
        int SubjectCount = Subjects.length;
        List<Student> Students = new ArrayList<>();
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // clear buffer
        for (int s = 1; s <= n; s++) {
            try {
                System.out.print("\nEnter student name: ");
                String Name = sc.nextLine();
                int[] Marks = new int[SubjectCount];
                for (int i = 0; i < SubjectCount; i++) {
                    System.out.print("Enter marks for " + Subjects[i] + ": ");
                    Marks[i] = sc.nextInt();
                }
                sc.nextLine(); // clear buffer
                Student Student = new Student(Name, Marks);
                Students.add(Student);
                ReportGenerator.displayReport(Student, Subjects);
            } catch (InvalidMarkException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
