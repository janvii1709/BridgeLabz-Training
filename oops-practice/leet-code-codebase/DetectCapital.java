import java.util.Scanner;
public class DetectCapital {
    public static boolean detectCapitalUse(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                count++;
            }
        }
        if (count == word.length()) return true;
        if (count == 0) return true;
        if (count == 1 && Character.isUpperCase(word.charAt(0))) return true;

        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the word: ");
        String word = sc.nextLine();
        System.out.println(detectCapitalUse(word));
    }
}