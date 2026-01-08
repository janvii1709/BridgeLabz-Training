import java.util.Scanner;

public class StudentRecordManagement {

    // Student structure of Singly Linked List
    // Each Student node stores one student record
    static class Student {
        int rollNo;        // Student roll number
        String name;       // Student name
        int age;           // Student age
        char grade;        // Student grade
        Student next;      // Reference to next student
    }

    // Head points to first student record
    static Student head = null;

    //  ADDING STUDENT AT THE BEGINNING 
    static void addAtBeginning(int r, String n, int a, char g) {
        Student newStudent = new Student();
        newStudent.rollNo = r;
        newStudent.name = n;
        newStudent.age = a;
        newStudent.grade = g;

        newStudent.next = head;
        head = newStudent;

        System.out.println("Student record added successfully");
    }

    // ADDING STUDENT AT THE  END
    static void addAtEnd(int r, String n, int a, char g) {
        Student newStudent = new Student();
        newStudent.rollNo = r;
        newStudent.name = n;
        newStudent.age = a;
        newStudent.grade = g;
        newStudent.next = null;

        if (head == null) {
            head = newStudent;
        } else {
            Student temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newStudent;
        }

        System.out.println("Student record added successfully");
    }

    // ADDING STUDENT AT A  SPECIFIC POSITION
    static void addAtPosition(int position, int r, String n, int a, char g) {

        if (position == 1) {
            addAtBeginning(r, n, a, g);
            return;
        }

        Student temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        Student newStudent = new Student();
        newStudent.rollNo = r;
        newStudent.name = n;
        newStudent.age = a;
        newStudent.grade = g;

        newStudent.next = temp.next;
        temp.next = newStudent;

        System.out.println("Student record added successfully");
    }

    // DELETING STUDENT BY THERE ROLL NUMBERS
    static void deleteByRollNo(int r) {

        if (head == null) {
            System.out.println("No student records found");
            return;
        }

        if (head.rollNo == r) {
            head = head.next;
            System.out.println("Student record deleted successfully");
            return;
        }

        Student temp = head;
        while (temp.next != null && temp.next.rollNo != r) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Student not found");
        } else {
            temp.next = temp.next.next;
            System.out.println("Student record deleted successfully");
        }
    }

    //SEARCHING STUDENT BY THERE ROLL NUMBER
    static void searchByRollNo(int r) {
        Student temp = head;

        while (temp != null) {
            if (temp.rollNo == r) {
                System.out.println("Student Found:");
                System.out.println("Roll Number: " + temp.rollNo);
                System.out.println("Name: " + temp.name);
                System.out.println("Age: " + temp.age);
                System.out.println("Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Student not found");
    }

    //UPDATING  STUDENTS  GRADE
    static void updateGrade(int r, char g) {
        Student temp = head;

        while (temp != null) {
            if (temp.rollNo == r) {
                temp.grade = g;
                System.out.println("Grade updated successfully");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Student not found");
    }

    // DISPLAYING  ALL RECORDS OF STUDENTS
    static void display() {

        if (head == null) {
            System.out.println("No student records found");
            return;
        }

        System.out.println("RollNo | Name | Age | Grade");

        Student temp = head;
        while (temp != null) {
            System.out.println(
                temp.rollNo + " | " + temp.name + " | " + temp.age + " | " + temp.grade
            );
            temp = temp.next;
        }
    }

    //  MAIN METHOD  FOR  STUDENT RECORD MANAGEMENT
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Specific Position");
            System.out.println("4. Delete by Roll Number");
            System.out.println("5. Search by Roll Number");
            System.out.println("6. Update Grade");
            System.out.println("7. Display All Records");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Roll Number: ");
                    int r1 = sc.nextInt();
                    System.out.print("Enter Name: ");
                    String n1 = sc.next();
                    System.out.print("Enter Age: ");
                    int a1 = sc.nextInt();
                    System.out.print("Enter Grade: ");
                    char g1 = sc.next().charAt(0);
                    addAtBeginning(r1, n1, a1, g1);
                    break;

                case 2:
                    System.out.print("Enter Roll Number: ");
                    int r2 = sc.nextInt();
                    System.out.print("Enter Name: ");
                    String n2 = sc.next();
                    System.out.print("Enter Age: ");
                    int a2 = sc.nextInt();
                    System.out.print("Enter Grade: ");
                    char g2 = sc.next().charAt(0);
                    addAtEnd(r2, n2, a2, g2);
                    break;

                case 3:
                    System.out.print("Enter Position: ");
                    int pos = sc.nextInt();
                    System.out.print("Enter Roll Number: ");
                    int r3 = sc.nextInt();
                    System.out.print("Enter Name: ");
                    String n3 = sc.next();
                    System.out.print("Enter Age: ");
                    int a3 = sc.nextInt();
                    System.out.print("Enter Grade: ");
                    char g3 = sc.next().charAt(0);
                    addAtPosition(pos, r3, n3, a3, g3);
                    break;

                case 4:
                    System.out.print("Enter Roll Number to delete: ");
                    deleteByRollNo(sc.nextInt());
                    break;

                case 5:
                    System.out.print("Enter Roll Number to search: ");
                    searchByRollNo(sc.nextInt());
                    break;

                case 6:
                    System.out.print("Enter Roll Number to update grade: ");
                    int r = sc.nextInt();
                    System.out.print("Enter New Grade: ");
                    char g = sc.next().charAt(0);
                    updateGrade(r, g);
                    break;

                case 7:
                    display();
                    break;

                case 8:
                    System.out.println("Exiting the program");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 8);
    }
}
