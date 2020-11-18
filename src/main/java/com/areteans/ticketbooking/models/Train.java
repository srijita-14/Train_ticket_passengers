package com.areteans.ticketbooking.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Train {
    private String startCity;
    private String endCity;
    private Double fare;
    private Integer train_no;
    private Integer total_seats;


    public Train(String startCity, String endCity,Double fare,Integer train_no, Integer total_seats){
    this.startCity=startCity;
    this.endCity=endCity;
    this.fare =fare;
    this.train_no=train_no;
    this.total_seats =total_seats;
    }


}

