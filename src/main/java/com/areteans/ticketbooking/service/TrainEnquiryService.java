package com.areteans.ticketbooking.service;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class TrainEnquiryService {
    private final JdbcTemplate jdbctemplateForTrainEq;
    public Map<String, Object> TrainDetails(String start_city, String end_city) {
        return jdbctemplateForTrainEq.queryForMap("select * from train where start_city=? and end_city=?", start_city,end_city);
    }

}
