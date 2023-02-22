package edu.ithaca.barr.bank;
import java.util.ArrayList;
/* Class name: Account
   Methods: Deposit,Withdraw,Transfer,getAccNum,getCustomer,checkBalance,getTransactionHistory
   Name: Nardos Mamo
   Date: Feb 19, 2023
   */ 
public class Account {
    private int acct_num;
    private double balance;
    private Customer customer;
    private ArrayList<Double> transaction_history;

    public Account(int acct_num,double balance,Customer customer){
        this.acct_num = acct_num;
        this.balance = balance;
        this.customer = customer;
        this.transaction_history = new ArrayList<>();
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

    public static boolean isAmountValid(double amount){
        //String num = Double.toString(amount);
        
        if( amount <0){
            return false;
        }
        
        return true;    
    }

    public void deposit(double amount) {
        if(isAmountValid(amount)){
        balance += amount;
        transaction_history.add(amount);}
        else
        throw new IllegalArgumentException("Enter a positive integer with less than or equal to 2 decimal points");
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
    }

    public ArrayList<Double> getTransactionHistory() {
        return transaction_history;
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
}