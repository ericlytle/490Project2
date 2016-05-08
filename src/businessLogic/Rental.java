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
public class Rental {
    private DVD dvd;
    private Calendar rentDate;
    private Calendar returnDate;
    private Status status;
    private Review review;
    public enum Status{Rented, Returned};
    
    public Rental(DVD DVD, Calendar RentDate, Status Status){
        this.dvd = DVD;
        this.rentDate = RentDate;
        this.returnDate = RentDate;
        //Mark return date to the default 1 week (7 days)
        this.returnDate.add(Calendar.DAY_OF_MONTH, 7);
    }
    
    public Rental(DVD DVD, Calendar RentDate, Status Status, Review Review){
        this.dvd = DVD;
        this.rentDate = RentDate;
        this.returnDate = RentDate;
        //Mark return date to the default 1 week (7 days)
        this.returnDate.add(Calendar.DAY_OF_MONTH, 7);
        this.review = Review;
    }
    
    public DVD getDVD() {return dvd;}
    
    public Calendar getReturnDate() {return returnDate;}
}
