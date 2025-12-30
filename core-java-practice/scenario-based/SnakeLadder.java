// // public class SnakeLadder {
// //     public static void main(String[] args) {
// //         // UC 1 : Snake and Ladder game played with single player
// //         // Player starts from position 0
// //         int playerPosition = 0;
// //         System.out.println("Snake and Ladder Game Started");
// //         System.out.println("Player starting position: " + playerPosition);
// //     }
// // }
// import java.util.Random; // RANDOM class import
// public class SnakeLadder {
//     public static void main(String[] args) {
//         // UC 1 : Snake and Ladder game played with single player
//         // Player starts from position 0
//         int PlayerPosition = 0;
//         // Create Random object
//         Random random = new Random();
//         // UC 2 : Player rolls the die (number between 1 to 6)
//         int DieRoll = random.nextInt(6) + 1;
//         System.out.println("Snake and Ladder Game Started");
//         System.out.println("Player starting position: " + PlayerPosition);
//         System.out.println("Die rolled value: " + DieRoll);
//     }
// }
import java.util.Random;   // RANDOM class for dice and option
public class SnakeLadder {
    public static void main(String[] args) {
        // UC 1 : Snake and Ladder game played with single player
        // Player starts from position 0
        int PlayerPosition = 0;
        // Create Random object
        Random random = new Random();
        // UC 2 : Player rolls the die (1 to 6)
        int DieRoll = random.nextInt(6) + 1;
        // UC 3 : Player checks option
        // 0 -> No Play, 1 -> Ladder, 2 -> Snake
        int Option = random.nextInt(3);
        System.out.println("Player starting position: " + PlayerPosition);
        System.out.println("Die rolled: " + DieRoll);
        // Check which option occurred
        if (Option == 0) {
            // No Play: Player stays in same position
            System.out.println("Option: No Play");
            // playerPosition remains unchanged
        }
        else if (Option == 1) {
            // Ladder: Player moves forward by die roll value
            System.out.println("Option: Ladder");
            PlayerPosition = PlayerPosition + DieRoll;
        }
        else {
            // Snake: Player moves backward by die roll value
            System.out.println("Option: Snake");
            PlayerPosition = PlayerPosition - DieRoll;
        }

        // Display player position after applying option
        System.out.println("Player position after move: " + PlayerPosition);
    }
}

