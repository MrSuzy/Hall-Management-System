/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Scheduler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public void clearPastMaintenanceRecords() {
        String fileName = "maintenance.txt";
        String tempFileName = "maintenance_temp.txt";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFileName))) {
            String line;
            Date today = new Date(); // Get current date

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length < 5) continue; // Skip if the line is not valid

                String dateStr = parts[1]; // Date is the second part
                Date maintenanceDate = dateFormat.parse(dateStr);

                // Check if the maintenance date is today or in the future
                if (!maintenanceDate.before(today)) {
                    writer.write(line); // Write the valid record to the temporary file
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        // Delete the old file and rename the temp file
        new java.io.File(fileName).delete();
        new java.io.File(tempFileName).renameTo(new java.io.File(fileName));
    }
}
