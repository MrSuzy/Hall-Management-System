/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Customer;

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
    
    public int capacity() {
        return capacity;
    }
    
    public String availabilty() {
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
}
