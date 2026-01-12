public class UPIPayment implements Payment {
    public void pay(double amount) throws PaymentFailedException {
        if (amount > 50000)
            throw new PaymentFailedException("UPI Limit Exceeded");
        System.out.println("UPI Payment Successful: INR " + amount);
    }
}
