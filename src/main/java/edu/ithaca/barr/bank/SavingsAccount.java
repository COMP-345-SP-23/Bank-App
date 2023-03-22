package edu.ithaca.barr.bank;

import java.util.ArrayList;

/**
 * Class Name: SavingsAccount
 * Methods: inherits methods from account, interestEarned method, maxWithdrawal method
 * Name: Vanessa Mpofu
 * Date: 23 Feb 2023
 */
/*
 * Edited on 17 March 2023
 * Name: Nardos Mamo
 */
 public class SavingsAccount extends Account{
    public SavingsAccount(int acct_num, double balance, Customer customer, String password) {
        super(acct_num, balance, customer, password);
     
    }

    int maxAmount = 1000;
    double interestRate = 0.10;
    
    @Override
    public void withdraw(double amount){
        if (balance < amount) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        if(!isAmountValid(amount)){
            throw new IllegalArgumentException("Enter a positive integer with less than or equal to 2 decimal points");
        }
        if(amount > maxAmount){
            throw new IllegalArgumentException("Cannot make a withdrawal that exceeds the maximum withdrawal amount");
        }
        balance -= amount;
        transaction_history.add(-amount);
        
    }


    public double interestEarned( SavingsAccount account){
        double balanceAfterInterest = 0.0;
        if (account != null && account.checkBalance() != 0.0){          
            balanceAfterInterest = account.checkBalance() + account.checkBalance() * interestRate;    
        }
        return balanceAfterInterest;
      
    }
    

}