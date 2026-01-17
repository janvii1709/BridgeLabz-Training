import java.util.*;
public class SearchWordInSentences {
    public static String findSentence(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of sentences: ");
        int n = sc.nextInt();
        sc.nextLine(); // Used for consuming the newline character
        String[] sentences = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the sentence " + (i + 1) + ": ");
            sentences[i] = sc.nextLine();
        }
        System.out.print("Enter the word to search: ");
        String word = sc.nextLine();
        String str = findSentence(sentences, word);
        System.out.println("Result is : " + str);
    }
}
