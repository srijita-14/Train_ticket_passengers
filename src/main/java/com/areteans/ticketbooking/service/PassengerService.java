package com.areteans.ticketbooking.service;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class PassengerService {
    private final JdbcTemplate jdbcTemplateOfPassenger;
    public Map<String, Object> save(Map<String, Object> passengers) {
        Map<String, Object> pMap = jdbcTemplateOfPassenger.queryForMap("insert into passengers(passenger_id,passenger_name,age,contact_no,start_city,end_city) values(?,?,?,?,?,?) RETURNING passenger_id",
                Integer.parseInt((String) passengers.get("passenger_id")),
                passengers.get("passenger_name"),
                Integer.parseInt((String) passengers.get("age")),
                Long.parseLong((String) passengers.get("contact_no")),
                passengers.get("start_city"),
                passengers.get("end_city"));

        passengers.put("passenger_id" , pMap.get("passenger_id"));
        return passengers;
    }



}
