package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Passengers {
    public static Scanner scanner = new Scanner(System.in);
    //int passengerNumber;
    ArrayList<String> fullName = new ArrayList<String>();
    int[] age;
    String startCity;
    String endCity;
    Date strDate;
    long[] contactNumber;

    public Passengers(int passengerNumber) {

        age = new int[passengerNumber];
        contactNumber = new long[passengerNumber];
    }


    public void getName(int passengerNumber) {

        System.out.println("Enter " + passengerNumber + " passenger's Full Name: ");
        for (int i = 0; i < passengerNumber; i++) {
            fullName.add(scanner.nextLine());
        }
    }

    public void getAge(int passengerNumber) {
        System.out.println();

        for (int i = 0; i < passengerNumber; i++) {

            System.out.print("Enter the Age of Passenger " + (i+1) + " : ");
            age[i] = scanner.nextInt();
            scanner.nextLine();
        }
    }
    public void getContactNumber(int passengerNumber) {
        System.out.println();
        for (int i = 0; i < passengerNumber; i++) {
            System.out.println("Enter the Contact Number of Passenger " + (i+1) + " : ");
            contactNumber[i] = scanner.nextLong();
            scanner.nextLine();
        }

    }


    public String getStartCity() {
        System.out.print("Enter the Start Station: ");
        startCity = scanner.nextLine();
        //scanner.nextLine();
        //System.out.print("Enter the Destination: ");
       // endCity = scanner.nextLine();
        //scanner.nextLine();
        return startCity;
    }
    public String getEndCity(){
        System.out.println("Enter the End station: ");
        endCity= scanner.nextLine();
        return endCity;

    }
    public void getDate() {

        System.out.print("Enter the Travelling Date in (DD/MM/YYYY) format: ");
        String inputDate = scanner.nextLine();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        try {
            strDate = formatter.parse(inputDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }


    public void printPassengerDetails(int passengerNumber) {
        for (int i = 0; i < passengerNumber; i++) {
            String name = fullName.get(i);
            int passengerAge = age[i];
            long contact = contactNumber[i];
            System.out.println("\nThe Details of Passenger " + (i+1) + " is: ");
            System.out.println("\tName: " + name + " , " + "  Age: " + passengerAge + "   Contact Number: " + contact);
            System.out.println("\tBoarding At: " + startCity + "   Destination: " + endCity );
            //System.out.println("Travelling Date: " +strDate);

        }
    }
}
