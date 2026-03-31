import java.util.Scanner;
public class ToggleCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input string from the user
        System.out.print("Enter a string: ");
        String Input = sc.nextLine();
        String Toggled = "";
        // Loop through each character
        for (int i = 0; i < Input.length(); i++) {
            char ch = Input.charAt(i);
            // Check if uppercase
            if (ch >= 'A' && ch <= 'Z') {
                Toggled += (char)(ch + 32); // Convert to lowercase
            }
            // Check if lowercase
            else if (ch >= 'a' && ch <= 'z') {
                Toggled += (char)(ch - 32); // Convert to uppercase
            }
            // If not a letter, keep it unchanged
            else {
                Toggled += ch;
            }
        }

        // Display the toggled string
        System.out.println("Toggled case string: " + Toggled);
    }
}
