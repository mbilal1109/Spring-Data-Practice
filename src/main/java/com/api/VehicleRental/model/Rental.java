package com.api.VehicleRental.model;

import java.util.Date;

public class Rental {

    private int rentalId;
    private Date dateRented;
    private Date dateReturned;

    public Rental(int rentalId, Date dateRented, Date dateReturned) {
        this.rentalId = rentalId;
        this.dateRented = dateRented;
        this.dateReturned = dateReturned;
    }

    public Rental() {
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public Date getDateRented() {
        return dateRented;
    }

    public void setDateRented(Date dateRented) {
        this.dateRented = dateRented;
    }

    public Date getDateReturned() {
        return dateReturned;
    }

    public void setDateReturned(Date dateReturned) {
        this.dateReturned = dateReturned;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "rentalId=" + rentalId +
                ", dateRented=" + dateRented +
                ", dateReturned=" + dateReturned +
                '}';
    }
}
