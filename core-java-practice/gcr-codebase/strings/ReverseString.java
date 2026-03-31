import java.util.Scanner;
public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input from the user
        System.out.print("Enter a string: ");
        String Input = sc.nextLine();

        String Reversed = "";

        // Loop from end of the string to the beginning
        for (int i = Input.length() - 1; i >= 0; i--) {
            Reversed += Input.charAt(i); // Append characters in reverse order
        }

        // Display the reversed string
        System.out.println("Reversed string: " + Reversed);
    }
}
