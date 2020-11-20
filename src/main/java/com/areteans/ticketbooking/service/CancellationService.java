package com.areteans.ticketbooking.service;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CancellationService {
    private final JdbcTemplate jdbcTemplateForCancellation;

    public void CancelTicket(Integer ticket_no) {
       jdbcTemplateForCancellation.update("Delete from ticket where ticket_no=?;", ticket_no);
    }
    public void CancelPassenger(Integer passenger_id) {
        jdbcTemplateForCancellation.update("Delete from passengers where passenger_id=?", passenger_id);
    }



}
