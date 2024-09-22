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
public class bookingClass {
    private String bookingID;
    private String email;
    private String hallID;
    private Date bookingDate;
    private Date startTime;
    private Date endTime;
    private String paymentMethod;
    private String paymentStatus;
    
    // date formatter 
    private static final SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    
    // time formatter 
    private static final SimpleDateFormat time = new SimpleDateFormat("HH:mm");
    
    
    // constructor
    public bookingClass(String bookingID, String email, String hallID, Date bookingDate, Date startTime, Date endTime, String paymentMethod, String paymentStatus) {
        this.bookingID = bookingID;
        this.email = email;
        this.hallID = hallID;
        this.bookingDate = bookingDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }
    
    // getters method 
    public String getBookingID() {
        return bookingID;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getHallID() {
        return hallID;
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
    
    public String getPaymentMethod() {
        return paymentMethod;
    }
    
    public String getPaymentStatus() {
        return paymentStatus;
    }
    
    // setters method
    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setHallID(String hallID) {
        this.hallID = hallID;
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
    
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
           
    // perform booking and write details into text file 
    public static void performBooking(String hallID, Date bookingDate, Date startTime, Date endTime, String email, String paymentMethod) {
        String bookingID = generateBookingID();
        String paymentStatus = "Paid";
        double price = 0.0;
        
        System.out.println("Hall ID: " + hallID);
        System.out.println("Booking Date: " + bookingDate);
        System.out.println("Start time: " + startTime);
        System.out.println("End time: " + endTime);
        System.out.println("Email: " + email);
        System.out.println("Payment method: " + paymentMethod);
        
        StringBuilder hall = new StringBuilder(); // to store contents
        
        try{
            FileReader fr = new FileReader("hall.txt");
            BufferedReader br = new BufferedReader(fr);
            String read;
            
            while ((read = br.readLine()) != null) {
                String[] details = read.split(";");
                if (details[0].equals(hallID)) {
                    price = Double.parseDouble(details[2]);
                    details[3] = date.format(bookingDate);
                    details[4] = time.format(startTime);
                    details[5] = time.format(endTime);
                    details[7] = "Booked";
                    
                    hall.append(String.join(";", details)).append(System.lineSeparator());
                } else {
                    hall.append(read).append(System.lineSeparator());
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading hall.txt" + e.getMessage());
            return;
        }
        
        // write to hall.txt
        try{
            FileWriter fw = new FileWriter("hall.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(hall.toString());
            bw.flush();
        } catch (IOException e) {
            System.out.println("Error writing to hall.txt" + e.getMessage());
            }
        
        // update selected booked hall to booking.txt
        try{
            FileWriter fw = new FileWriter("booking.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write(bookingID + ";" + email + ";" + hallID + ";" + date.format(bookingDate) + ";" + time.format(startTime) + ";" + time.format(endTime) + ";" + price + ";" + paymentMethod + ";" + paymentStatus);
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            System.out.println("Error writing to booking.txt" + e.getMessage());
        }
    }
    
    // auto generate booking ID method
    private static String generateBookingID() {
        String bookingIDPrefix = "B";
        int lastNumber = 0;
        
        // find highest existing bookingID in booking.txt 
        try{
            FileReader fr = new FileReader("booking.txt");
            BufferedReader br = new BufferedReader(fr);
            String read;
            
            while ((read = br.readLine()) != null) {
                String[] details = read.split(";");
                String currentBookingID = details[0];
                if (currentBookingID.startsWith(bookingIDPrefix)) {
                    // convert to int of the extracted number
                    int LastNumber = Integer.parseInt(currentBookingID.substring(1));
                    
                    // update lastNumber if LastNumber is higher
                    if (LastNumber > lastNumber) {
                        lastNumber = LastNumber;
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading booking.txt" + e.getMessage());
        }
        
        lastNumber++;
        
        return String.format("B%03d", lastNumber);
    }
    
    // view upcoming and past bookings method 
    public static List<String[]> viewBooking(boolean isUpcoming, String loggedInEmail) {
        List<String[]> booking = new ArrayList<>();
        Date currentDate = new Date();
        
        try{
            FileReader fr = new FileReader("booking.txt");
            BufferedReader br = new BufferedReader(fr);
            String read;
            
            while ((read = br.readLine()) != null) {
                String[] details = read.split(";");
                
                // filter email
                if (!details[1].equals(loggedInEmail)) {
                    continue;
                }
                
                Date bookingDate = date.parse(details[3]);
                Date startTime = time.parse(details[4]);
                
                // combine date and time 
                long bookingDateTime = bookingDate.getTime() + startTime.getTime();
                
                // compare with current DateTime
                if (isUpcoming && bookingDateTime > currentDate.getTime()) {
                    booking.add(details);
                } else if (!isUpcoming && bookingDateTime < currentDate.getTime()) {
                    booking.add(details);
                }
            }
        } catch (IOException | ParseException e) {
            System.out.println("Error reading booking.txt" + e.getMessage());
        }
        return booking;
    }
    
    public static void cancelBooking(String bookingID, String loggedInEmail) {
        StringBuilder booking = new StringBuilder();
        boolean found = false;
        String hallID = "";
        
        try{
            FileReader fr = new FileReader("booking.txt");
            BufferedReader br = new BufferedReader(fr);
            String read;
            
            while ((read = br.readLine()) != null) {
                String[] details = read.split(";");
                
                
                if (details[0].equals(bookingID) && details[1].equals(loggedInEmail)) {
                    System.out.println("Booking matched for ID: " + bookingID);
                    Date bookingDate = date.parse(details[3]);
                    Date startTime = time.parse(details[4]);
                    Date currentDate = new Date();
                    
                    
                    long bookingDateTime = bookingDate.getTime() + startTime.getTime();
                    long currentDateTime = currentDate.getTime();
                    
                    
                    // calculate the difference in days 
                    long diffMS = bookingDate.getTime() - currentDate.getTime();
                    long diffDays = diffMS / (1000 * 60 * 60 * 24);
                    
                    
                    // check if booking is upcoming and not cancelled
                    if (bookingDateTime > currentDateTime && !details[8].equals("Cancelled")) {
                        if (diffDays >= 3) {
                        details[8] = "Cancelled";
                        found = true;
                            System.out.println("Booking cancelled success");
                        } else {
                            System.out.println("Cancellation must be at least 3 days before booking date");
                        }
                    } else if (details[8].equals("Cancelled")) {
                        System.out.println("The selected booking has already been cancelled");
                    }
                }
                booking.append(String.join(";", details)).append(System.lineSeparator());
            }
        } catch (IOException | ParseException e) {
            System.out.println("Error reading booking.txt" + e.getMessage());
            return;
        }
        
        if (found) {
            try{
                FileWriter fw = new FileWriter("booking.txt");
                BufferedWriter bw = new BufferedWriter(fw);
                
                bw.write(booking.toString());
                bw.flush();
                System.out.println("Booking cancelled successfully");
            } catch (IOException e) {
                System.out.println("Error writing booking.txt" + e.getMessage());
            }
            
            // change back to 'available' in hall.txt
            try{
                FileReader fr = new FileReader("hall.txt");
                BufferedReader br = new BufferedReader(fr);
                StringBuilder hall = new StringBuilder();
                String read;
                
                while ((read = br.readLine()) != null) {
                    String[] details = read.split(";");
                    
                    // checking for matching hallID with selected one
                    if (details[0].equals(hallID)) {
                        details[3] = "N/A";
                        details[4] = "N/A";
                        details[5] = "N/A";
                        details[7] = "Available";
                        System.out.println("Hall is available to book again");
                    }
                    
                    hall.append(String.join(";", details)).append(System.lineSeparator());
                }
                br.close();
                
                FileWriter fw = new FileWriter("hall.txt");
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(hall.toString());
                bw.flush();
                bw.close();
                System.out.println("Updated hall.txt successfully");
            } catch (IOException e) {
                System.out.println("Error writing hall.txt" + e.getMessage());
            }
        } else {
            System.out.println("No such booking found.");
        }
    }


}


 