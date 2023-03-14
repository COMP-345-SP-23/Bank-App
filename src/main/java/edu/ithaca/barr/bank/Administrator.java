package edu.ithaca.barr.bank;
import java.util.ArrayList;

public class Administrator {
    public CentralBank bank;
    public Teller teller;
    public ATM atm;

    private ArrayList<Account> suspicious_acc = new ArrayList<>();

    public ArrayList<Account> getSuspiciousAccounts(){
        suspicious_acc.addAll(teller.getSuspiciousAccounts());
        suspicious_acc.addAll(atm.getSuspiciousAccounts());
        return suspicious_acc;
    }
    public double checkOverallBalance(){
        // TODO Auto-generated method stub
        return -1.0;
    }

    public boolean freezeAccount(int accNum){
        // TODO Auto-generated method stub
        return false;
    }

    public boolean unfreezeAccount(int accNum){
        // TODO Auto-generated method stub
        return false;
    }

 


}

