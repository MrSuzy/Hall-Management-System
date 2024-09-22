/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
}
