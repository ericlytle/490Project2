/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import java.util.HashSet;
import java.util.Iterator;
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
    
    //Search for movie based on keyword
    public LinkedList<Movie> findMoviesByKeyword(Keyword keyword)
    {        
        LinkedList<Movie> results = new LinkedList<>();
        
        //Returns a list of movies
        for (Movie movie : getMovies())
        {
            if (movie.hasKeyword(keyword))
            {
                //System.out.println(movie.toString());
                results.add(movie);
            }
        }
        return results;
    }
    
    //Is the movie available for rental?
    public boolean isAvailable(Movie movie)
    {
        
        int numCopies = numberOfDVDsByMovie(movie);
        int numUnavailable = 0;
        for (Customer cust : customers)
        {
            for (Rental rental : cust.getRentals())
            {
                if (rental.getDVD().getMovie() == movie && rental.getStatus() == Rental.Status.Rented)
                {
                    numUnavailable += 1;
                }
            }
        }
        
        if (numCopies > numUnavailable)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    //Returns the number of DVD copies that a particular movie has by movie ID.
    public int numberOfDVDsByMovieID(long movieID)
    {
        int result = 0;
        for (DVD dvd : dvds)
        {
            if (dvd.getMovie().getID() == movieID)
            {
                result += 1;
            }
        }
        return result;
    }
    
    //Returns the number of DVD copies 
    public int numberOfDVDsByMovie(Movie movie)
    {
        int result = 0;
        for (DVD dvd : dvds)
        {
            if (dvd.getMovie() == movie)
            {
                result += 1;
            }
        }
        return result;
    }
    
   //Print all of the movies specified and whether or not they are available.
   public void printMoviesAndStatus(LinkedList<Movie> movies)
   {
       for (Movie mov : movies)
       {
           System.out.println(mov.toString() + " || Available: " + isAvailable(mov));
       }
   }
   
   //Print all of the movies specified and whether or not they are available.
   public void printMoviesAndStatus()
   {
       for (Movie mov : getMovies())
       {
           System.out.println(mov.toString() + " || Available: " + isAvailable(mov));
       }
   }
   
   //Returns the first SN of a DVD copy of a movie that is available.
   public long getDVDSNAvailable(Movie movie)
   {
       if (isAvailable(movie))
       {
           for (DVD dvd : dvds)
           {
               if (dvd.getMovie() == movie)
               {
                   return dvd.getID();
               }
           }
       }
       
       return -1; //Not available
   }
   
   //Returns a DVD object that is available to rent.
   public DVD findAvailableDVDByMovie(Movie movie)
   {
       long dvdID = getDVDSNAvailable(movie);
       return findDVDByID(dvdID);
   }
   
   //Find all movies containing an actor.
   public LinkedList<Movie> findMoviesWithActor(Actor actor)
   {
       LinkedList<Movie> movies = new LinkedList<>();
       
       for (Movie movie : getMovies())
       {
           for (Actor act : movie.getActors())
           {
               if (act.getName().equals(actor.getName()) && act.getGender() == actor.getGender())
               {
                   movies.add(movie);
               }
           }
       }
       
       return movies;
   }
   
   //Retrieve all of the unique actors in the system.
   public Set<Actor> getAllActors()
   {
       Set<Actor> results = new HashSet<>();
       
       for (DVD dvd : dvds)
       {
           for (Actor act : dvd.getMovie().getActors())
           {
               results.add(act);
           }
       }
       return results;
   }
   
   //Retrieve all of the unique keywords in the system.
   public Set<Keyword> getAllKeywords()
   {
       Set<Keyword> results = new HashSet<>();
       
       for (DVD dvd : dvds)
       {
           for (Keyword key : dvd.getMovie().getKeywords())
           {
               results.add(key);
           }
       }
       
       return results;
   }
   
   //Retrieve all of the movies that match the specified Genre.
   public LinkedList<Movie> findMoviesWithGenre(Movie.Genre genre)
   {
       LinkedList<Movie> results = new LinkedList<>();
       
       for (Movie movie : getMovies())
       {
           if (movie.getGenre() == genre)
           {
               results.add(movie);
           }
       }
       return results;
   }
   
   //Deletes all the copies of the movie from the system, as well as the movie.
   public void deleteMovie(Movie movie)
   {
       boolean allDVDsIn = true;
       
       for (Customer cust : customers)
       {
           for (Rental rent : cust.getRentals())
           {
               if (rent.getDVD().getMovie() == movie && rent.getStatus() != Rental.Status.Returned)
               {
                   allDVDsIn = false;
               }
           }
       }
       
       if (allDVDsIn == false)
       {
           System.out.println("Please wait until all copies of the DVD have been returned.");
       }
       
       if (allDVDsIn == true)
       {
           for (Iterator<DVD> it = dvds.iterator(); it.hasNext();)
           {
               DVD dvd = it.next();
               if (dvd.getMovie() == movie)
               {
                   it.remove();
               }
           }
       }      
   }
}
