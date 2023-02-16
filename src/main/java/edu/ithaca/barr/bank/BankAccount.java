package edu.ithaca.barr.bank;

public class BankAccount {

    private String email;
    private double balance;

    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public BankAccount(String email, double startingBalance){
        if (isEmailValid(email)){
            this.email = email;
            this.balance = startingBalance;
        }
        else {
            throw new IllegalArgumentException("Email address: " + email + " is invalid, cannot create account");
        }
    }

    public double getBalance(){
        return balance;
    }

    public String getEmail(){
        return email;
    }

    /**
     * @post reduces the balance by amount if amount is non-negative and smaller than balance
     */
    public void withdraw (double amount) throws InsufficientFundsException{
        if (amount <= balance){
            balance -= amount;
        }
        else {
            throw new InsufficientFundsException("Not enough money");
        }
    }


    /**
     * @param email
     * @return
     */
    public static boolean isEmailValid(String email){
        if(!Character.isLetterOrDigit(email.charAt(email.indexOf("@")-1))){
            return false;
        }

        int IndexATT=0;
        String prefix = email.substring(0, IndexATT);
        for (int p = 0; p < prefix.length(); p++) {
            char pre = prefix.charAt(p);
            if (!Character.isLetterOrDigit(pre) && pre != '-' && pre != '_' && pre != '.') {
                return false;
            }
        }
        if (email.length()<=5) return false;

        if (email.indexOf('@') == -1){
           
            return false;
        }
        
        
        else {
            return true;

        }
    
        
    
    }  
}