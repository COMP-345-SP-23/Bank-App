package edu.ithaca.barr.bank;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
public class SystemTest {
    CentralBank bank = new CentralBank();
    Teller teller = new Teller(bank);
    Administrator admin = new Administrator(bank);
    ATM atm = new ATM(bank);

    @Test
    public void testBankingSystem() {
        // Create a central bank and a teller
        CentralBank bank = new CentralBank();
        Teller teller = new Teller(bank);
    
        // Create two customers
        Customer customer1 = new Customer("Alice","a@gmail.com");
        Customer customer2 = new Customer("Jane", "Smith");
    
        // Create a savings account for customer1
        teller.createSavingAccount(customer1, "Password123**");
        assertEquals(1, bank.getSavingAccounts().size());
        //Authenticate user
        int savingsAccNum = bank.getSavingAccounts().get(0).getAcctNum();
        assertTrue(teller.authenticateUser(savingsAccNum, "Password123**"));
    
        // Make a deposit to customer1's savings account
        teller.depositToSavings(bank.getSavingAccounts().get(0), 1000.0);
        assertEquals(1000.0, teller.checkSavingsBalance(bank.getSavingAccounts().get(0)), 0.001);
    
        // Create a checking account for customer2
        teller.createCheckingAccount(customer2, "Mypassword123!");
        assertEquals(1, bank.getCheckingAccounts().size());
    
        int checkingAccNum = bank.getCheckingAccounts().get(0).getAcctNum();
        assertTrue(teller.authenticateUser(checkingAccNum, "Mypassword123!"));
    
    
        // Make a deposit to customer2's checking account
        teller.depositToCheckings(bank.getCheckingAccounts().get(0), 5000.0);
        assertEquals(5000.0, teller.checkCheckingsBalance(bank.getCheckingAccounts().get(0)), 0.001);
    

   // Call the transferSavingsToChecking method with a savings account that belongs to a different customer
   try {
       teller.transferSavingtoChecking(bank.getSavingAccounts().get(0), bank.getCheckingAccounts().get(0), 20.0);
       fail("Expected IllegalArgumentException to be thrown");
   } catch (IllegalArgumentException e) {
       assertEquals("You can not transfer money from your savings account unless it is to your checkings Account", e.getMessage());
   }

   // Withdraw money from customer2's checking account using the ATM
   atm.withdrawFromCheckings(bank.getCheckingAccounts().get(0), 1000.0);
   assertEquals(4000.0, teller.checkCheckingsBalance(bank.getCheckingAccounts().get(0)), 0.001);

     // Call the deleteSavingAccount method and check that the account was removed
     teller.deleteSavingAccount(savingsAccNum);  
    // Ensure that the account was deleted
    assertEquals(0, bank.getSavingAccounts().size());
}}