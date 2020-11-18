package com.areteans.ticketbooking.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Train {
    private String startCity;
    private String endCity;
    private Double trainFare;
    private Integer trainNumber;
    private Integer numberOfSeats;


    public Train(String startCity, String endCity,Double trainFare,Integer trainNumber, Integer numberOfSeats){
    this.startCity=startCity;
    this.endCity=endCity;
    this.trainFare=trainFare;
    this.trainNumber=trainNumber;
    this.numberOfSeats=numberOfSeats;
    }


}

