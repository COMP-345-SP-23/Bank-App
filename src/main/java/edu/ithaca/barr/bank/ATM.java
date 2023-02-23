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

    public double checkBalance(Account account) {
        return 0.0;
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

    @Override
    public boolean checkCredentials(String credentials) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkCredentials'");
    }
}


