/*
* ATM_teller interface
 * Methods : checkBalance,Deposit,seeTransaction,withdraw,transfer
 * Name : Simret Melak
 * Date :  2/21/2023
 */

package edu.ithaca.barr.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CentralBankTest {

    private CentralBank centralBank;
    private Account account1;
    private Account account2;
    private Account account3;


    @Test
    public void testSearchAccount() {
        centralBank = new CentralBank();
        account1 = new Account(1, 100.0, new Customer("Alice","a@gmail.com"));
        account2 = new Account(2, 50.0, new Customer("Bob","b@gmail.com"));
        centralBank.addAccounts(account1);
        centralBank.addAccounts(account2);
        Account result1 = CentralBank.searchAccount(1, centralBank.getAccounts());
        Account result2 = CentralBank.searchAccount(2, centralBank.getAccounts());
        Account result3 = CentralBank.searchAccount(3, centralBank.getAccounts());

        assertEquals(account1, result1);
        assertEquals(account2, result2);
        assertNull(result3);
    }

    @Test
    public void testGetAccounts() {
        centralBank = new CentralBank();
        account1 = new Account(1, 100.0, new Customer("Alice","a@gmail.com"));
        account2 = new Account(2, 50.0, new Customer("Bob","b@gmail.com"));
        centralBank.addAccounts(account1);
        centralBank.addAccounts(account2);
        assertEquals(2, centralBank.getAccounts().size());
        assertTrue(centralBank.getAccounts().contains(account1));
        assertTrue(centralBank.getAccounts().contains(account2));
    }

    @Test
    public void testAddAccounts() {
        centralBank = new CentralBank();
        account1 = new Account(1, 100.0, new Customer("Alice","a@gmail.com"));
        account2 = new Account(2, 50.0, new Customer("Bob","b@gmail.com"));
        centralBank.addAccounts(account1);
        centralBank.addAccounts(account2);
        account3 = new Account(3, 75.0, new Customer("Charlie","c@gmail.com"));
        centralBank.addAccounts(account3);
        assertTrue(centralBank.getAccounts().contains(account3));
    }

    @Test
    public void testDeleteAccount() {
        centralBank = new CentralBank();
        account1 = new Account(1, 100.0, new Customer("Alice","a@gmail.com"));
        account2 = new Account(2, 50.0, new Customer("Bob","b@gmail.com"));
        centralBank.addAccounts(account1);
        centralBank.addAccounts(account2);
        centralBank.deleteAccount(account1);
        assertFalse(centralBank.getAccounts().contains(account1));
        assertEquals(1, centralBank.getAccounts().size());

        centralBank.deleteAccount(account2);
        assertFalse(centralBank.getAccounts().contains(account2));
        assertEquals(0, centralBank.getAccounts().size());
    }
}
