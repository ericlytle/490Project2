/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 *
 * @author Tamas
 */
public class Controller {
    
    private LinkedList<Customer> customers;
    
    private LinkedList<DVD> dvds;
    
    private static Controller instance = null;
    
    private Controller()
    {
        customers = new LinkedList<>();
        dvds = new LinkedList<>();
    }
    
    public static Controller getInstance()
    {
        if (instance == null)
        {
            return new Controller();
        }
        return instance;        
    }
    
    //Customer related.
    public void addCustomer(Customer customer)
    {
        this.customers.add(customer);
    }
    
    public void removeCustomer(Customer customer)
    {
        this.customers.remove(customer);
    }
    
    public LinkedList<Customer> getCustomers() {return customers;}
    
    //DVD related
    public void addDVD(DVD dvd) {this.dvds.add(dvd);}
    
    public void removeDVD(DVD dvd) {this.dvds.remove(dvd);}
    
       
    //Return a collection of unique movies.
    public Set<Movie> getMovies()
    {
        Set<Movie> movies = new HashSet<>();
        
        for (DVD dvd : dvds)
        {
            movies.add(dvd.getMovie());
        }
        
        return movies;        
    }
    
    //Return a collection of DVDs.
    public LinkedList<DVD> getDVDs(){return dvds;}
    
    //ID based searches
    //Find customer by ID
    public Customer findCustomerByID(long id)
    {
        for (Customer customer : customers)
        {
            if (customer.getID() == id)
            {
                return customer;
            }
        }
        return null;
    }
    
    //Find a movie by ID
    public Movie findMovieByID(long id)
    {
        for (Movie movie : getMovies())
        {
            if (movie.getID() == id)
            {
                return movie;
            }
        }
        return null;
    }
    
    //Find a DVD by ID
    public DVD findDVDByID(long id)
    {
        for (DVD dvd : dvds)
        {
            if (dvd.getID() == id)
            {
                return dvd;
            }
        }
        return null;
    }
    
    
}
