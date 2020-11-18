package com.areteans.ticketbooking.controller;

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
@RequestMapping(path = "train")
public class TrainController {
   private final TrainService trainService;

    @PostMapping(path = "details", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> createDetails(@RequestBody Map<String, Object> train) {
        return trainService.save(train);
    }
}

