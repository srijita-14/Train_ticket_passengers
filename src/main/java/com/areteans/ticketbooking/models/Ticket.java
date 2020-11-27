package com.areteans.ticketbooking.models;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ticket {
    private Integer ticket_no;
    private Integer price;
    private String start_city;
    private String end_city;
    private Integer train_no;
    private  Passengers passengers;

    public Ticket(Integer ticket_no,Integer price,String start_city,String end_city,Integer train_no){
        this.ticket_no=ticket_no;
        this.price=price;
        this.start_city=start_city;
        this.end_city=end_city;
        this.train_no=train_no;
    }

}