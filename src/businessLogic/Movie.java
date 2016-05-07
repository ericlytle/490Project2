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
    public enum Genre{Action, Comedy, Horror, SciFi}
    public enum Rating{G, PG, PG13, R};
    
    public Movie(String Name, int Year, Rating Rating, Genre Genre, LinkedList<Keyword> Keywords, LinkedList<Actor> Actors){
        this.name = Name;
        this.year = Year;
        this.rating = Rating;
        this.genre = Genre;
        this.keywords = Keywords;
        this.actors = Actors;
        this.keywords = new LinkedList<>();
        this.actors = new LinkedList<>();
    }
    
    @Override
    public String toString()
    {
        String output = name + ", " + year + ", " + rating.name() + ", " + genre.name() + ", Actors: ";
        for (Actor actor : actors){output += actor.getName() + ", ";}
        output += "Keywords: ";
        for (Keyword keyword : keywords){output += keyword.getKeyword() + ", ";}
        output = output.substring(0, output.length() - 2); //Remove extra comma
        return output;
    }
    
    public void setActors(LinkedList<Actor> actors) {this.actors = actors;}
    
    public void setKeywords(LinkedList<Keyword> keywords) {this.keywords = keywords;}
    
    public void addActor(Actor actor) {this.actors.add(actor);}
    
    public void addKeyword(Keyword keyword) {this.keywords.add(keyword);}
    
    public LinkedList<Actor> getActors() {return actors;}
    
    public LinkedList<Keyword> getKeywords() {return keywords;}
    
    public String getName() {return name;}
}
