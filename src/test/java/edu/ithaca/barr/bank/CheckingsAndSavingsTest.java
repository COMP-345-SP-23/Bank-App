package edu.ithaca.barr.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Class Name:CheckingsAndSavingsTest
 * Methods: test methods on both Savings and Checkings accounts
 * Name: Vanessa Mpofu
 * Date: 23 Feb 2023
 */
public class CheckingsAndSavingsTest {
    
    @Test
    /**
     * deposit test on a checkings account
     */
    void testDeposit() {
        Customer customer = new Customer("John", "johndoe@example.com");
        CheckingsAccount account = new CheckingsAccount(123456, 1000.0, customer,"Password123#");
        account.deposit(500.0);
        assertEquals(1500.0, account.checkBalance(), 0.01);
        assertEquals(1, account.getTransactionHistory().size());
        assertTrue(account.getTransactionHistory().contains(500.0));
    }
    
    /**
     * withdraw test on checkings account 
     */
    @Test
    void testWithdraw() {
        Customer customer = new Customer("John", "johndoe@example.com");
        CheckingsAccount account = new CheckingsAccount(123456, 1000.0, customer,"Password123#");
        account.withdraw(500.0);
        assertEquals(500.0, account.checkBalance(), 0.01);
        assertEquals(1, account.getTransactionHistory().size());
        assertTrue(account.getTransactionHistory().contains(-500.0));
    }
    
    /**
     * transfer test on checkings account
     */
    @Test
    void testTransfer() {
        Customer customer = new Customer("John", "johndoe@example.com");
        CheckingsAccount account = new CheckingsAccount(123456, 1000.0, customer,"Password123#");
        CheckingsAccount account2 = new CheckingsAccount(654321, 500.0, customer,"Password123#");
        account.transfer(account2, 500.0);
        assertEquals(500.0, account.checkBalance(), 0.01);
        assertEquals(1, account.getTransactionHistory().size());
        assertTrue(account.getTransactionHistory().contains(-500.0));
        assertEquals(1000.0, account2.checkBalance(), 0.01);
        assertEquals(1, account2.getTransactionHistory().size());
        assertTrue(account2.getTransactionHistory().contains(500.0));
    }

    /**
     * deposits and calculate interest on savings account
     */
    @Test
    void depositAndInterestTest(){
        Customer customer = new Customer("John", "johndoe@example.com");
        SavingsAccount account = new SavingsAccount(123456, 1000.0, customer,"Password123#");
        account.deposit(500.0);
        assertEquals(1500.0, account.checkBalance());
        account.interestEarned(account, 0.05);
        assertEquals(1575.0, account.interestEarned(account, 0.05));
    }


    /**
     * test for maximum withdrawal amount on savings account
     */
    @Test
    void maxWithdrawalTest(){
        Customer customer = new Customer("John", "johndoe@example.com");
        SavingsAccount account = new SavingsAccount(123456, 10000.0, customer,"Password123#");
        assertThrows(IllegalArgumentException.class, ()-> account.maxWithdrawal(5500.00, 5000.0));

    }
    
    
}
