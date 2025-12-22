import java.util.Scanner;
public class CompareSubString  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Take string input from user
        System.out.print("Enter the string: ");
        String text = sc.next();
        // Taking start index
        System.out.print("Enter start index: ");
        int Start = sc.nextInt();
        // Take end index
        System.out.print("Enter end index: ");
        int End = sc.nextInt();

        // Creating substring using charAt()

        String Char_At_Substring = "";
        for (int i = Start; i < End; i++) {
            Char_At_Substring = Char_At_Substring + text.charAt(i);
        }
        // Create substring using built-in method
        String Built_In_Substring = text.substring(Start, End);

        // Compare both substrings using charAt()

        boolean Is_Equal = true;

        // Length checkING
        if (Char_At_Substring.length() !=Built_In_Substring.length()) {
            Is_Equal = false;
        } else {
            // Character-by-character comparison
            for (int i = 0; i < Char_At_Substring.length(); i++) {
                if (Char_At_Substring.charAt(i) != Built_In_Substring.charAt(i)) {
                    Is_Equal = false;
                    break;
                }
            }
        }
        // Results are
        System.out.println("Substring using charAt(): " + Char_At_Substring);
        System.out.println("Substring using substring(): " + Built_In_Substring);
        System.out.println("Are both substrings equal? " + Is_Equal);

    }
}
