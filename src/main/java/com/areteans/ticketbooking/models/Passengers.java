package com.areteans.ticketbooking.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Passengers {
    private String full_name;
    private Integer age;
    private String start_city;
    private String end_city;
    private Long contact_no;
    private Integer passenger_id;
    private Integer ticket_no;

    public Passengers(String full_name,Integer age,String start_city,String end_city,Long contact_no,Integer passenger_id,Integer ticket_no){
        this.full_name=full_name;
        this.age=age;
        this.start_city=start_city;
        this.end_city=end_city;
        this.contact_no=contact_no;
        this.passenger_id = passenger_id;
        this.ticket_no=ticket_no;
    }
}
