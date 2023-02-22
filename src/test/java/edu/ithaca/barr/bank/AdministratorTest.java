package edu.ithaca.barr.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AdministratorTest {
    
    @Test
    void overallBalanceTest(){
        CentralBank centralBankSystem = new CentralBank();
        Customer customer = new Customer("John", "johndoe@example.com");
        Customer customer1 = new Customer("Jack", "jackdoe@example.com");
        Customer customer2 = new Customer("James ", "james@example.com");
        Customer customer3 = new Customer("Jake", "jdoe@example.com");
        
        centralBankSystem.add(new Account(654321, 5000.0, customer));
        centralBankSystem.add(new Account(651432, 1500.0, customer1));
        centralBankSystem.add(new Account(321654, 5500.0, customer2));
        centralBankSystem.add(new Account(432651, 50000.0, customer3));

        assertEquals(62000.0, centralBankSystem.checkOverallBalance());
        // not yet sure whether checkOverallBalance should have a parameter

    }

    @Test
    void freezeAccountTest(){
        Customer customer = new Customer("John", "johndoe@example.com");
        Customer customer1 = new Customer("Jack", "jackdoe@example.com");
        Customer customer2 = new Customer("James ", "james@example.com");
        Account account  = new Account(654321, 500.0, customer);
        Account account1 = new Account(645321, 5000.0, customer1);
        Account account2 = new Account(674831, 500.0, customer2);
        assertTrue(account.freezeAccount(654321));
        assertTrue(account1.freezeAccount(645321));
        assertFalse(account1.freezeAccount(674831));

    }


    @Test
    void unfreezeAccountTest(){
        Customer customer = new Customer("John", "johndoe@example.com");
        Customer customer1 = new Customer("Jack", "jackdoe@example.com");
        Customer customer2 = new Customer("James ", "james@example.com");
        Account account  = new Account(654321, 500.0, customer);
        Account account1 = new Account(645321, 5000.0, customer1);
        Account account2 = new Account(674831, 500.0, customer2);
        assertTrue(account.unfreezeAccount(654321));
        assertTrue(account1.unfreezeAccount(645321));
        assertFalse(account1.unfreezeAccount(674831));
    }

    @Test 
    void checkSuspiciousTest(){
        CentralBank centralBankSystem = new CentralBank();
        Customer customer = new Customer("John", "johndoe@example.com");
        Account account  = new Account(654321, 500.0, customer);
        centralBankSystem.add(account);
        centralBankSystem.account.deposit(500.00);
        centralBankSystem.account.deposit(500.00);
        centralBankSystem.account.withdraw(200.00);
        centralBankSystem.account.deposit(500.00);
        centralBankSystem.account.withdraw(100.00);
        centralBankSystem.account.deposit(500.00);
        centralBankSystem.checkSuspiciousNess(654321);
 // should printout a message reporting suspicious activity

    }
}
