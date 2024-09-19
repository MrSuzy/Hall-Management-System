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
    private String paymentStatus;
    
    // date formatter 
    private static final SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    
    
    // constructor
    public bookingClass(String bookingID, String email, String hallID, Date bookingDate, String paymentStatus) {
        this.bookingID = bookingID;
        this.email = email;
        this.hallID = hallID;
        this.bookingDate = bookingDate;
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
                if (details.length == 5) {
                    String bookingID = details[0];
                    String Email = details[1];
                    String hallID = details[2];
                    Date bookingDate = date.parse(details[3]);
                    String paymentStatus = details[4];
                    
                    if (Email.equals(email)) {
                        if(upcoming && bookingDate.after(currentDate)) {
                            viewBooking.add(new bookingClass(bookingID, email, hallID, bookingDate, paymentStatus));
                        } else if (!upcoming && bookingDate.before(currentDate)) {
                            viewBooking.add(new bookingClass(bookingID, email, hallID, bookingDate, paymentStatus));
                        }
                    }
                    
                }
            }
        } catch (IOException | ParseException e) {
            System.out.println("Error" + e.getMessage());
        }
        return viewBooking;
    }
    
    // cancel booking method
    public void cancelBooking() {
        Date currentDate = new Date(); //set current date
        
        // check if date is at least 3 days in future 
        long timeDiff = bookingDate.getTime() - currentDate.getTime();
        long dayDiff = timeDiff / (1000 * 60 * 60 * 24); //convert ms to days
        
        if (dayDiff >= 3 && this.paymentStatus.equals("Paid")) {
            this.paymentStatus = "Cancelled";
            recordBooking();
            System.out.println("Booking cancelled.");
        } else {
            System.out.println("Cancel failed. Booking must be at least 3 days before booking date.");
        }
    }
    
    // update to booking.txt file 
    private void recordBooking() {
        List<bookingClass> booking = new ArrayList();
        
        // read existing records in booking.txt
        try{
            FileReader fr = new FileReader("booking.txt");
            BufferedReader br = new BufferedReader(fr);
            String read;
            
            while((read = br.readLine()) != null) {
                String[] details = read.split(";");
                if (details.length == 5) {
                    String bookingID = details[0];
                    String email = details[1];
                    String hallID = details[2];
                    Date bookingDate = date.parse(details[3]);
                    String paymentStatus = details[4];
                    
                    if (this.bookingID.equals(bookingID)) {
                        booking.add(this); //update the record
                    } else {
                        booking.add(new bookingClass(bookingID, email, hallID, bookingDate, paymentStatus));
                    }
                }
            }
        } catch (IOException | ParseException e) {
            System.out.println("Error" + e.getMessage());
        }
        
        // write the file with the updated records
        try{
            FileWriter fw = new FileWriter("booking.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (bookingClass updatedBooking : booking) {
                bw.write(updatedBooking.bookingID + ";" + updatedBooking.email + ";" + date.format(updatedBooking.bookingDate) + ";" + updatedBooking.paymentStatus);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
    }
}
 