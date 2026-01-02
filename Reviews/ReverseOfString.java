import java.util.*;
public class ReverseOfString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] Words = str.split(" ");
        for (String word : Words) {
            String ReversedWord = "";
            for (int i = word.length() - 1; i >= 0; i--) {
                ReversedWord += word.charAt(i);
            }
            System.out.print(ReversedWord + " ");
        }
    }
    
}
