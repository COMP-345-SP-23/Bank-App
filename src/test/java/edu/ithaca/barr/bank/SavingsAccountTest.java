package edu.ithaca.barr.bank;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class SavingsAccountTest {

    @Test
    public void testMaxWithdrawal() {
        SavingsAccount savingsAccount = new SavingsAccount(12345, 5000.00, new Customer("John Doe", "123 Main St"), "password");

        // Test withdrawing an amount less than or equal to the maximum amount
        savingsAccount.maxWithdrawal(500.00);
        assertEquals(4500.0, savingsAccount.checkBalance(), 0.001);

        savingsAccount.maxWithdrawal(1000.00);
        assertEquals(3500.0, savingsAccount.checkBalance(), 0.001);
        // Test withdrawing an amount greater than the maximum amount
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            savingsAccount.maxWithdrawal(1001.00);
        });
        assertEquals("Cannot make a withdrawal that exceeds the maximum withdrawal amount", exception.getMessage());
    }

    @Test
    public void testInterestEarned() {
        SavingsAccount savingsAccount = new SavingsAccount(12345, 500.00, new Customer("Nardos Mamo", "123 Main St"), "password");

        // Test interest earned on a non-null account with positive balance
        double expectedBalance = 500.00 + 500.00 * 0.35;
        assertEquals(expectedBalance, savingsAccount.interestEarned(savingsAccount), 0.001);

        // Test interest earned on a null account
        assertEquals(0.0, savingsAccount.interestEarned(null), 0.001);

        // Test interest earned on an account with zero balance
        SavingsAccount zeroBalanceAccount = new SavingsAccount(23456, 0.0, new Customer("Nardos Mamo", "456 Main St"), "password");
        assertEquals(0.0, zeroBalanceAccount.interestEarned(zeroBalanceAccount), 0.001);
    }
}
