package edu.ithaca.barr.bank;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;



public class TellerTest {

    private Teller teller;
    private CentralBank bank;
    private Customer customer1;
    private Customer customer2;
    private Account account1;
    private Account account2;


    

    @Test
    public void testCreateAccount() {
        teller = new Teller();
        bank = new CentralBank();
        teller.bank = bank;
        teller.createAccount(new Customer("Charlie","c@gmail.com"), 3);
        assertNotNull(bank.getAccounts());
        assertEquals(0.0, bank.searchAccount(3,bank.getAccounts()).checkBalance(), 0.0);
    }

    @Test
    public void testDeleteAccount() {
        teller = new Teller();
        bank = new CentralBank();
        teller.bank = bank;
        teller.createAccount(new Customer("Charlie","c@gmail.com"), 3);
        assertNotNull(bank.getAccounts());
        teller.deleteAccount(bank.searchAccount(3,bank.getAccounts()));
        assertNull(bank.searchAccount(3,bank.getAccounts()));
        assertEquals(0, bank.getAccounts().size());
    }

    @Test
    public void testCheckBalance() {
        teller = new Teller();
        bank = new CentralBank();
        teller.bank = bank;
        customer1 = new Customer("Alice","a@gmail.com");
        customer2 = new Customer("Bob","b@gmail.com");
        account1 = new Account(1, 100.0, customer1);
        account2 = new Account(2, 50.0, customer2);
        assertEquals(100.0, teller.checkBalance(account1), 0.0);
        assertEquals(50.0, teller.checkBalance(account2), 0.0);
    }

    @Test
    public void testDeposit() {
        teller = new Teller();
        bank = new CentralBank();
        teller.bank = bank;
        customer1 = new Customer("Alice","a@gmail.com");
        customer2 = new Customer("Bob","b@gmail.com");
        account1 = new Account(1, 100.0, customer1);
        account2 = new Account(2, 50.0, customer2);
        teller.deposit(account1, 50.0);
        assertEquals(150.0, account1.checkBalance(), 0.0);
    }

    @Test
    public void testSeeTransaction() {
        teller = new Teller();
        bank = new CentralBank();
        teller.bank = bank;
        customer1 = new Customer("Alice","a@gmail.com");
        customer2 = new Customer("Bob","b@gmail.com");
        account1 = new Account(1, 100.0, customer1);
        account2 = new Account(2, 50.0, customer2);
        account1.deposit(100.0);
        account1.withdraw(50.0);
        account1.deposit(75.0);

        ArrayList<Double> transactions = teller.seeTransaction(account1);
        assertEquals(3, transactions.size());
        assertEquals(100.0, transactions.get(0), 0.0);
        assertEquals(-50.0, transactions.get(1), 0.0);
        assertEquals(75.0, transactions.get(2), 0.0);
    }

    @Test
    public void testWithdraw() {
        teller = new Teller();
        bank = new CentralBank();
        teller.bank = bank;
        customer1 = new Customer("Alice","a@gmail.com");
        customer2 = new Customer("Bob","b@gmail.com");
        account1 = new Account(1, 100.0, customer1);
        account2 = new Account(2, 50.0, customer2);
        teller.withdraw(account2, 20.0);
        assertEquals(30.0, account2.checkBalance(), 0.0);
    }

    @Test
    public void testTransfer() {
        teller = new Teller();
        bank = new CentralBank();
        teller.bank = bank;
        customer1 = new Customer("Alice","a@gmail.com");
        customer2 = new Customer("Bob","b@gmail.com");
        account1 = new Account(1, 100.0, customer1);
        account2 = new Account(2, 50.0, customer2);
        teller.transfer(account1, account2, 50.0);
        assertEquals(50.0, account1.checkBalance(), 0.0);
        assertEquals(100.0, account2.checkBalance(), 0.0);
    }
}
