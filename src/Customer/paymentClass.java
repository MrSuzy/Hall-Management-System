/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Customer;

import java.util.Date;

/**
 *
 * @author xuen_
 */
public class paymentClass {
    private String paymentID;
    private String bookingID;
    private double totalAmount;
    private Date paymentDate;
    private String paymentMethod;
    
    // constructor
    public paymentClass(String paymentID, String bookingID, double totalAmount, Date paymentDate, String paymentMethod) {
        this.paymentID = paymentID;
        this.bookingID = bookingID;
        this.totalAmount = totalAmount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
    }
    
    // getters method
    public String getPaymentID() {
        return paymentID;
    }
    
    public String getBookingID() {
        return bookingID;
    }
    
    public double getTotalAmount() {
        return totalAmount;
    }
    
    public Date getPaymentDate() {
        return paymentDate;
    }
    
    public String getPaymentMethod() {
        return paymentMethod;
    }
    
    
    // setters method
    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }
    
    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }
    
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
    
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    

}
