package edu.ithaca.barr.bank;

import java.util.ArrayList;

/**
 * Class Name: SavingsAccount
 * Methods: inherits methods from account, interestEarned method, maxWithdrawal method
 * Name: Vanessa Mpofu
 * Date: 23 Feb 2023
 */
public class SavingsAccount extends Account{
    
    public SavingsAccount(int acctNumIn,double balanceln,Customer customerln){
        super(acctNumIn, balanceln, customerln);
        
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

    public void maxWithdrawal(double amount, double maxAmount){
        if( amount < maxAmount){
            withdraw(amount);
        }

        else{
            throw new IllegalArgumentException("Cannot make a withdrawal that exceeds the maximum withdrawal amount");
        }
    }


    public double interestEarned( SavingsAccount account, double interestRate){
        double balanceAfterInterest = 0.0;
        if (account != null && account.checkBalance() != 0.0){          
            balanceAfterInterest = account.checkBalance() + account.checkBalance() * interestRate;    
        }
        return balanceAfterInterest;
      
    }


    public int getAcctNum(){
        return acctNum;
    }


    public Customer getCustomer(){
        return customer;

    }


    public double checkBalance() {
        return balance;
    }

    public int getTransactionCount() {
        return transactionCount;
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
    

}
