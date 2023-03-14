package edu.ithaca.barr.bank;

/*
* ATM
 * Methods : checkBalance,deposit,seeTransaction,withdraw,transfer
  * Name : Simret Melak
 * Date :  2/21/2023
 */



 import java.util.ArrayList;
 
 public class ATM implements ATM_teller{

     public  CentralBank bank;
     public Account current_account;


     public ATM(CentralBank bank) {
        this.bank = bank;
    }
  


 
    @Override
    public double checkSavingsBalance(SavingsAccount account) {
        return account.checkBalance();
    }

    @Override
    public double checkCheckingsBalance(CheckingsAccount account) {
        return account.checkBalance();
    }

    @Override
    public void depositToSavings(SavingsAccount account, double amount) {
    //Check if the account is frozen
    if(account.getFreeze()==true)
    {
       System.out.println("You can not deposit. This account is frozen");
       return;
    }
      //mark as suspicious account if more than 5000 is deposited
      if(amount > 5000)
      account.setSuspicious(true);
  account.deposit(amount);
  }


  @Override
  public void depositToCheckings(CheckingsAccount account, double amount) {
      //Check if the account is frozen
      if(account.getFreeze()==true)
           {
              System.out.println("You can not deposit. This account is frozen");
              return;
           }

      //mark as suspicious account if more than 5000 is deposited
      if(amount > 5000)
          account.setSuspicious(true);
      account.deposit(amount);
  }

    @Override
    public ArrayList<Double> seeSavingsTransaction(SavingsAccount account) {
        return account.getTransactionHistory();
    }

    @Override
    public ArrayList<Double> seeCheckingsTransaction(CheckingsAccount account) {
        return account.getTransactionHistory();
    }

    @Override
    public void withdrawFromSavings(SavingsAccount account, double amount) {

        if(account.getFreeze()==true)
             {
                System.out.println("You can not deposit. This account is frozen");
                return;
             }
        if(amount > 5000)
            account.setSuspicious(true);
    account.withdraw(amount);
    }

     @Override
    public void withdrawFromCheckings(CheckingsAccount account, double amount) {
        if(account.getFreeze()==true)
             {
                System.out.println("You can not deposit. This account is frozen");
                return;
             }
        if(amount > 5000)
            account.setSuspicious(true);

    account.withdraw(amount);
    }

    @Override
    public void transferChecking(CheckingsAccount accountSender, CheckingsAccount accountReciever, double amount) {
        withdrawFromCheckings(accountSender, amount);
        accountReciever.deposit(amount);
    }

    @Override
    public boolean authenticateUser(int accountNumber, String password) {
        for (Account account : bank.getCheckingAccounts()) {
            if (accountNumber == account.getAcctNum() && account.checkPassword(password)) {
                current_account = account;
                return true;
            }
        }
        return false;
    }
    @Override
    public void transferSavingtoChecking(SavingsAccount accountSender, CheckingsAccount accountReciever,
            double amount) {
        if(accountSender.getCustomer().equals(accountReciever.getCustomer()))
        {
            withdrawFromSavings(accountSender, amount);
            accountReciever.deposit(amount);
        }
        else
            throw new IllegalArgumentException("You can not transfer money from your savings account unless it is to your checkings Account");
                
    }
    
 }


