package com.areteans.ticketbooking.controller;

import models.Passengers;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.PassengerService;

import java.util.Map;

@RestController
@RequestMapping(path = "passenger")
public class PassengerController {
    /*@PostMapping(path = "TravelDetails", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String TravelDetails(@RequestBody Map<String, String> input) {
        String StartCityName = input.get("Hyd");
        //String EndCityName= input.get("kolkata");
        return StartCityName;*/
    private PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService= passengerService;
    }


    @PostMapping(path = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Passengers passenger(@RequestBody Passengers passenger) {
        return PassengerService.createPassenger(passenger);
    }
}

    }
}
