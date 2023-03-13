package edu.ithaca.barr.bank;

import java.util.ArrayList;

/**
 * Class Name: CheckingsAccount
 * Methods: inherits methods from Account
 * Name: Vanessa Mpofu
 * Date: 23 Feb 2023
 */

public class CheckingsAccount extends Account {

    public CheckingsAccount(int acct_num, double balance, Customer customer, String password) {
        super(acct_num, balance, customer, password);
       
    }

    public  boolean isAmountValid(double amount){
        return super.isAmountValid(amount);
    }

    public void deposit(double amount){
        super.deposit(amount);
    }

    public void withdraw(double amount){
        super.withdraw(amount);
    }

    public ArrayList<Double> getTransactionHistory(){
        return super.getTransactionHistory();
        
    }

    public void transfer(Account acc2, double amount){
        super.transfer(acc2, amount);
    }

    public int getAcctNum(){
        return acct_num;
    }
    public Customer getCustomer(){
        return customer;

    }
    public double checkBalance() {
        return balance;
    }
    

    public int getTransactionCount() {
        return getTransactionCount();
    }

    public void checkSuspiciousNess(int acc_num) {
        
    }

    public void freezeAccount(){
        freezeAccount();
    }

    public void unfreezeAccount(){
       unfreezeAccount();

    }

    public boolean isFrozen() {
        return isFrozen();
    }

    public void depositToCheckings(double amount) {
    }
    
}