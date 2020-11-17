package models;

import com.areteans.ticketbooking.config.PostgresManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Train {
    Scanner sc = new Scanner(System.in);
    private String startCity;
    private String endCity;
    private Double trainFare;
    private int trainNumber;
    private int numberOfSeats;
    private Map<String, String> newMap = new HashMap<>();

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    protected void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getStartCity() {
        //startCity=sc.next();
        return startCity;
    }

    protected String setStartCity(String startCity) {
        this.startCity = startCity.toLowerCase();
        return startCity;
    }

    public String getEndCity() {
        return endCity.toLowerCase();
    }

    protected String setEndCity(String endCity) {
        this.endCity = endCity.toLowerCase();
        return endCity;
    }

    public Double getTrainFare() {
        // System.out.println("enter fare");
        // trainFare=sc.nextDouble();

        return trainFare;
    }

    protected void setTrainFare(Double trainFare) {
        this.trainFare = trainFare;
    }

    public Integer setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
        return trainNumber;
    }

    public Integer getTrainNumber() {
        // trainNumber=sc.nextInt();

        return trainNumber;
    }

    public Map getTrainInfo(String startCity,String endCity) {
        Connection c = null;
        try {
            // Map<String, String> newMap = new HashMap<>();
            c = PostgresManager.getConnection();

            Statement statement = c.createStatement();
            System.out.println("select * from train where start_city="+ startCity +" and end_city="+ endCity);
            ResultSet resultSet = statement.executeQuery("select * from train where start_city='"+ startCity +"' and end_city='"+ endCity+"'");
            while (resultSet.next()) {
                newMap.put("TRAIN NO ", resultSet.getString("train_no"));
                newMap.put("FARE ", resultSet.getString("fare"));
                newMap.put("START CITY ", resultSet.getString("start_city"));
                newMap.put("DESTINATION ", resultSet.getString("end_city"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return newMap ;
    }

}

