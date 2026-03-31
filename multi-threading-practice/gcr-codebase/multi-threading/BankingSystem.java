import java.text.SimpleDateFormat;
import java.util.*;

class BankAccount {
    private double balance = 10000;

    public synchronized void withdraw(String customer, double amount) {
        String time = new SimpleDateFormat("HH:mm:ss").format(new Date());

        if (balance >= amount) {
            balance -= amount;
            System.out.println(
                "Transaction successful: " + customer +
                ", Amount: " + amount +
                ", Balance: " + balance +
                ", Time: " + time
            );
        } else {
            System.out.println(
                "Transaction failed: " + customer +
                ", Amount: " + amount +
                ", Balance: " + balance +
                ", Time: " + time
            );
        }
    }

    public double getBalance() {
        return balance;
    }
}

class Transaction implements Runnable {
    private BankAccount account;
    private double amount;

    Transaction(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        String customer = Thread.currentThread().getName();
        System.out.println("[" + customer + "] Attempting to withdraw " + amount);
        account.withdraw(customer, amount);
    }
}

public class BankingSystem {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount();

        System.out.print("Enter number of customers: ");
        int n = sc.nextInt();

        Thread[] threads = new Thread[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter withdrawal amount for Customer-" + (i + 1) + ": ");
            double amount = sc.nextDouble();

            Transaction transaction = new Transaction(account, amount);
            threads[i] = new Thread(transaction, "Customer-" + (i + 1));

            System.out.println(
                "[" + threads[i].getName() + "] State before processing: " +
                threads[i].getState()
            );

            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("Final Balance: " + account.getBalance());
    }
}
