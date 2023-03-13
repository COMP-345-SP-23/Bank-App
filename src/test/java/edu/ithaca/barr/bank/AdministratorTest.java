package edu.ithaca.barr.bank;
/**
 * Class Name: AdministratorTest
 * Methods: checKOverallBalance, freezeAcc, unfreezeAcc, checkSuspiciousness
 * Name: Vanessa Mpofu
 * Date: 23 Feb 2023
 */
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
        Account account  = new Account(654321, 5000.0, customer);
        Account account1 = new Account(651432, 1500.0, customer1);
        Account account2  = new Account(321654, 5500.0, customer2);
        Account account3 = new Account(432651, 50000.0, customer3);
        centralBankSystem.addAccounts(account);
        centralBankSystem.addAccounts(account1);
        centralBankSystem.addAccounts(account2);
        centralBankSystem.addAccounts(account3);
        assertEquals(62000.0, centralBankSystem.checkOverallBalance());
        // not yet sure whether checkOverallBalance should have a parameter

    }
    

    @Test
    /**
     * create an account object
     * check if the account is frozen or unfrozen upon creation 
     * it should show false because we cannot create a frozen account
     */
    void frozenUnfrozenTest(){
        Customer customer = new Customer("John", "johndoe@example.com");
        Account account  = new Account(654321, 500.0, customer);
        assertFalse(account.isFrozen());
        account.freezeAccount();
        assertTrue(account.isFrozen());
        account.unfreezeAccount();
        assertFalse(account.isFrozen());
     
    }

    @Test 
    void checkSuspiciousTest(){
        CentralBank centralBank = new CentralBank();
        Customer customer = new Customer("John", "johndoe@example.com");
        Customer customer2 = new Customer("James ", "james@example.com");
        Account account  = new Account(654321, 500.0, customer);
        Account account2 = new Account(674831, 500.0, customer2);

        centralBank.addAccounts(account);
        centralBank.addAccounts(account2);

        centralBank.accounts.get(0).deposit(500.00);
        centralBank.accounts.get(0).deposit(500.00);
        centralBank.accounts.get(0).withdraw(200.00);
        centralBank.accounts.get(0).deposit(500.00);
        centralBank.accounts.get(0).withdraw(100.00);
        centralBank.accounts.get(0).deposit(500.00);
        centralBank.accounts.get(0).checkSuspiciousNess(654321);
 // should printout a message reporting suspicious activity

    }
}
