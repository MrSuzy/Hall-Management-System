/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author khaientiew
 */
public class managerSalesClass {
    private String hallID;
    private Date bookingDate;
    private String price;
    private String paymentStatus;
    private List<String[]> salesdata = new ArrayList<>();
    
    
    public List<String[]> processSalesData(String filterValue, String filterType) {
    String bookingFile = "bookings.txt";
    String salesFile = "sales.txt";
    List<String[]> filteredSalesData = new ArrayList<>();
    List<String[]> salesData = new ArrayList<>();

    // Read Booking File and process data
    try {
        FileReader bookingreader = new FileReader(bookingFile);
        BufferedReader bookingReader = new BufferedReader(bookingreader);
        String read;
        
        while ((read = bookingReader.readLine()) != null) {
            String[] readSplit = read.split(";");
            String hallID = readSplit[2]; 
            String bookingDate = readSplit[3];
            String price = readSplit[6];
            String paymentStatus = readSplit[8];
            
            if (paymentStatus.equalsIgnoreCase("Paid")) {
                salesData.add(new String[]{hallID, bookingDate, price});
            }
        }

        // Store data to sales.txt
        try {
            FileWriter saleswriter = new FileWriter(salesFile, true);
            BufferedWriter salesWriter = new BufferedWriter(saleswriter);
            for (String[] sale : salesData) {
                salesWriter.write(String.join(";", sale) + "\n");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

    } catch (IOException e) {
        e.printStackTrace();
    }

    // Load data from sales.txt
    try
    {
        FileReader salesreader = new FileReader(salesFile);
        BufferedReader salesReader = new BufferedReader(salesreader);
        String read;

        while ((read = salesReader.readLine()) != null) {
            String[] splitData = read.split(";");
            salesData.add(splitData);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    // Filter data
    filteredSalesData = salesData.stream()
        .filter(sale -> {
            String[] dateParts = sale[1].split("-");
            switch (filterType.toLowerCase()) {
                case "day":
                    return sale[1].equals(filterValue); // YYYY-MM-DD
                case "month":
                    return dateParts[0].equals(filterValue.substring(0, 4)) && dateParts[1].equals(filterValue.substring(5, 7)); // YYYY-MM
                case "year":
                    return dateParts[0].equals(filterValue); // YYYY
                default:
                    return false;
            }
        })
        .collect(Collectors.toList());

    return filteredSalesData; // Return the filtered sales data
}
}


