package com.areteans.ticketbooking.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import java.util.*;

import java.awt.*;

@RestController
@RequestMapping(path = "test")
public class TestController {
    @GetMapping(path = "/data")
    public String getDummyData(@RequestParam(value = "name", required = false) String name,
                               @RequestParam(value = "age", required = false) Integer age) {
        return name != null && age != null ? name.toUpperCase() + ": " + age : "empty input";
    }

    @GetMapping(path = "data/{age}")
    public String getFromPV(@PathVariable("age") Integer age) {
        return String.valueOf(age);
    }

    @PostMapping(path = "data",consumes = MediaType.APPLICATION_JSON_VALUE)
    public String getDummyData(@RequestBody Map<String,String> input){
        String name= input.get("name");
        Integer age= Integer.parseInt(input.get("age"));
        return name != null && age != null ? name.toUpperCase() + ": " + age : "empty input";

    }

    @PutMapping(path = "data",consumes = MediaType.APPLICATION_JSON_VALUE)
    public String getDummyval(@RequestBody Map<String,String> input){
        String name= input.get("name");
        Integer age= Integer.parseInt(input.get("age"));
        return name != null && age != null ? name.toUpperCase() + ": " + age : "empty input";

    }
}

  //  PreparedStatement preparedStatement = c.prepareStatement("insert into detail(name, contact, address) values (?,?,?)");
  //          preparedStatement.setString(1, "ABC");
  //                  preparedStatement.setLong(2, 21222);
   //                 preparedStatement.setString(3, "DEF");

    //                boolean resultSet1 = preparedStatement.execute();