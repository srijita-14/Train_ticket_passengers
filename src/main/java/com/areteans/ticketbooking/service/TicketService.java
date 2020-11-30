package com.areteans.ticketbooking.service;
import com.areteans.ticketbooking.models.Ticket;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TicketService {
    private JdbcTemplate jdbcTemplate;
    private  TicketService ticketService;

    public Map<String, Object> save(Map<String, Object> ticket) {
        Map<String, Object> rMap = jdbcTemplate.queryForMap("insert into ticket(ticket_no,price,start_city,end_city,train_no) values(?,?,?,?,?) RETURNING ticket_no",
                Integer.parseInt((String) ticket.get("ticket_no")),
                Integer.parseInt((String) ticket.get("price")),
                ticket.get("start_city"),
                ticket.get("end_city"),
                Integer.parseInt((String) ticket.get("train_no")));

        ticket.put("ticket_no", rMap.get("ticket_no"));
        return ticket;
    }

   public void seatBooking(){
        ReserveService reserve= new ReserveService();
        //RestTemplate restTemplate = new RestTemplate();
            Thread T1=new Thread(reserve);
            Thread T2=new Thread(reserve);
            T1.setName("Rajdeep");
            T2.setName("Srijita");
            T1.start();
            T2.start();
       ExecutorService executorService = Executors.newFixedThreadPool(10);
       executorService.submit(reserve);
       // ResponseEntity<Ticket> ReserveServiceEntity = restTemplate.postForEntity("http://localhost:8080/booking/ticket/", ticket, Ticket.class);
        //log.info(ReserveServiceEntity.getBody().toString());
        //log.info(T1.getName());
        //log.info(T2.getName());

        }

    }


