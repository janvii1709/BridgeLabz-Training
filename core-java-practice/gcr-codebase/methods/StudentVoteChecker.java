import java.util.Scanner;
public class StudentVoteChecker {
    // Method to check whether a student can vote
    public static boolean canStudentVote(int age) {

        // If age is negative, student cannot vote
        if (age < 0) {
            return false;
        }

        // Check if age is 18 or above
        if (age >= 18) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Array to store ages of 10 students
        int[] ages = new int[10];

        // Taking input and checking voting eligibility
        for (int i = 0; i < ages.length; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            ages[i] = sc.nextInt();

            if (canStudentVote(ages[i])) {
                System.out.println("Student " + (i + 1) + " can vote");
            } else {
                System.out.println("Student " + (i + 1) + " cannot vote");
            }
        }
    }
}
