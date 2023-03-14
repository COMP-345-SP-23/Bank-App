

/*
* ATM_teller interface
 * Methods : testSearchAccount(),testGetAccounts(),testAddAccounts()
  * Name : Simret Melak
 * Date :  3/13/2023
 */

 package edu.ithaca.barr.bank;

 import org.junit.jupiter.api.Test;
 import static org.junit.jupiter.api.Assertions.*;
 
 public class CentralBankTest {
 
     // This test checks if the searchSavingAccount method returns the correct savings account for a given account ID.
     @Test
     public void testSearchSavingAccount() {
         CentralBank bank = new CentralBank();
         Customer customer = new Customer("Nardos","naninut@gmail.com");
         SavingsAccount savingsAccount = new SavingsAccount(1,100,customer,"Simret1023###");
         bank.addSavingAccounts(savingsAccount);
         SavingsAccount account = bank.searchSavingAccount(1);
         assertEquals(savingsAccount, account);
     }
 
     // This test checks if the searchCheckingAccount method returns the correct checking account for a given account ID.
     @Test
     public void testSearchCheckingAccount() {
         CentralBank bank = new CentralBank();
         Customer customer = new Customer("Nardos","naninut@gmail.com");
         CheckingsAccount checkingsAccount = new CheckingsAccount(1,100,customer,"Simret1023###");
         bank.addCheckingAccounts(checkingsAccount);
         CheckingsAccount account = bank.searchCheckingAccount(1);
         assertEquals(checkingsAccount, account);
     }
 
     // This test checks if the getSavingAccounts method returns all the savings accounts in the bank, and if it correctly identifies a savings account that has been added.
     @Test
     public void testGetSavingAccounts() {
         CentralBank bank = new CentralBank();
         Customer customer = new Customer("Nardos","naninut@gmail.com");
         SavingsAccount savingsAccount = new SavingsAccount(1,100,customer,"Simret1023###");
         bank.addSavingAccounts(savingsAccount);
         assertEquals(1, bank.getSavingAccounts().size());
         assertTrue(bank.getSavingAccounts().contains(savingsAccount));
     }
 
     // This test checks if the getCheckingAccounts method returns all the checking accounts in the bank, and if it correctly identifies a checking account that has been added.
     @Test
     public void testGetCheckingAccounts() {
         CentralBank bank = new CentralBank();
         Customer customer = new Customer("Nardos","naninut@gmail.com");
         CheckingsAccount checkingsAccount = new CheckingsAccount(1,100,customer,"Simret1023###");
         bank.addCheckingAccounts(checkingsAccount);
         assertEquals(1, bank.getCheckingAccounts().size());
         assertTrue(bank.getCheckingAccounts().contains(checkingsAccount));
     }
 
     // This test checks if the addSavingAccounts method correctly adds a new savings account to the bank.
     @Test
     public void testAddSavingAccounts() {
         CentralBank bank = new CentralBank();
         Customer customer = new Customer("Nardos","naninut@gmail.com");
         SavingsAccount savingsAccount = new SavingsAccount(1,100,customer,"Simret1023###");
         bank.addSavingAccounts(savingsAccount);
         Customer customer1 = new Customer("Simret","nt@gmail.com");
         SavingsAccount newAccount = new SavingsAccount(1,100,customer,"Simret1023###");
         bank.addSavingAccounts(newAccount);
         assertTrue(bank.getSavingAccounts().contains(newAccount));
     }

     // This test checks if the addCheckingAccounts method correctly adds a new savings account to the bank.
    @Test
    public void testAddCheckingAccounts() {
        CentralBank bank = new CentralBank();
        Customer customer = new Customer("Nardos","naninut@gmail.com");
      
        CheckingsAccount checkingsAccount = new CheckingsAccount(1,100,customer,"Simret1023###");
        bank.addCheckingAccounts(checkingsAccount);
        Customer customer1 = new Customer("Simret","n@gmail.com");
        CheckingsAccount newAccount = new CheckingsAccount(1,100,customer,"Simret1023###");
        bank.addCheckingAccounts(newAccount);
        assertTrue(bank.getCheckingAccounts().contains(newAccount));
    }

    // this test checks the overall balance of the bank
    @Test
    public void testGetOverallBalance() {
        CentralBank bank = new CentralBank();
        Customer customer = new Customer("Nardos","naninut@gmail.com");
        SavingsAccount savingsAccount = new SavingsAccount(1,100,customer,"Simret1023###");
        CheckingsAccount checkingsAccount = new CheckingsAccount(1,100,customer,"Simret1023###");
        bank.addSavingAccounts(savingsAccount);
        bank.addCheckingAccounts(checkingsAccount);
        assertEquals(200, bank.getOverallBalance(), 0.01);
    }
}
