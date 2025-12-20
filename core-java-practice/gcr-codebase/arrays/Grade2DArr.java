import java.util.*;
public class Grade2DArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //input number of students
        System.out.print("Enter number of students: ");
        int Numb = sc.nextInt();
        // Arrays
        // marks[i][0] = Physics marks of student i
        // marks[i][1] = Chemistry marks of student i
        // marks[i][2] = Maths marks of student i
        int[][] Marks = new int[Numb][3];
        double[] Percentage = new double[Numb]; // Stores percentage of each student
        String[] Grade = new String[Numb];      // Stores grade of each student
        // input the marks
        for (int i = 0; i < Numb; i++) {
            System.out.println("Enter marks for Student " + (i + 1));
            System.out.print("Physics: ");
            Marks[i][0] = sc.nextInt();
            System.out.print("Chemistry: ");
            Marks[i][1] = sc.nextInt();
            System.out.print("Maths: ");
            Marks[i][2] = sc.nextInt();
            // Validation is done as marks must be between 0 and 100
            if (Marks[i][0] < 0 || Marks[i][0] > 100 ||
                Marks[i][1] < 0 || Marks[i][1] > 100 ||
                Marks[i][2] < 0 || Marks[i][2] > 100) {
                System.out.println("Invalid marks. Please enter values between 0 and 100.");
                i--; // index decrement so that same student's marks are entered again
            }
        }
        // calculating percentage and grade
        for (int i = 0; i < Numb; i++) {
            int Total = Marks[i][0] + Marks[i][1] + Marks[i][2];
            Percentage[i] = (Total / 300.0) * 100;
            // Grade calculation based on percentage
            if (Percentage[i] >= 80) {
                Grade[i] = "A";
            } else if (Percentage[i] >= 70) {
                Grade[i] = "B";
            } else if (Percentage[i] >= 60) {
                Grade[i] = "C";
            } else if (Percentage[i] >= 50) {
                Grade[i] = "D";
            } else if (Percentage[i] >= 40) {
                Grade[i] = "E";
            } else {
                Grade[i] = "R";
            }
        }
        for (int i = 0; i < Numb; i++) {
            System.out.println("Student " + (i + 1));
            System.out.println("Physics Marks   : " + Marks[i][0]);
            System.out.println("Chemistry Marks : " + Marks[i][1]);
            System.out.println("Maths Marks     : " + Marks[i][2]);
            System.out.println("Percentage      : " + Percentage[i]);
            System.out.println("Grade           : " + Grade[i]);
        }
        
    }
    
}
