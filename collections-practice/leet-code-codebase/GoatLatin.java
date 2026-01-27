import java.util.Scanner;
public class GoatLatin {
    public static String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char firstChar = word.charAt(0);
            if (vowels.indexOf(firstChar) != -1) {
                result.append(word);
            } else {
                result.append(word.substring(1));
                result.append(firstChar);
            }
            result.append("ma");
            for (int j = 0; j <= i; j++) {
                result.append("a");
            }
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter sentence: ");
        String sentence = sc.nextLine();
        String output = toGoatLatin(sentence);
        System.out.println("Goat Latin Output:");
        System.out.println(output);
    }
}
