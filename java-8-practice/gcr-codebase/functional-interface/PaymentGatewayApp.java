import java.util.Scanner;
interface PaymentProcessor {
    void pay(double amount);
    default void refund(double amount) {
        System.out.println("Refund of INR " + amount + " processed using standard gateway.");
    }
}
class UPIProcessor implements PaymentProcessor {
    public void pay(double amount) {
        System.out.println("Paid INR " + amount + " using UPI.");
    }
}
class CreditCardProcessor implements PaymentProcessor {
    public void pay(double amount) {
        System.out.println("Paid INR " + amount + " using Credit Card.");
    }
}
public class PaymentGatewayApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose Payment Method:");
        System.out.println("1. UPI");
        System.out.println("2. Credit Card");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        PaymentProcessor processor;
        if (choice == 1) {
            processor = new UPIProcessor();
        } else {
            processor = new CreditCardProcessor();
        }
        processor.pay(amount);
        System.out.print("Do you want refund? (true/false): ");
        boolean refundChoice = sc.nextBoolean();
        if (refundChoice) {
            processor.refund(amount);
        }
    }
}
