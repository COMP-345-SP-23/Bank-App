package edu.ithaca.barr.bank;
import java.util.ArrayList;
/* Class name: Account
   Methods: Deposit,Withdraw,Transfer,getAccNum,getCustomer,checkBalance,getTransactionHistory
   Name: Nardos Mamo
   Date: Feb 19, 2023
   */ 
public class Account {
    protected int acctNum;
    protected double balance;
    protected Customer customer;
    protected int transactionCount;
    protected ArrayList<Double> transaction_history;
    private boolean isFrozen;

    public Account(int acctNumIn,double balanceln,Customer customerln){
        acctNum = acctNumIn;
        balance = balanceln;
        customer = customerln;
        transactionCount = 0;
        transaction_history = new ArrayList<>();
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

    public  boolean isAmountValid(double amount){
        //String num = Double.toString(amount);
        
        if( amount <0){
            return false;
        }
        
        return true;    
    }

    public void deposit(double amount) {
        if(isAmountValid(amount)){
            balance += amount;
            transaction_history.add(amount);
            transactionCount ++;
        }

        else{
            throw new IllegalArgumentException("Enter a positive integer with less than or equal to 2 decimal points");
    
        }
    }

    public void withdraw(double amount) {
        if (balance < amount) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        if(!isAmountValid(amount)){
            throw new IllegalArgumentException("Enter a positive integer with less than or equal to 2 decimal points");
        }

        balance -= amount;
        transaction_history.add(-amount);
        transactionCount ++;
    }

    public ArrayList<Double> getTransactionHistory() {
        return transaction_history;
    }

    public int getTransactionnCount(){
        return transactionCount;
    }

    public void transfer(Account acc2, double amount) {
        if (balance < amount) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        if(!isAmountValid(amount)){
            throw new IllegalArgumentException("Enter a positive integer with less than or equal to 2 decimal points");
        }

        withdraw(amount);
        acc2.deposit(amount);
    }

    public int getTransactionCount() {
        return transactionCount;
    }

    public void checkSuspiciousNess(int acc_num) {
        
    }

    public void freezeAccount(){
        isFrozen = true;
        System.out.println("Account is frozen");
    }

    public void unfreezeAccount(){
        isFrozen = false;
        //return false;
        System.out.println("Account is unfrozen");

    }

    public boolean isFrozen() {
        return isFrozen;
    }

}