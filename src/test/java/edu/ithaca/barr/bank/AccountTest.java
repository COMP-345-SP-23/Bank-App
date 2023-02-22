package edu.ithaca.barr.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class AccountTest {
    
    private Account account;
    private Customer customer;
    
    
    @Test
    public void testDeposit() {
        customer = new Customer("John", "johndoe@example.com");
        account = new Account(123456, 1000.0, customer);
        account.deposit(500.0);
        assertEquals(1500.0, account.checkBalance(), 0.01);
        assertEquals(1, account.getTransactionHistory().size());
        assertTrue(account.getTransactionHistory().contains(500.0));
    }
    
    @Test
    public void testWithdraw() {
        customer = new Customer("John", "johndoe@example.com");
        account = new Account(123456, 1000.0, customer);
        account.withdraw(500.0);
        assertEquals(500.0, account.checkBalance(), 0.01);
        assertEquals(1, account.getTransactionHistory().size());
        assertTrue(account.getTransactionHistory().contains(-500.0));
    }
    
    @Test
    public void testTransfer() {
        customer = new Customer("John", "johndoe@example.com");
        account = new Account(123456, 1000.0, customer);
        Account account2 = new Account(654321, 500.0, customer);
        account.transfer(account2, 500.0);
        assertEquals(500.0, account.checkBalance(), 0.01);
        assertEquals(1, account.getTransactionHistory().size());
        assertTrue(account.getTransactionHistory().contains(-500.0));
        assertEquals(1000.0, account2.checkBalance(), 0.01);
        assertEquals(1, account2.getTransactionHistory().size());
        assertTrue(account2.getTransactionHistory().contains(500.0));
    }
    

}