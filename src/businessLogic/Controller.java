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
public class Controller {
    
    private LinkedList<Customer> customers;
    
    private static Controller instance = null;
    
    private Controller(){}
    
    public static Controller getInstance()
    {
        if (instance == null)
        {
            return new Controller();
        }
        return instance;        
    }  
    
}
