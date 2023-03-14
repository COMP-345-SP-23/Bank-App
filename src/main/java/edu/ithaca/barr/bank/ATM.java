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
 //@checkBalance returns the balance of the account passed to it
     public double checkBalance(Account account) {
         return account.checkBalance();
     }


 //@deposit deposits the amount of money passed in the account that is passed    
     public void deposit(Account account, double amount){
        if(amount > 5000)
            suspicious_acc.add(account);
         account.deposit(amount);
     }


  //@seeTransaction returns the transaction history of the account passed
     public ArrayList<Double> seeTransaction(Account account){
         return account.getTransactionHistory();
     }
        

  //@withdraw withdraws the amount of money passed from the account passed to it
     public void withdraw(Account account,double amount){
        if(amount > 5000)
            suspicious_acc.add(account);
         account.withdraw(amount);
     }
 
 //@transfer transfers the amount of money passed form one account to another
     public void transfer(Account accountSender, Account accountReciever, double amount){
         accountSender.transfer(accountReciever, amount);
     }
 

    @Override
    public boolean checkCredentials(String credentials) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkCredentials'");
    }
}


