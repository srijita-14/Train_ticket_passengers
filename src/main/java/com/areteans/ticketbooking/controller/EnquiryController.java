package com.areteans.ticketbooking.controller;


import com.areteans.ticketbooking.service.TicketEnquiryService;
import com.areteans.ticketbooking.service.TrainEnquiryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "enquiry")
public class EnquiryController {
    private final TicketEnquiryService ticketEnquiryService;
    private final TrainEnquiryService trainEnquiryService;

    @GetMapping(path = "ticket")
    public Map<String, Object> GetTicketDetails(@RequestParam(value = "ticket_no")Integer ticket_no){
    return this.ticketEnquiryService.TicketDetails(ticket_no);
    }
    @GetMapping(path = "train")
    public Map<String, Object> GetTrainDetails(@RequestParam(value = "start_city")String start_city,
                                               @RequestParam(value = "end_city")String end_city){
        return this.trainEnquiryService.TrainDetails(start_city,end_city);
    }
}
