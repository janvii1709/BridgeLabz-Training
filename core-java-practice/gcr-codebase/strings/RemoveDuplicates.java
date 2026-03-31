import java.util.Scanner;
public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input from user
        System.out.print("Enter a string: ");
        String string = sc.nextLine();

        String Output  = "";

        // Loop through each character
        for (int i = 0; i < string.length(); i++) {
            char Ch = string.charAt(i);
            // Append character only if it's not already in the result
            if (Output.indexOf(Ch) == -1) {
                Output += Ch;
            }
        }

        // Display the modified string
        System.out.println("String after removing duplicates: " + Output);
    }
}
