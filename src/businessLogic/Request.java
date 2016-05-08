/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import java.util.Calendar;

/**
 *
 * @author Eric
 */
public class Request {
    private Calendar requestDate;
    private Calendar responseDate;
    private Status status;
    public enum Status{Order, Wait, Impossible};
    private Movie movie;
    //type -- no clue what this corresponds to
    
    public Request(Calendar RequestDate, Calendar ResponseDate, Movie Movie){
        this.requestDate = RequestDate;
        this.responseDate = ResponseDate;
        this.movie = Movie;
        this.status = Status.Wait; //Default to Wait status
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    @Override
    public String toString()
    {
        return "* Request Details || Request Date: " + requestDate.getTime().toString()
                + " Response Date: " + responseDate.getTime().toString() + "\n* Movie: " + movie.getName()
                + " Status: " + status.name();
    }
}
