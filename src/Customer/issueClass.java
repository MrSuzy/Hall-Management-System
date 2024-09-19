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
    private String status;
    
    // format the date
    private static final SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public issueClass(String issueID, String bookingID, String issueDescription) {
        this.issueID = issueID;
        this.bookingID = bookingID;
        this.issueDate = new Date(); //set current date 
        this.issueDescription = issueDescription;
        this.status = "Open";
    }
    
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
    
    public String getStatus() {
        return status;
    }
    
    // raise issue method 
    public void raiseIssue() {
        try{
            FileWriter fw = new FileWriter("issues.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(issueID + ";" + bookingID + ";" + date.format(issueDate) + ";" + issueDescription + ";" + status);
            bw.newLine();
            System.out.println("Issue raised successfully");
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
    }
    
    // update issue status method
    public void updateStatus(String updatedStatus) {
        this.status = updatedStatus;
    }
    
    // write record into text file 
    private void recordIssue() {
        List<String> issue = new ArrayList<>();
        
        // read records from text file 
        try{
            FileReader fr = new FileReader("issues.txt");
            BufferedReader br = new BufferedReader(fr);
            String read;
            
            while ((read = br.readLine()) != null) {
                String[] details = read.split(";");
                if (details.length == 5) {
                    String issueID = details[0];
                    
                    if (issueID.equals(this.issueID)) {
                        details[4] = this.status;
                        read = String.join(";", details);
                    }
                }
            }
            
            issue.add(read);
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
        
        try{
            FileWriter fw = new FileWriter("issues.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (String record : issue) {
                bw.write(record);
                bw.newLine();
            }
            
            System.out.println("Issue is: " + status);
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
    }
}
