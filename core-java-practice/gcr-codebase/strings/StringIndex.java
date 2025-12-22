import java.util.Scanner;
public class StringIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Taking the  string input from user
        System.out.print("Enter a string: ");
        String Str = sc.nextLine();
        // GENERATing the StringIndexOutOfBoundsException
        System.out.println("Generating StringIndexOutOfBoundsException:");
        try {
            // Accessing the character index beyond string length
            System.out.println(Str.charAt(Str.length())); // Exception
        } catch (Exception e) {
            System.out.println("Exception generated and program stopped abruptly");
        }
        // Handling the StringIndexOutOfBoundsException
        System.out.println("Handling StringIndexOutOfBoundsException using try-catch:");
        try {
            // Accessing character index beyond string length
            System.out.println(Str.charAt(Str.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException caught");
            System.out.println("Message: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Generic RuntimeException caught");
        }

    }
}
