package service;

import models.Passengers;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

public class PassengerService {
 public Passengers createPassenger = postgre.getconnection;
    try{
        PreparedStatement preparedStatement = connection.prepareStatement("insert into passenger(name, contact, age, travelDate) values (?,?,?,?)");
        preparedStatement.setInt(1,Passengers.getName());



