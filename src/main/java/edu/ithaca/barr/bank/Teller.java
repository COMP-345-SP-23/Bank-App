package edu.ithaca.barr.bank;

import java.util.ArrayList;

public class Teller implements ATM_teller{
    public CentralBank bank;
   
    public void createAccount(Customer customer, int acc_num){
        Account acc = new Account(acc_num,0.0,customer);
        bank.addAccounts(acc); 
    }

    public void deleteAccount(Account account){
        bank.deleteAccount(account);
    }

    public double checkBalance(Account account) {
        return account.checkBalance();
    }
    
    public void deposit(Account account, double amount){
        account.deposit(amount);
    }
 
    public ArrayList<Double> seeTransaction(Account account){
        return account.getTransactionHistory();
    }
       
    public void withdraw(Account account,double amount){
        account.withdraw(amount);
    }

    public void transfer(Account accountSender, Account accountReciever, double amount){
        accountSender.transfer(accountReciever, amount);
    }
}