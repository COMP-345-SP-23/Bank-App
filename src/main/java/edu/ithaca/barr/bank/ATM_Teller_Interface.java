package edu.ithaca.barr.bank;

import java.util.ArrayList;
/* Class name: ATM_Teller_Interface
   Methods: Deposit,Withdraw,Transfer,checkBalance,getTransactionHistory, checkCredentials, createAccount, deleteAccount
   Name: Vanessa Mpofu
   Date: Feb 22, 2023
   */ 

public interface ATM_Teller_Interface {
    /**
     * deposit  money into the account
     */
    void deposit(Account account, double amount);

    
    /**
     * withdraws money from the account
     * @param amount
     */
    void withdraw(Account account,double amount);


    /**
     * returns an arraylist of transaction history
     * @return
     */
    ArrayList<Double> getTransactionHistory();

    /**
     * 
     * transfers money from 1 account to another
     * @param accountSender
     * @param accountReciever
     * @param amount
     */
    void transfer(Account accountSender, Account accountReciever, double amount);


    /**
     * checks the balance of an account
     * @param account
     * @return
     */
    double checkBalance(Account account);

    /**
     * verifies the correctness of the customer's credentials
     */
    boolean checkCredentials(String credentials);
    
}
