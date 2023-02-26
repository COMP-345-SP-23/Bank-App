/*
* CentralBank Class
 * Methods : SearchAccount,GetAccounts,AddAccounts,DeleteAccount
 * Name : Simret Melak
 * Date : 2/21/2023
 */
package edu.ithaca.barr.bank;

import java.util.ArrayList;

public class CentralBank {

    private ArrayList<Account> savingAccounts;
    private ArrayList<Account> checkingAccounts;
    private ArrayList<Account> allAccounts;

    //@CentralBank contains all the accounts in the Bank
    public CentralBank(){
        this.savingAccounts = new ArrayList<>();
        this.checkingAccounts = new ArrayList<>();
        this.allAccounts = new ArrayList<>();
    }

    //@SearchAccount searches an account given the account number and the list of all accounts in the Bank
    public static ArrayList<Account> searchAllAccount(int acc_num, ArrayList<Account> accounts){
        ArrayList<Account> result= null; 
        for(Account account : accounts ){
    
            if (account.getAcctNum() == acc_num){
            result.add(account);
            break;
            }
    }
    return result;
    }

    //@SearchSaving
    public static Account searchSavingAccount(int acc_num, ArrayList<Account> accounts){
        Account result= null; 
        for(Account account : accounts ){
    
            if (account.getAcctNum() == acc_num){
            result = account;
            System.out.println("found");
            break;
            }
    }
    return result;
    }

    public static Account searchCheckingAccount(int acc_num, ArrayList<Account> accounts){
        Account result= null; 
        for(Account account : accounts ){
    
            if (account.getAcctNum() == acc_num){
            result = account;
            System.out.println("found");
            break;
            }
    }
    return result;
    }


    //@getAccounts gets all accounts 
    public ArrayList<Account> getAllAccounts() {
        // Create a new ArrayList to hold the unique elements from savingAccounts and checkingAccounts
        ArrayList<Account> newAccounts = new ArrayList<>();
    
        // Add only the unique elements from savingAccounts to newAccounts
        savingAccounts.stream()
                .filter(account -> !allAccounts.contains(account))
                .forEach(newAccounts::add);
    
        // Add only the unique elements from checkingAccounts to newAccounts
        checkingAccounts.stream()
                .filter(account -> !allAccounts.contains(account))
                .forEach(newAccounts::add);
    
        // Add all the new unique accounts to allAccounts
        allAccounts.addAll(newAccounts);
    
        // Return allAccounts
        return allAccounts;
    }


    //@getAccounts gets all savings accounts 
    public ArrayList<Account> getSavingAccounts(){
        return savingAccounts;
    }

    //@getAccounts gets all checking accounts 
    public ArrayList<Account> getCheckingAccounts(){
        return checkingAccounts;
    }

    
    //@addAccount Adds accounts to the list of accounts in the bank
    public void addSavingAccounts(Account account){
        this.savingAccounts.add(account);
    }

    public void addCheckingAccounts(Account account){
        this.checkingAccounts.add(account);
    }
     //@deleteAccount Removes an account from the list of accounts after withdrawing all the money inside the account
     public void deleteAllAccount(Account account){
        allAccounts.removeIf(acc -> acc.getAcctNum()==account.getAcctNum());
        savingAccounts.removeIf(acc -> acc.getAcctNum()==account.getAcctNum());
        checkingAccounts.removeIf(acc -> acc.getAcctNum()==account.getAcctNum());
        
    }            
   
    }
