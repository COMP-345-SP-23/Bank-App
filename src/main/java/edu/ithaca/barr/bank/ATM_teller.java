/*ATM_teller interface
 * Methods : checkBalance,Deposit,seeTransaction,withdraw,transfer
 * Name : Simret Melak
 * Date : 
 */
package edu.ithaca.barr.bank;
import java.util.ArrayList;
interface ATM_teller {

    public double checkBalance(Account account);
    public void deposit(Account account, double amount);
    public ArrayList<Double> seeTransaction(Account account);
    public void withdraw(Account account,double amount);
    public void transfer(Account accountSender, Account accountReciever, double amount);

}
