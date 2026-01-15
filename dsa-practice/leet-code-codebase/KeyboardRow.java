import java.util.ArrayList;
import java.util.Scanner;

public class KeyboardRow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking number of words
        System.out.print("Enter number of words: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] words = new String[n];

        // Taking words input
        for (int i = 0; i < n; i++) {
            System.out.print("Enter word " + (i + 1) + ": ");
            words[i] = sc.nextLine();
        }

        ArrayList<String> result = findWords(words);

        // Printing output
        System.out.println("Output words:");
        for (String word : result) {
            System.out.println(word);
        }
    }

    public static ArrayList<String> findWords(String[] words) {
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";

        ArrayList<String> validWords = new ArrayList<>();

        for (String word : words) {
            String lower = word.toLowerCase();
            String row = "";

            char firstChar = lower.charAt(0);

            if (row1.contains(firstChar + "")) {
                row = row1;
            } else if (row2.contains(firstChar + "")) {
                row = row2;
            } else {
                row = row3;
            }

            boolean isValid = true;

            for (int i = 0; i < lower.length(); i++) {
                if (!row.contains(lower.charAt(i) + "")) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                validWords.add(word);
            }
        }

        return validWords;
    }
}
