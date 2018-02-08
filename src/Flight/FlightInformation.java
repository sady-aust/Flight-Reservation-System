/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flight;

/**
 *
 * @author User
 */
public class FlightInformation {
    private int flightid;
    private int airlinesId;
    private String flightNumber;
    private int rootId;
     private int AdminId;

    public FlightInformation(int flightid, int airlinesId, String flightNumber, int rootId, int AdminId) {
        this.flightid = flightid;
        this.airlinesId = airlinesId;
        this.flightNumber = flightNumber;
        this.rootId = rootId;
        this.AdminId = AdminId;
    }

    public FlightInformation(int airlinesId, String flightNumber, int rootId, int AdminId) {
        this.airlinesId = airlinesId;
        this.flightNumber = flightNumber;
        this.rootId = rootId;
         this.AdminId = AdminId;
    }

    public FlightInformation() {
    }

    public int getAdminId() {
        return AdminId;
    }

    public void setAdminId(int AdminId) {
        this.AdminId = AdminId;
    }

    public int getFlightid() {
        return flightid;
    }

    public void setFlightid(int flightid) {
        this.flightid = flightid;
    }

    public int getAirlinesId() {
        return airlinesId;
    }

    public void setAirlinesId(int airlinesId) {
        this.airlinesId = airlinesId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getRootId() {
        return rootId;
    }

    public void setRootId(int rootId) {
        this.rootId = rootId;
    }
    
    
    
}
