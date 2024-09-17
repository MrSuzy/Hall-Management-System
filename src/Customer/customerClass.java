/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Customer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author xuen_
 */
public class customerClass {
    private String name;
    private String email;
    private String address;
    private String password;
    private String role;
    
    public customerClass(String name, String email, String address, String password, String role) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.password = password;
        this.role = role;
    }
    
    // getters method
    public String getName() {
        return name;
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getRole() {
        return role;
    }
    
    // setters method  
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
    
    public void setRole(String role) {
        this.role = role;
    }
    
    // update to text file 
    public void customerRecord() {
        try{
            FileWriter fw = new FileWriter("users.txt", true);
            fw.write(name + "," + address + "," + email + "," + password + "," + role + "\n");
        } catch (IOException e) {
            System.out.println("Exception error." + e.getMessage());

        }
    }
    
    // user authentication method 
    public static customerClass authenticate(String email, String password) {
        try{
            FileReader fr = new FileReader("users.txt");
            BufferedReader br = new BufferedReader(fr);
            String read;
            while ((read = br.readLine()) != null) {
                String[] details = read.split(",");
                if(details[3].equals(email) && details[4].equals(password)) {
                    return new customerClass(details[0], details[1], details[2], details[3], details[4]);
                }
            }           
        } catch (IOException e) {
            System.out.println("Exception error." + e.getMessage());
        }
        return null;
    }
    
}
