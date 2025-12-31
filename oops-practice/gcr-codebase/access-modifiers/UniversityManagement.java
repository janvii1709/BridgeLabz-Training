// Base Class
class Student {

    // Public variable
    // Can be accessed from anywhere
    public int rollNumber;

    // Protected variable
    // Can be accessed within same package or subclass
    protected String name;

    // Private variable
    // Can be accessed only inside this class
    private double CGPA;

    // Parameterized constructor
    // Used to initialize student details
    Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    // Public setter method
    // Used to modify private CGPA
    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

    // Public getter method
    // Used to access private CGPA
    public double getCGPA() {
        return CGPA;
    }

    // Method to display student details
    public void displayStudentDetails() {
        System.out.println("Roll Number : " + rollNumber);
        System.out.println("Name        : " + name);
        System.out.println("CGPA        : " + CGPA);
        System.out.println("---------------------------------------------");
    }
}

// Subclass 
class PostgraduateStudent extends Student {

    // Constructor of subclass
    // Calls parent class constructor using super keyword
    PostgraduateStudent(int rollNumber, String name, double CGPA) {
        super(rollNumber, name, CGPA);
    }

    // Method to demonstrate access of public and protected members
    public void displayPostgraduateDetails() {

        // Accessing public variable from parent class
        System.out.println("PG Student Roll Number : " + rollNumber);

        // Accessing protected variable from parent class
        System.out.println("PG Student Name        : " + name);

        // Accessing private variable using getter method
        System.out.println("PG Student CGPA        : " + getCGPA());

        System.out.println("---------------------------");
    }
}

// Main Class
public class UniversityManagement {

    public static void main(String[] args) {

        // Creating object of Student class
        Student student1 = new Student(101, "Janhavi", 9.1);

        System.out.println("Student Details:");
        System.out.println();

        // Displaying student details
        student1.displayStudentDetails();

        // Modifying CGPA using setter method
        student1.setCGPA(9.3);

        System.out.println("After Updating CGPA:");
        System.out.println();

        // Displaying updated details
        student1.displayStudentDetails();

        // Creating object of PostgraduateStudent class
        PostgraduateStudent pg1 =
                new PostgraduateStudent(201, "Rahul", 8.7);

        System.out.println("Postgraduate Student Details:");
        System.out.println();

        // Displaying postgraduate student details
        pg1.displayPostgraduateDetails();
    }
}
