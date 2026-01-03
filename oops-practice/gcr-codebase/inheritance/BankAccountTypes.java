import java.util.Scanner;
// Superclass: BankAccount
class BankAccount {
    long accountNumber; // numeric account number
    double balance;
    BankAccount(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
}
// Subclass: SavingsAccount
class SavingsAccount extends BankAccount {
    double interestRate;
    SavingsAccount(long accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }
    void displayAccountType() {
        System.out.println("Account Type: Savings Account");
    }
    @Override
    void displayAccountInfo() {
        displayAccountType();
        super.displayAccountInfo();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}
// Subclass: CheckingAccount
class CheckingAccount extends BankAccount {
    double withdrawalLimit;
    CheckingAccount(long accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }
    void displayAccountType() {
        System.out.println("Account Type: Checking Account");
    }
    @Override
    void displayAccountInfo() {
        displayAccountType();
        super.displayAccountInfo();
        System.out.println("Withdrawal Limit: $" + withdrawalLimit);
    }
}
// Subclass: FixedDepositAccount
class FixedDepositAccount extends BankAccount {
    int depositPeriod; // in months
    double interestRate;
    FixedDepositAccount(long accountNumber, double balance, int depositPeriod, double interestRate) {
        super(accountNumber, balance);
        this.depositPeriod = depositPeriod;
        this.interestRate = interestRate;
    }
    void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
    }
    @Override
    void displayAccountInfo() {
        displayAccountType();
        super.displayAccountInfo();
        System.out.println("Deposit Period: " + depositPeriod + " months");
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}
// Main Class
public class BankAccountTypes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = null;
        int choice;
        System.out.println("----- Bank Account Setup -----");
        // Validated choice input
        while (true) {
            System.out.println("Choose Account Type:");
            System.out.println("1. Savings Account");
            System.out.println("2. Checking Account");
            System.out.println("3. Fixed Deposit Account");
            System.out.print("Enter choice : ");
            choice = sc.nextInt();
            if (choice >= 1 && choice <= 3) {
                break; // valid
            } else { 
                System.out.println("Invalid choice! Please enter 1, 2, or 3.\n");
            }
        }
        // Common account input
        System.out.print("Enter Account Number : ");
        long accountNumber = sc.nextLong();
        System.out.print("Enter Initial Balance : ");
        double balance = sc.nextDouble();
        // Subclass-specific input
        switch (choice) {
            case 1: // SavingsAccount
                System.out.print("Enter Interest Rate (%): ");
                double savingsInterest = sc.nextDouble();
                account = new SavingsAccount(accountNumber, balance, savingsInterest);
                break;
            case 2: // CheckingAccount
                System.out.print("Enter Withdrawal Limit ($): ");
                double limit = sc.nextDouble();
                account = new CheckingAccount(accountNumber, balance, limit);
                break;
            case 3: // FixedDepositAccount
                System.out.print("Enter Deposit Period (months): ");
                int period = sc.nextInt();
                System.out.print("Enter Interest Rate (%): ");
                double fdInterest = sc.nextDouble();
                account = new FixedDepositAccount(accountNumber, balance, period, fdInterest);
                break;
        }
        // Display account details polymorphically
        System.out.println("\n----- Account Details -----");
        account.displayAccountInfo();
    }
}
