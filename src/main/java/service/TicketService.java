package service;

import com.areteans.ticketbooking.config.PostgresManager;
import models.Train;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketService {

    public Train createTrain(Train train) {
        jdbcTemplate.update("insert into train(start_city,end_city,train_no,fare) values (?,?,?,?)");

    }

        Connection connection = PostgresManager.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("insert into train(name, contact, address, grade, section, percentage) values (?,?,?,?,?,?)");
            preparedStatement.setString(1, start_city.getName());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new train(resultSet.getString("name"), resultSet.getLong("studentID"), resultSet.getLong("contact"), null, 0, 'A', 0, null);
            }
    } catch(SQLException ex) {
        System.err.println(ex.getMessage());
    }
        return null;
            }





