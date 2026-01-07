// BankingSystem.java
import java.util.Scanner;

public class BankingSystem {
    public static void main(String[] args) {
        BankService bank = new Bank();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Online Banking Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer Funds");
            System.out.println("5. Show Balance");
            System.out.println("6. Transaction History");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    String accNo = sc.nextLine();
                    System.out.print("Enter account holder name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter initial balance: ");
                    double balance = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Account type (Savings/Current): ");
                    String type = sc.nextLine();

                    if (type.equalsIgnoreCase("Savings")) {
                        System.out.print("Enter interest rate: ");
                        double rate = sc.nextDouble();
                        sc.nextLine();
                        Account sa = new SavingsAccount(accNo, name, balance, rate);
                        bank.createAccount(sa);
                    } else if (type.equalsIgnoreCase("Current")) {
                        Account ca = new CurrentAccount(accNo, name, balance);
                        bank.createAccount(ca);
                    } else {
                        System.out.println("Invalid account type!");
                    }
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    String dAcc = sc.nextLine();
                    System.out.print("Enter amount to deposit: ");
                    double dAmt = sc.nextDouble();
                    sc.nextLine();
                    bank.deposit(dAcc, dAmt);
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    String wAcc = sc.nextLine();
                    System.out.print("Enter amount to withdraw: ");
                    double wAmt = sc.nextDouble();
                    sc.nextLine();
                    bank.withdraw(wAcc, wAmt);
                    break;

                case 4:
                    System.out.print("Enter sender account number: ");
                    String fromAcc = sc.nextLine();
                    System.out.print("Enter receiver account number: ");
                    String toAcc = sc.nextLine();
                    System.out.print("Enter amount to transfer: ");
                    double tAmt = sc.nextDouble();
                    sc.nextLine();
                    bank.transferFunds(fromAcc, toAcc, tAmt);
                    break;

                case 5:
                    System.out.print("Enter account number: ");
                    String bAcc = sc.nextLine();
                    bank.showBalance(bAcc);
                    break;

                case 6:
                    bank.printTransactionHistory();
                    break;

                case 7:
                    System.out.println("Exiting... Thank you!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
