import java.util.*;

// Interface
interface Loanable {
    void applyForLoan();
    double calculateLoanEligibility();
}

// Abstract Class
abstract class BankAccount {
    private int accountNumber;
    private String holderName;
    protected double balance;

    BankAccount(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0)
            balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance)
            balance -= amount;
    }

    abstract double calculateInterest();
}

// Savings Account
class SavingsAccount extends BankAccount implements Loanable {

    SavingsAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    double calculateInterest() {
        return balance * 0.04;
    }

    public void applyForLoan() {
        System.out.println("Savings Account Loan Applied");
    }

    public double calculateLoanEligibility() {
        return balance * 5;
    }
}

// Current Account
class CurrentAccount extends BankAccount implements Loanable {

    CurrentAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    double calculateInterest() {
        return balance * 0.02;
    }

    public void applyForLoan() {
        System.out.println("Current Account Loan Applied");
    }

    public double calculateLoanEligibility() {
        return balance * 8;
    }
}

// Main Class
public class BankingSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();

        System.out.print("Enter number of accounts to create: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {

            System.out.println("\nEnter details for Account " + i);

            System.out.print("Account Number: ");
            int accNo = sc.nextInt();
            sc.nextLine();

            System.out.print("Holder Name: ");
            String name = sc.nextLine();

            System.out.print("Initial Balance: ");
            double balance = sc.nextDouble();

            System.out.println("Account Type:");
            System.out.println("1. Savings");
            System.out.println("2. Current");
            int type = sc.nextInt();

            BankAccount acc;
            if (type == 1)
                acc = new SavingsAccount(accNo, name, balance);
            else
                acc = new CurrentAccount(accNo, name, balance);

            System.out.print("Deposit amount: ");
            acc.deposit(sc.nextDouble());

            System.out.print("Withdraw amount: ");
            acc.withdraw(sc.nextDouble());

            accounts.add(acc);
        }

        // Polymorphism demonstration
        System.out.println("\n---- Account Summary ----");
        for (BankAccount acc : accounts) {
            System.out.println("Account No: " + acc.getAccountNumber());
            System.out.println("Name: " + acc.getHolderName());
            System.out.println("Balance: " + acc.getBalance());
            System.out.println("Interest: " + acc.calculateInterest());

            Loanable loan = (Loanable) acc;
            loan.applyForLoan();
            System.out.println("Loan Eligibility: " + loan.calculateLoanEligibility());
            System.out.println("-------------------------------------");
        }
    }
}
