import java.util.Scanner;
public class DetectCapital {
    public static boolean detectCapitalUse(String word) {
        if (word.equals(word.toUpperCase())) {
            return true;
        }
        if (word.equals(word.toLowerCase())) {
            return true;
        }
        String first = word.substring(0, 1);
        String rest = word.substring(1);
        if (first.equals(first.toUpperCase()) &&
            rest.equals(rest.toLowerCase())) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter word: ");
        String word = sc.next();
        System.out.println(detectCapitalUse(word));
    }
}
