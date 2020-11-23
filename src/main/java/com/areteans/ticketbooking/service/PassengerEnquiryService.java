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
public class PassengerEnquiryService {
    public final JdbcTemplate jdbcTemplateForPassengerEq;
    private  final PassengerRepository passengerRepository;
    public Map<String, Object> PassengerDetails(Integer passenger_id) {
        return jdbcTemplateForPassengerEq.queryForMap("select * from ticket where passenger_id=?", passenger_id);
    }


    public PassengerJPA getPassengerByID(Long id) {
        Optional<PassengerJPA> emp = passengerRepository.findById(id);
        if (emp.isPresent()) {
            return emp.get();
        }
        return null;
    }

}

