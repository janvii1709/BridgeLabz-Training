import java.util.Scanner;
public class ReconstructSentence {
    public static String sortSentence(String s) {
        // Split the shuffled sentence into words
        String[] words = s.split(" ");
        // Array to store words in correct order
        String[] sorted = new String[words.length];
        for (String word : words) {
            // Get the position (last character) as integer
            int pos = word.charAt(word.length() - 1) - '0';  
            // Remove the number and place the word at correct position
            sorted[pos - 1] = word.substring(0, word.length() - 1);
        }
        // Join the sorted words to form the original sentence
        return String.join(" ", sorted);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the shuffled sentence: ");
        String s = sc.nextLine();
        String original = sortSentence(s);
        System.out.println("Original sentence: " + original);
    }
}
