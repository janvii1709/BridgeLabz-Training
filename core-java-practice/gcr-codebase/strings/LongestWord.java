
import java.util.Scanner;

public class LongestWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input sentence from user
        System.out.print("Enter a sentence: ");
        String Sentence = sc.nextLine();

        // Split the sentence into words
        String[] Words = Sentence.split(" ");

        String LongestWord = "";
        int MaxLength = 0;

        // Loop through all words
        for (String word : Words) {
            if (word.length() > MaxLength) {
                MaxLength = word.length();
                LongestWord = word;
            }
        }

        // Display the longest word
        System.out.println("The longest word is: " + LongestWord);
    }
}
