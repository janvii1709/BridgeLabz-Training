
import java.util.Scanner;

public class RemoveChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input string
        System.out.print("Enter a string: ");
        String string = sc.nextLine();

        // Input character to remove
        System.out.print("Enter the character to remove: ");
        char ChToRemove = sc.next().charAt(0);

        String Output = "";

        // Loop through each character
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (ch != ChToRemove) {
                string += ch; // Add character if it's not the one to remove
            }
        }

        // Display modified string
        System.out.println("Modified String: " + Output);
    }
}
