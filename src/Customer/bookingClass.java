/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Customer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

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
    
    // payment method 
    public void payment() {
        this.paymentStatus = "Paid";
        updateBooking();
    }
    
    public void cancelPayment() {
        this.paymentStatus = "Cancelled";
        updateBooking();
    }
    
    private void updateBooking() {
        try{
            FileWriter fw = new FileWriter("bookings.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write(bookingID + ";" + email + ";" + hallID + ";" + bookingDate + ";" + paymentStatus);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
    }
}
