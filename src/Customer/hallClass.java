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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author xuen_
 */
public class hallClass {
    private String hallID;
    private String hallType;
    private double price;
    private Date bookingDate;
    private Date startTime;
    private Date endTime;
    private int capacity;
    private String availability;
    
    // date formatter
    private static final SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    
    // time formatter
    private static final SimpleDateFormat time = new SimpleDateFormat("HH:mm");
    
    public hallClass(String hallID, String hallType, double price, Date bookingDate, Date startTime, Date endtime, int capacity, String availability) {
        this.hallID = hallID;
        this.hallType = hallType;
        this.price = price;
        this.bookingDate = bookingDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.capacity = capacity;
        this.availability = availability;
    }
    
    // getters method
    public String getHallID() {
        return hallID;
    }
    
    public String getHallType() {
        return hallType;
    }
    
    public double getPrice() {
        return price;
    }
    
    public Date getBookingDate() {
        return bookingDate;
    }
    
    public Date getStartTime() {
        return startTime;
    }
    
    public Date getEndTime() {
        return endTime;
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
    
    public void setHallType(String hallType) {
        this.hallType = hallType;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }
    
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public void setAvailabiliy(String availability) {
        this.availability = availability;
    }
    
    
    // check hall availabilty before booking method 
    public static List<String> hallAvailability(Date selectedDate, String selectedStartTime, String selectedEndTime, String hallType) {
        List<String> available = new ArrayList<>();
        
        try{
            FileReader fr = new FileReader("hall.txt");
            BufferedReader br = new BufferedReader(fr);
            String read;
            
            while ((read = br.readLine()) != null) {
                String[] details = read.split(";");
                if (details.length == 8) {
                    String hallID = details[0];
                    String type = details[1];
                    String availability = details[7];
                    
                    // parse date and time 
                    Date bookingDate = details[3].equals("N/A") ? null : date.parse(details[3]);
                    Date startTime = details[4].equals("N/A") ? null : time.parse(details[4]);
                    Date endTime = details[5].equals("N/A") ? null : time.parse(details[5]);
                    
                    // check if hall is available
                    if (type.equals(hallType) && availability.equals("Available")) {
                        // check date first
                        if (bookingDate == null || !bookingDate.equals(selectedDate)) {
                            available.add(hallID);
                        } else {
                            Date requestedStartTime = time.parse(selectedStartTime);
                            Date requestedEndTime = time.parse(selectedEndTime);
                            
                            // check time clash
                            if (requestedEndTime.before(startTime) || requestedStartTime.after(endTime)) {
                                available.add(hallID);
                            }
                        }
                    }
                }
            }
        } catch (IOException | ParseException e) {
            System.out.println("Error" + e.getMessage());
        }
        return null;
    }
    
    // write updated availability to text file after booking
    public static void updatedAvailability(String hallID, Date bookingDate, Date startTime, Date endTime) {
        List<hallClass> hall = new ArrayList<>();
        try{
            FileReader fr = new FileReader("hall.txt");
            BufferedReader br = new BufferedReader(fr);
            String read;
            
            while ((read = br.readLine()) != null) {
                String[] details = read.split(";");
                if (details.length == 8) {
                    String HallID = details[0];
                    String hallType = details[1];
                    double price = Double.parseDouble(details[2]);
                    Date selectedBookingDate = date.parse(details[3]);
                    Date selectedStartTime = time.parse(details[4]);
                    Date selectedEndTime = time.parse(details[5]);
                    int capacity = Integer.parseInt(details[6]);
                    String availability = details[7];
                    
                    if (HallID.equals(hallID)) {
                        hall.add(new hallClass(HallID, hallType, price, selectedBookingDate, selectedStartTime, selectedEndTime, capacity, "Booked"));
                    } else {
                        hall.add(new hallClass(HallID, hallType, price, selectedBookingDate, selectedStartTime, selectedEndTime, capacity, availability));
                    }
                }
            }
        } catch (IOException | ParseException e) {
            System.out.println("Error" + e.getMessage());
        }
        
        try{
            FileWriter fw = new FileWriter("hall.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (hallClass halls : hall) {
                bw.write(halls.getHallID() + ";" + halls.getHallType() + ";" + halls.getPrice() + ";" + date.format(halls.getBookingDate()) + ";" + time.format(halls.getStartTime()) + ";" + time.format(halls.getEndTime()) + ";" + halls.getCapacity() + ";" + halls.getAvailabilty());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
    } 

    
}
