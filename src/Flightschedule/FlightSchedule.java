/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flightschedule;

/**
 *
 * @author User
 */
public class FlightSchedule {
    private int TimeAndDateId;
    private String DepartureDay;
    private String DepartureTime;
    private String ArrivalDay;
    private String ArrivalTIme;
    private String flightNumber;

    public FlightSchedule(int TimeAndDateId, String DepartureDay, String DepartureTime, String ArrivalDay, String ArrivalTIme,String flightNumber) {
        this.TimeAndDateId = TimeAndDateId;
        this.DepartureDay = DepartureDay;
        this.DepartureTime = DepartureTime;
        this.ArrivalDay = ArrivalDay;
        this.ArrivalTIme = ArrivalTIme;
        this.flightNumber = flightNumber;
    }

    public FlightSchedule(String DepartureDay, String DepartureTime, String ArrivalDay, String ArrivalTIme) {
        this.DepartureDay = DepartureDay;
        this.DepartureTime = DepartureTime;
        this.ArrivalDay = ArrivalDay;
        this.ArrivalTIme = ArrivalTIme;
        this.flightNumber = flightNumber;
    }

    public FlightSchedule() {
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    
    public int getTimeAndDateId() {
        return TimeAndDateId;
    }

    public void setTimeAndDateId(int TimeAndDateId) {
        this.TimeAndDateId = TimeAndDateId;
    }

    public String getDepartureDay() {
        return DepartureDay;
    }

    public void setDepartureDay(String DepartureDay) {
        this.DepartureDay = DepartureDay;
    }

    public String getDepartureTime() {
        return DepartureTime;
    }

    public void setDepartureTime(String DepartureTime) {
        this.DepartureTime = DepartureTime;
    }

    public String getArrivalDay() {
        return ArrivalDay;
    }

    public void setArrivalDay(String ArrivalDay) {
        this.ArrivalDay = ArrivalDay;
    }

    public String getArrivalTIme() {
        return ArrivalTIme;
    }

    public void setArrivalTIme(String ArrivalTIme) {
        this.ArrivalTIme = ArrivalTIme;
    }
    
    
    
    
}
