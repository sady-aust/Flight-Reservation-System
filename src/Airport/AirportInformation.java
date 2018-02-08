/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Airport;

/**
 *
 * @author User
 */
public class AirportInformation {
    private int AirportId ;
    private String AirportName;
    private String CountryName ;
    private String CityName ;
    private String AirportCode;
    private int AdminId;

    public AirportInformation(int AirportId, String AirportName, String CountryName, String CityName, String AirportCode, int AdminId) {
        this.AirportId = AirportId;
        this.AirportName = AirportName;
        this.CountryName = CountryName;
        this.CityName = CityName;
        this.AirportCode = AirportCode;
        this.AdminId = AdminId;
    }

    public AirportInformation(String AirportName, String CountryName, String CityName, String AirportCode, int AdminId) {
        this.AirportName = AirportName;
        this.CountryName = CountryName;
        this.CityName = CityName;
        this.AirportCode = AirportCode;
        this.AdminId = AdminId;
    }

    public AirportInformation() {
    }

    public int getAirportId() {
        return AirportId;
    }

    public void setAirportId(int AirportId) {
        this.AirportId = AirportId;
    }

    public String getAirportName() {
        return AirportName;
    }

    public void setAirportName(String AirportName) {
        this.AirportName = AirportName;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String CountryName) {
        this.CountryName = CountryName;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String CityName) {
        this.CityName = CityName;
    }

    public String getAirportCode() {
        return AirportCode;
    }

    public void setAirportCode(String AirportCode) {
        this.AirportCode = AirportCode;
    }

    public int getAdminId() {
        return AdminId;
    }

    public void setAdminId(int AdminId) {
        this.AdminId = AdminId;
    }
    
    
    
    
    
}
