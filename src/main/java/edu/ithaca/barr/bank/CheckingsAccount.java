package edu.ithaca.barr.bank;

import java.util.ArrayList;

/**
 * Class Name: CheckingsAccount
 * Methods: inherits methods from Account
 * Name: Vanessa Mpofu
 * Date: 23 Feb 2023
 */
public class CheckingsAccount extends Account {

    public CheckingsAccount(int acctNumIn,double balanceln,Customer customerln){
        super(acctNumIn, balanceln, customerln);
        // tell Nardos to change the Account attributes to protected
    }

    public static boolean isAmountValid(double amount){
        //TODO Auto-generated message 
        return false;
    }

    public void deposit(double amount){
        //TODO Auto-generated message 

    }

    public void withdraw(double amount){
        //TODO Auto-generated message 

    }

    public ArrayList<Double> getTransactionHistory(){
        //TODO Auto-generated message 
        return null;

    }

    public void transfer(Account acc2, double amount){
        //TODO Auto-generated message 

    }

    public int getAcctNum(){
        //TODO Auto-generated message 
        return -1;
    }
    public Customer getCustomer(){
        //TODO Auto-generated message 
        return null;

    }
    public double checkBalance() {
        //TODO Auto-generated message 
        return -1.0;
    }
    
}
