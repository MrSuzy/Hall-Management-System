/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartPanel;
//import org.jfree.chart.JFreeChart;
//import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author xuen_
 */
public class managerClass {
    private String name;
    private String phoneNum;
    private String email;
    private String password;
    private String status;
    private String role;  
    
    public managerClass(String name, String phoneNum, String email, String password, String status, String role) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
        this.password = password;
        this.status = status;
        this.role = role;
    }
    
    // getters method
    public String getName() {
        return name;
    }
    
    public String getPhoneNum() {
        return phoneNum;
    }
    
     public String getEmail() {
        return email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getStatus() {
        return status;
    }
    
    public String getRole() {
        return role;
    }
    
    // setters method  
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    public void salesdata(){
        String bookingFile = "booking.txt";
        String paymentFile = "payment.txt";
        String salesFile = "sales.txt";

        // Map to store hall sales data
        Map<String, Double> hallSales = new HashMap<>();

        // Read booking data (booking_id, hall_id)
        Map<String, String> bookingData = new HashMap<>();

        //Read Booking File from Customer
        try {
            FileReader bookingreader = new FileReader(bookingFile);
            BufferedReader bookingReader = new BufferedReader(bookingreader);
            String read;
            while ((read = bookingReader.readLine()) != null) {
                String[] readSplit = read.split(";");
                String booking_id = readSplit[0]; 
                String customer_id = readSplit[1];
                String hall_id = readSplit[2];
                String booking_date = readSplit[3];
                String payment_status = readSplit[4];
                bookingData.put(hall_id, booking_id);
            }
            
        } catch (IOException e) {
            System.out.println("Error:" + e.getMessage());
        }

        // Read payment data (booking_id, amount)
        try {
            FileReader paymentreader = new FileReader(paymentFile);
            BufferedReader paymentReader = new BufferedReader(paymentreader);
            String read;
            while ((read = paymentReader.readLine()) != null) {
                String[] splitData = read.split(";"); 
                String payment_id = splitData[0];
                String booking_id = splitData[1];
                String payment_date = splitData[2];
                String amountStr = splitData[3];  
                String payment_Method = splitData[4];
                
                //change amount from string to double
                double amount = Double.parseDouble(amountStr);

                // Find corresponding hall_id from bookingData
                String hall_id = bookingData.get(booking_id);
                if (hall_id != null) {
                    hallSales.put(hall_id, hallSales.getOrDefault(hall_id, 0.0) + amount);
                }
            }
        } catch (IOException e) {
            System.out.println("Error:" + e.getMessage());
        }

        // store data
        try {
            FileWriter saleswriter = new FileWriter(salesFile);
            BufferedWriter salesWriter = new BufferedWriter(saleswriter);
            for (Map.Entry<String, Double> entry : hallSales.entrySet()) {
                salesWriter.write(entry.getKey() + entry.getValue() + "\n");
            }
            System.out.println("Sales data successfully written to " + salesFile);
        } catch (IOException e) {
            System.out.println("Error:" + e.getMessage());
        }
    }
}
    
    /*
    public void saleschart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader("sales.txt"))) {
            while ((line = br.readLine()) != null) {
                // Assume sales.txt has "date,salesAmount"
                String[] parts = line.split(",");
                String date = parts[0];
                double salesAmount = Double.parseDouble(parts[1]);

                dataset.addValue(salesAmount, "Sales", date);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        JFreeChart chart = ChartFactory.createBarChart(
            "Sales Chart",
            "Date",
            "Sales Amount",
            dataset
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        JFrame frame = new JFrame("Sales Data");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(chartPanel);
        frame.pack();
        frame.setVisible(true);
       
    }
    
}
*/