import java.util.Scanner;

public class WordPattern {

    public static boolean followsPattern(String pattern, String s) {

        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        String[] charToWord = new String[26];   // a → word
        String[] wordToChar = new String[words.length]; // word → char

        for (int i = 0; i < pattern.length(); i++) {

            char ch = pattern.charAt(i);
            int index = ch - 'a';
            String word = words[i];

            // pattern → word mapping
            if (charToWord[index] == null) {
                charToWord[index] = word;
            } else if (!charToWord[index].equals(word)) {
                return false;
            }

            // word → pattern mapping
            for (int j = 0; j < i; j++) {
                if (words[j].equals(word) && pattern.charAt(j) != ch) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter pattern: ");
        String pattern = sc.nextLine();

        System.out.print("Enter string: ");
        String s = sc.nextLine();

        System.out.println("Output: " + followsPattern(pattern, s));
    }
}
