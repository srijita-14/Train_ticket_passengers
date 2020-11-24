package com.areteans.ticketbooking.service;
import com.areteans.ticketbooking.models.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.Map;
@Service
@RequiredArgsConstructor
public class CommonService {
    private final JdbcTemplate jdbcTemplateForCreate;

    public Ticket create(Ticket ticket) {
        Map<String, Object> map1 = jdbcTemplateForCreate.queryForMap("insert into passengers(passenger_name,age,contact_no,start_city,end_city) values(?,?,?,?,?) RETURNING passenger_id",
                ticket.getPassengers().getPassenger_name(),
                ticket.getPassengers().getAge(),
                ticket.getPassengers().getContact_no(),
                ticket.getPassengers().getStart_city(),
                ticket.getPassengers().getEnd_city());
        jdbcTemplateForCreate.update("insert into ticket(price,start_city,end_city,train_no,passengers) values(?,?,?,?,?)",
                ticket.getPrice(),
                ticket.getStart_city(),
                ticket.getEnd_city(),
                ticket.getTrain_no(),
                map1.get("passenger_id"));
        return ticket;
    }

}






