/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import java.util.Calendar;
import java.util.LinkedList;

/**
 *
 * @author Tamas
 */
public class Main {
    
    public static void main(String[] args)
    {
        /*Assumptions:
        Actors are unique, their name serves as their unique identifier.
        Keywords are unique, the name of the keyword is the identifer.
        Customers and Movies have unique IDs.
        A DVD's unique ID is the serial number (relative to the entire system).*/
       
        Controller controller = Controller.getInstance();
        Loader loader = new Loader();
        
        //Set up simulation.
        //Populate the inventory and display.
        loader.populateInventory(controller);   //Populate the system with DVDs
        loader.printAllMovies(controller);      //Output all unique movies
        System.out.println();
        loader.printAllDVDs(controller);        //Print out all copies of DVDs
        System.out.println();
        
        //Add users to the system.
        loader.populateCustomers(controller);
        loader.printCustomers(controller);
        System.out.println();
       
        //Begin simulation
        System.out.println("Begin Simulation **********************************");
        
        //Rent Movie
        System.out.println("Rent Movie\n***************************************************");
        
        //Customer searches for movie based on keyword.
        Customer cust1 = controller.findCustomerByID(1);
        System.out.println("System: Hello " + cust1.getName() + "! What would you like to do?");
        System.out.println(cust1.getName() + ": Search for movies based on keyword, 'Suspenseful' please.");
        System.out.println("\nSystem: Movies Matching Criteria: ");
        LinkedList<Movie> results = controller.findMoviesByKeyword(new Keyword("Suspenseful"));
        controller.printMoviesAndStatus(results);
        System.out.println("\n" + cust1.getName() + ": Rent 'Eraser'"); //ID of Movie Eraser is 6
        System.out.println("System: Do you want the movie to be mailed or to pick up at the store?");
        System.out.println(cust1.getName() + ": In Store Pickup");
        //Next customer will request a movie that is not available.
        //Creation of rental object.
        Rental rental1 = new Rental(controller.findAvailableDVDByMovie(controller.findMovieByID(6)),Calendar.getInstance(),Rental.Status.Rented);
        System.out.println("System: Okay, Total Due: $2.00");
        System.out.println(cust1.getName() + ": Here is my money.");
        cust1.addRental(rental1);
        System.out.println("System: Thank you " + cust1.getName() + ", the rental is due on " + rental1.getReturnDate().getTime().toString());
        System.out.println("***************************************************************");
        
        
    }
}
