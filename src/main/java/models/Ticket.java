package models;

import java.util.ArrayList;

public class Ticket {
    private String startCity;
    private String endCity;
    private	int bookingNumber;
    //private static int bookingNumberGenerator = 0;
    private double fare;
    private ArrayList<Passengers> passenger;

    public void addPassenger(Passengers passenger) {
        if(this.passenger==null)
        {
            this.passenger=new ArrayList<>();
        }
        this.passenger.add(passenger);
    }

    public double getFare() {
        return fare;
    }

    protected void setFare(Double double1) {
        this.fare = double1;
    }

    public String getStartCity() {
        return startCity;
    }

    public String getEndCity() {
        return endCity;
    }

    public int getBookingNumber() {
        return bookingNumber;
    }

    protected void setStartCity(String startCity) {
        this.startCity = startCity;
    }
    protected void setEndCity(String endCity) {
        this.endCity = endCity;
    }


}
