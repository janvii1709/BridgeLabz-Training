// public class SnakeLadder {
//     public static void main(String[] args) {
//         // UC 1 : Snake and Ladder game played with single player
//         // Player starts from position 0
//         int playerPosition = 0;
//         System.out.println("Snake and Ladder Game Started");
//         System.out.println("Player starting position: " + playerPosition);
//     }
// }
import java.util.Random; // RANDOM class import
public class SnakeLadder {
    public static void main(String[] args) {
        // UC 1 : Snake and Ladder game played with single player
        // Player starts from position 0
        int PlayerPosition = 0;
        // Create Random object
        Random random = new Random();
        // UC 2 : Player rolls the die (number between 1 to 6)
        int DieRoll = random.nextInt(6) + 1;
        System.out.println("Snake and Ladder Game Started");
        System.out.println("Player starting position: " + PlayerPosition);
        System.out.println("Die rolled value: " + DieRoll);
    }
}
