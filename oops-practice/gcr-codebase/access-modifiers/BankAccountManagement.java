// Base Class
class BankAccount {

    // Public variable
    // Can be accessed from anywhere
    public long accountNumber;

    // Protected variable
    // Can be accessed within same package or subclass
    protected String accountHolder;

    // Private variable
    // Can be accessed only inside this class
    private double balance;

    // Parameterized constructor
    // Used to initialize bank account details
    BankAccount(long accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Public getter method
    // Used to access private balance
    public double getBalance() {
        return balance;
    }

    // Public setter method
    // Used to modify private balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("Account Number  : " + accountNumber);
        System.out.println("Account Holder  : " + accountHolder);
        System.out.println("Balance         : " + balance);
        System.out.println("-----------------------------------------------");
    }
}

// Subclass 
class SavingsAccount extends BankAccount {

    // Constructor of subclass
    // Calls parent class constructor using super keyword
    SavingsAccount(long accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    // Method to demonstrate access of public and protected members
    public void displaySavingsAccountDetails() {

        // Accessing public variable from parent class
        System.out.println("Savings Account Number : " + accountNumber);

        // Accessing protected variable from parent class
        System.out.println("Account Holder Name    : " + accountHolder);

        // Accessing private variable using getter method
        System.out.println("Available Balance      : " + getBalance());

        System.out.println("-----------------------------------------------");
    }
}

//  Main Class 
public class BankAccountManagement {

    public static void main(String[] args) {

        // Creating object of BankAccount class
        BankAccount account1 =
                new BankAccount(1234567890L, "Janhavi Singh", 50000);

        System.out.println("Bank Account Details:");
        System.out.println();

        // Displaying account details
        account1.displayAccountDetails();

        // Modifying balance using setter method
        account1.setBalance(65000);

        System.out.println("After Updating Balance:");
        System.out.println();

        // Displaying updated account details
        account1.displayAccountDetails();

        // Creating object of SavingsAccount class
        SavingsAccount savings1 = new SavingsAccount(9876543210L, "Rahul Sharma", 30000);

        System.out.println("Savings Account Details:");
        System.out.println();

        // Displaying savings account details
        savings1.displaySavingsAccountDetails();
    }
}
