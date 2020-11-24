package com.areteans.ticketbooking.service;
import com.areteans.ticketbooking.models.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final JdbcTemplate jdbcTemplate;

    public Map<String, Object> save(Map<String, Object> ticket) {
        Map<String, Object> rMap = jdbcTemplate.queryForMap("insert into ticket(ticket_no,price,start_city,end_city,train_no) values(?,?,?,?,?) RETURNING ticket_no",
                Integer.parseInt((String) ticket.get("ticket_no")),
                Integer.parseInt((String) ticket.get("price")),
                ticket.get("start_city"),
                ticket.get("end_city"),
                // ticket.get("booking_date"),
                Integer.parseInt((String) ticket.get("train_no")));

        ticket.put("ticket_no", rMap.get("ticket_no"));
        return ticket;
    }
}

