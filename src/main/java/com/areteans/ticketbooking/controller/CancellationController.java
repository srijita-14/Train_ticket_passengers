package com.areteans.ticketbooking.controller;

import com.areteans.ticketbooking.service.CancellationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "Cancel")
public class CancellationController {
    private final CancellationService cancellationService;

    @DeleteMapping(value = "ticket")
    public void CancellationOfTicket(@PathVariable("ticket_no") Integer ticket_no) {
     cancellationService.CancelTicket(ticket_no);
    }
}
