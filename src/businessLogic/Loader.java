/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

/**
 *
 * @author Tamas
 */
public class Loader {
    
    //Method for adding DVDs and movies to the rental system.
    public void populateInventory(Controller controller)
    {
        //Interstellar!!!
        Movie Interstellar = new Movie("Interstellar", 2014, Movie.Rating.PG13, Movie.Genre.SciFi, null, null);
        Interstellar.addActor(new Actor("Matthew McConaughey",Actor.Gender.Male));
        Interstellar.addActor(new Actor("Anne Hathaway",Actor.Gender.Female));
        Interstellar.addKeyword(new Keyword("Breathtaking"));
        Interstellar.addKeyword(new Keyword("Space"));
        
        //Rush Hour
        Movie RushHour = new Movie("Rush Hour", 1998, Movie.Rating.PG13, Movie.Genre.Comedy, null, null);
        RushHour.addActor(new Actor("Jackie Chan", Actor.Gender.Male));
        RushHour.addActor(new Actor("Chris Tucker", Actor.Gender.Male));
        RushHour.addKeyword(new Keyword("Hilarious"));
        RushHour.addKeyword(new Keyword("Crime"));
        
        //Star Wars: The Force Awakens
        Movie StarWars7 = new Movie("Star Wars: The Force Awakens", 2015, Movie.Rating.PG13, Movie.Genre.SciFi, null, null);
        StarWars7.addActor(new Actor("Daisy Ridley", Actor.Gender.Female));
        StarWars7.addActor(new Actor("Mark Hamill",Actor.Gender.Male));
        StarWars7.addKeyword(new Keyword("Space"));
        StarWars7.addKeyword(new Keyword("Future"));
        
        //Jackie Chan's First Strike
        Movie JCFS = new Movie("Jackie Chan's First Strike", 1996, Movie.Rating.PG13, Movie.Genre.Action, null, null);
        JCFS.addActor(new Actor("Jackie Chan", Actor.Gender.Male));
        JCFS.addKeyword(new Keyword("Fun"));
        JCFS.addKeyword(new Keyword("Foreign"));
        
        //The Mummy
        Movie TheMummy = new Movie("The Mummy", 1999, Movie.Rating.PG13, Movie.Genre.Action, null, null);
        TheMummy.addActor(new Actor("Brendan Frasier", Actor.Gender.Male));
        TheMummy.addActor(new Actor("Rachel Weisz", Actor.Gender.Female));
        TheMummy.addKeyword(new Keyword("Adventure"));
        TheMummy.addKeyword(new Keyword("Egypt"));
        
        //Eraser
        Movie Eraser = new Movie("Eraser", 1996, Movie.Rating.R, Movie.Genre.Action, null, null);
        Eraser.addActor(new Actor("Arnold Schwarzenegger", Actor.Gender.Male));
        Eraser.addActor(new Actor("Vanessa Williams", Actor.Gender.Female));
        Eraser.addKeyword(new Keyword("Explosive"));
        Eraser.addKeyword(new Keyword("Intense"));
        Eraser.addKeyword(new Keyword("Suspenseful"));
        
        //Shrek
        Movie Shrek = new Movie("Shrek", 2001, Movie.Rating.PG, Movie.Genre.Family, null, null);
        Shrek.addActor(new Actor("Mike Meyers", Actor.Gender.Male));
        Shrek.addActor(new Actor("Eddie Murphy", Actor.Gender.Male));
        Shrek.addActor(new Actor("Cameron Diaz", Actor.Gender.Female));
        Shrek.addKeyword(new Keyword("Fun"));
        Shrek.addKeyword(new Keyword("Hilarious"));
        Shrek.addKeyword(new Keyword("Animation"));
        
        //Life of Pi
        Movie Pi = new Movie("Life of Pi",2012, Movie.Rating.PG, Movie.Genre.Family, null, null);
        Pi.addActor(new Actor("Suraj Sharma", Actor.Gender.Male));
        Pi.addKeyword(new Keyword("Suspenseful"));
        Pi.addKeyword(new Keyword("Heartbreaking"));
        
        //Add multiple copies of these movies as DVDs to the system.       
        controller.addDVD(new DVD(Interstellar, 1));
        controller.addDVD(new DVD(Interstellar, 2));
        controller.addDVD(new DVD(Interstellar, 3));
        controller.addDVD(new DVD(RushHour, 4));
        controller.addDVD(new DVD(StarWars7, 5));
        controller.addDVD(new DVD(StarWars7, 6));
        controller.addDVD(new DVD(JCFS, 7));
        controller.addDVD(new DVD(TheMummy, 8));
        controller.addDVD(new DVD(Eraser, 9));
        controller.addDVD(new DVD(Shrek, 10));
        controller.addDVD(new DVD(Shrek, 11));
        controller.addDVD(new DVD(Pi, 12));   
    }
    
    //Print out movies in the rental system, not DVD copies.
    public void printAllMovies(Controller controller)
    {
        System.out.println("Movies In Rental System:");
        for (Movie movie : controller.getMovies())
        {
            System.out.println(movie.toString());
        }
    }
    
    //Print out all DVD copies of all movies in the rental system.
    public void printAllDVDs(Controller controller)
    {
        System.out.println("DVD Copies of All Movies:");         
        for (DVD dvd : controller.getDVDs())
        {
            System.out.println(dvd.toString());
        }     
    }
}
