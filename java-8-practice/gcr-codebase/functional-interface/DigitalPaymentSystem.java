import java.util.Scanner;
interface Payment {
    void pay(double amount);
}
class UPI implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid INR " + amount + " using UPI.");
    }
}
class CreditCard implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid INR " + amount + " using Credit Card.");
    }
}
class Wallet implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid INR " + amount + " using Wallet.");
    }
}
public class DigitalPaymentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Payment upi = new UPI();
        Payment creditCard = new CreditCard();
        Payment wallet = new Wallet();
        System.out.print("Enter the amount to pay: INR ");
        double amount = sc.nextDouble();
        while (true) {
            System.out.println("\nSelect a payment method:");
            System.out.println("1. UPI");
            System.out.println("2. Credit Card");
            System.out.println("3. Wallet");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            if (choice == 4) {
                System.out.println("Payment process exited. Goodbye!");
                break;
            }
            Payment paymentMethod = null;
            switch (choice) {
                case 1 -> paymentMethod = upi;
                case 2 -> paymentMethod = creditCard;
                case 3 -> paymentMethod = wallet;
                default -> System.out.println("Invalid choice!");
            }
            if (paymentMethod != null) {
                paymentMethod.pay(amount);
            }
        }
    }
}
