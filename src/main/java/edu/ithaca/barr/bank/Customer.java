/*
 * Customer
 * Methods : getName,getEmail
 * Name : Simret Melak
 * Date :  2/21/2023
 */
package edu.ithaca.barr.bank;

public class Customer {

    private String name;
    private String email;
    
    public Customer( String name,String email){
        this.name = name;
        this.email= email;}

    public String getName(){
        return name;
    }
    
    public String getEmail(){
        return email;
    }
    
}