package edu.ithaca.barr.bank;

import java.util.ArrayList;

public class Teller implements ATM_teller{
    public CentralBank bank;
    private ArrayList<Account> suspicious_acc = new ArrayList<>();
    public void createSavingAccount(Customer customer, int acc_num){
        Account acc = new Account(acc_num,0.0,customer);
        bank.addSavingAccounts(acc); 
    }

    public void createCheckingAccount(Customer customer, int acc_num){
        Account acc = new Account(acc_num,0.0,customer);
        bank.addSavingAccounts(acc); 
    }

    public ArrayList<Account> getSuspiciousAccounts(){
        return suspicious_acc;
    }

   
    public double checkBalance(Account account) {
        return account.checkBalance();
    }
    
    public void deposit(Account account, double amount){
        if(amount > 5000)
            suspicious_acc.add(account);
        account.deposit(amount);
    }
 
    public ArrayList<Double> seeTransaction(Account account){
        return account.getTransactionHistory();
    }
       
    public void withdraw(Account account,double amount){
        if(amount > 5000)
            suspicious_acc.add(account);
        account.withdraw(amount);
    }

    public void transfer(Account accountSender, Account accountReciever, double amount){
        accountSender.transfer(accountReciever, amount);
    }

   public void deleteAccount(Account account){
        bank.deleteAllAccount(account);
   }
}
