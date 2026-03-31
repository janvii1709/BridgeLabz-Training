import java.util.Random;   // RANDOM class for dice and option

public class SnakeLadder {
    public static void main(String[] args) {

        // UC 1 : Snake and Ladder game with 2 players
        // Both players start from position 0
        int Player1Position = 0;
        int Player2Position = 0;

        // UC 6 : Dice roll count
        int DiceCount = 0;

        // To track whose turn it is (1 or 2)
        int CurrentPlayer = 1;

        // Random object
        Random random = new Random();

        System.out.println("Snake and Ladder Game Started");
        System.out.println("Player 1 Position: 0");
        System.out.println("Player 2 Position: 0");

        // UC 4 : Repeat till any player reaches EXACT 100
        while (Player1Position < 100 && Player2Position < 100) {

            // Select current player's position
            int PlayerPosition = (CurrentPlayer == 1) ? Player1Position : Player2Position;

            // Store previous position (UC 5)
            int PreviousPosition = PlayerPosition;

            // UC 2 : Roll the die (1 to 6)
            int DieRoll = random.nextInt(6) + 1;
            DiceCount++;

            // UC 3 : Check option (0 = No Play, 1 = Ladder, 2 = Snake)
            int Option = random.nextInt(3);

            System.out.println("\nPlayer " + CurrentPlayer + " rolled dice: " + DieRoll);

            // UC 3 : NO PLAY
            if (Option == 0) {
                System.out.println("Option: No Play");
            }

            // UC 3 : LADDER
            else if (Option == 1) {
                System.out.println("Option: Ladder");
                PlayerPosition += DieRoll;
            }

            // UC 3 : SNAKE
            else {
                System.out.println("Option: Snake");
                PlayerPosition -= DieRoll;

                // UC 4 : If position goes below 0, reset to 0
                if (PlayerPosition < 0) {
                    PlayerPosition = 0;
                }
            }

            // UC 5 : If position goes above 100, revert back
            if (PlayerPosition > 100) {
                PlayerPosition = PreviousPosition;
            }

            // Update correct player's position
            if (CurrentPlayer == 1) {
                Player1Position = PlayerPosition;
            } else {
                Player2Position = PlayerPosition;
            }

            // UC 6 : Print position after every dice roll
            System.out.println("Player 1 Position: " + Player1Position);
            System.out.println("Player 2 Position: " + Player2Position);

            // UC 7 : If Ladder, same player plays again
            if (Option != 1) {
                CurrentPlayer = (CurrentPlayer == 1) ? 2 : 1;
            }
        }

        // UC 7 : Declare Winner
        System.out.println("\nGAME OVER ");
        if (Player1Position == 100) {
            System.out.println("Player 1 WON the game!");
        } else {
            System.out.println("Player 2 WON the game!");
        }

        // UC 6 : Total dice rolls
        System.out.println("Total Dice Rolls: " + DiceCount);
    }
}
