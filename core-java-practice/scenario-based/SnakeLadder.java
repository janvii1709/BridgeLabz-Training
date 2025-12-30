import java.util.Random;   // RANDOM class for dice and option
public class SnakeLadder {
    public static void main(String[] args) {
        // UC 1 : Snake and Ladder game played with single player
        // Player starts from position 0
        int PlayerPosition = 0;
        // UC 6 : Variable to count number of dice rolls
        int DiceCount = 0;
        // Create Random object
        Random random = new Random();
        System.out.println("Snake and Ladder Game Started");

        // UC 4 : Repeat till player reaches winning position 100
        while (PlayerPosition < 100) {

            // Store previous position (needed for UC 5)
            int previousPosition = PlayerPosition;

            // UC 2 : Player rolls the die (1 to 6)
            int DieRoll = random.nextInt(6) + 1;
            DiceCount++;   // UC 6 : Increment dice count

            // UC 3 : Player checks option
            // 0 = No Play, 1 = Ladder, 2 = Snake
            int Option = random.nextInt(3);

            System.out.println("\nDie Rolled: " + DieRoll);

            // UC 3 : NO PLAY
            if (Option == 0) {
                System.out.println("Option: No Play");
                // Player stays in same position
            }

            // UC 3 : LADDER
            else if (Option == 1) {
                System.out.println("Option: Ladder");
                PlayerPosition = PlayerPosition + DieRoll;
            }

            // UC 3 : SNAKE
            else {
                System.out.println("Option: Snake");
                PlayerPosition = PlayerPosition - DieRoll;

                // UC 4 : If position goes below 0, restart from 0
                if (PlayerPosition < 0) {
                    PlayerPosition = 0;
                }
            }

            // UC 5 : If position goes above 100, stay at previous position
            if (PlayerPosition > 100) {
                PlayerPosition = previousPosition;
            }

            // UC 6 : Report position after every dice roll
            System.out.println("Player Position: " + PlayerPosition);
        }

        // Game End
        System.out.println("\nPlayer reached EXACT position 100. Game Over!");

        // UC 6 : Report total number of dice rolls
        System.out.println("Total Dice Rolls: " + DiceCount);
    }
}
