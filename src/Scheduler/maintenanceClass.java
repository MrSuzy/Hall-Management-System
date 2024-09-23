/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Scheduler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
        String content = hallID + ";" + maintenanceDate + ";" + startTime + ";" + endTime + ";" + remarks + System.lineSeparator();
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(content);
            return "success"; // Indicate that the record was saved successfully
        } catch (IOException e) {
            e.printStackTrace();
            return "error"; // Indicate that there was an error saving the record
        }
    }
}
