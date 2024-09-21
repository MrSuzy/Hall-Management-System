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
       
    // view and filter booking method 
    public static List<bookingClass> viewBooking(String email, boolean upcoming) {
        List<bookingClass> viewBooking = new ArrayList<>();
        Date currentDate = new Date(); // current date
        
        try{
            FileReader fr = new FileReader("bookings.txt");
            BufferedReader br = new BufferedReader(fr);
            String read;
            
            while ((read = br.readLine()) != null) {
                String[] details = read.split(";");
                if (details.length == 8) {
                    String bookingID = details[0];
                    String Email = details[1];
                    String hallID = details[2];
                    Date bookingDate = date.parse(details[3]);
                    Date startTime = date.parse(details[4]);
                    Date endTime = date.parse(details[5]);
                    String paymentMethod = details[6];
                    String paymentStatus = details[7];
                    
                    if (Email.equals(email)) {
                        if(upcoming && bookingDate.after(currentDate)) {
                            viewBooking.add(new bookingClass(bookingID, email, hallID, bookingDate, startTime, endTime, paymentMethod, paymentStatus));
                        } else if (!upcoming && bookingDate.before(currentDate)) {
                            viewBooking.add(new bookingClass(bookingID, email, hallID, bookingDate, startTime, endTime, paymentMethod, paymentStatus));
                        }
                    }
                    
                }
            }
        } catch (IOException | ParseException e) {
            System.out.println("Error" + e.getMessage());
        }
        return viewBooking;
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
        System.out.println("Payment method: paymentMethod");
        
        try{
            FileReader fr = new FileReader("hall.txt");
            BufferedReader br = new BufferedReader(fr);
            String read;
            
            while ((read = br.readLine()) != null) {
                String[] details = read.split(";");
                if (details[0].equals(hallID)) {
                    price = Double.parseDouble(details[2]);
                    System.out.println("Price of hall" + hallID + "is: " + price);
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
            return;
        }
        
        try{
            FileWriter fw = new FileWriter("bookings.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write(bookingID + ";" + email + ";" + hallID + ";" + date.format(bookingDate) + ";" + time.format(startTime) + ";" + time.format(endTime) + ";" + price + ";" + paymentMethod + ";" + paymentStatus);
            bw.newLine();
            System.out.println("Booking written success");
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
    }
    
    // auto generate booking ID method
    private static String generateBookingID() {
        return "B" + System.currentTimeMillis();
    }
    
    // cancel booking method
    public void cancelBooking() {
        Date currentDate = new Date(); //set current date
        
        // check if date is at least 3 days in future 
        long timeDiff = bookingDate.getTime() - currentDate.getTime();
        long dayDiff = timeDiff / (1000 * 60 * 60 * 24); //convert ms to days
        
        if (dayDiff >= 3 && this.paymentStatus.equals("Paid")) {
            this.paymentStatus = "Cancelled";
            
            List<bookingClass> booking = new ArrayList<>();
            
            try{
                FileReader fr = new FileReader("bookings.txt");
                BufferedReader br = new BufferedReader(fr);
                String read;
                
                while ((read = br.readLine()) != null) {
                    String[] details = read.split(";");
                    if (details.length == 8) {
                        String bookingID = details[0];
                        String email = details[1];
                        String hallID = details[2];
                        Date bookingDate = date.parse(details[3]);
                        Date startTime = time.parse(details[4]);
                        Date endTime = time.parse(details[5]);
                        String paymentMethod = details[6];
                        String paymentStatus = details[7];
                        
                        if (this.bookingID.equals(bookingID)) {
                            booking.add(new bookingClass(bookingID, email, hallID, bookingDate, startTime, endTime, paymentMethod, this.paymentStatus));
                        } else {
                            booking.add(new bookingClass(bookingID, email, hallID, bookingDate, startTime, endTime, paymentMethod, paymentStatus));
                        }
                    }
                }
            } catch (IOException | ParseException e) {
                System.out.println("Error" + e.getMessage());
            }
            
            try{
                FileWriter fw = new FileWriter("bookings.txt");
                BufferedWriter bw = new BufferedWriter(fw);
                
                for (bookingClass bookings : booking) {
                    bw.write(bookings.getBookingID() + ";" + bookings.getEmail() + ";" + bookings.getHallID() + ";" + date.format(bookings.getBookingDate()) + ";" + time.format(bookings.getStartTime()) + ";" + time.format(bookings.getEndTime()) + ";" + bookings.getPaymentMethod() + ";" + bookings.getPaymentStatus());
                    bw.newLine();
                }
            } catch (IOException e) {
                System.out.println("Error" + e.getMessage());
            }
        }
    }
    

}
 