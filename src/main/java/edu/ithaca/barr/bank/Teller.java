package edu.ithaca.barr.bank;

import java.util.ArrayList;

public class Teller implements ATM_teller{
    public CentralBank bank;
   
    public void createAccount(Customer customer, int acc_num){
       
    }

    public void deleteAccount(Account account){
    
    }

    public double checkBalance(Account account) {
        return 0;
        
    }
    
    public void deposit(Account account, double amount){
        
    }
 
    public ArrayList<Double> seeTransaction(Account account){
        return null;
       
    }
       
    public void withdraw(Account account,double amount){
      
    }

    public void transfer(Account accountSender, Account accountReciever, double amount){
        
    }
}