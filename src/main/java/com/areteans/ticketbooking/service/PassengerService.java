package com.areteans.ticketbooking.service;

import com.areteans.ticketbooking.models.PassengerJPA;
import com.areteans.ticketbooking.models.Passengers;
import com.areteans.ticketbooking.repository.PassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PassengerService {
    private final JdbcTemplate jdbcTemplateOfPassenger;
    private  final PassengerRepository passengerRepository;
    public Map<String, Object> save(Map<String, Object> passengers) {
        Map<String, Object> pMap = jdbcTemplateOfPassenger.queryForMap("insert into passengers(passenger_id,passenger_name,age,contact_no,start_city,end_city,ticket_no) values(?,?,?,?,?,?,?) RETURNING passenger_id",
                Integer.parseInt((String) passengers.get("passenger_id")),
                passengers.get("passenger_name"),
                Integer.parseInt((String) passengers.get("age")),
                Long.parseLong((String) passengers.get("contact_no")),
                passengers.get("start_city"),
                passengers.get("end_city"),
                Integer.parseInt((String) passengers.get("ticket_no")));

        passengers.put("passenger_id" , pMap.get("passenger_id"));
        return passengers;
    }
    public PassengerJPA savePassenger(PassengerJPA passengerJPA) {
        return passengerRepository.save(passengerJPA);
    }

    /*public PassengerJPA deletePassengerByID(Long id) {
        Optional<PassengerJPA> emp = passengerRepository.deleteAll();
        if (emp.isPresent()) {
            return emp.get();
        }
        return null;
    }*/





}
