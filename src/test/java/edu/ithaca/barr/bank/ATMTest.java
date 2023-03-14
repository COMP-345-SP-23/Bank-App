/*
* ATM
 * Methods : checkBalanceTest,depositTest,seeTransactionTest,withdrawTest,transferTest
  * Name : Simret Melak
 * Date :  3/13/2023
 */

 package edu.ithaca.barr.bank;

 // import necessary libraries and classes
 import static org.junit.jupiter.api.Assertions.*;
 import org.junit.jupiter.api.Test;
 import java.util.ArrayList;
 
 // define a class to test ATM methods
 public class ATMTest {
 
     // test method to check savings account balance
     @Test
     public void testCheckSavingsBalance() {
         // create a new central bank object
         CentralBank bank = new CentralBank();
 
         // create a new customer object with name and email
         Customer customer = new Customer("Charlie","c@gmail.com");
 
         // create a new savings account with account number, balance, customer, and password
         SavingsAccount savingsAccount = new SavingsAccount(1, 100.0, customer, "password");
 
         // add the savings account to the bank
         bank.addSavingAccounts(savingsAccount);
 
         // create a new ATM object with the bank as a parameter
         ATM atm = new ATM(bank);
 
         // check the balance of the savings account using the ATM's checkSavingsBalance method
         double balance = atm.checkSavingsBalance(savingsAccount);
 
         // assert that the balance is equal to the expected value (100.0) with a tolerance of 0.01
         assertEquals(100, balance, 0.01);
     }
 
     // test method to check checkings account balance
     @Test
     public void testCheckCheckingsBalance() {
         // create a new central bank object
         CentralBank bank = new CentralBank();
 
         // create a new customer object with name and email
         Customer customer = new Customer("Dave","d@gmail.com");
 
         // create a new checkings account with account number, balance, customer, and password
         CheckingsAccount account = new CheckingsAccount(1, 100.0, customer, "password");
 
         // add the checkings account to the bank
         bank.addCheckingAccounts(account);
 
         // create a new ATM object with the bank as a parameter
         ATM atm = new ATM(bank);
 
         // check the balance of the checkings account using the ATM's checkCheckingsBalance method
         double balance = atm.checkCheckingsBalance(account);
 
         // assert that the balance is equal to the expected value (100.0) with a tolerance of 0.01
         assertEquals(100, balance, 0.01);
     }
 
     @Test
public void testDepositToSavings() {
    // Create a new instance of the CentralBank class
    CentralBank bank = new CentralBank();
    
    // Create a new instance of the Customer class with name "Charlie" and email "c@gmail.com"
    Customer customer = new Customer("Charlie","c@gmail.com");
    
    // Create a new instance of the SavingsAccount class with account number 1, initial balance of 100.0,
    // the customer instance created earlier, and a password of "password"
    SavingsAccount savingsAccount = new SavingsAccount(1, 100.0, customer, "password");
    
    // Add the savings account to the bank
    bank.addSavingAccounts(savingsAccount);
    
    // Create a new instance of the ATM class with the bank instance created earlier
    ATM atm = new ATM(bank);
    
    // Deposit 500.00 to the savings account using the ATM instance created earlier
    atm.depositToSavings(savingsAccount, 500.00);
    
    // Check the balance of the savings account using the ATM instance created earlier and store it in the "balance" variable
    double balance = atm.checkSavingsBalance(savingsAccount);
    
    // Assert that the balance of the savings account is 600.00 with a delta of 0.01 (allowing for a small margin of error)
    assertEquals(600.00, balance, 0.01);
}

@Test
public void testDepositToCheckings() {
    // Create a new instance of the CentralBank class
    CentralBank bank = new CentralBank();
    
    // Create a new instance of the Customer class with name "Dave" and email "d@gmail.com"
    Customer customer = new Customer("Dave","d@gmail.com");
    
    // Create a new instance of the CheckingsAccount class with account number 1, initial balance of 100.0,
    // the customer instance created earlier, and a password of "password"
    CheckingsAccount account = new CheckingsAccount(1, 100.0, customer, "password");
    
    // Add the checkings account to the bank
    bank.addCheckingAccounts(account);
    
    // Create a new instance of the ATM class with the bank instance created earlier
    ATM atm = new ATM(bank);
    
    // Deposit 1000.00 to the checkings account using the ATM instance created earlier
    atm.depositToCheckings(account, 1000.00);
    
    // Check the balance of the checkings account using the ATM instance created earlier and store it in the "balance" variable
    double balance = atm.checkCheckingsBalance(account);
    
    // Assert that the balance of the checkings account is 1100.00 with a delta of 0.01 (allowing for a small margin of error)
    assertEquals(1100.00, balance, 0.01);
}

@Test
public void testSeeSavingsTransaction() {

    // Creating a new central bank instance
    CentralBank bank = new CentralBank();

    // Creating a new customer instance
    Customer customer = new Customer("Charlie", "c@gmail.com");

    // Creating a new savings account instance for the customer
    SavingsAccount savingsAccount = new SavingsAccount(1, 100.0, customer, "password");

    // Adding the savings account to the central bank
    bank.addSavingAccounts(savingsAccount);

    // Creating a new ATM instance with the central bank
    ATM atm = new ATM(bank);

    // Depositing 500.00 into the savings account using the ATM
    atm.depositToSavings(savingsAccount, 500.00);

    // Withdrawing 250.00 from the savings account using the ATM
    atm.withdrawFromSavings(savingsAccount, 250.00);

    // Retrieving the transaction history of the savings account using the ATM
    ArrayList<Double> transactionHistory = atm.seeSavingsTransaction(savingsAccount);

    // Asserting that the size of the transaction history is 2
    assertEquals(2, transactionHistory.size());

    // Asserting that the first transaction in the history is the deposit of 500.00
    assertEquals(500.00, transactionHistory.get(0), 0.01);

    // Asserting that the second transaction in the history is the withdrawal of 250.00
    assertEquals(-250.00, transactionHistory.get(1), 0.01);
}

// Test to check the transaction history of checkings account after deposit and withdrawal
@Test
public void testSeeCheckingsTransaction() {

    // Creating a new central bank instance
    CentralBank bank = new CentralBank();

    // Creating a new customer instance
    Customer customer = new Customer("Dave", "d@gmail.com");

    // Creating a new checkings account instance for the customer
    CheckingsAccount account = new CheckingsAccount(1, 100.0, customer, "password");

    // Adding the checkings account to the central bank
    bank.addCheckingAccounts(account);

    // Creating a new ATM instance with the central bank
    ATM atm = new ATM(bank);

    // Depositing 1000.00 into the checkings account using the ATM
    atm.depositToCheckings(account, 1000.00);

    // Withdrawing 500.00 from the checkings account using the ATM
    atm.withdrawFromCheckings(account, 500.00);

    // Retrieving the transaction history of the checkings account using the ATM
    ArrayList<Double> transactionHistory = atm.seeCheckingsTransaction(account);

    // Asserting that the size of the transaction history is 2
    assertEquals(2, transactionHistory.size());

    // Asserting that the first transaction in the history is the deposit of 1000.00
    assertEquals(1000.00, transactionHistory.get(0), 0.01);

    // Asserting that the second transaction in the history is the withdrawal of 500.00
    assertEquals(-500, transactionHistory.get(1), 0.01);
}
 }