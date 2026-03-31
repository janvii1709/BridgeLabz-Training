import java.util.Scanner;

// Superclass
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

// Teacher subclass
class Teacher extends Person {
    String subject;

    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    void displayRole() {
        System.out.println("Role: Teacher");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Subject: " + subject);
    }
}

// Student subclass
class Student extends Person {
    String grade;

    Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    void displayRole() {
        System.out.println("Role: Student");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
    }
}

// Staff subclass
class Staff extends Person {
    String department;

    Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    void displayRole() {
        System.out.println("Role: Staff");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Department: " + department);
    }
}

// Main class
public class SchoolSystemWithDifferentRoles {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ---------- Teacher Input ----------
        System.out.println("Enter Teacher details:");

        String tName;
        while (true) {
            System.out.print("Name: ");
            tName = sc.nextLine();
            if (tName.matches("[A-Za-z ]+")) break;
            System.out.println("Name must contain only alphabets.");
        }

        int tAge;
        while (true) {
            System.out.print("Age: ");
            if (sc.hasNextInt()) {
                tAge = sc.nextInt();
                sc.nextLine();
                break;
            } else {
                System.out.println(" Age must be an integer.");
                sc.nextLine();
            }
        }

        String subject;
        while (true) {
            System.out.print("Subject: ");
            subject = sc.nextLine();
            if (subject.matches("[A-Za-z ]+")) break;
            System.out.println(" Subject must contain only alphabets.");
        }

        Teacher teacher = new Teacher(tName, tAge, subject);

        // ---------- Student Input ----------
        System.out.println("\nEnter Student details:");

        String sName;
        while (true) {
            System.out.print("Name: ");
            sName = sc.nextLine();
            if (sName.matches("[A-Za-z ]+")) break;
            System.out.println(" Name must contain only alphabets.");
        }

        int sAge;
        while (true) {
            System.out.print("Age: ");
            if (sc.hasNextInt()) {
                sAge = sc.nextInt();
                sc.nextLine();
                break;
            } else {
                System.out.println(" Age must be an integer.");
                sc.nextLine();
            }
        }

        String grade;
        while (true) {
            System.out.print("Grade (A/B/C/D/E): ");
            grade = sc.nextLine().toUpperCase();
            if (grade.matches("[ABCDE]")) break;
            System.out.println(" Grade must be A, B, C, D, or E only.");
        }

        Student student = new Student(sName, sAge, grade);

        // ---------- Staff Input ----------
        System.out.println("\nEnter Staff details:");

        String stName;
        while (true) {
            System.out.print("Name: ");
            stName = sc.nextLine();
            if (stName.matches("[A-Za-z ]+")) break;
            System.out.println(" Name must contain only alphabets.");
        }

        int stAge;
        while (true) {
            System.out.print("Age: ");
            if (sc.hasNextInt()) {
                stAge = sc.nextInt();
                sc.nextLine();
                break;
            } else {
                System.out.println(" Age must be an integer.");
                sc.nextLine();
            }
        }

        String department;
        while (true) {
            System.out.print("Department: ");
            department = sc.nextLine();
            if (department.matches("[A-Za-z ]+")) break;
            System.out.println(" Department must contain only alphabets.");
        }

        Staff staff = new Staff(stName, stAge, department);

        // ---------- Output ----------
        System.out.println("\n--- School Members ---");
        teacher.displayRole();
        System.out.println();
        student.displayRole();
        System.out.println();
        staff.displayRole();
    }
}
