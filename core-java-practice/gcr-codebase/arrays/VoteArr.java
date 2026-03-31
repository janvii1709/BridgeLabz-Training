import java.util.*;
public class VoteArr {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int [] AgeOfStudents = new int[10];// declaring array for 10 students
    // taking user input age for each students
    for(int i = 0; i < AgeOfStudents.length ; i++){
        System.out.print("Enter age of student " + (i + 1) + ": ");
        AgeOfStudents[i] = sc.nextInt();
    }
        // checking eligibility of voting
        for (int i = 0; i < AgeOfStudents.length; i++) {
            if (AgeOfStudents[i] < 0) {
                System.out.println("Invalid age");
            } else if (AgeOfStudents[i] >= 18) {
                System.out.println("The student with the age " + AgeOfStudents[i] + " can vote.");
            } else {
                System.out.println("The student with the age " + AgeOfStudents[i] + " cannot vote.");
            }
        }
    }
}

