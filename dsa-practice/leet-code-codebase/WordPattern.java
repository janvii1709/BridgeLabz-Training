import java.util.*;

public class WordPattern {

    public static boolean followsPattern(String pattern, String s) {
        String[] words = s.split(" ");

        // Length check
        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];

            // Check character → word mapping
            if (charToWord.containsKey(ch)) {
                if (!charToWord.get(ch).equals(word)) {
                    return false;
                }
            } else {
                charToWord.put(ch, word);
            }

            // Check word → character mapping
            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != ch) {
                    return false;
                }
            } else {
                wordToChar.put(word, ch);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter pattern: ");
        String pattern = sc.nextLine();

        System.out.print("Enter string s: ");
        String s = sc.nextLine();

        boolean result = followsPattern(pattern, s);
        System.out.println("Output: " + result);
    }
}
