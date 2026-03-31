import java.util.Scanner;
public class ValidateCreditCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter credit card number:");
        String card = sc.nextLine().replaceAll("\\s+", "");
        String visaRegex = "^4\\d{15}$";
        String masterRegex = "^5\\d{15}$";
        if (card.matches(visaRegex)) {
            System.out.println("Valid Visa card");
        } else if (card.matches(masterRegex)) {
            System.out.println("Valid MasterCard");
        } else {
            System.out.println("Invalid card number");
        }
    }
}
