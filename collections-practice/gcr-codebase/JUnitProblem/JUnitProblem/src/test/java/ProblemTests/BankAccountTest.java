package ProblemTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Problems.BankAccount;
import static org.junit.jupiter.api.Assertions.*;
public class BankAccountTest {
    private BankAccount account;
    @BeforeEach
    void setUp() {
        account = new BankAccount(1000.0); 
    }
    @Test
    void testDeposit() {
        account.deposit(500.0);
        assertEquals(1500.0, account.getBalance());
    }
    @Test
    void testWithdraw() {
        account.withdraw(300.0);
        assertEquals(700.0, account.getBalance());
    }
    @Test
    void testWithdrawInsufficientFunds() {
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(2000.0);
        });
    }
}
