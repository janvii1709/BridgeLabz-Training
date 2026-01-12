public class WalletPayment implements Payment {
    public void pay(double amount) throws PaymentFailedException {
        if (amount > 10000)
            throw new PaymentFailedException("Insufficient Wallet Balance");
        System.out.println("Wallet Payment Successful: INR " + amount);
    }
}
