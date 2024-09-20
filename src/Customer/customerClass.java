/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Customer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xuen_
 */
public class customerClass {
    private String name;
    private String phoneNum;
    private String email;
    private String password;
    private String currentDateTime;
    private String status;
    private String role;  
    
    public customerClass(String name, String phoneNum, String email, String password,String currentDateTime, String status, String role) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
        this.password = password;
        this.currentDateTime = currentDateTime;
        this.status = status;
        this.role = role;
    }
    
    public customerClass() {
        
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
    
    public String getCurrentDateTime() {
        return currentDateTime;
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
    
    public void setCurrentDatetime(String currentDatetime) {
        this.currentDateTime = currentDateTime;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    // update to text file 
    public void customerRecord() {
        try{
            FileWriter fw = new FileWriter("users.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write(name + ";" + phoneNum + ";" + email + ";" + password + ";" + ";" +  status + ";" + role + ";");
            bw.flush();
        } catch (IOException e) {
            System.out.println("Exception error." + e.getMessage());

        }
    }
    
    public static void updateProfile(customerClass updated) {
        List<customerClass> customer = new ArrayList<>();
        
        // read details from users.txt
        try{
            FileReader fr = new FileReader("users.txt");
            BufferedReader br = new BufferedReader(fr);
            String read;
            
            while ((read = br.readLine()) != null) {
                String[] details = read.split(";");
                if (details.length >= 7) {
                if (details[0].equals(updated.getName())) {
                    customer.add(new customerClass(updated.getName(), updated.getPhoneNum(), updated.getEmail(), updated.getPassword(), details[4], updated.getStatus(), updated.getRole()));
                } else {
                    customer.add(new customerClass(details[0], details[1], details[2], details[3], details[4], details[5], details[6]));
                }
                
            }
            br.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // write the updated profile details into the text file
        try{
            FileWriter fw = new FileWriter("users.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (customerClass updateCustomer : customer) {
                bw.write(updateCustomer.getName() + ";" + updateCustomer.getPhoneNum() + ";" + updateCustomer.getEmail() + ";" + updateCustomer.getPassword() + ";" + updateCustomer.getCurrentDateTime() + ";" + updateCustomer.getStatus() + ";" + updateCustomer.getRole() + ";");
                bw.newLine();
                bw.flush();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
    }
    
}
