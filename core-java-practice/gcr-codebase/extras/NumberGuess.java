import java.util.Random;
import java.util.Scanner;
public class NumberGuess {
    // Method to generate a random guess between min and max
    public static int GenerateGuess(int Min, int Max) {
        Random Rand = new Random();
        return Rand.nextInt(Max - Min + 1) + Min;
    }
    // Method to get feedback from the user
    public static String GetFeedback(Scanner sc) {
        System.out.print("Enter feedback (high / low / correct): ");
        return sc.nextLine().toLowerCase();
    }

    // Method to update the guessing range based on feedback
    public static int[] UpdateRange(String Feedback, int Guess, int Min, int Max) {
        if (Feedback.equals("high")) {
            Max = Guess - 1;
        } else if (Feedback.equals("low")) {
            Min = Guess + 1;
        }
        return new int[]{Min, Max};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Initial guessing range
        int Min = 1;
        int Max = 100;
        System.out.println("Think of a number between 1 and 100.");
        System.out.println("Computer will try to guess it!");
        while (true) {
            // Generate computer guess
            int Guess = GenerateGuess(Min, Max);
            System.out.println("Computer guesses: " + Guess);
            // Get user feedback
            String Feedback = GetFeedback(sc);
            // If guess is correct, stop the game
            if (Feedback.equals("correct")) {
                System.out.println("Computer guessed the correct number!");
                break;
            }

            // Update the range based on user feedback
            int[] Range = UpdateRange(Feedback, Guess, Min, Max);
            Min = Range[0];
            Max = Range[1];
        }
    }
}
