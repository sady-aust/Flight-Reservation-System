/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Airlines;

/**
 *
 * @author User
 */
public class AirlinesInformation {
    private int AirlinesId;
    private String AirlinesName;
    private int AdminId;
    private String CountryName;
    private String LicenseNo;

    public AirlinesInformation(int AirlinesId, String AirlinesName, int AdminId, String CountryName, String LicenseNo) {
        this.AirlinesId = AirlinesId;
        this.AirlinesName = AirlinesName;
        this.AdminId = AdminId;
        this.CountryName = CountryName;
        this.LicenseNo = LicenseNo;
    }

    public AirlinesInformation(String AirlinesName, int AdminId, String CountryName, String LicenseNo) {
        this.AirlinesName = AirlinesName;
        this.AdminId = AdminId;
        this.CountryName = CountryName;
        this.LicenseNo = LicenseNo;
    }

    public AirlinesInformation() {
    }

    public int getAirlinesId() {
        return AirlinesId;
    }

    public void setAirlinesId(int AirlinesId) {
        this.AirlinesId = AirlinesId;
    }

    public String getAirlinesName() {
        return AirlinesName;
    }

    public void setAirlinesName(String AirlinesName) {
        this.AirlinesName = AirlinesName;
    }

    public int getAdminId() {
        return AdminId;
    }

    public void setAdminId(int AdminId) {
        this.AdminId = AdminId;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String CountryName) {
        this.CountryName = CountryName;
    }

    public String getLicenseNo() {
        return LicenseNo;
    }

    public void setLicenseNo(String LicenseNo) {
        this.LicenseNo = LicenseNo;
    }
    
    
    
    
}
