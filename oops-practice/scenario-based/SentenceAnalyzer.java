import java.util.Scanner;
public class SentenceAnalyzer {
    // Method to count words in a paragraph
    public static int CountWords(String Sentence) {
        if (Sentence == null || Sentence.trim().isEmpty()) {
            return 0; // No words in empty paragraph
        }
        // Split by one or more spaces
        String[] Words = Sentence.trim().split("\\s+");
        return Words.length;
    }
    // Method to find the longest word
    public static String FindLongestWord(String Sentence) {
        if (Sentence == null || Sentence.trim().isEmpty()) {
            return ""; // Return empty string if paragraph is empty
        }
        String[] Words = Sentence.trim().split("\\s+");
        String Longest = "";
        for (String word : Words) {
            if (word.length() > Longest.length()) {
                Longest = word; // Update longest word
            }
        }
        return Longest;
    }
    // Method to replace all occurrences of a word (case-insensitive)
    public static String ReplaceWord(String Sentence, String OldWord, String NewWord) {
        if (Sentence == null || Sentence.trim().isEmpty()) {
            return Sentence; // Return as is if paragraph is empty
        }
        if (OldWord == null || OldWord.trim().isEmpty()) {
            return Sentence; // Nothing to replace
        }
        if (NewWord == null) {
            NewWord = ""; // Replace with empty string if null
        }
        // Case-insensitive replacement of whole words only
        return Sentence.replaceAll("(?i)\\b" + OldWord + "\\b", NewWord);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Take paragraph input
        System.out.println("Enter the paragraph:");
        String Sentence = sc.nextLine();
        // Count words
        int WordCount = CountWords(Sentence);
        System.out.println("\nNumber of words: " + WordCount);

        // Find longest word
        String LongestWord = FindLongestWord(Sentence);
        System.out.println("Longest word: " + LongestWord);

        // Replace word
        System.out.println("\nEnter the word to replace:");
        String OldWord = sc.nextLine();
        System.out.println("Enter the new word:");
        String NewWord = sc.nextLine();

        String UpdatedParagraph = ReplaceWord(Sentence, OldWord, NewWord);
        // Display updated paragraph
        System.out.println("\nUpdated Paragraph:");
        System.out.println(UpdatedParagraph);
    }
}
