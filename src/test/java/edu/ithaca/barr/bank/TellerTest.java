package edu.ithaca.barr.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TellerTest {

    @Test
    public void testCreateSavingAccount() {
        CentralBank bank = new CentralBank();
        Teller teller = new Teller();
        teller.bank = bank;
        Customer customer = new Customer("John", "Doe");
        int accountNumber = 123456789;
        teller.createSavingAccount(customer, accountNumber);
        Account account = bank.searchSavingAccount(accountNumber, bank.getSavingAccounts());
        assertNotNull(account);
        assertEquals(0.0, account.checkBalance(), 0.001);
        assertEquals(customer, account.getCustomer());
    }

    @Test
    public void testCreateCheckingAccount() {
        CentralBank bank = new CentralBank();
        Teller teller = new Teller();
        teller.bank = bank;
        Customer customer = new Customer("Jane", "Doe");
        int accountNumber = 987654321;
        teller.createCheckingAccount(customer, accountNumber);
        Account account = bank.searchCheckingAccount(accountNumber, bank.getAllAccounts());
        assertNotNull(account);
        assertEquals(0.0, account.checkBalance(), 0.001);
        assertEquals(customer, account.getCustomer());
    }

    @Test
    public void testDeleteAccount() {
        CentralBank bank = new CentralBank();
        Teller teller = new Teller();
        teller.bank = bank;
        Customer customer = new Customer("John", "Doe@d.com");
        Customer customer2 = new Customer("John", "will@j.com");
        teller.createSavingAccount(customer, 1);
        teller.createSavingAccount(customer2, 2);
        Account account1 = bank.searchSavingAccount(1, bank.getAllAccounts());
        Account account2 = bank.searchSavingAccount(2, bank.getAllAccounts());
        assertNotNull(account1);
        assertEquals(2,bank.getAllAccounts().size());
        teller.deleteAccount(account1);
        teller.deleteAccount(account2);
        assertEquals(0,bank.getAllAccounts().size());
        assertEquals(0,bank.getCheckingAccounts().size());
        assertEquals(0,bank.getSavingAccounts().size());

    }

    @Test
    public void testCheckBalance() {
        CentralBank bank = new CentralBank();
        Teller teller = new Teller();
        teller.bank = bank;
        Customer customer = new Customer("John", "Doe");
        int accountNumber = 123456789;
        teller.createSavingAccount(customer, accountNumber);
        Account account = bank.searchAllAccount(accountNumber, bank.getAllAccounts());
        assertNotNull(account);
        assertEquals(0.0, teller.checkBalance(account), 0.001);
        account.deposit(1000);
        assertEquals(1000.0, teller.checkBalance(account), 0.001);
    }

    @Test
    public void testDeposit() {
        CentralBank bank = new CentralBank();
        Teller teller = new Teller();
        teller.bank = bank;
        Customer customer = new Customer("John", "Doe");
        int accountNumber = 123456789;
        teller.createSavingAccount(customer, accountNumber);
        Account account = bank.searchAllAccount(accountNumber, bank.getAllAccounts());
        assertNotNull(account);
        teller.deposit(account, 1000);
        assertEquals(1000.0, account.checkBalance(), 0.001);
        assertTrue(teller.getSuspiciousAccounts().isEmpty());
        teller.deposit(account, 6000);
        assertEquals(7000.0, account.checkBalance(), 0.001);
        assertTrue(teller.getSuspiciousAccounts().contains(account));
    }

}


