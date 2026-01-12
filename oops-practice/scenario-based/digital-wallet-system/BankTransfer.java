public class BankTransfer implements TransferService {

    @Override
    public void transfer(Wallet from, Wallet to, double amount)
            throws InsufficientBalanceException {

        // Assume bank always allows transfer
        to.balance += amount;
    }
}
