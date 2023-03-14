/*ATM_teller interface
 * Methods : checkBalance,deposit,transaction,withdraw,transfer,authenticateUser
 * Name : Simret Melak
 * Date : 3/13/2023
 */
package edu.ithaca.barr.bank;

import java.util.ArrayList;
interface ATM_teller {

    public double checkSavingsBalance(SavingsAccount account);
    public double checkCheckingsBalance(CheckingsAccount account);
    public void depositToSavings(SavingsAccount account, double amount);
    public void depositToCheckings(CheckingsAccount account, double amount);
    public ArrayList<Double> seeSavingsTransaction(SavingsAccount account);
    public ArrayList<Double> seeCheckingsTransaction(CheckingsAccount account);
    public void withdrawFromSavings(SavingsAccount account,double amount);
    public void withdrawFromCheckings(CheckingsAccount account,double amount);
    public void transferChecking(CheckingsAccount accountSender, CheckingsAccount accountReciever, double amount);
    public void transferSavingtoChecking(SavingsAccount accountSender, CheckingsAccount accountReciever, double amount);
    public boolean authenticateUser(int accountNumber, String password);
}

