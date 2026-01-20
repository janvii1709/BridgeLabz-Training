import java.util.Scanner;

// Abstract class
abstract class BankAccount {
    private final String accountNumber;
    private final double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Getter only (immutability)
    public double getBalance() {
        return balance;
    }

    // Polymorphic method
    public abstract double calculateFee();
}

// Savings Account
class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public double calculateFee() {
        return getBalance() * 0.005;
    }
}

// Checking Account
class CheckingAccount extends BankAccount {
    public CheckingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public double calculateFee() {
        return getBalance() < 1000 ? 1.0 : 0.0;
    }
}


public class BankAccountDetails {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Select Account Type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Checking Account");
        System.out.print("Enter your choice: ");

        int choice = sc.nextInt();
        sc.nextLine(); // clear buffer

        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();

        System.out.print("Enter Balance: ");
        double balance = sc.nextDouble();

        BankAccount account;

        if (choice == 1) {
            account = new SavingsAccount(accNo, balance);
        } else if (choice == 2) {
            account = new CheckingAccount(accNo, balance);
        } else {
            System.out.println("Invalid account type!");
            return;
        }

        System.out.printf("Calculated Fee: %.2f%n", account.calculateFee());
    }
}
