/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Scheduler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Huawei
 */
public class maintenanceClass {
    private String hallID;
    private Date maintenanceDate;
    private Date startTime;
    private Date endTime;
    private String remarks;


    public maintenanceClass(String hallID, Date maintenanceDate, Date startTime, Date endTime, String remarks) {
        this.hallID = hallID;
        this.maintenanceDate = maintenanceDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.remarks = remarks;
    }
    
    public maintenanceClass() {
        // Empty Constructor
    }
    
    public String createMaintenanceRecord(String hallID, Date maintenanceDate, Date startTime, Date endTime, String remarks) {
    String fileName = "maintenance.txt";
    
    // Set up date formats
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
    
    // Format the dates
    String formattedDate = dateFormat.format(maintenanceDate);
    String formattedStartTime = timeFormat.format(startTime);
    String formattedEndTime = timeFormat.format(endTime);
    
    // Prepare the content
    String content = hallID + ";" + formattedDate + ";" + formattedStartTime + ";" + formattedEndTime + ";" + remarks + System.lineSeparator();

    // Write to the file
    try (FileWriter writer = new FileWriter(fileName, true)) {
        writer.write(content);
        return "success";
    } catch (IOException e) {
        e.printStackTrace();
        return "error";
    }
}
}
