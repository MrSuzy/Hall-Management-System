/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author khaientiew
 */
public class managerMaintenanceClass {
    
    public ArrayList<String[]> readIssues() {
        ArrayList<String[]> IssueList = new ArrayList<>();
        File file = new File("issue.txt");
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] bookingDetails = line.split(";");
                IssueList.add(bookingDetails);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return IssueList;
    }
    
    public ArrayList<String[]> filterIssue(String type) {
        ArrayList<String[]> filteredList = new ArrayList<>();
        
        // read all txt
        ArrayList<String[]> allissue = readIssues();
        
        // filter 
        for (String[] issue : allissue) {
            String issueStatus = issue[4];
            // switch case to filter
            switch(type) {
                case "Open":
                    if (issueStatus.equalsIgnoreCase("Open")) {
                        filteredList.add(issue);
                    }
                    break;
                case "InProgress":
                    if (issueStatus.equalsIgnoreCase("InProgress")) {
                        filteredList.add(issue);
                    }
                    break;
                case "Done":
                    if (issueStatus.equalsIgnoreCase("Done")) {
                        filteredList.add(issue);
                    }
                    break;
                case "Closed":
                    if (issueStatus.equalsIgnoreCase("Closed")) {
                        filteredList.add(issue);
                    }
                    break;
                case "Cancelled":
                    if (issueStatus.equalsIgnoreCase("Cancelled")) {
                        filteredList.add(issue);
                    }
                    break;
                case "all":
                default:
                    filteredList.add(issue);
                    break;
            }
        }
        return filteredList;
    }
    
    
}
