/*Class: Teller
 * Methods: createAccount, deleteAccount, checkBalance, seeTransaction, Withdraw, transfer
 * Name: Nardos Mamo
 * Date: 2/23/23
 */
/*
 * Edited on: 3/13/2023
 */

package edu.ithaca.barr.bank;
import java.util.ArrayList;

public class Teller implements ATM_teller {
    public CentralBank bank;
    public Administrator admin = new Administrator(bank);
    int acc_num;
    Account current_account;

    public Teller(CentralBank bank) {
        this.bank = bank;
    }

    public void createSavingAccount(Customer customer,String password){
        acc_num = bank.getSavingAccounts().size()+1;

        SavingsAccount acc = new SavingsAccount(acc_num,0.0,customer,password);
        bank.addSavingAccounts(acc); 
        
    }

    public void createCheckingAccount(Customer customer,String password){
        acc_num = bank.getCheckingAccounts().size()+1;
        CheckingsAccount acc = new CheckingsAccount(acc_num,0.0,customer,password);
        bank.addCheckingAccounts(acc); 
    }

    @Override
    public double checkSavingsBalance(SavingsAccount account) {
        return account.checkBalance();
    }

    @Override
    public double checkCheckingsBalance(CheckingsAccount account) {
        return account.checkBalance();
    }

  
    @Override
    public void depositToSavings(SavingsAccount account, double amount) {
    //Check if the account is frozen
    if(account.getFreeze()==true)
    {
        throw new IllegalArgumentException("The account is frozen. Can not make any transaction");
    }
    //mark as suspicious account if more than 5000 is deposited
    if(amount > 5000)
        account.setSuspicious(true);
    account.deposit(amount);
    }

    @Override
    public void depositToCheckings(CheckingsAccount account, double amount) {
        //Check if the account is frozen
        if(account.getFreeze()==true)
             {
                throw new IllegalArgumentException("The account is frozen. Can not make any transaction");
               
             }

        //mark as suspicious account if more than 5000 is deposited
        if(amount > 5000)
            account.setSuspicious(true);
        account.deposit(amount);
    }

    @Override
    public ArrayList<Double> seeSavingsTransaction(SavingsAccount account) {
        return account.getTransactionHistory();
    }

    @Override
    public ArrayList<Double> seeCheckingsTransaction(CheckingsAccount account) {
        return account.getTransactionHistory();
    }

    @Override
    public void withdrawFromSavings(SavingsAccount account, double amount) {

        if(account.getFreeze()==true)
             {
                throw new IllegalArgumentException("The account is frozen. Can not make any transaction");
             }
        if(amount > 5000)
            account.setSuspicious(true);
    account.withdraw(amount);
    }

    @Override
    public void withdrawFromCheckings(CheckingsAccount account, double amount) {
        if(account.getFreeze()==true)
             {
                throw new IllegalArgumentException("The account is frozen. Can not make any transaction");
             }
        if(amount > 5000)
            account.setSuspicious(true);

    account.withdraw(amount);
    }

    @Override
    public void transferChecking(CheckingsAccount accountSender, CheckingsAccount accountReciever, double amount) {
        withdrawFromCheckings(accountSender, amount);
        accountReciever.deposit(amount);
    }

    
    public void deleteCheckingAccount(int acc_num){
        bank.getCheckingAccounts().removeIf(acc -> acc.getAcctNum()==acc_num);
         } 


    public void deleteSavingAccount(int acc_num){
        bank.getSavingAccounts().removeIf(acc -> acc.getAcctNum()==acc_num);
    }

    @Override
    public boolean authenticateUser(int accountNumber, String password) {
        for (Account account : bank.getCheckingAccounts()) {
            if (accountNumber == account.getAcctNum() && account.checkPassword(password)) {
                current_account = account;
                return true;
            }
        }
        return false;
    }

@Override
    public void transferSavingtoChecking(SavingsAccount accountSender, CheckingsAccount accountReciever,
            double amount) {
        if(accountSender.getCustomer().equals(accountReciever.getCustomer()))
        {
            withdrawFromSavings(accountSender, amount);
            accountReciever.deposit(amount);
        }
        else
            throw new IllegalArgumentException("You can not transfer money from your savings account unless it is to your checkings Account");
                
    }
    

    
}