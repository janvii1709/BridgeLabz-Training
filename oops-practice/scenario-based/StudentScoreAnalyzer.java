import java.util.Scanner;

public class StudentScoreAnalyzer {

    // Method to calculate average
    public static int getAverage(int[] scores) {
        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        return sum / scores.length;
    }

    // Method to get maximum score
    public static int getMax(int[] scores) {
        int max = scores[0];
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }
        }
        return max;
    }

    // Method to get minimum score
    public static int getMin(int[] scores) {
        int min = scores[0];
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        int[] scores = new int[n];

        try {
            for (int i = 0; i < n; i++) {
                System.out.print("Enter the score of student " + (i + 1) + ": ");
                scores[i] = sc.nextInt();

                if (scores[i] < 0 || scores[i] > 100) {
                    throw new Exception("Invalid score: " + scores[i]);
                }
            }

            // Output results
            System.out.println("\nAverage Score: " + getAverage(scores));
            System.out.println("Highest Score: " + getMax(scores));
            System.out.println("Lowest Score: " + getMin(scores));

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
