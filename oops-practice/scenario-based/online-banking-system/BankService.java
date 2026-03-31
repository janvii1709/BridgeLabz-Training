// BankService.java
public interface BankService {
    void createAccount(Account account);
    void deposit(String accountNumber, double amount);
    void withdraw(String accountNumber, double amount);
    void transferFunds(String fromAcc, String toAcc, double amount);
    void showBalance(String accountNumber);
    void printTransactionHistory();
}
