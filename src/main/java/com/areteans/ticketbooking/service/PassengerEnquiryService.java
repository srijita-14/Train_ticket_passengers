package com.areteans.ticketbooking.service;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class PassengerEnquiryService {
    public final JdbcTemplate jdbcTemplateForPassengerEq;
    public Map<String, Object> PassengerDetails(Integer passenger_id) {
        return jdbcTemplateForPassengerEq.queryForMap("select * from ticket where passenger_id=?", passenger_id);
    }

}

