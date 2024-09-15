/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Customer;

/**
 *
 * @author xuen_
 */
public class customerClass {
    private String custID;
    private String name;
    private String phoneNum;
    private String email;
    private String address;
    private String password;
    
    public customerClass(String custID, String name, String phoneNum, String email, String address, String password) {
        this.custID = custID;
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
        this.address = address;
        this.password = password;
    }
    
    // getters method
    public String getCustID() {
        return custID;
    }
    
    public String getName() {
        return name;
    }
    
    public String getPhoneNum() {
        return phoneNum;
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getPassword() {
        return password;
    }
    
    // setters method
    public void setCustID(String custID) {
        this.custID = custID;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    // update profile method
    public void updateProfile(String address, String password) {
        this.address = address;
        this.password = password;
    }
}
