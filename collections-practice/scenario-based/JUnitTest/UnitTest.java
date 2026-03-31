package main;

import org.junit.Test;
import static org.junit.Assert.*;

public class UnitTest {

    @Test
    public void Test_Deposit_ValidAmount() {
        Program account = new Program(1000);
        account.deposit(500);
        assertEquals(1500.0, account.getBalance(), 0.01);
    }

    @Test
    public void Test_Deposit_NegativeAmount() {
        Program account = new Program(1000);
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-200));
    }

    @Test
    public void Test_Withdraw_ValidAmount() {
        Program account = new Program(1000);
        account.withdraw(400);
        assertEquals(600.0, account.getBalance(), 0.01);
    }

    @Test
    public void Test_Withdraw_InsufficientFunds() {
        Program account = new Program(500);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(1000));
    }
}
