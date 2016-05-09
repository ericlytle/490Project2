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
        //Next customers will request a movie that is not available.
        //Creation of rental object.
        Rental rental1 = new Rental(controller.findAvailableDVDByMovie(controller.findMovieByID(6)),Calendar.getInstance(),Rental.Status.Rented);
        System.out.println("System: Okay, Total Due: $2.00");
        System.out.println(cust1.getName() + ": Here is my money.");
        cust1.addRental(rental1);
        System.out.println("System: Thank you " + cust1.getName() + ", the rental is due on " + rental1.getReturnDate().getTime().toString());
        //controller.printMoviesAndStatus(results); //Uncomment this line to see the availability status change upon rental.
        System.out.println("***************************************************************");
               
        //Customer search for movie based on actor.
        Customer cust2 = controller.findCustomerByID(2);
        System.out.println("System: Hello " + cust2.getName() + "! What would you like to do?");
        System.out.println(cust2.getName() + ": Search for movies with actor, 'Jackie Chan' please.");
        System.out.println("\nSystem: Movies Matching Criteria: ");
        LinkedList<Movie> results2 = controller.findMoviesWithActor(new Actor("Jackie Chan",Actor.Gender.Male));
        controller.printMoviesAndStatus(results2);
        System.out.println("\n" + cust2.getName() + ": Rent 'Rush Hour'");
        System.out.println("System: Do you want the movie to be mailed or to pick up at the store?");
        System.out.println(cust2.getName() + ": Mail Rental");
        Rental RushHourRental = new Rental(controller.findAvailableDVDByMovie(controller.findMovieByID(2)),Calendar.getInstance(),Rental.Status.Rented);
        System.out.println("System: Okay, Total Due: $2.00");
        System.out.println(cust2.getName() + ": Here is my money.");
        cust2.addRental(RushHourRental);
        System.out.println("System: Thank you " + cust2.getName() + ", the rental is due on " + RushHourRental.getReturnDate().getTime().toString());
        //controller.printMoviesAndStatus(results2); //Uncomment this line to see the availability status change upon rental.
        System.out.println("***************************************************************");
        
        System.out.println("\nMaking A Request / Account Inquiry\n***************************************************");
        
        //Customer searches for movie based on genre and makes a request for an unavailable movie.
        Customer cust3 = controller.findCustomerByID(3);
        System.out.println("System: Hello " + cust3.getName() + "! What would you like to do?");
        System.out.println(cust3.getName() + ": Search for all movies with the genre 'Action' please.");
        System.out.println("\nSystem: Movies Matching Criteria: ");
        LinkedList<Movie> results3 = controller.findMoviesWithGenre(Movie.Genre.Action);
        controller.printMoviesAndStatus(results3);
        System.out.println("\n" + cust3.getName() + ": I see that Eraser is unavailable; I'd like to make a request to be on the wait list.");
        System.out.println("System: Absolutely, adding a request to your account.");
        Request KimboRequest = new Request(Calendar.getInstance(),Calendar.getInstance(), controller.findMovieByID(6));
        cust3.addRequest(KimboRequest);
        System.out.println("System: Request added, here are your current requests:");
        cust3.printRequests();
        System.out.println(cust3.getName() + ": That is all thank you.");
        System.out.println("***************************************************************");
        
        //Customer wants to see their rentals.
        //Add a few rentals to Kesha's account.
        Customer cust4 = controller.findCustomerByID(4);
        Rental rentalKesha1 = new Rental(controller.findAvailableDVDByMovie(controller.findMovieByID(7)), Calendar.getInstance(), Rental.Status.Rented);
        Rental rentalKesha2 = new Rental(controller.findAvailableDVDByMovie(controller.findMovieByID(8)), Calendar.getInstance(), Rental.Status.Returned);
        cust4.addRental(rentalKesha1);
        cust4.addRental(rentalKesha2);
        
        System.out.println("System: Hello " + cust4.getName() + "! What would you like to do?");
        System.out.println(cust4.getName() + ": View all my rentals please.\n");
        System.out.println("System: Your rentals:");
        cust4.printRentals();
        System.out.println("\n" + cust4.getName() + ": That is all thank you.");
        System.out.println("***************************************************************");
        
        //Returning Movies
        System.out.println("\n\nReturn Movie.");
        System.out.println("***************************************************************");
        
        //Scenario in which an employee checks in a movie that a customer turned in on time.
        //Customer 4 returns Shrek
        System.out.println("Hello Employee, what you like to do today?");
        System.out.println("Employee: A customer, Kesha, has returned their movie, Shrek, on time.");
        System.out.println("System: Provide the DVD ID.");
        System.out.println("Employee: Here it is: " + cust4.grabActiveRental().getDVD().getID());
        cust4.grabActiveRental().setStatus(Rental.Status.Returned);
        System.out.println("System: The DVD has been returned on time. There are no late fees.");
        System.out.println("System: Here are Kesha's current rentals: ");
        cust4.printRentals();
        
        System.out.println("\n\nHere is a quick view of the currently available and unavailable movies in the system:\n");
        controller.printMoviesAndStatus();
        System.out.println("***************************************************************");
        //Scenario in which an employee check in a movie that a customer turned in 3 days late.
        System.out.println("Hello Employee, what would you like to do today?");
        System.out.println("Employee: A customer, John Connor, has returned their movie, Eraser, 3 days late.");
        System.out.println("System: He was probably time travelling or something. Provide the DVD ID.");
        System.out.println("Employee: Here it is: " + cust1.grabActiveRental().getDVD().getID());
        cust1.grabActiveRental().setStatus(Rental.Status.Returned);
        System.out.println("System: 3 Days X $0.10 = $0.30 Late Fee");
        cust1.setLateCharges(cust1.getLateCharges() + 0.3);
        System.out.println("System: Late charges applied to " + cust1.getName() + "'s account.");
        System.out.println("System: Movie successfully returned.");
        
        System.out.println("\n\nHere is a quick view of the currently available and unavailable movies in the system:\n");
        controller.printMoviesAndStatus();
        System.out.println("***************************************************************");
        
        //Management Duty
        System.out.println("Management Scenario");
        System.out.println("System: Hello Manager, what would you like to do today?");
        System.out.println("Manager: The movie 'Jackie Chan's First Strike' hasn't been rented in 2 years. I no longer want to have it in the system.");
        System.out.println("System: Please enter the movie ID.");
        System.out.println("Manager: Here it is: " + 4);
        
        System.out.println("Successfully removed all copies of " + controller.findMovieByID(4).getName() + ".");
        
        controller.deleteMovie(controller.findMovieByID(4)); //Remove Movie and DVD's from the system.
        
        System.out.println("\n\nHere is a quick view of the currently available and unavailable movies in the system:\n");
        controller.printMoviesAndStatus();      
        
    }
}
