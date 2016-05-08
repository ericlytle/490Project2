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
        Controller controller = Controller.getInstance();
        Loader loader = new Loader();
        
        //Run simulation here.
        loader.populateInventory(controller);   //Populate the system with DVDs
        loader.printAllMovies(controller);      //Output all unique movies
        loader.printAllDVDs(controller);        //Print out all copies of DVDs
    }
}
