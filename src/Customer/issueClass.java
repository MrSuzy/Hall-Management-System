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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author xuen_
 */
public class issueClass {
    private String issueID;
    private String bookingID;
    private Date issueDate;
    private String issueDescription;
    private String issueStatus;
    private String scheduler;
    
    // format the date
    private static final SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public issueClass(String issueID, String bookingID, Date issueDate, String issueDescription, String issueStatus, String scheduler) {
        this.issueID = issueID;
        this.bookingID = bookingID;
        this.issueDate = issueDate; //set current date 
        this.issueDescription = issueDescription;
        this.issueStatus = issueStatus;
        this.scheduler = scheduler;
    }
    
    // getters method
    public String getIssueID() {
        return issueID;
    }
    
    public String getBookingID() {
        return bookingID;
    }
    
    public Date getIssueDate() {
        return issueDate;
    }
    
    public String getIssueDescription() {
        return issueDescription;
    }
    
    public String getIssueStatus() {
        return issueStatus;
    }
    
    public String getScheduler() {
        return scheduler;
    }
    
    // setters method 
    public void setIssueID(String issueID) {
        this.issueID = issueID;
    }
    
    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }
    
    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }
    
    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }
    
    public void setIssueStatus(String issueStatus) {
        this.issueStatus = issueStatus;
    }
    
    public void setScheduler(String scheduler) {
        this.scheduler = scheduler;
    }
    
    // raise issue method 
    public static void raiseIssue(String bookingID, String issueDescription) {
        String issueID = generateIssueID();
        String issueDate = date.format(new Date());
        String issueStatus = "Open";
        String scheduler = "na";
        
        try{
            FileWriter fw = new FileWriter("issue.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write(issueID + ";" + bookingID + ";" + issueDate + ";" + issueDescription + ";" + issueStatus + ";" + scheduler);
            bw.newLine();
            bw.flush();
            System.out.println("Issue raised sucessfully");
        } catch (IOException e) {
            System.out.println("Error writing issue.txt" + e.getMessage());
        }
    }
    
    private static String generateIssueID() {
        String issueIDPrefix = "I";
        int lastNumber = 0;
        
        // check for highest number of Payment ID in payment.txt
        try{
            FileReader fr = new FileReader("issue.txt");
            BufferedReader br = new BufferedReader(fr);
            String read;
            
            while ((read = br.readLine()) != null) {
                String[] details = read.split(";");
                String currentIssueID = details[0];
                
                if (currentIssueID.startsWith(issueIDPrefix)) {
                    // ccnvert to integer
                    int LastNumber = Integer.parseInt(currentIssueID.substring(1));
                    
                    // update lastNumber if LastNumber is higher
                    if (LastNumber > lastNumber) {
                        lastNumber = LastNumber;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading payment.txt" + e.getMessage());
        }
        
        lastNumber++;
        
        return String.format("I%03d", lastNumber);
    }
}

