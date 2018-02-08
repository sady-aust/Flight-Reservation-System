/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightTransitInformation;

/**
 *
 * @author User
 */
public class FlightTransit {
    private int transitId;
    private String flightNumber;
    private String firstTransit = null;
    private String secondTransit = null;

    public FlightTransit(int transitId, String flightNumber, String firstTransit, String secondTransit) {
        this.transitId = transitId;
        this.flightNumber = flightNumber;
        this.firstTransit = firstTransit;
        this.secondTransit = secondTransit;
    }

    public FlightTransit(String flightNumber, String firstTransit, String secondTransit) {
        this.flightNumber = flightNumber;
        this.firstTransit = firstTransit;
        this.secondTransit = secondTransit;
    }

    public int getTransitId() {
        return transitId;
    }

    public void setTransitId(int transitId) {
        this.transitId = transitId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFirstTransit() {
        return firstTransit;
    }

    public void setFirstTransit(String firstTransit) {
        this.firstTransit = firstTransit;
    }

    public String getSecondTransit() {
        return secondTransit;
    }

    public void setSecondTransit(String secondTransit) {
        this.secondTransit = secondTransit;
    }
    
    
}
