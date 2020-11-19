package com.areteans.ticketbooking.service;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class TicketEnquiryService {
    private final JdbcTemplate jdbctemplateForTicketEq;
    public Map<String, Object> TicketDetails(Integer ticket_no) {
        return jdbctemplateForTicketEq.queryForMap("select * from ticket where ticket_no=?", ticket_no);
    }

}
