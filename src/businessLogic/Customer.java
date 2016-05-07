/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import java.util.LinkedList;

/**
 *
 * @author Eric
 */
public class Customer {
    private String email;
    private String address;
    private String phone;
    private String password;
    private String name;
    
    private long id;
    
    private LinkedList<Rental> rentals;
    private LinkedList<Request> requests;
    
    public Customer(String Email, String Address, String Phone, String Password, String Name){
        this.email = Email;
        this.address = Address;
        this.phone = Phone;
        this.password = Password; //maybe encrypt??
        this.name = Name;
    }
   
    public void setID(long id) {this.id= id;}
    public long getID(){return id;}
    
}