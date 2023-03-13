
package edu.ithaca.barr.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;


public class AccountTest {

    // Test deposit method
    @Test
    public void testDeposit() {
        Customer c = new Customer("John", "johndoe@gmail.com");
        Account acct = new Account(123, 500.0, c, "password");

        // Deposit $100
        acct.deposit(100.0);
        assertEquals(600.0, acct.checkBalance(), 0.0);

        // Deposit $0
        acct.deposit(0.0);
        assertEquals(600.0, acct.checkBalance(), 0.0);

        // Deposit -$100
        try {
            acct.deposit(-100.0);
        } catch (IllegalArgumentException e) {
            assertEquals("Enter a positive integer with less than or equal to 2 decimal points", e.getMessage());
        }
    }

    // Test withdraw method
    @Test
    public void testWithdraw() {
        Customer c = new Customer("John","johndoe@gmail.com");
        Account acct = new Account(123, 500.0, c, "password");

        // Withdraw $100
        acct.withdraw(100.0);
        assertEquals(400.0, acct.checkBalance(), 0.0);

        // Withdraw $0
        acct.withdraw(0.0);
        assertEquals(400.0, acct.checkBalance(), 0.0);

        // Withdraw $600 (more than balance)
        try {
            acct.withdraw(600.0);
        } catch (IllegalArgumentException e) {
            assertEquals("Insufficient balance", e.getMessage());
        }

        // Withdraw -$100
        try {
            acct.withdraw(-100.0);
        } catch (IllegalArgumentException e) {
            assertEquals("Enter a positive integer with less than or equal to 2 decimal points", e.getMessage());
        }
    }

    // Test transfer method
    @Test
    public void testTransfer() {
        Customer c1 = new Customer("John","johndoe@gmail.com");
        Account acct1 = new Account(123, 500.0, c1, "password");

        Customer c2 = new Customer("Jane","janedoe@gmail.com");
        Account acct2 = new Account(456, 200.0, c2, "password");

        // Transfer $100 from acct1 to acct2
        acct1.transfer(acct2, 100.0);
        assertEquals(400.0, acct1.checkBalance(), 0.0);
        assertEquals(300.0, acct2.checkBalance(), 0.0);

        // Transfer $0 from acct1 to acct2
        acct1.transfer(acct2, 0.0);
        assertEquals(400.0, acct1.checkBalance(), 0.0);
        assertEquals(300.0, acct2.checkBalance(), 0.0);

        // Transfer $600 (more than balance) from acct1 to acct2
        try {
            acct1.transfer(acct2, 600.0);
        } catch (IllegalArgumentException e) {
            assertEquals("Insufficient balance", e.getMessage());
        }

        // Transfer -$100 from acct1 to acct2
        try {
            acct1.transfer(acct2, -100.0);
        } catch (IllegalArgumentException e) {
            assertEquals("Enter a positive integer with less than or equal to 2 decimal points", e.getMessage());
        }
    }
    @Test
    public void testGetTransactionHistory() {
        Customer customer = new Customer("Alice", "main@gmail.com");
        Account account = new Account(1001, 500.0, customer, "Password123");

        account.deposit(100.0);
        account.withdraw(50.0);

        ArrayList<Double> expected = new ArrayList<>();
        expected.add(100.0);
        expected.add(-50.0);

        assertEquals(expected, account.getTransactionHistory());
    }


@Test
    public void testIsPasswordValid() {
        assertTrue(Account.isPasswordValid("Password123!"));
        assertThrows(IllegalArgumentException.class, () -> {
            Account.isPasswordValid("short");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Account.isPasswordValid("longpasswordwithoutspecialcharactersandnumbers");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Account.isPasswordValid("password with spaces");
        });
     
        assertThrows(IllegalArgumentException.class, () -> {
            Account.isPasswordValid("onlylowercaseletters");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Account.isPasswordValid("ONLYUPPERCASELETTERS");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Account.isPasswordValid("1234567890");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Account.isPasswordValid("onlyletters");
        });
    }
}