import java.util.*;
public class GradeArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //input number of students
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        //Arrays
        // marks[i][0] = Physics marks
        // marks[i][1] = Chemistry marks
        // marks[i][2] = Maths marks
        int[][] Marks = new int[n][3];
        double[] Percentage = new double[n]; // Percentage of each student
        String[] Grade = new String[n];      // Grade of each student

        // input marks
        for (int i = 0; i < n; i++) {
            System.out.println("Enter marks for Student " + (i + 1));
            System.out.print("Physics: ");
            Marks[i][0] = sc.nextInt();
            System.out.print("Chemistry: ");
            Marks[i][1] = sc.nextInt();
            System.out.print("Maths: ");
            Marks[i][2] = sc.nextInt();
            // Validation as the marks should be between 0 and 100
            if (Marks[i][0] < 0 || Marks[i][0] > 100 || Marks[i][1] < 0 || Marks[i][1] > 100 || Marks[i][2] < 0 || Marks[i][2] > 100) {
                System.out.println("Invalid marks . Please enter marks between 0 and 100.");
                i--; // index decrement TO re eneter the marks
            }
        }
        //calculating percentage and grade
        for (int i = 0; i < n; i++) {
            int total = Marks[i][0] + Marks[i][1] + Marks[i][2];
            Percentage[i] = (total / 300.0) * 100;
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
        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1));
            System.out.println("Physics Marks   : " + Marks[i][0]);
            System.out.println("Chemistry Marks : " + Marks[i][1]);
            System.out.println("Maths Marks     : " + Marks[i][2]);
            System.out.println("Percentage      : " + Percentage[i]);
            System.out.println("Grade           : " + Grade[i]);
        }

    }
    
}

