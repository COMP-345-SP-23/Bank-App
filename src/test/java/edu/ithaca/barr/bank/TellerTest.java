/*class name: Teller Test
 * name: Nardos Mamo
 * date: 2/23/23
 */
/*
 * Edited on 3/13/2023
 */

package edu.ithaca.barr.bank;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TellerTest {

    @Test
    public void testCreateSavingAccount() {
        CentralBank bank = new CentralBank();
        Teller teller = new Teller(bank);
        Customer customer = new Customer("Alice","a@gmail.com");
        teller.createSavingAccount(customer, "password");
        assertEquals(1, bank.getSavingAccounts().size());
    }

    @Test
    public void testCreateCheckingAccount() {
        CentralBank bank = new CentralBank();
        Teller teller = new Teller(bank);
        Customer customer = new Customer("Bob","b@gmail.com");
        teller.createCheckingAccount(customer, "password");
        assertEquals(1, bank.getCheckingAccounts().size());
    }

    @Test
    public void testCheckSavingsBalance() {
        CentralBank bank = new CentralBank();
        Teller teller = new Teller(bank);
        Customer customer = new Customer("Charlie","c@gmail.com");
        SavingsAccount account = new SavingsAccount(1, 100.0, customer, "password");
        assertEquals(100.0, teller.checkSavingsBalance(account), 0.001);
    }

    @Test
    public void testCheckCheckingsBalance() {
        CentralBank bank = new CentralBank();
        Teller teller = new Teller(bank);
        Customer customer = new Customer("Dave","d@gmail.com");
        CheckingsAccount account = new CheckingsAccount(1, 100.0, customer, "password");
        assertEquals(100.0, teller.checkCheckingsBalance(account), 0.001);
    }

    @Test
void testDeleteSavingsAccount() {
    // create a bank and teller instance
    CentralBank bank = new CentralBank();
    Teller teller = new Teller(bank);

    // create a customer and a savings account for the customer
    Customer customer = new Customer("John", "johndoe@example.com");
    teller.createSavingAccount(customer, "password");

    // get the account number of the savings account
    SavingsAccount savingsAccount = bank.getSavingAccounts().get(0);
    int accountNum = savingsAccount.getAcctNum();

    // delete the savings account
    teller.deleteSavingAccount(accountNum);

    // assert that the savings account has been deleted from the bank
    assertFalse(bank.getSavingAccounts().contains(savingsAccount));
}

@Test
void testDeleteCheckingsAccount() {
    // create a bank and teller instance
    CentralBank bank = new CentralBank();
    Teller teller = new Teller(bank);

    // create a customer and a checkings account for the customer
    Customer customer = new Customer("John", "johndoe@example.com");
    teller.createCheckingAccount(customer, "password");

    // get the account number of the checkings account
    CheckingsAccount checkingsAccount = bank.getCheckingAccounts().get(0);
    int accountNum = checkingsAccount.getAcctNum();

    // delete the checkings account
    teller.deleteCheckingAccount(accountNum);

    // assert that the checkings account has been deleted from the bank
    assertFalse(bank.getCheckingAccounts().contains(checkingsAccount));
}

@Test
public void testDeleteSavingAccount() {
    CentralBank bank = new CentralBank();
    Teller teller = new Teller(bank);
    // Create a saving account with account number 1234 and add it to the bank
    SavingsAccount account = new SavingsAccount(1234,1000, new Customer("John", "Doe"), "Password123**");
    bank.addSavingAccounts(account);
    
    // Call the deleteSavingAccount method and check that the account was removed
    teller.deleteSavingAccount(1234);
    assertFalse(bank.getSavingAccounts().contains(account));
}

@Test
public void testAuthenticateUser() {
    CentralBank bank = new CentralBank();
    Teller teller = new Teller(bank);
    // Create a checking account with account number 5678 and password "password" and add it to the bank
    CheckingsAccount account = new CheckingsAccount(1,100,new Customer("Jane", "Doe"), "Password123*");
    bank.addCheckingAccounts(account);
    
    // Call the authenticateUser method with the correct account number and password
    assertTrue(teller.authenticateUser(1, "Password123*"));
    
    // Call the authenticateUser method with the incorrect password
    assertFalse(teller.authenticateUser(1, "Wrongpassword8&"));
    
    // Call the authenticateUser method with a non-existent account number
    assertFalse(teller.authenticateUser(1000, "Password123*"));
}

@Test
public void testTransferSavingtoChecking() {
    // Create a saving account and a checking account with the same customer and add them to the bank
    Customer customer = new Customer("John", "Doe");
    CentralBank bank = new CentralBank();
    Teller teller = new Teller(bank);
    SavingsAccount savingAccount = new SavingsAccount(1,1000,customer, "Password123**");
    CheckingsAccount checkingAccount = new CheckingsAccount(2,100,customer, "Password123**");
    bank.addSavingAccounts(savingAccount);
    bank.addCheckingAccounts(checkingAccount);
    
    // Call the transferSavingtoChecking method with a valid transfer amount
    teller.transferSavingtoChecking(savingAccount, checkingAccount, 100.0);
    assertEquals(900, savingAccount.checkBalance(), 0.001);
    assertEquals(200.0, checkingAccount.checkBalance(), 0.001);
    
    // Call the transferSavingtoChecking method with a transfer amount greater than the saving account balance
    try {
        teller.transferSavingtoChecking(savingAccount, checkingAccount, 2000);
        fail("Expected IllegalArgumentException to be thrown");
    } catch (IllegalArgumentException e) {
        assertEquals("Insufficient balance", e.getMessage());
    }
    
    // Call the transferSavingtoChecking method with a checking account that belongs to a different customer
    CheckingsAccount otherAccount = new CheckingsAccount(3,1000,  new Customer("Bob", "Smith"),"Password123**");
    bank.addCheckingAccounts(otherAccount);
    try {
        teller.transferSavingtoChecking(savingAccount, otherAccount, 50.0);
        fail("Expected IllegalArgumentException to be thrown");
    } catch (IllegalArgumentException e) {
        assertEquals("You can not transfer money from your savings account unless it is to your checkings Account", e.getMessage());
    }
}

}