class SimulateAnATM {
    String AccountHolder, AccountNumber;
    double Balance;

    void Deposit(double Amount) {
        Balance += Amount;
        System.out.println("Deposited: " + Amount);
        System.out.println("Current balance: " + Balance);
    }
    void Withdraw(double Amount) {
        if(Amount <= Balance) {
            Balance -= Amount;
            System.out.println("Withdraw amount is : " + Amount);
            System.out.println("Current balance: " + Balance);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public static void main(String[] args) {
        SimulateAnATM b = new SimulateAnATM();
        b.AccountHolder="                              State of Chennai             ";
        b.Balance = 700;

        System.out.println(b.AccountHolder);
        System.out.println("Current balance: " + b.Balance);

        b.Deposit(200);
        b.Withdraw(100);
        b.Withdraw(2000);
    }
}