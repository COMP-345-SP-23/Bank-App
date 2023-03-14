/*
* ATM
 * Methods : checkBalance,deposit,seeTransaction,withdraw,transfer
  * Name : Simret Melak
 * Date :  2/21/2023
 */

 package edu.ithaca.barr.bank;

 import java.util.ArrayList;
 
 public class ATM implements ATM_Teller_Interface{
     public CentralBank bank;
     private ArrayList<Account> suspicious_acc = new ArrayList<>();
     public double checkBalance(Account account) {
         return account.checkBalance();
     }

     public ArrayList<Account> getSuspiciousAccounts(){
        return suspicious_acc;
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
 

    @Override
    public boolean checkCredentials(String credentials) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkCredentials'");
    }
}


