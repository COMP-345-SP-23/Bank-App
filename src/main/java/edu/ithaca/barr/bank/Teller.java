/*Class: Teller
 * Methods: createAccount, deleteAccount, checkBalance, seeTransaction, Withdraw, transfer
 * Name: Nardos Mamo
 * Date: 2/23/23
 */
package edu.ithaca.barr.bank;

import java.util.ArrayList;

public class Teller implements ATM_teller{
    public CentralBank bank;
    private ArrayList<Account> suspicious_acc = new ArrayList<>();
    public void createSavingAccount(Customer customer, int acc_num){
        bank.addAccounts(acc); 
    }
//Delete Account 
    public void deleteAccount(Account account){
        bank.deleteAccount(account);
    }
//Check Balance in the account
    public double checkBalance(Account account) {
        return account.checkBalance();
    }
//Deposits the amount of money passes in the account that is passed   
    public void deposit(Account account, double amount){
        account.deposit(amount);
    }
 //returns the transaction history od the account
    public ArrayList<Double> seeTransaction(Account account){
        return account.getTransactionHistory();
    }
    //withdraws the amount of money passed   
    public void withdraw(Account account,double amount){
        account.withdraw(amount);
    }
//transfers money from one account to another
    public void transfer(Account accountSender, Account accountReciever, double amount){
        accountSender.transfer(accountReciever, amount);
    }
}

