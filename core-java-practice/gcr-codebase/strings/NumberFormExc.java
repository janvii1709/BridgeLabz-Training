import java.util.Scanner;
public class NumberFormExc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Taking input string from user
        System.out.print("Enter a number: ");
        String Str = sc.nextLine();
        //  GENERATE NumberFormatException
        System.out.println("Generating NumberFormatException:");
        try {
            int Num = Integer.parseInt(Str); // May throw exception
            System.out.println("Parsed number: " + Num);
        } catch (Exception e) {
            System.out.println("Exception generated and program stopped abruptly");
        }
        // Handling NumberFormatException using try-catch
        System.out.println("Handling NumberFormatException using try-catch:");
        try {
            int Num = Integer.parseInt(Str); // May throw exception
            System.out.println("Parsed number: " + Num);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught");
            System.out.println("Message: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Generic RuntimeException caught");
        }
    }
}
