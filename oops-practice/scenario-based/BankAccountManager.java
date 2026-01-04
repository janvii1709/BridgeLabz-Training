import java.util.Scanner;

// This class represents a bank account
class BankAccount {
    // Properties of the bank account
    String accountNumber;
    double balance;

    // Constructor to create a new bank account with account number and initial balance
    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Method to deposit money into the account
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount; // Add the amount to current balance
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount!"); // Reject negative or zero deposit
        }
    }

    // Method to withdraw money from the account
    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance! Cannot withdraw " + amount); // Prevent overdraft
        } else {
            balance -= amount; // Deduct amount from balance
            System.out.println("Withdrawn: " + amount);
        }
    }

    // Method to check the current balance of the account
    void checkBalance() {
        System.out.println("Current balance: " + balance);
    }
}

public class BankAccountManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask the user to enter account number (numbers only)
        String accNumber;
        while (true) {
            System.out.print("Enter account number : ");
            accNumber = sc.nextLine();
            if (accNumber.matches("\\d+")) {
                break; // Valid numeric input
            } else {
                System.out.println("Invalid account number! Must contain numbers only.");
            }
        }

        // Ask the user to enter initial balance
        System.out.print("Enter initial balance: ");
        double initialBalance = sc.nextDouble();

        // Create a new bank account object
        BankAccount account = new BankAccount(accNumber, initialBalance);

        // Ask the user for deposit amount and update balance
        System.out.print("Enter amount to deposit: ");
        double depositAmount = sc.nextDouble();
        account.deposit(depositAmount);

        // Ask the user for withdrawal amount and update balance
        System.out.print("Enter amount to withdraw: ");
        double withdrawAmount = sc.nextDouble();
        account.withdraw(withdrawAmount);
        System.out.println();
        System.out.println("------------------- Details Are -------------------");

        // Show the current balance
        account.checkBalance();
    }
}
