package Manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class managerSalesClass {
    private final Set<String> years;        // Set for unique years
    private final Set<String> months;       // Set for unique months
    private final Set<String> days;         // Set for unique days
    
    public managerSalesClass() {
        years = new TreeSet<>();  // TreeSet automatically sorts the years
        months = new TreeSet<>();
        days = new TreeSet<>();
    }
    
    public ArrayList<String[]> readBooking() {
        ArrayList<String[]> bookingList = new ArrayList<>();
        File file = new File("booking.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] bookingDetails = line.split(";");
                bookingList.add(bookingDetails);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading the booking.txt file!", "File Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return bookingList;
    }
    
    public void populateComboBoxes() {
        years.clear(); // Clear previous years
        months.clear(); // Clear previous months
        days.clear(); // Clear previous days
        
        ArrayList<String[]> allBooking = readBooking();
        for (String[] booking : allBooking) {
            String status = booking[8]; // Payment status
            if ("Paid".equals(status)) {
                String[] dateParts = booking[3].split("-");
                years.add(dateParts[0]);  // Year
                months.add(dateParts[1]); // Month
                days.add(dateParts[2]);   // Day
            }
        }
    }
    
    // Populate the year combo box
    public void populateYearCombo(javax.swing.JComboBox<String> cbyComboBox) {
        DefaultComboBoxModel<String> yearModel = new DefaultComboBoxModel<>();
        for (String year : years) {
            yearModel.addElement(year);
        }
        cbyComboBox.setModel(yearModel);
    }

    // Populate the month combo box based on selected year
    public void populateMonthCombo(String selectedYear, javax.swing.JComboBox<String> cbmComboBox) {
        months.clear(); // Clear previous months
        ArrayList<String[]> allBooking = readBooking();

        for (String[] booking : allBooking) {
            if (booking[8].equals("Paid") && booking[3].startsWith(selectedYear)) {
                String[] dateParts = booking[3].split("-");
                months.add(dateParts[1]);
            }
        }

        DefaultComboBoxModel<String> monthModel = new DefaultComboBoxModel<>();
        for (String month : months) {
            monthModel.addElement(month);
        }
        cbmComboBox.setModel(monthModel);
    }

    // Populate the day combo box based on selected month
    public void populateDayCombo(String selectedYear, String selectedMonth, javax.swing.JComboBox<String> cbdComboBox) {
        days.clear(); // Clear previous days
        ArrayList<String[]> allBooking = readBooking();

        for (String[] booking : allBooking) {
            if (booking[8].equals("Paid") && booking[3].startsWith(selectedYear + "-" + selectedMonth)) {
                String[] dateParts = booking[3].split("-");
                days.add(dateParts[2]);
            }
        }

        DefaultComboBoxModel<String> dayModel = new DefaultComboBoxModel<>();
        for (String day : days) {
            dayModel.addElement(day);
        }
        cbdComboBox.setModel(dayModel);
    }
}
