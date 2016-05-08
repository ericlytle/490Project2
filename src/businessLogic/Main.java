/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

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
        
        //Simulation Set Up.
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
    }
}
