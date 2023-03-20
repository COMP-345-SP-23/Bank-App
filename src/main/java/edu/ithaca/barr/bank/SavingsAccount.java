package edu.ithaca.barr.bank;

import java.util.ArrayList;

/**
 * Class Name: SavingsAccount
 * Methods: inherits methods from account, interestEarned method, maxWithdrawal method
 * Name: Vanessa Mpofu
 * Date: 23 Feb 2023
 */

 public class SavingsAccount extends Account{
    int maxAmount = 1000;
    double interestRate = 0.35;
    public SavingsAccount(int acct_num, double balance, Customer customer, String password) {
        super(acct_num, balance, customer, password);
     
    }
    public void maxWithdrawal(double amount){
        if( amount <= maxAmount){
            withdraw(amount);
        }

        else{
            throw new IllegalArgumentException("Cannot make a withdrawal that exceeds the maximum withdrawal amount");
        }
    }


    public double interestEarned( SavingsAccount account){
        double balanceAfterInterest = 0.0;
        if (account != null && account.checkBalance() != 0.0){          
            balanceAfterInterest = account.checkBalance() + account.checkBalance() * interestRate;    
        }
        return balanceAfterInterest;
    
}}