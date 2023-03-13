package edu.ithaca.barr.bank;
import java.util.ArrayList;
/* Class name: Account
   Methods: Deposit,Withdraw,Transfer,getAccNum,getCustomer,checkBalance,getTransactionHistory
   Name: Nardos Mamo
   Date: Feb 19, 2023
   */ 
public class Account {
    protected int acct_num;
    protected double balance;
    protected Customer customer;
    private ArrayList<Double> transaction_history;
    private String password; 
    private boolean freeze;
    private boolean suspicious;
    

    public Account(int acct_num,double balance,Customer customer, String password){
        this.acct_num = acct_num;
        this.balance = balance;
        this.customer = customer;
        this.password = password;
        this.transaction_history = new ArrayList<>();
    }
    public void setFreeze(boolean freeze)
    {
        this.freeze = freeze;
    }

    public boolean getFreeze(){
        return freeze;
    }

    public int getAcctNum(){
        return acct_num;
    }
    public void setSuspicious(boolean suspicious)
    {
        this.suspicious = suspicious;
    }
    public boolean getSuspicious(){
        return suspicious;
    }

    public Customer getCustomer(){
        return customer;
    }
    public double checkBalance() {
        return balance;
    }

    public boolean isAmountValid(double amount){
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public static boolean isPasswordValid(String password){
       
        // for checking if password length
        // is between 8 and 15
        if (!((password.length() >= 8)
              && (password.length() <= 15))) {
            throw new IllegalArgumentException("Password length should be between 8 to 15 characters");
        }
  
        // to check space
        if (password.contains(" ")) {
            throw new IllegalArgumentException("Password cant have space");
        }
        if (true) {
            int count = 0;
  
            // check digits from 0 to 9
            for (int i = 0; i <= 9; i++) {
  
                // to convert int to string
                String str1 = Integer.toString(i);
  
                if (password.contains(str1)) {
                    count = 1;
                }
            }
            if (count == 0) {
                throw new IllegalArgumentException("Password should contain at least one digit(0-9)");
            }
        }
  
        // for special characters
        if (!(password.contains("@") || password.contains("#")
              || password.contains("!") || password.contains("~")
              || password.contains("$") || password.contains("%")
              || password.contains("^") || password.contains("&")
              || password.contains("*") || password.contains("(")
              || password.contains(")") || password.contains("-")
              || password.contains("+") || password.contains("/")
              || password.contains(":") || password.contains(".")
              || password.contains(", ") || password.contains("<")
              || password.contains(">") || password.contains("?")
              || password.contains("|"))) {
            throw new IllegalArgumentException("Password should contain at least one special character");
        }
  
        if (true) {
            int count = 0;
  
            // checking capital letters
            for (int i = 65; i <= 90; i++) {
  
                // type casting
                char c = (char)i;
  
                String str1 = Character.toString(c);
                if (password.contains(str1)) {
                    count = 1;
                }
            }
            if (count == 0) {
                throw new IllegalArgumentException("Password should contain at"
                + " least one uppercase letter(A-Z)");
            }
        }
  
        if (true) {
            int count = 0;
  
            // checking small letters
            for (int i = 90; i <= 122; i++) {
  
                // type casting
                char c = (char)i;
                String str1 = Character.toString(c);
  
                if (password.contains(str1)) {
                    count = 1;
                }
            }
            if (count == 0) {
                throw new IllegalArgumentException("Password should contain at least one lowercase letter(a-z)");
            }
        }
  
        // The password is valid
    
        return true;


    }
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

}