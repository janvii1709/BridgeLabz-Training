import java.util.Scanner;
public class StudentTestScores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Ask how many students are there
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        // Create an array to store scores of n students
        int[] Scores = new int[n];
        int Sum = 0;
        // Take input for each student's score
        for (int i = 0; i < n; i++) {
            while (true) {
                try {
                    System.out.print("Enter score for student " + (i + 1) + ": ");
                    int Score = sc.nextInt();

                    // Check for negative score
                    if (Score < 0) {
                        System.out.println("Score cannot be negative. Please enter again.");
                        continue;
                    }
                    // Store valid score
                    Scores[i] = Score;
                    Sum += Score;
                    break;
                } catch (Exception e) {
                    // Handle non-numeric input
                    System.out.println("Invalid input. Please enter a number.");
                    sc.next(); // clear invalid input
                }
            }
        }
        // Calculate average score
        double Average = (double) Sum / n;
        // Assume first score is both highest and lowest at start
        int Highest = Scores[0];
        int Lowest = Scores[0];
        // Find highest and lowest score
        for (int i = 1; i < n; i++) {
            if (Scores[i] > Highest) {
                Highest = Scores[i];
            }
            if (Scores[i] < Lowest) {
                Lowest = Scores[i];
            }
        }
        // Display average, highest and lowest scores
        System.out.println("\nAverage Score: " + Average);
        System.out.println("Highest Score: " + Highest);
        System.out.println("Lowest Score: " + Lowest);
        // Display scores above average
        System.out.println("\nScores above average:");
        for (int i = 0; i < n; i++) {
            if (Scores[i] > Average) {
                System.out.println(Scores[i]);
            }
        }
    }
}
