// Student class is used to store student details
class Student {
    // This variable is common for all students
    static String universityName = "Global University";
    // This variable keeps count of total students
    private static int totalStudents = 0;
    // Roll number should not change, so it is final
    final int rollNumber;
    // These values are different for each student
    String name;
    String grade;
    // Constructor to set student data
    // 'this' is used to refer to the current student object
    Student(int rollNumber, String name, String grade) {
        this.rollNumber = rollNumber; // set roll number
        this.name = name;             // set student name
        this.grade = grade;           // set student grade
        totalStudents++;              // increase student count
    }
    // This method shows how many students are enrolled
    static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }
    // This method displays student details
    // instanceof is used to make sure object is of Student type
    void displayDetails(Object obj) {
        if (obj instanceof Student) {
            System.out.println("University Name: " + universityName);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("Grade: " + grade);
        }
    }
    // This method updates the grade of a student
    // Object check is done before updating
    void updateGrade(Object obj, String newGrade) {
        if (obj instanceof Student) {
            this.grade = newGrade;
            System.out.println("Grade updated to: " + newGrade);
        }
    }
}
// Main class for starting the execution of program
public class UniversityStudentManagement {
    public static void main(String[] args) {
        // Creating first student
        Student student1 = new Student(101, "Hemashree", "A");
        // Creating second student
        Student student2 = new Student(102, "Sharmila", "B");
        // Display total students
        Student.displayTotalStudents();
        // Display student details
        student1.displayDetails(student1);
        student2.displayDetails(student2);
        // Update grade of second student
        student2.updateGrade(student2, "A");
        // Display updated details
        student2.displayDetails(student2);
    }
}
