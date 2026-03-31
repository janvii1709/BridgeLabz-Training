import java.util.*;
public class GradeArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // input number from user
        System.out.print("Enter the number of students: ");
        int Numb = sc.nextInt();
        // Declaring array to store marks of physics for each student
        int[] Physics = new int[Numb];
        // Declaring array to store marks of chemistry for each student
        int[] Chemistry = new int[Numb];
        // Declaring array to store marks of maths for each student
        int[] Maths = new int[Numb];
        // Declaring array to store percentage for each student
        double[] Percentage = new double[Numb];
        // Declaring array to store grade for each student
        char[] Grade = new char[Numb];
        // Loop to take input for the marks of students
        for (int i=0; i<Numb; i++) {
            System.out.println("Enter marks for Student " + (i + 1));
            System.out.print("Physics: ");
            Physics[i] = sc.nextInt();
            if (Physics[i] < 0) { i--; continue; }
            System.out.print("Chemistry: ");
            Chemistry[i] = sc.nextInt();
            if (Chemistry[i] < 0) { i--; continue; }
            System.out.print("Maths: ");
            Maths[i] = sc.nextInt();
            if (Maths[i] < 0) { i--; continue; }
        }

        // Loop for calculating percentage and grade of each student
        for (int i=0; i<Numb; i++) {
            Percentage[i] = (Physics[i] + Chemistry[i] + Maths[i]) / 3.0;
            if (Percentage[i] >= 80)
                Grade[i] = 'A';
            else if (Percentage[i] >= 70 && Percentage[i] <= 79)
                Grade[i] = 'B';
            else if (Percentage[i] >= 60 && Percentage[i] <= 69)
                Grade[i] = 'C';
            else if (Percentage[i] >= 50 && Percentage[i] <= 99)
                Grade[i] = 'D';
            else if (Percentage[i] >= 40 && Percentage[i] <= 49)
                Grade[i] = 'E';
            else
                Grade[i] = 'R';
        }
        // Loop for printing the result
        System.out.println("Student Results:");
        for (int i=0; i<Numb; i++) {
            System.out.println(
                "Student " + (i + 1) +
                " | Physics: " + Physics[i] +
                " | Chemistry: " + Chemistry[i] +
                " | Maths: " + Maths[i] +
                " | Percentage: " + String.format("%.2f", Percentage[i]) +
                " | Grade: " + Grade[i]
            );
        }
    }
}
         