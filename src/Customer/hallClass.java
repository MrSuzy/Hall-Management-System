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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xuen_
 */
public class hallClass {
    private String hallID;
    private String hallName;
    private String hallType;
    private double price;
    private int capacity;
    private String availability;
    
    public hallClass(String hallID, String hallName, String hallType, double price, String availability) {
        this.hallID = hallID;
        this.hallName = hallName;
        this.hallType = hallType;
        this.price = price;
        this.capacity = capacity;
        this.availability = availability;
    }
    
    // getters method
    public String getHallID() {
        return hallID;
    }
    
    public String getHallName() {
        return hallName;
    }
    
    public String getHallType() {
        return hallType;
    }
    
    public double getPrice() {
        return price;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    public String getAvailabilty() {
        return availability;
    }
    
    // setters method 
    public void setHallID(String hallID) {
        this.hallID = hallID;
    }
    
    public void setHallName(String hallName) {
        this.hallName = hallName;
    }
    
    public void setHallType(String hallType) {
        this.hallType = hallType;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public void setAvailabiliy(String availability) {
        this.availability = availability;
    }
    
    // hall booking method
    public void book() {
        if(this.availability.equals("Available")) {
            this.availability = "Booked";
            updateAvailability();
        }
    }
    
    public void cancel() {
        if(this.availability.equals("Booked")) {
            this.availability = "Available";
            updateAvailability();
        }
    }
    
    private void updateAvailability() {
        List<hallClass> halls = new ArrayList<>();
        try{
            FileReader fr = new FileReader("halls.txt");
            BufferedReader br = new BufferedReader(fr);
            String read;
            while((read = br.readLine()) != null) {
                String[] details = read.split(";");
                if (details.length == 6) {
                    String hallID = details[0];
                    String hallName = details[1];
                    String hallType = details[2];
                    double price = Double.parseDouble(details[3]);
                    int capacity = Integer.parseInt(details[4]);
                    String availability = details[5];
                    
                    if (hallID.equals(this.hallID) && hallName.equals(this.hallName)) {
                        // update the availability column
                        halls.add(new hallClass(hallID, hallName, hallType, price, availability));
                    } else {
                        halls.add(new hallClass(hallID, hallName, hallType, price, availability));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error." + e.getMessage());
        }
        
        
        // write the updated ArrayList into the text file 
        try{
            FileWriter fw = new FileWriter("halls.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (hallClass hall : halls) {
                bw.write(hall.getHallID() + ";" + hall.getHallName() + ";" + hall.getHallType() + ";" + hall.getPrice() + ";" + hall.getCapacity() + ";" + hall.getAvailabilty());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
    }
}
