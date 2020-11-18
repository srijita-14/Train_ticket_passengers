package service;

import lombok.RequiredArgsConstructor;
import models.Train;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final JdbcTemplate jdbcTemplate;
    public Map<Train, Object> save(Map<Train, Object> train) {
        Map<String, Object> sMap = jdbcTemplate.queryForMap("insert into train(train_no,train_name,start_city,end_city,total_seats) values(?,?,?,?,?)",
                Integer.parseInt((String) train.get("train_no")),
                train.get("train_name"),
                train.get("start_city"),
                train.get("end_city"),
                Integer.parseInt((String) train.get("total_seats")));


        return train;
    }
}






