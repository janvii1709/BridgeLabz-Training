import java.util.*;
public class GradeCalculator {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int physics = sc.nextInt();// input physics marks from user
    int chemistry = sc.nextInt(); // input chemistry marks from user
    int maths = sc.nextInt() ; // input maths marks from user
    if (physics < 0 || physics > 100 ||
            chemistry < 0 || chemistry > 100 ||
            maths < 0 || maths > 100) {// check valid marks from (0 to 100)
            System.out.println("Please enter valid marks between 0 and 100.");

        } else {
        int total =  physics + chemistry + maths; // calculate total marks
        double percentage = (total / 300.0) * 100;  // calculate percentage 
        double average = total / 3.0 ; // calculate average marks
        String grade; // variable to store grade
        String remarks; // variable to store remarks
        // grade calculation
        if(percentage >= 80){
            grade = "A";
            remarks="Level 4, above agency-normalized standards";
        }
        else if(percentage >= 70 && percentage < 80){
            grade = "B";
            remarks = "Level 3, at agency-normalized standards";
        }
        else if (percentage >= 60 && percentage < 70){
            grade = "C";
            remarks = "Level 2, below, but approaching agency-normalized standards";
        }
        else if (percentage >= 50 && percentage < 60){
            grade = "D";
            remarks = "Level 1, well below agency-normalized standards";
        }
        else if(percentage >= 40 && percentage < 50){
            grade = "E";
            remarks = "Level 1-, too below agency-normalized standards";
        }
        else {
            grade = "R";
            remarks = "Remedial standards";
        }
        System.out.println("Total Marks: " + total);
        System.out.println("Percentage: " + percentage);
        System.out.println("Average Marks: " + average);
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remarks);
    }
}
}