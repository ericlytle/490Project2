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
    public LinkedList<DVD> getDVDs()
    {
        return dvds;
    }
}
