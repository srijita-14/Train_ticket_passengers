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

    @GetMapping(path = "data/{train_no}")
    public String getFromPV(@PathVariable("train_no") Integer train_no) {
        return String.valueOf(train_no);
    }

    @PostMapping(path = "data", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String getDetails(@RequestBody Map<String, String> input) {
        String start_city = input.get("start_city");
        Integer train_no = Integer.parseInt(input.get("train_no"));
        return start_city != null && train_no != null ? start_city.toUpperCase() + ": " + train_no : "empty input";


    }
}



