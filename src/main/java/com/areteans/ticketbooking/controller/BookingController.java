package com.areteans.ticketbooking.controller;

import com.areteans.ticketbooking.service.PassengerService;
import com.areteans.ticketbooking.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.areteans.ticketbooking.service.TrainService;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "booking")
public class BookingController {
   private final TrainService trainService;
   private final TicketService ticketService;
   private final PassengerService passengerService;

    @PostMapping(path = "train", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> createDetails(@RequestBody Map<String, Object> train) {
        return trainService.save(train);
    }

    @PostMapping(path = "ticket", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> ticketDetails(@RequestBody Map<String, Object> ticket){
        return ticketService.save(ticket);
    }
    @PostMapping(path = "passengers", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> passengerDetails(@RequestBody Map<String, Object> passengers){
        return passengerService.save(passengers);
    }
}

//jdbc.update(sql, ps.getNewPaswd(),ps.getUsername() );
