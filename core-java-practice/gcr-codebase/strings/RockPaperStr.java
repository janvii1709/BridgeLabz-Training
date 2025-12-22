import java.util.Scanner;

public class RockPaperStr {

    // Method to generate computer's random choice
    static String Choice() {
        int Ran = (int)(Math.random() * 3); // Random number between 0 and 2
        // Return "rock" for 0, "paper" for 1, "scissors" for 2
        return (Ran == 0) ? "rock" : (Ran == 1) ? "paper" : "scissors";
    }

    // Method to determine winner of a single game
    // Returns 1 if user wins, -1 if computer wins, 0 if draw
    static int Winner(String User, String Comp) {
        if (User.equals(Comp)) return 0; // Draw
        // Check all winning combinations for the user
        if ((User.equals("rock") && Comp.equals("scissors")) ||
            (User.equals("paper") && Comp.equals("rock")) ||
            (User.equals("scissors") && Comp.equals("paper")))
            return 1; // User wins
        return -1; // Computer wins
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Number of games: ");
        int Num = sc.nextInt(); // Read number of games from user

        int User_Wins = 0, Comp_Wins = 0; // Counters for wins

        // Loop for each game
        for (int i = 1; i <= Num; i++) {
            System.out.print("Enter rock/paper/scissors: ");
            String User = sc.next(); // Read user's choice
            String Comp = Choice(); // Generate computer's choice

            int Res = Winner(User, Comp); // Determine winner
            if (Res == 1) User_Wins++;   // Increment user wins
            else if (Res == -1) Comp_Wins++; // Increment computer wins

            System.out.println("Game " + i + ": Computer = " + Comp); // Show computer choice
        }

        // final outputs
        System.out.println("\nPlayer Wins: " + User_Wins);
        System.out.println("Computer Wins: " + Comp_Wins);
        System.out.println("Player Win %: " + (User_Wins * 100.0 / Num));
        System.out.println("Computer Win %: " + (Comp_Wins * 100.0 / Num));
    }
}
