/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Customer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JTextArea;

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
    
    private static final SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    // constructor
    public paymentClass(String paymentID, String bookingID, double totalAmount, Date paymentDate, String paymentMethod) {
        this.paymentID = paymentID;
        this.bookingID = bookingID;
        this.totalAmount = totalAmount;
        this.paymentDate = new Date();
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
    
// perform payment method
public void performPayment() {
    this.paymentDate = new Date(); // set current date as payment date
    recordPayment();
    displayReceipt();
}

// record payment method
public void recordPayment() {
    try{
        FileWriter fw = new FileWriter("payment.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(paymentID + ";" + bookingID + ";" + date.format(paymentDate) + ";" + totalAmount + ";" + paymentMethod);
    } catch (IOException e) {
        System.out.println("Error" + e.getMessage());
    }
}

// display receipt details method
public void displayReceipt() {
    JFrame frame = new JFrame("Payment Receipt");
    JTextArea area = new JTextArea();
    area.setText("Payment ID: " + paymentID + "\nBooking ID: " + bookingID + "\nTotal Amount: " + totalAmount + "\nPayment Date: " + date.format(paymentDate) + "\nPayment Method: " + paymentMethod);
    area.setEditable(false);
    frame.add(area);
    frame.setSize(300, 200);
    frame.setVisible(true);
}

   
    
    

}
