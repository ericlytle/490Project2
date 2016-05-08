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
    
    public Customer(String Email, String Address, String Phone, String Password, String Name,long id){
        this.email = Email;
        this.address = Address;
        this.phone = Phone;
        this.password = Password;
        this.name = Name;
        this.id = id;
        this.rentals = new LinkedList<>();
        this.requests = new LinkedList<>();
    }
    
    @Override
    public String toString()
    {
        return "Name: " + name + " ID: " + id + " Email: " + email + " Phone #: " + phone + " Address: " + address + " Password: " + password;
    }
   
    public void setID(long id) {this.id= id;}
    public long getID(){return id;}
    
    public String getName() {return name;}
    
    public LinkedList<Rental> getRentals() {return rentals;}
    
    public LinkedList<Request> getRequests() {return requests;}
    
    public void addRental(Rental rental) {this.rentals.add(rental);}
    
    public void addRequest(Request request) {this.requests.add(request);}
    
    public void printRequests()
    {
        for (Request request : requests)
        {
            System.out.println(request.toString());
        }
    }
    
    public void printRentals()
    {
        for (Rental rental : rentals)
        {
            System.out.println(rental.toString());
        }
    }
    
}