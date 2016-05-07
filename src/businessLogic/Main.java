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
        
        //Run simulation here.
        //Create a collection of movies that the rental system has.
        //String Name, int Year, Rating Rating, Genre Genre, LinkedList<Keyword> Keywords, LinkedList<Actor> Actors
         Movie interstellar = new Movie("Interstellar", 2014, Movie.Rating.PG13, Movie.Genre.SciFi, null, null);
         interstellar.addActor(new Actor("Matthew McConaughey",Actor.Gender.Male));
         interstellar.addActor(new Actor("Anne Hathaway",Actor.Gender.Female));
         
         interstellar.addKeyword(new Keyword("Breathtaking"));
         interstellar.addKeyword(new Keyword("Space"));
         
         //Create a DVD copy of the movie Interstellar and add to rental system.
         controller.addDVD(new DVD(interstellar, 1));
         controller.addDVD(new DVD(interstellar, 2));
         
         //Print out movies in the rental system, not DVD copies.
         System.out.println("Movies In Rental System:");
         for (Movie movie : controller.getMovies())
         {
             System.out.println(movie.toString());
         }
         
         //Print out all DVD copies of all movies in the rental system.
         System.out.println("DVD Copies of All Movies:");         
         for (DVD dvd : controller.getDVDs())
         {
             System.out.println(dvd.toString());
         }     
                
    }
}
