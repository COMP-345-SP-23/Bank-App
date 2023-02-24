package edu.ithaca.barr.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Class Name:CheckingsAndSavingsTest
 * Methods: 
 * Name: Vanessa Mpofu
 * Date: 23 Feb 2023
 */
public class CheckingsAndSavingsTest {
    
    @Test
    public void testDeposit() {
        Customer customer = new Customer("John", "johndoe@example.com");
        CheckingsAccount account = new CheckingsAccount(123456, 1000.0, customer);
        account.deposit(500.0);
        assertEquals(1500.0, account.checkBalance(), 0.01);
        assertEquals(1, account.getTransactionHistory().size());
        assertTrue(account.getTransactionHistory().contains(500.0));
    }
    
    @Test
    public void testWithdraw() {
        Customer customer = new Customer("John", "johndoe@example.com");
        CheckingsAccount account = new CheckingsAccount(123456, 1000.0, customer);
        account.withdraw(500.0);
        assertEquals(500.0, account.checkBalance(), 0.01);
        assertEquals(1, account.getTransactionHistory().size());
        assertTrue(account.getTransactionHistory().contains(-500.0));
    }
    
    @Test
    public void testTransfer() {
        Customer customer = new Customer("John", "johndoe@example.com");
        CheckingsAccount account = new CheckingsAccount(123456, 1000.0, customer);
        CheckingsAccount account2 = new CheckingsAccount(654321, 500.0, customer);
        account.transfer(account2, 500.0);
        assertEquals(500.0, account.checkBalance(), 0.01);
        assertEquals(1, account.getTransactionHistory().size());
        assertTrue(account.getTransactionHistory().contains(-500.0));
        assertEquals(1000.0, account2.checkBalance(), 0.01);
        assertEquals(1, account2.getTransactionHistory().size());
        assertTrue(account2.getTransactionHistory().contains(500.0));
    }
    
    
}
