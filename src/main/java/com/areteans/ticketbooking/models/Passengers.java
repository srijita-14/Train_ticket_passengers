package com.areteans.ticketbooking.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Passengers {
    private String passenger_name;
    private Integer age;
    private String start_city;
    private String end_city;
    private Long contact_no;
    private Integer passenger_id;

    public Passengers(String passenger_name,Integer age,String start_city,String end_city,Long contact_no,Integer passenger_id){
        this.passenger_name=passenger_name;
        this.age=age;
        this.start_city=start_city;
        this.end_city=end_city;
        this.contact_no=contact_no;
        this.passenger_id = passenger_id;
    }
}
