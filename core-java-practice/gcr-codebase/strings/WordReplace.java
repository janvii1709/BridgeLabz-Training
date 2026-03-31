import java.util.Scanner;
public class WordReplace {
    // Method to replace a word in a sentence
    public static String ReplaceWord(String Sentence, String OldWord, String NewWord) {
        // Split the sentence into words
        String[] Words = Sentence.split(" ");
        String Result = "";
        // Loop through words and replace if it matches oldWord
        for (int i = 0; i < Words.length; i++) {
            if (Words[i].equals(OldWord)) {
                Words[i] = NewWord;
            }
            Result += Words[i];
            if (i != Words.length - 1) {
                Result += " "; // Add space between words
            }
        }
        return Result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input sentence
        System.out.print("Enter a sentence: ");
        String Sentence = sc.nextLine();
        // Input old word and new word
        System.out.print("Enter the word to replace: ");
        String OldWord = sc.next();
        System.out.print("Enter the new word: ");
        String NewWord = sc.next();
        // Call method and display result
        String ModifiedSentence = ReplaceWord(Sentence, OldWord, NewWord);
        System.out.println("Modified Sentence: " + ModifiedSentence);
    }
}
