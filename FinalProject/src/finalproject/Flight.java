/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.tools.DocumentationTool.Location;

/**
 *
 * @author macstudent
 */
public class Flight extends PassengerList {

    //Itinerary class was deleted
    Itinerary itinerary;
    DepartureDate departureDate;

    String number;
    String pilotName;

    //it will be set as false when all the seats are reserved
    boolean isAvailable = true;

    //0 = available, n > 0 = passengerId Reservation
    Map<Seat, Integer> passengerList = new HashMap<Seat, Integer>();

    Flight(Itinerary itinerary, DepartureDate departureDate, String number, String pilotName) {
        this.itinerary = itinerary;
        this.departureDate = departureDate;
        this.number = number;
        this.pilotName = pilotName;
        initializeSeats();
    }

    //Return the PassengerSeat reserved
    @Override
    public int setPassengerSeat(Integer passengerID) {
        Integer seatReserved = 0;
        for (Map.Entry<Seat, Integer> entry : this.passengerList.entrySet()) {
            if (entry.getValue() == 0) {
                entry.setValue(passengerID);
                seatReserved = entry.getKey().Number;
                System.out.println("Seat number: " + seatReserved + " for the passengerID: " + passengerID);
                break;
            }
        }
        verifyFlighAvailable();

        return seatReserved;
    }

    //Return the PassengerSeat removed
    @Override
    public int removePassengerSeat(Integer passengerID) {
        Integer seatReserved = 0;
        for (Map.Entry<Seat, Integer> entry : this.passengerList.entrySet()) {
            if (entry.getValue() == passengerID) {
                Seat objSeat = new Seat();
                objSeat.Number = 0;
                entry.setValue(objSeat.Number);
                seatReserved = entry.getKey().Number;
                System.out.println("Seat removed: " + seatReserved);
            }
        }
        verifyFlighAvailable();

        return seatReserved;
    }

    public void showSeatsStatus() {

        System.out.println("Flight number: " + this.number);
        for (Map.Entry<Seat, Integer> entry : this.passengerList.entrySet()) {
            System.out.println("Seat: " + entry.getKey().Number + " Reserved for the passenger [" + entry.getValue() + "]");
        }
        
        System.out.println("");
    }

    public void verifyFlighAvailable() {
        this.isAvailable = false;
        for (Integer value : this.passengerList.values()) {
            if (value == 0) {
                this.isAvailable = true;
            }
        }
    }

    private void initializeSeats() {
        int count;
        for (count = 1; count < 11; count++) {
            Seat objSeat = new Seat();
            objSeat.Number = count;
            passengerList.put(objSeat, 0);
        }
    }

    public void getItinerary() {
        System.out.println("Itinerary info: ");
        System.out.println("Start point: " + itinerary.startPoint);
        System.out.println("End point: " + itinerary.endPoint);
    }

    //gets and setters
    public String getNumber() {
        return this.number;
    }

    public void setNumber(String name) {
        this.number = number;
    }

    public String getPilotName() {
        return this.pilotName;
    }

    public void setPilotName(String pilotName) {
        this.pilotName = pilotName;
    }

}
