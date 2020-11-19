package com.areteans.ticketbooking.controller;

import com.areteans.ticketbooking.service.UpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "update")
public class UpdateController {
    private final UpdateService updateService;

    @PutMapping (path = "passengers", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> passengerDetails(@RequestBody Map<String, Object> passengers){
        return updateService.updatePassengers(passengers);
    }
}
