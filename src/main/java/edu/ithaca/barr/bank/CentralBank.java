/*
* ATM_teller interface
 * Methods : SearchAccount,GetAccounts,AddAccounts,DeleteAccount
 * Name : Simret Melak
 * Date :  2/21/2023
 */
package edu.ithaca.barr.bank;

import java.util.ArrayList;

public class CentralBank {

    ArrayList<Account> accounts;

    //@CentralBank contains all the accounts in the Bank
    public CentralBank(){
        this.accounts = new ArrayList<>();
    }

    //@SearchAccount searches an account given the account number and the list of all accounts in the Bank
    public static Account searchAccount(int acc_num, ArrayList<Account> accounts){
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

    //@getAccounts gets an account from the list of accounts
    public ArrayList<Account> getAccounts(){
        return accounts;
    }

    //@addAccount Adds accounts to the list of accounts in the bank
    public void addAccounts(Account account){
        this.accounts.add(account);
    }
    //@deleteAccount Removes an account from the list of accounts
    public void deleteAccount(Account account){
        if(searchAccount(account.getAcctNum(),accounts).equals(account))
            accounts.remove(account);
        else
            System.out.println("The account does not exist");
    }

    // Vanessa added this method
    public Double checkOverallBalance() {
        double overallBalance = 0.0;
        for (Account account : accounts) {
            overallBalance += account.checkBalance();
        }
        return overallBalance;
    }

    // Vanessa added this method
    public void checkSuspiciousNess(int acc_num){
        Account account = accounts.get(acc_num);
        if(account  != null && account.getTransactionCount() > 5 ){
            System.out.println("Suspicious activity detected");
            
        }

    }

    

    
}
