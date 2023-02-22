/*
* ATM_teller interface
 * Methods : checkBalance,Deposit,seeTransaction,withdraw,transfer
 * Name : Simret Melak
 * Date :  2/21/2023
 */
package edu.ithaca.barr.bank;

import java.util.ArrayList;

public class CentralBank {

    private ArrayList<Account> accounts;

    //@CentralBank contains all the accounts in the Bank
    public CentralBank(){
        
    }

    //@SearchAccount searches an account given the account number and the list of all accounts in the Bank
    public static Account searchAccount(int acc_num, ArrayList<Account> accounts){
      
        return null;
    }

    //@getAccounts gets an account from the list of accounts
    public ArrayList<Account> getAccounts(){
        return null;
       
    }

    //@addAccount Adds accounts to the list of accounts in the bank
    public void addAccounts(Account account){
        
    }
    //@deleteAccount Removes an account from the list of accounts
    public void deleteAccount(Account account){
      
    }
}
