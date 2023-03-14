package edu.ithaca.barr.bank;
import java.util.ArrayList;
import java.time.Duration;
import java.time.LocalDateTime;
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
    private boolean suspicious;
    private ArrayList<LocalDateTime> transactionTimes = new ArrayList<>();

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
        transactionTimes.add(LocalDateTime.now());
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
        transactionTimes.add(LocalDateTime.now());
        balance -= amount;
        transaction_history.add(-amount);
    }

//     public boolean checkSuspicion(){

//         LocalDateTime lastTransactionTime = transactionTimes.get(transactionTimes.size() - 1);
//         LocalDateTime secondLastTransactionTime = transactionTimes.get(transactionTimes.size() - 2);
//         LocalDateTime thirdLastTransactionTime = transactionTimes.get(transactionTimes.size() - 3);
//         Duration duration1 = Duration.between(thirdLastTransactionTime, secondLastTransactionTime);
//         Duration duration2 = Duration.between(secondLastTransactionTime, lastTransactionTime);
        
//    if (duration1.compareTo(Duration.ofHours(1)) <= 0 && duration2.compareTo(Duration.ofHours(1)) <= 0)
//        suspicious=true;
//    else
//        suspicious=false;

//        return suspicious;
//     }

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