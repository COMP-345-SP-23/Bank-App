package edu.ithaca.barr.bank;
/**
 * Class Name: AdministratorTest
 * Methods: checKOverallBalance, freezeAcc, unfreezeAcc, checkSuspiciousness
 * Name: Vanessa Mpofu
 * Date: 23 Feb 2023
 */

/**
 * Edited
 * Class Name: AdministratorTest
 * Methods: getOverallBalance,freezeAccount,getSuspiciousAccount
 * Name: Simret Melak
 * Date: 3/13/2023
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AdministratorTest {
    CentralBank bank = new CentralBank();
    Teller teller = new Teller(bank);
    Administrator admin = new Administrator(bank);
    @Test
void testGetOverallBalance() {
    // Create a customer and add a savings and checking account to the bank
    Customer customer = new Customer("Charlie","c@gmail.com");
    bank.addSavingAccounts(new SavingsAccount(1, 100.0, customer, "password"));
    CheckingsAccount account = new CheckingsAccount(1, 100.0, customer, "password");
    bank.addCheckingAccounts(account);
    
    // Test that the overall balance is correctly calculated
    assertEquals(200.0, admin.getOverallBalance(), 0.01);
}

// Test the freezeCheckingAccount and unfreezeCheckingAccount methods of the Administrator class
@Test
void testFreezeCheckingAccount() {
    // Create two customers and checking accounts, and add them to the bank
    Customer customer = new Customer("Charlie","c@gmail.com");
    Customer customer1 = new Customer("at","c@gmail.com");
    CheckingsAccount acc1 = new CheckingsAccount(1, 100.0, customer, "password");
    CheckingsAccount acc2 = new CheckingsAccount(2, 100.0, customer1, "password");
    bank.addCheckingAccounts(acc1);
    bank.addCheckingAccounts(acc2);
    
    // Test that a frozen account throws an exception when a transaction is attempted
    admin.freezeCheckingAccount(acc1.getAcctNum());
    assertThrows(IllegalArgumentException.class, () -> {
        teller.depositToCheckings(acc1,200);
        throw new IllegalArgumentException("The account is frozen. Can not make any transaction");
    });
    
    // Test that a thawed account can be used for a transaction
    admin.unfreezeCheckingAccount(acc1.getAcctNum());
    teller.depositToCheckings(acc1,200);
    assertEquals(300, acc1.checkBalance());  
}

// Test the freezeSavingAccount and unfreezeSavingAccount methods of the Administrator class
@Test
void testFreezeSavingAccount() {
    // Create two customers and savings accounts, and add them to the bank
    Customer customer = new Customer("Charlie","c@gmail.com");
    Customer customer1 = new Customer("at","c@gmail.com");
    SavingsAccount acc1 = new SavingsAccount(1, 100.0, customer, "password");
    SavingsAccount acc2 = new SavingsAccount(2, 100.0, customer1, "password");
    bank.addSavingAccounts(acc1);
    bank.addSavingAccounts(acc2);
    
    // Test that a frozen account throws an exception when a transaction is attempted
    admin.freezeSavingAccount(acc1.getAcctNum());
    assertThrows(IllegalArgumentException.class, () -> {
        teller.depositToSavings(acc1,200);
        throw new IllegalArgumentException("The account is frozen. Can not make any transaction");
    });
    
    // Test that a thawed account can be used for a transaction
    admin.unfreezeSavingAccount(acc1.getAcctNum());
    teller.depositToSavings(acc1,200);
    assertEquals(300, acc1.checkBalance());
}
@Test
void testgetSuspiciousAccounts(){
Administrator admin = new Administrator(bank);
Customer customer = new Customer("Charlie","c@gmail.com");
Customer customer1 = new Customer("at","c@gmail.com");

// create two saving accounts
teller.createSavingAccount(customer1,"Nardos124()");
teller.createSavingAccount(customer,"Nardos124()");

// deposit a large amount to the first account
teller.depositToSavings(bank.getSavingAccounts().get(0), 8000);
teller.depositToSavings(bank.getSavingAccounts().get(1), 800);

// check if the first account is returned by the getSuspiciousSavings() method
assertEquals(bank.getSavingAccounts().get(0),admin.getSuspiciousSavings().get(0));
}
}