public class WalletTransfer implements TransferService {

    @Override
    public void transfer(Wallet from, Wallet to, double amount)
            throws InsufficientBalanceException {

        if (from.balance < amount)
            throw new InsufficientBalanceException("Insufficient wallet balance!");

        from.balance -= amount;
        to.balance += amount;
    }
}
