/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Root;

/**
 *
 * @author User
 */
public class RootInformation {
    private int RootId;
    private int AddedBy;
    private String DepartureCityAirportCode;
    private String DestinationCityAirporCode;

    public RootInformation(int RootId, int AddedBy, String DepartureCityAirportCode, String DestinationCityAirporCode) {
        this.RootId = RootId;
        this.AddedBy = AddedBy;
        this.DepartureCityAirportCode = DepartureCityAirportCode;
        this.DestinationCityAirporCode = DestinationCityAirporCode;
    }

    public RootInformation(String DepartureCityAirportCode, String DestinationCityAirporCode) {
        this.DepartureCityAirportCode = DepartureCityAirportCode;
        this.DestinationCityAirporCode = DestinationCityAirporCode;
    }

    
    public RootInformation() {
    }

    public RootInformation(int AddedBy, String DepartureCityAirportCode, String DestinationCityAirporCode) {
        this.AddedBy = AddedBy;
        this.DepartureCityAirportCode = DepartureCityAirportCode;
        this.DestinationCityAirporCode = DestinationCityAirporCode;
    }

    public int getRootId() {
        return RootId;
    }

    public void setRootId(int RootId) {
        this.RootId = RootId;
    }

    public int getAddedBy() {
        return AddedBy;
    }

    public void setAddedBy(int AddedBy) {
        this.AddedBy = AddedBy;
    }

    public String getDepartureCityAirportCode() {
        return DepartureCityAirportCode;
    }

    public void setDepartureCityAirportCode(String DepartureCityAirportCode) {
        this.DepartureCityAirportCode = DepartureCityAirportCode;
    }

    public String getDestinationCityAirporCode() {
        return DestinationCityAirporCode;
    }

    public void setDestinationCityAirporCode(String DestinationCityAirporCode) {
        this.DestinationCityAirporCode = DestinationCityAirporCode;
    }
    
    

  
    
    
}
