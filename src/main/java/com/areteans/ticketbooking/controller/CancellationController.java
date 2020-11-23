package com.areteans.ticketbooking.controller;

import com.areteans.ticketbooking.models.PassengerJPA;
import com.areteans.ticketbooking.service.CancellationService;
import com.areteans.ticketbooking.service.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "Cancel")
public class CancellationController {
    private final CancellationService cancellationService;
    private  final PassengerService passengerService;
    @DeleteMapping(value = "ticket/{ticket_no}")
    public void CancellationOfTicket(@PathVariable("ticket_no") Integer ticket_no) {
        cancellationService.CancelTicket(ticket_no);
    }
    @DeleteMapping(value = "passengers/{passenger_id}")
   public void CancellationOfPassenger(@PathVariable("passenger_id") Integer passenger_id) {
        cancellationService.CancelPassenger(passenger_id);
    }
    /*@DeleteMapping(value = "passenger/{passenger_id}")
        public  void deletePassengerData(@PathVariable ("passenger_id") Long passenger_id){
            passengerService.deletePassengerByID(passenger_id);*/

    }
