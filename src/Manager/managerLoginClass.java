/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

/**
 *
 * @author xuen_
 */
public class managerLoginClass {
    private String name;
    private String phoneNum;
    private String email;
    private String password;
    private String status;
    private String role; 
    
            
    
    public managerLoginClass(String name, String phoneNum, String email, String password, String status, String role) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
        this.password = password;
        this.status = status;
        this.role = role;
    }
    
    // getters method
    public String getName() {
        return name;
    }
    
    public String getPhoneNum() {
        return phoneNum;
    }
    
     public String getEmail() {
        return email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getStatus() {
        return status;
    }
    
    public String getRole() {
        return role;
    }
    
    // setters method  
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public void setRole(String role) {
        this.role = role;
    }  
}
