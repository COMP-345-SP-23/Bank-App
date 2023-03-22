[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-c66648af7eb3fe8bc4f294546bfd86ef473780cde1dea487d3c4ff354943c9ae.svg)](https://classroom.github.com/online_ide?assignment_repo_id=10008270&assignment_repo_type=AssignmentRepo)
# CS345 - Software Engineering at Ithaca College
## Project 01 - Bank Software

Names:
<< Nardos , Simret and Vanessa >>

Link to Requirements Document 
<<https://docs.google.com/document/d/1-pKehThNOm8TJwOM18VeIuC9TttF-Pmkahn2sR0sOQE/edit?usp=sharing>>

Link to UML Use Case Diagram:
<< https://drive.google.com/file/d/11aHQGEY17bDOg7T0jDhaxKtAm4KifwEo/view?usp=sharing >>

Link to UML Class Diagram:
<< https://drive.google.com/file/d/1fWRYX_ax9gVxKZg9EaLZayDz_JXwuUxA/view?usp=sharing>>

Link to UML Sequence Diagram:
<<https://drive.google.com/file/d/1XX2A5za30BVD2Bkkb4Lswd9_QAtnfRdZ/view?usp=sharing>>

Link to UML State Diagram:
<<https://drive.google.com/file/d/1YNfy2vFmPVUqkZpixCByOH0HazGp08v3/view?usp=sharing>>

Three Use Cases that you will implement first:
1. - ATM
2. - Teller
3. - Customer

Which classes & methods do you need to implement for these use cases?
(Indicated which team member is responsible for the implemenation)
1. -Account(Methods- Deposit,Withdraw,Transfer,getAccNum,getCustomer,checkBalance,getTransactionHistory,getPassword,checkPassword)(Nardos and Vanessa)

2. -SavingsAccount- implements from Account class and have additional methods (maxWithdrawal,interestEarned)(Nardos and Vanessa)

3. -CheckingsAccount - implements from Account class(Nardos and Vanessa)

4. -ATM_teller Interface(Methods-checkSavingsBalance,checkCheckingBalance,depositToSavings,depositToCheckings,seeSavingsTransaction,seeCheckingsTransaction,withdrawFromSavings,withdrawFromCheckings,trtransferChecking,transferSavingtoChecking,authenticateUser)(Simret)

5.-Teller - in addition to the methods in the interface the teller has createSavingAccount,createCheckingAccount,deleteSavingAccount,deleteCheckingAccount methods(Nardos)

6 -ATM - has all the methods in the ATM_teller interface(Simret)

7.- Customer(Methods- getName, getEmail)(Simret)

8.- CentralBank(Methods- searchSavingAccount,searchCheckingAccount,getSavingAccouts,getCheckingAccounts,addSavingAccounts,addCheckingAccounts,getOverallBalance)(Simret)

9.- Administrator(Methods- getOverallBalance,freezeCheckingAccount,freezeSavingAccount,unfreezeCheckingAccount,unfreezeSavingAccount,getSuspiciousSavings,getSuspiciousCheckings)(Simret and Vanessa)

10.-User Interface-(Nardos)

Don't forget to use Test-Driven Development (TDD)
1. Write Class and Method Function Headers
2. Write Tests
3. Implement Method Functions

Good Luck!

