import java.util.Scanner;

public class IllegalArgue {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking string input from user
        System.out.print("Enter a string: ");
        String Str = sc.nextLine();
        // Generating  IllegalArgumentException

        System.out.println("\nGenerating IllegalArgumentException:");
        try {
            // Manually throw IllegalArgumentException for demonstration
            throw new IllegalArgumentException("Manual IllegalArgumentException for demo");
        } catch (Exception e) {
            System.out.println("Exception generated and program stopped abruptly");
        }

        //  Handling IllegalArgumentException using try-catch

        System.out.println("Handling IllegalArgumentException using try-catch:");
        try {
            // Again throw exception to demonstrate handling
            throw new IllegalArgumentException("Manual IllegalArgumentException for demo");
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught");
            System.out.println("Message: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Generic RuntimeException caught");
        }

    }
}
