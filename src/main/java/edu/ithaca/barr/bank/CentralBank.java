/*
* CentralBank Class
 * Methods : SearchAccount,GetAccounts,AddAccounts,DeleteAccount
 * Name : Simret Melak
 * Date : 2/21/2023
 */
package edu.ithaca.barr.bank;

import java.util.ArrayList;

public class CentralBank {

    private ArrayList<SavingsAccount> savingAccounts;
    private ArrayList<CheckingsAccount> checkingAccounts;
   

    //@CentralBank contains all the accounts in the Bank
    public CentralBank(){
        this.savingAccounts = new ArrayList<>();
        this.checkingAccounts = new ArrayList<>();
        
    }



    //@SearchSavingAccounts returns the account wheh    
    public SavingsAccount searchSavingAccount(int acc_num){
        SavingsAccount result= null; 
        for(SavingsAccount account : savingAccounts ){
            if (account.getAcctNum() == acc_num){
            result = account;
            break;
            }
    }
    return result;
    }

    public CheckingsAccount searchCheckingAccount(int acc_num){
        CheckingsAccount result= null; 
        for(CheckingsAccount account : checkingAccounts ){
    
            if (account.getAcctNum() == acc_num){
            result = account;
            break;
            }
    }
    return result;
    }




    //@getAccounts gets all savings accounts 
    public ArrayList<SavingsAccount> getSavingAccounts(){
        return savingAccounts;
    }

    //@getAccounts gets all checking accounts 
    public ArrayList<CheckingsAccount> getCheckingAccounts(){
        return checkingAccounts;
    }

    
    //@addAccount Adds accounts to the list of accounts in the bank
    public void addSavingAccounts(SavingsAccount account){
        this.savingAccounts.add(account);
    }

    public void addCheckingAccounts(CheckingsAccount account){
        this.checkingAccounts.add(account);
    }
   
    
    public double getOverallBalance(){
        double overallBalance=0.0;
        for(int i=0 ; i < getCheckingAccounts().size();i++){
            overallBalance = overallBalance + getCheckingAccounts().get(i).balance;
        }
        for(int i=0 ; i < getSavingAccounts().size();i++){
            overallBalance = overallBalance + getSavingAccounts().get(i).balance;
        }

        return overallBalance;
    }
   
    }
    
