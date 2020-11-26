package com.areteans.ticketbooking.service;
import com.areteans.ticketbooking.models.PassengerJPA;
import com.areteans.ticketbooking.models.Ticket;
import com.areteans.ticketbooking.repository.PassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;
@Service
@RequiredArgsConstructor
public class CommonService {
    private final JdbcTemplate jdbcTemplateForCreate;
    private final PassengerRepository passengerRepository;
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

    @Transactional
    public Map<String, Object> createPassengerJpa(Map<String, Object> passengerJPA) {
        PassengerJPA passenger = new PassengerJPA(
                null,
                String.valueOf(passengerJPA.get("passenger_name")),
                Integer.parseInt(String.valueOf(passengerJPA.get("age"))),
                Long.parseLong(String.valueOf(passengerJPA.get("contact_no"))),
                String.valueOf(passengerJPA.get("start_city")),
                String.valueOf(passengerJPA.get("end_city")));

        PassengerJPA passenger1 = passengerRepository.save(passenger);//SAVE 1
        passenger1.setAge(31);
        passenger1.setContact_no(5738382892L);
        passengerRepository.save(passenger1);//SAVE2
        return new HashMap<>();


    }

}






