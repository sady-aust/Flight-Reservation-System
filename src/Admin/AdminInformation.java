/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

/**
 *
 * @author User
 */
public class AdminInformation {
    private int AdminId;
    private String AdminUserName;
    private String AdminPassword;
    private String AdminEmail;
    private String AdminFirstName;
    private String AdminLastName;

    public AdminInformation(int AdminId, String AdminUserName, String AdminPassword, String AdminEmail, String AdminFirstName, String AdminLastName) {
        this.AdminId = AdminId;
        this.AdminUserName = AdminUserName;
        this.AdminPassword = AdminPassword;
        this.AdminEmail = AdminEmail;
        this.AdminFirstName = AdminFirstName;
        this.AdminLastName = AdminLastName;
    }

    public AdminInformation(String AdminUserName, String AdminPassword, String AdminEmail, String AdminFirstName, String AdminLastName) {
        this.AdminUserName = AdminUserName;
        this.AdminPassword = AdminPassword;
        this.AdminEmail = AdminEmail;
        this.AdminFirstName = AdminFirstName;
        this.AdminLastName = AdminLastName;
    }
    
    public AdminInformation(){
        
    }

    public int getAdminId() {
        return AdminId;
    }

    public void setAdminId(int AdminId) {
        this.AdminId = AdminId;
    }

    public String getAdminUserName() {
        return AdminUserName;
    }

    public void setAdminUserName(String AdminUserName) {
        this.AdminUserName = AdminUserName;
    }

    public String getAdminPassword() {
        return AdminPassword;
    }

    public void setAdminPassword(String AdminPassword) {
        this.AdminPassword = AdminPassword;
    }

    public String getAdminEmail() {
        return AdminEmail;
    }

    public void setAdminEmail(String AdminEmail) {
        this.AdminEmail = AdminEmail;
    }

    public String getAdminFirstName() {
        return AdminFirstName;
    }

    public void setAdminFirstName(String AdminFirstName) {
        this.AdminFirstName = AdminFirstName;
    }

    public String getAdminLastName() {
        return AdminLastName;
    }

    public void setAdminLastName(String AdminLastName) {
        this.AdminLastName = AdminLastName;
    }
    
    
    
    
}
