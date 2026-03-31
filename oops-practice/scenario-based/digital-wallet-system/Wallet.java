import java.util.ArrayList;

public class Wallet {
    int walletId;
    double balance;
    ArrayList<Transaction> transactions = new ArrayList<>();

    public Wallet(int walletId) {
        this.walletId = walletId;
        this.balance = 0;
    }

    public void addTransaction(String type, double amount) {
        transactions.add(new Transaction(type, amount));
    }
}
