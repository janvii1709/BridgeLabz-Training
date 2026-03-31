// CurrentAccount.java
public class CurrentAccount extends Account {

    public CurrentAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    @Override
    public void accountType() {
        System.out.println(accountHolder + " has a Current Account");
    }
}
