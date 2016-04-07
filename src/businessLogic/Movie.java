/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import java.util.LinkedList;

/**
 *
 * @author Eric
 */
public class Movie {
    private LinkedList<Keyword> keywords;
    private LinkedList<Actor> actors;
    private Rating rating;
    private Genre genre;
    private int year;
    private String name;
    public enum Genre{Action, Comedy, Horror}
    public enum Rating{G, PG, PG13, R};
    
    public Movie(String Name, int Year, Rating Rating, Genre Genre, LinkedList<Keyword> Keywords, LinkedList<Actor> Actors){
        this.name = Name;
        this.year = Year;
        this.rating = Rating;
        this.genre = Genre;
        this.keywords = Keywords;
        this.actors = Actors;
    }
    
}
