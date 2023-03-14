package edu.ithaca.barr.bank;
/**
 * Class Name: Administrator
 * Methods: checKOverallBalance, freezeAcc, unfreezeAcc, checkSuspiciousness
 * Name: Vanessa Mpofu
 * Date: 23 Feb 2023
 */
import java.util.ArrayList;

public class Administrator {
    public CentralBank bank;
    public Teller teller;
    
   
    private ArrayList<SavingsAccount> suspiciousSavingsAcc = new ArrayList<>();
    private ArrayList<CheckingsAccount> suspiciousCheckingsAcc = new ArrayList<>();

// Defining the constructor method for Administrator.
public Administrator(CentralBank bank) {
    this.bank = bank;
}

// Defining the method to get the overall balance of the bank.
public double getOverallBalance() {
    double overallBalance = bank.getOverallBalance();
    return overallBalance;
}

// Defining the method to freeze a checking account.
public void freezeCheckingAccount(int accNum) {
    for (int i = 0; i < bank.getCheckingAccounts().size(); i++) {
        // Checking if the account number matches and then freezing the account.
        if (bank.getCheckingAccounts().get(i).getAcctNum() == accNum) {
            bank.getCheckingAccounts().get(i).setFreeze(true);
        }
    }
}

// Defining the method to freeze a savings account.
public void freezeSavingAccount(int accNum) {
    for (int i = 0; i < bank.getSavingAccounts().size(); i++) {
        // Checking if the account number matches and then freezing the account.
        if (bank.getSavingAccounts().get(i).getAcctNum() == accNum) {
            bank.getSavingAccounts().get(i).setFreeze(true);
        }
    }
}

// Defining the method to unfreeze a checking account.
public void unfreezeCheckingAccount(int accNum) {
    for (int i = 0; i < bank.getCheckingAccounts().size(); i++) {
        // Checking if the account number matches and then unfreezing the account.
        if (bank.getCheckingAccounts().get(i).getAcctNum() == accNum) {
            bank.getCheckingAccounts().get(i).setFreeze(false);
        }
    }
}

// Defining the method to unfreeze a savings account.
public void unfreezeSavingAccount(int accNum) {
    for (int i = 0; i < bank.getSavingAccounts().size(); i++) {
        // Checking if the account number matches and then unfreezing the account.
        if (bank.getSavingAccounts().get(i).getAcctNum() == accNum) {
            bank.getSavingAccounts().get(i).setFreeze(false);
        }
    }
}

// Defining the method to get a list of all suspicious savings accounts.
public ArrayList<SavingsAccount> getSuspiciousSavings() {
    for (int i = 0; i < bank.getSavingAccounts().size(); i++) {
        // Checking if the account is suspicious and then adding it to the list of suspicious savings accounts.
        if (bank.getSavingAccounts().get(i).getSuspicious() == true) {
            suspiciousSavingsAcc.add(bank.getSavingAccounts().get(i));
        }
    }
    return suspiciousSavingsAcc;
}
// Defining the method to get a list of all suspicious checkings accounts.
public ArrayList<CheckingsAccount> getSuspiciousCheckings(){
    for(int i=0; i<bank.getCheckingAccounts().size();i++)
    {
         if(bank.getCheckingAccounts().get(i).getSuspicious()==true)
             suspiciousCheckingsAcc.add(bank.getCheckingAccounts().get(i));
    }
    return suspiciousCheckingsAcc;
 }
}
