package com.areteans.ticketbooking.service;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CancellationService {
    private final JdbcTemplate jdbcTemplateForCancellation;

    public  Map<String, Object> CancelTicket(Integer ticket_no) {
       return jdbcTemplateForCancellation.queryForMap("Delete from ticket where ticket_no=?", ticket_no);
    }
    public Map<String, Object> CancelPassenger(Integer passenger_id) {
        return jdbcTemplateForCancellation.queryForMap("Delete from passengers where passenger_id=?", passenger_id);
    }



}
