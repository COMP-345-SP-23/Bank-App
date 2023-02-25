package edu.ithaca.barr.bank;

import java.util.ArrayList;

/**
 * Class Name: SavingsAccount
 * Methods: inherits methods from account
 * Name: Vanessa Mpofu
 * Date: 23 Feb 2023
 */
public class SavingsAccount extends Account{
    private double maxAmount;
    private double interestRate;

    public SavingsAccount(int acctNumIn,double balanceln,Customer customerln){
        super(acctNumIn, balanceln, customerln);
        maxAmount = 0.0;
        interestRate =0.0;
    }

    public  boolean isAmountValid(double amount){
        // TODO auto-generated message 
        return false;
    }


    public void deposit(double amount){
        // TODO auto-generated message

    }


    public void withdraw(double amount){
        // TODO auto-generated message 

    }


    public ArrayList<Double> getTransactionHistory(){
        // TODO auto-generated message 
        return null;

        
    }


    public void transfer(Account acc2, double amount){
        // TODO auto-generated message 

    }
    

    public void maxWithdrawal(double amount, double maxAmount){
        // TODO auto-generated message 
      
    }


    public double interestEarned( double interestRate){
        // TODO auto-generated message 
        return -1.0;
      
    }


    public int getAcctNum(){
        // TODO auto-generated message 
        return -1;
    }


    public Customer getCustomer(){
        // TODO auto-generated message 
        return null;

    }


    public double checkBalance() {
        // TODO auto-generated message
        return -1.0; 
    }
    
}
