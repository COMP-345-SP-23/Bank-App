/*
* ATM
 * Methods : checkBalanceTest,depositTest,seeTransactionTest,withdrawTest,transferTest
  * Name : Simret Melak
 * Date :  2/22/2023
 */

package edu.ithaca.barr.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class ATMTest {
    
    private ATM atm;
    private CentralBank bank;
    private Account account1;
    private Account account2;
    
    // @Before
    // public void setUp() {
    //     bank = Mockito.mock(CentralBank.class);
    //     atm = new ATM();
    //     atm.bank = bank;
    //     Customer customer1 = new Customer("John", "johndoe@example.com");
    //     Customer customer2 = new Customer("Jane", "janedoe@example.com");
    //     account1 = new Account(123456, 1000.0, customer1);
    //     account2 = new Account(654321, 500.0, customer2);
    // }

    @Test
    public void testCheckBalance() {
        atm = new ATM();
        atm.bank = bank;
        Customer customer1 = new Customer("John", "johndoe@example.com");
        Customer customer2 = new Customer("Jane", "janedoe@example.com");
        account1 = new Account(123456, 1000.0, customer1);
        account2 = new Account(654321, 500.0, customer2);
        assertEquals(1000.0, atm.checkBalance(account1), 0.01);
        assertEquals(500.0, atm.checkBalance(account2), 0.01);
    }
    
    @Test
    public void testDeposit() {
        atm = new ATM();
        atm.bank = bank;
        Customer customer1 = new Customer("John", "johndoe@example.com");
        Customer customer2 = new Customer("Jane", "janedoe@example.com");
        account1 = new Account(123456, 1000.0, customer1);
        account2 = new Account(654321, 500.0, customer2);
        atm.deposit(account1, 500.0);
        assertEquals(1500.0, account1.checkBalance(), 0.01);
    }
    
    @Test
    public void testSeeTransaction() {
        atm = new ATM();
        atm.bank = bank;
        Customer customer1 = new Customer("John", "johndoe@example.com");
        Customer customer2 = new Customer("Jane", "janedoe@example.com");
        account1 = new Account(123456, 1000.0, customer1);
        account2 = new Account(654321, 500.0, customer2);
        atm.deposit(account1, 500.0);
        atm.withdraw(account1, 200.0);
        ArrayList<Double> transactionHistory = atm.seeTransaction(account1);
        assertEquals(2, transactionHistory.size());
        assertTrue(transactionHistory.contains(500.0));
        assertTrue(transactionHistory.contains(-200.0));
    }
    
    @Test
    public void testWithdraw() {
        atm = new ATM();
        atm.bank = bank;
        Customer customer1 = new Customer("John", "johndoe@example.com");
        Customer customer2 = new Customer("Jane", "janedoe@example.com");
        account1 = new Account(123456, 1000.0, customer1);
        account2 = new Account(654321, 500.0, customer2);
        atm.withdraw(account1, 500.0);
        assertEquals(500.0, account1.checkBalance(), 0.01);
    }
    
    @Test
    public void testTransfer() {
        atm = new ATM();
        atm.bank = bank;
        Customer customer1 = new Customer("John", "johndoe@example.com");
        Customer customer2 = new Customer("Jane", "janedoe@example.com");
        account1 = new Account(123456, 1000.0, customer1);
        account2 = new Account(654321, 500.0, customer2);
        atm.transfer(account1, account2, 500.0);
        assertEquals(500.0, account1.checkBalance(), 0.01);
        assertEquals(1000.0, account2.checkBalance(), 0.01);
    }
}

