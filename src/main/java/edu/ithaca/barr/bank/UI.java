
/*Class: Main Class
Name: Nardos Mamo
Date: 02/03/2023
*/
/*
 * Edited on 3/14/23
 */
package edu.ithaca.barr.bank;
import java.util.Scanner;

public class UI {
    public static void main(String[] args){
        CentralBank bank = new CentralBank();
        ATM atm = new ATM(bank);
        Teller teller = new Teller(bank);
        Administrator admin=new Administrator(bank);
        String adminPassword = "adminPassword";
        
        Scanner scnr = new Scanner(System.in);

        int choice;
       
        while(true){ // Run an infinite loop to continuously prompt user for input
            
            System.out.println("Welcome to the Central Bank system. Please select an option:");
            System.out.println("1. Log in ");
            System.out.println("2. Signup");
            System.out.println("3. Exit");

            System.out.println("4. Login as an administrator ");
                

       
            choice =scnr.nextInt();
            //choice for Atm and Teller
            switch (choice){
                case 1:
                System.out.println("Customer:");
                System.out.println("1. ATM");
                System.out.println("2. Teller");

                

                int atmORteller = scnr.nextInt();

                switch(atmORteller){
                    //Login in thorugh the ATM
                        case 1:
                        System.out.println("Enter account number");
                        int acc_num=scnr.nextInt();
                        System.out.println("Enter password");
                        String password=scnr.next();
                    
                        boolean isAuthenticated = atm.authenticateUser(acc_num, password);

                        while (!isAuthenticated) { // Restart loop if password doesn't match
                            System.out.println("Incorrect password. Please try again.");
                            System.out.println("Enter password");
                            password = scnr.next();
                            isAuthenticated = atm.authenticateUser(acc_num, password);
                        }
                           
                            System.out.println("Choose Account Type:");
                            System.out.println("1, Checking");
                            System.out.println("2, Saving");
                           
                           
                            
                        
                        choice=scnr.nextInt();

                        //Login into checking account through the ATM
                        switch (choice){
                            case 1:
                            System.out.println("Please choose:");
                            System.out.println("1.Withdraw");   
                            System.out.println("2.Transfer");   
                           System.out.println("3.Deposit");                  
                            System.out.println("4.View Balance");   
                            System.out.println("5.Transaction History");  
                            System.out.println("6. Exit");
                          int type=scnr.nextInt();

                          switch(type){
                            //Withdraw form checking account through the ATM
                            case 1: 
                         System.out.println("Please enter the amount to be withdrawn:");
                            double amount=scnr.nextDouble();
                          
                            try{
                            atm.withdrawFromCheckings(bank.searchCheckingAccount(acc_num), amount);
                            
                            System.out.println("Successfully Withdrawn!");
                        }
                            catch(IllegalArgumentException e)
                            { System.out.println("You can not withdraw. This account is frozen");}

                            catch(ArithmeticException e){
                                System.out.println("Insufficient balance");
                            }

                            break;
                        // transfer form checking account through the ATM
                            case 2:
                            System.out.println("Please enter the amount to be transferred:");
                            amount=scnr.nextDouble();
                            System.out.println("Enter account number to be transferred to:");
                            int account_num = scnr.nextInt();
                            atm.transferChecking(bank.searchCheckingAccount(acc_num), bank.searchCheckingAccount(account_num), amount);
                        
                            break;
                            //deposit form checking account through the ATM
                        case 3:
                        System.out.println("Please enter the amount to be deposited:");
                        amount=scnr.nextDouble();
                        try{
                        atm.depositToCheckings(bank.searchCheckingAccount(acc_num), amount);
                        System.out.println("Successfully Deposited!"); 
                    }catch(IllegalArgumentException e){
                        System.out.println("You can not deposit. This account is frozen");

                    }
                    
                        break;
                        //check balance form checking account through the ATM
                        case 4:
                        System.out.println("Current amount in account is:"+ atm.checkCheckingsBalance(bank.searchCheckingAccount(acc_num)));
                        break;
                        //See transaction form checking account through the ATM
                        case 5:

                        System.out.println("Here is the transaction for this account:" +atm.seeCheckingsTransaction(bank.searchCheckingAccount(acc_num)));
                        break;
                        //Exit form checking account through the ATM
                        case 6:

                        System.out.println("Thank you!");

                        default:

                        System.out.println("Please choose the correct option");
                       
                        break;

                          }
                          break;
                          //Login to the saving account through ATM
                          case 2:
                          System.out.println("Please choose:");
                            System.out.println("1.Withdraw");        
                           System.out.println("2.Deposit");                  
                            System.out.println("3.View Balance");   
                            System.out.println("4.Transaction History"); 
                            System.out.println("5.Transfer to checking"); 
                            System.out.println("6. Exit");
                         type=scnr.nextInt();
                         switch(type){
                            // Withdraw from the saving account through ATM
                         case 1: 
                         System.out.println("Please enter the amount to be withdrawn:");
                            double amount=scnr.nextDouble();
                          
                            try{
                            atm.withdrawFromSavings(bank.searchSavingAccount(acc_num), amount);
                            
                            System.out.println("Successfully Withdrawn!");
                        }
                            catch(IllegalArgumentException e)
                            { System.out.println("You can not withdraw. This account is frozen");}

                        catch(ArithmeticException e){
                        System.out.println("Insufficient balance");
                    }
                            break;
                            //deposit from the saving account though ATM
                            case 2:
                            System.out.println("Please enter the amount to be deposited:");
                            amount=scnr.nextDouble();
                            try{
                            atm.depositToSavings(bank.searchSavingAccount(acc_num), amount);
                            System.out.println("Successfully Deposited"); 
                        }catch(IllegalArgumentException e){
                            System.out.println("You can not deposit. This account is frozen");
    
                        }
                           
                            break;
                            //Check balance from the saving account though ATM
                            case 3:
                            System.out.println("Current amount in account is:"+ atm.checkSavingsBalance(bank.searchSavingAccount(acc_num)));
                            break;
                            //See transaction from the saving account though ATM
                            case 4:
                             System.out.println("Here is the transaction for this account:" +atm.seeSavingsTransaction(bank.searchSavingAccount(acc_num)));
                             break;
                             //transfer from saving to chcking account
                             case 5:
                             System.out.println("Enter your account number: ");
                             acc_num = scnr.nextInt();
       
                             System.out.println("Enter account number to be transferred to: ");
                             int account_num = scnr.nextInt();
       
                             System.out.println("Enter amount to be transferred: ");
                             amount = scnr.nextInt();
                             try{
                             atm.transferSavingtoChecking(bank.searchSavingAccount(acc_num),bank.searchCheckingAccount(account_num), amount);
                             //Exit from the saving account though ATM
                             
                             }catch(IllegalArgumentException e){
       
                             }
                             System.out.println("Successfully Transferred to Checking account");
                             break;
                             //Exit from the saving account though ATM
                             case 6:
                             System.out.println("Thank you!");
                             break;

                        default:
                        System.out.println("Please enter the corrrect choice");
                        break;

                    }
                          break;         
                    
                        }
                        break;
                       //Login through the Bank Teller
                        case 2:
                        System.out.println("Enter account number");
                        acc_num=scnr.nextInt();
                        System.out.println("Enter password");
                        password=scnr.next();
                        teller.authenticateUser(acc_num,password);

                        if (teller.authenticateUser(acc_num, password)==false){
                        System.out.println("Incorrect password/account number please Try again!");
                        }else{
                            System.out.println("Choose Account Type:");
                            System.out.println("1, Checking");
                            System.out.println("2, Saving");
                           
                        }


                      choice = scnr.nextInt();

                      switch(choice){

                        //Login into checking account through the Bank Teller
                 case 1:

                        System.out.println("Please choose:");
                        System.out.println("0. Delete account");
                            System.out.println("1.Withdraw");   
                            System.out.println("2.Transfer");   
                           System.out.println("3.Deposit");                  
                            System.out.println("4.View Balance");   
                            System.out.println("5.Transaction History"); 
                            System.out.println("6. Exit");

                         int type=scnr.nextInt();
                          switch(type){
                            //Delete Account
                    case  0: 
                    System.out.println("Could you confirm your account number:");
                    acc_num=scnr.nextInt();
                    teller.deleteSavingAccount(acc_num);

                    System.out.println("Account has been successfully deleted");
                    System.out.println("");
                   
                break;
                            //Withdraw form checking account through the Bank Teller
                            case 1:
                            System.out.println("Please enter the amount to be withdrawn:");
                            double amount=scnr.nextDouble();
                          
                            try{
                            teller.withdrawFromCheckings(bank.searchCheckingAccount(acc_num), amount);
                            
                            System.out.println("Successfully Withdrawn!");
                              }

                            catch(IllegalArgumentException e)
                            { System.out.println("You can not withdraw. This account is frozen");}

                            catch(ArithmeticException e){
                                System.out.println("Insufficient balance");
                            }
                            break;
                            // transfer form checking account through the Bank Teller
                            case 2:
                            System.out.println("Please enter the amount to be transferred:");
                            amount=scnr.nextDouble();
                            System.out.println("Enter account number to be transferred to:");
                            int account_num = scnr.nextInt();
                            teller.transferChecking(bank.searchCheckingAccount(acc_num), bank.searchCheckingAccount(account_num), amount);
                        
                            break;
                        //Deposit form checking account through the Bank Teller
                        case 3:
                        System.out.println("Please enter the amount to be deposited: ");
                        amount=scnr.nextDouble();
                        try{
                        teller.depositToCheckings(bank.searchCheckingAccount(acc_num), amount);
                        System.out.println("Successfully Deposited"); 
                        }catch(IllegalArgumentException e){
                        System.out.println("You can not deposit. This account is frozen");

                              }
                       catch(ArithmeticException e){
                          System.out.println("Insufficient balance");
                            }

                        break;
                        //Check balance form checking account through the Bank Teller
                        case 4:
                        System.out.println("Current amount in account is:"+ teller.checkCheckingsBalance(bank.searchCheckingAccount(acc_num)));
                        break;
                        //See transaction form checking account through the Bank Teller
                        case 5:
                        System.out.println("Here is the transaction for this account:" +teller.seeCheckingsTransaction(bank.searchCheckingAccount(acc_num)));
                        break;
                        // Exit form checking account through the Bank Teller
                        case 6:
                        System.out.println("Thank you !");
                              break;
                        default:

                        System.out.println("Please choose the correct option");
                       
                        break;

                          }
                         break;
                //Login into saving account through the Bank teller
             case 2:
                   System.out.println("Please choose:");
                   System.out.println("0.Delete account");
                   System.out.println("1.Withdraw");      
                  System.out.println("2.Deposit");                  
                   System.out.println("3.View Balance");   
                   System.out.println("4.Transaction History"); 
                   System.out.println("5.Transfer to checking");
                   System.out.println("6. Exit");

                type=scnr.nextInt();
                 switch(type){
                    //Delete Account
                    case  0: 
                        System.out.println("Could you confirm your account number:");
                        acc_num=scnr.nextInt();
                        teller.deleteSavingAccount(acc_num);
    
                        System.out.println("Account has been successfully deleted");
                        System.out.println("");
                       
                    break;
                    
                    //Withdraw form saving account through the Bank Teller
                    case 1:
                    System.out.println("Please enter the amount to be withdrawn:");
                    double amount=scnr.nextDouble();
                  
                    try{
                    teller.withdrawFromSavings(bank.searchSavingAccount(acc_num), amount);
                    
                    System.out.println("Successfully Withdrawn!");
                }
                    catch(IllegalArgumentException e)
                    { System.out.println("You can not withdraw. This account is frozen");}
                    catch(ArithmeticException e){
                        System.out.println("Insufficient balance");
                    }
                    break;
                    //deposit from the saving account though Bank Teller
                    case 2:
                    System.out.println("Please enter the amount to be deposited:");
                    amount=scnr.nextDouble();
                    try{
                    teller.depositToSavings(bank.searchSavingAccount(acc_num), amount);
                    System.out.println("Successfully Deposited"); 
                    }catch(IllegalArgumentException e){
                    System.out.println("You can not deposit. This account is frozen");

                    }
                    break;
                     //Check balance from the saving account though ATM
                     case 3:
                     System.out.println("Current amount in account is:"+ teller.checkSavingsBalance(bank.searchSavingAccount(acc_num)));
                     break;
                     //See transaction from the saving account though ATM
                     case 4:
                      System.out.println("Here is the transaction for this account:" +teller.seeSavingsTransaction(bank.searchSavingAccount(acc_num)));
                      break;
                      //transfer to your checking account
                      case 5:
                      System.out.println("Enter your account number: ");
                      acc_num = scnr.nextInt();

                      System.out.println("Enter account number to be transferred to: ");
                      int account_num = scnr.nextInt();

                      System.out.println("Enter amount to be transferred: ");
                      amount = scnr.nextInt();
                      try{
                      teller.transferSavingtoChecking(bank.searchSavingAccount(acc_num),bank.searchCheckingAccount(account_num), amount);
                      //Exit from the saving account though ATM
                      
                      }catch(IllegalArgumentException e){

                      }
                      System.out.println("Successfully Transferred to Checking account");
                      break;

                      case 6:
                      System.out.println("Thank you!");

                      break;

                      default:
                      System.out.println("Please choose the correct option");
                       
                     break;

                        }
                        break;
                    }
                    break;
                }
                break;
                        
        case 2:
                    
                    System.out.println("Do you want to create:");
                    System.out.println("1. Checking ");
                    System.out.println("2. Saving ");

                    choice= scnr.nextInt();
                    switch(choice){
                     case 1:
                     System.out.println("Enter name:");
                    String name =scnr.next();
                      System.out.println("Enter email address:");
                      String email= scnr.next();
                      
                     System.out.println("Create password:");
                  String password = scnr.next();
                      
                    
                     Customer Checkingcustomer = new Customer(name,email);
                 try{
                     teller.createCheckingAccount(Checkingcustomer, password);
                 
                     System.out.println("Your Account number is: "+bank.getCheckingAccounts().get (bank.getCheckingAccounts().size()-1).getAcctNum());

                     System.out.println("Checking account successfully created!");
                 }
                 catch(IllegalArgumentException e){
                System.out.println("Password should not contain any space.");
 
                System.out.println("Password should contain at least one digit(0-9).");
 
                System.out.println("Password length should be between 8 to 15 characters."); 
 
                System.out.println("Password should contain at least one lowercase letter(a-z).");
 
                System.out.println("Password should contain at least one uppercase letter(A-Z). ");
 
                System.out.println("Password should contain at least one special character ( @, #, %, &, !, $, etc…).");
                 }

                    
        break;

        case 2 :
        System.out.println("Enter name:");
                   name =scnr.next();
                      System.out.println("Enter email address:");
                       email= scnr.next();
                      
                     System.out.println("Create password:");
                  password = scnr.next();
                    
                     Customer Savingcustomer = new Customer(name,email);
                 
                     teller.createSavingAccount(Savingcustomer, password);
                     System.out.println("Your Account number is: "+bank.getSavingAccounts().get (bank.getSavingAccounts().size()-1).getAcctNum());

                     System.out.println("Saving account successfully created!");
                    

               break;
                }
                break;


case 3:
System.out.println("Thank you for using the Central Bank system.");
System.exit(0); // Exit the program
            
            break;

case 4:
System.out.println("Enter administrator password:");
String adminPassword1=scnr.next();
if(!adminPassword1.equals(adminPassword) ){
    System.out.println("Incorrect Password. Try again!");
}
else{
 System.out.println("Choose option: ");
 System.out.println("1.Freeze Account");
 System.out.println("2.Unfreeze Account");
 System.out.println("3.Get Suspicious");
}
choice=scnr.nextInt();
switch(choice){
    //freeze account
    case 1:
    System.out.println("Choose option:");
    System.out.println("1. Checking Account");
    System.out.println("2. Saving Account");

    choice=scnr.nextInt();
    switch (choice){
        case 1:
        System.out.println("Enter checking account number:");
        int acct_num =scnr.nextInt();
        admin.freezeCheckingAccount(acct_num);
        break;
          case 2:
          System.out.println("Enter saving account number:");
          acct_num =scnr.nextInt();
          admin.freezeSavingAccount(acct_num);
          break;
    }

break;
//unfreeze account
case 2:
System.out.println("Choose option:");
    System.out.println("1. Checking Account");
    System.out.println("2. Saving Account");

    choice=scnr.nextInt();
    switch (choice){
        case 1:
        System.out.println("Enter checking account number:");
        int acct_num =scnr.nextInt();
        admin.unfreezeCheckingAccount(acct_num);
        break;
          case 2: 
          System.out.println("Enter saving account number:");
          acct_num =scnr.nextInt();
          admin.unfreezeCheckingAccount(acct_num);
          break;
    }
    break;
//Get suspicious account
    case 3:
    System.out.println("Choose option:");
    System.out.println("1. Checking Account");
    System.out.println("2. Saving Account");

    choice=scnr.nextInt();
    switch (choice){
        case 1:
        
        System.out.println("Here are the Suspicious checking accounts");
        admin.getSuspiciousCheckings();

        break;

          case 2: 
        System.out.println("Here are the Suspicious saving accounts");
        admin.getSuspiciousSavings();

          break;
    }
    break;

}



break;
        default:
            System.out.println("Invalid option. Please try again.");
            break;
                    }    
}
}}
  

