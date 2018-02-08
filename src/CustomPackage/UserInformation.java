/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomPackage;

/**
 *
 * @author User
 */
public class UserInformation {
    private int UserId;
    private String firstName;
    private String lastName;
    private String userName;
    private String password; 
    private String email;
    private String phone;
    private String address;

    public UserInformation(String firstName, String lastName, String userName, String password, String email, String phone, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public UserInformation(int UserId, String firstName, String lastName, String userName, String password, String email, String phone, String address) {
        this.UserId = UserId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public UserInformation() {
    }
    
    

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }
    

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserInformation{" + "firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", password=" + password + ", email=" + email + ", phone=" + phone + ", address=" + address + '}';
    }
    
    
       
    
}
