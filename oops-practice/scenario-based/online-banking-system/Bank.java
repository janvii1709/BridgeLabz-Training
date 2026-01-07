// Bank.java
import java.util.*;

public class Bank implements BankService {
    private Map<String, Account> accounts = new HashMap<>();
    private List<String> transactionHistory = new ArrayList<>();

    @Override
    public void createAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
        System.out.println("Account created: " + account.getAccountHolder());
        account.accountType();
    }

    @Override
    public void deposit(String accountNumber, double amount) {
        Account acc = accounts.get(accountNumber);
        if (acc != null) {
            acc.deposit(amount);
        } else {
            System.out.println("Account not found!");
        }
    }

    @Override
    public void withdraw(String accountNumber, double amount) {
        Account acc = accounts.get(accountNumber);
        if (acc != null) {
            try {
                acc.withdraw(amount);
            } catch (InsufficientBalanceException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Account not found!");
        }
    }

    @Override
    public void transferFunds(String fromAcc, String toAcc, double amount) {
        Account sender = accounts.get(fromAcc);
        Account receiver = accounts.get(toAcc);

        if (sender == null || receiver == null) {
            System.out.println("Invalid account number(s)");
            return;
        }

        try {
            synchronized (sender) {
                sender.withdraw(amount);
            }
            synchronized (receiver) {
                receiver.deposit(amount);
            }
            String transaction = "Transferred " + amount + " from " + fromAcc + " to " + toAcc;
            transactionHistory.add(transaction);
            System.out.println(transaction);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void showBalance(String accountNumber) {
        Account acc = accounts.get(accountNumber);
        if (acc != null) {
            System.out.println(acc.getAccountHolder() + "'s balance: " + acc.getBalance());
        } else {
            System.out.println("Account not found!");
        }
    }

    @Override
    public void printTransactionHistory() {
        System.out.println("--- Transaction History ---");
        for (String t : transactionHistory) {
            System.out.println(t);
        }
    }
}
