import java.util.Scanner;

public class CardShuffleStr {
    public static void main(String[] args) {

        String[] Suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] Ranks = {
                "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "Jack", "Queen", "King", "Ace"
        };

        // Initialize deck
        String[] Deck = new String[Suits.length * Ranks.length];
        int INDEX = 0;

        for (int i = 0; i < Suits.length; i++) {
            for (int j = 0; j < Ranks.length; j++) {
                Deck[INDEX++] = Ranks[j] + " of " + Suits[i];
            }
        }

        // Shuffle deck
        for (int i = 0; i < Deck.length; i++) {
            int randomCardNumber = i + (int) (Math.random() * (Deck.length - i));
            String Temp = Deck[i];
            Deck[i] = Deck[randomCardNumber];
            Deck[randomCardNumber] = Temp;
        }

        // Take number of players (x)
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of players: ");
        int Players = sc.nextInt();

        // Check if cards can be evenly distributed
        if (Deck.length % Players != 0) {
            System.out.println("Cards cannot be evenly distributed among players.");
            return;
        }

        int Cards_Per_Player = Deck.length / Players;
        String[][] Player_Cards = new String[Players][Cards_Per_Player];

        // Distribute cards
        INDEX = 0;
        for (int i = 0; i < Players; i++) {
            for (int j = 0; j < Cards_Per_Player; j++) {
                Player_Cards[i][j] = Deck[INDEX++];
            }
        }

        // Print players and their cards
        for (int i = 0; i < Players; i++) {
            System.out.println("Player " + (i + 1) + " cards:");
            for (int j = 0; j < Cards_Per_Player; j++) {
                System.out.println(Player_Cards[i][j]);
            }
            System.out.println();
        }

        //Output of total
        System.out.println("Total Players: " + Players);
        System.out.println("Total Cards: " + Deck.length);
        System.out.println("Each Player Gets: " + Cards_Per_Player + " cards");
    }
}
