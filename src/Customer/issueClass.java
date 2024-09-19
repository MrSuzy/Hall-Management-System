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
}
