/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

/**
 *
 * @author Eric
 */
public class DVD {
    private Movie movie;
    private long serialNumber;
    private boolean lost;
    
    public DVD(Movie Movie, long SerialNumber){
        this.movie = Movie;
        this.serialNumber = SerialNumber;
        this.lost = false;
    }
    
    public Movie getMovie(){return movie;}
    
    public long getID() {return serialNumber;}
    
    @Override
    public String toString(){return movie.getName() + ", SN: " + serialNumber;}
}
