package edu.ithaca.barr.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class BankAccountTest {

    @Test
    void getBalanceTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals(200, bankAccount.getBalance(), 0.001);
    }

    @Test
    void withdrawTest() throws InsufficientFundsException{
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        bankAccount.withdraw(100);

        assertEquals(100, bankAccount.getBalance(), 0.001);
        assertThrows(InsufficientFundsException.class, () -> bankAccount.withdraw(300));
    }

    @Test
    void isEmailValidTest(){
        // valid email address - boundary case because it is the minimum number of accepted chars
        assertTrue(BankAccount.isEmailValid( "a@b.com")); 
        // empty string - equivalance case because it should not be an empty string  
        assertFalse( BankAccount.isEmailValid("")); 
        //all allowed characters - equivalance case, because it ensures letters, nums, and certain chars are allowed        
        assertTrue(BankAccount.isEmailValid("aZ1_0.9-d@z.net")); 
        //allowed character, but must be folllowed by a letter/number - equivalance case, because it ensures email fails in specific case
        assertFalse(BankAccount.isEmailValid("m_@r.com")); 
        //ensures numbers and dashes are allowed in the domain, and last part is over two characters - both boundary case and equivalance case- checks the length and specific case
        assertTrue(BankAccount.isEmailValid("jeff@b1-z.cc"));
        //just to check
        
    }

    @Test
    void constructorTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(200, bankAccount.getBalance(), 0.001);
        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));
    }

}