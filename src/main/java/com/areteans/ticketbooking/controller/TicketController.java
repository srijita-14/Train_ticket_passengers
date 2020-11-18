package com.areteans.ticketbooking.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "ticket")
public class TicketController {

    @GetMapping(path = "/data")
    public String getDummyData(@RequestParam(value = "start_city", required = false) String start_city,
                               @RequestParam(value = "end_city", required = false) String end_city) {
        return start_city != null && end_city != null ? start_city.toUpperCase() + ": " + end_city : "empty input";
    }



    @PostMapping(path = "traindetails", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String getDetails(@RequestBody Map<String, String> input) {
        String start_city = input.get("start_city");
        String end_city = input.get("end_city");
        //Integer train_no = Integer.parseInt(input.get("train_no"));
        Integer fare= Integer.parseInt(input.get("fare"));
        return start_city != null  && end_city!= null && fare!= null? start_city.toUpperCase() + ": " + end_city.toUpperCase() + ": "+ fare.floatValue(): "empty input";


    }
}



