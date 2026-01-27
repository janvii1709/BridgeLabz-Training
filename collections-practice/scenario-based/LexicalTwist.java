import java.util.*;
public class LexicalTwist {
    static boolean isInvalidWord(String str) {
        return str.trim().contains(" ");
    }
    static boolean isVowel(char ch) {
        return "AEIOUaeiou".indexOf(ch) != -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first word : ");
        String first = sc.nextLine();
        if (isInvalidWord(first)) {
            System.out.println(first + " is an invalid word");
            return;
        }
        System.out.print("Enter the second word : ");
        String second = sc.nextLine();
        if (isInvalidWord(second)) {
            System.out.println(second + " is an invalid word");
            return;
        }
        String reverseFirst = new StringBuilder(first).reverse().toString();
        if (reverseFirst.equalsIgnoreCase(second)) {
            String lower = reverseFirst.toLowerCase();
            String result = "";
            for (char ch : lower.toCharArray()) {
                if (isVowel(ch)) {
                    result += "@";
                } else {
                    result += ch;
                }
            }
            System.out.println(result);
        }
        else {
            String combined = (first + second).toUpperCase();
            int vowels = 0, consonants = 0;
            for (char ch : combined.toCharArray()) {
                if (isVowel(ch)) {
                    vowels++;
                } else if (Character.isLetter(ch)) {
                    consonants++;
                }
            }
            if (vowels > consonants) {
                LinkedHashSet<Character> set = new LinkedHashSet<>();
                for (char ch : combined.toCharArray()) {
                    if (isVowel(ch)) {
                        set.add(ch);
                    }
                    if (set.size() == 2) break;
                }
                for (char ch : set) {
                    System.out.print(ch);
                }
            }
            else if (consonants > vowels) {
                LinkedHashSet<Character> set = new LinkedHashSet<>();
                for (char ch : combined.toCharArray()) {
                    if (!isVowel(ch) && Character.isLetter(ch)) {
                        set.add(ch);
                    }
                    if (set.size() == 2) break;
                }
                for (char ch : set) {
                    System.out.print(ch);
                }
            }
            else {
                System.out.println("Vowels and consonants are equal");
            }
        }
    }
}
