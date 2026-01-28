import java.util.*;
public class FlipKey {
    public static String CleanseAndInvert(String input) {
        if (input == null || input.length() < 6) {
            return "";
        }
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (!((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z'))) {
                return "";
            }
        }
        input = input.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch % 2 != 0) {
                sb.append(ch);
            }
        }
        sb.reverse();
        for (int i = 0; i < sb.length(); i++) {
            if (i % 2 == 0) {
                sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
            } else {
                sb.setCharAt(i, Character.toLowerCase(sb.charAt(i)));
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string : ");
        String input = sc.nextLine();
        String key = CleanseAndInvert(input);
        if (key.isEmpty()) {
            System.out.println("Invalid Input");
        } else {
            System.out.println("The generated key is - " + key);
        }
    }
}
