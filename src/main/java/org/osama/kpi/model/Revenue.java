package org.osama.kpi.model;


import javax.persistence.*;


@Entity
public class Revenue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String product;
    String booking;
    String tripDone;
    String revenue;

    @ManyToOne
    RDate rDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getBooking() {
        return booking;
    }

    public void setBooking(String booking) {
        this.booking = booking;
    }

    public String getTripDone() {
        return tripDone;
    }

    public void setTripDone(String tripDone) {
        this.tripDone = tripDone;
    }

    public String getRevenue() {
        return revenue;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue;
    }

    public RDate getrDate() {
        return rDate;
    }

    public void setrDate(RDate rDate) {
        this.rDate = rDate;
    }
}
