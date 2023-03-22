package edu.ithaca.barr.bank;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SavingsAccountTest {
    
    @Test
    void testWithdraw() {
        Customer customer = new Customer("Vanessa","j@gmail.com");
        SavingsAccount savingsAccount = new SavingsAccount(123, 500, customer, "password");
        savingsAccount.withdraw(200);
        assertEquals(300, savingsAccount.checkBalance());
        assertThrows(IllegalArgumentException.class, () -> savingsAccount.withdraw(1001));
    }
    
    @Test
    void testInterestEarned() {
        Customer customer = new Customer("Vanessa","j@gmail.com");
        SavingsAccount savingsAccount = new SavingsAccount(123, 500, customer, "password");
        double interestEarned = savingsAccount.interestEarned(savingsAccount);
        assertEquals(550, interestEarned);
    }
}