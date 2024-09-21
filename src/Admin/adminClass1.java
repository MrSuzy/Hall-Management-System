/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Admin;

/**
 *
 * @author jason
 */

// import 
import java.awt.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;

public class adminClass1 {
    private String name;
    private String phoneNum;
    private String email;
    private String password;
    private String status;
    private String role;
    
    // date formatter
    private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    
    // time formatter
    private static final SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm");
    
    public adminClass1 (String name, String phoneNum, String email, String password, String status, String role) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
        this.password = password;
        this.status = status;
        this.role = role;
    }
    
    public adminClass1() {
        
    }
    
    // getters
    public String getName() {
        return name;
    }
    
    public String getphoneNum() {
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
    
    // setters
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
    
    public void setRole (String role) {
        this.role = role;
    }
    
    // count number of users
    public int countUsers() {
        int userCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader ("users.txt"))) {
            String line;
            while((line = br.readLine()) != null) {
                String[] userDetails = line.split(";");
                String role = userDetails[6];
                if (role.equalsIgnoreCase("customer")) {
                    userCount++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userCount;
    }
    
    // count number of staff
    public int countStaff() {
        int staffCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader ("users.txt"))) {
            String line;
            while((line = br.readLine()) != null) {
                String[] userDetails = line.split(";");
                String role = userDetails[6];
                if (role.equalsIgnoreCase("admin") ||
                    role.equalsIgnoreCase("scheduler") ||
                    role.equalsIgnoreCase("manager")) {
                    staffCount++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return staffCount;
    }
    
    // load users to display in table
    public void loadUserByRole(String selectedRole, String selectedStatus, DefaultTableModel model, boolean showPass) {
        try {
            FileReader fr = new FileReader("users.txt");
            BufferedReader br = new BufferedReader(fr);
            String read;
            
            // clear the existing rows from the table
            model.setRowCount(0);
            
            // read the txt file into the table
            while ((read = br.readLine()) != null) {
                String name = read.split(";")[0];
                String phoneNum = read.split(";")[1];
                String email = read.split(";")[2];
                String password = read.split(";")[3];
                String dateTime = read.split(";")[4];
                String status = read.split(";")[5];
                String role = read.split(";")[6];
                
                boolean roleMatch = selectedRole.equalsIgnoreCase("all") || role.equalsIgnoreCase(selectedRole);
                boolean statusMatch = selectedStatus.equalsIgnoreCase("all") || status.equalsIgnoreCase(selectedStatus);
                
                // match selected role
                if (roleMatch && statusMatch) {
                    if (showPass) {
                        model.addRow(new Object[]{name, phoneNum, email, password, dateTime, status, role});
                    } else { 
                        // exclude the password column
                        model.addRow(new Object[]{name, phoneNum, email, dateTime, status, role});
                    }
                }
                /*
                if (role.equalsIgnoreCase(selectedRole) && status.equalsIgnoreCase(selectedStatus)) {
                    model.addRow(new Object[]{name, phoneNum, email, dateTime, status, role});
                }*/
            }
            br.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // method to check if staff exists
    private boolean isStaffExists (String name, String email) {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] staffDetails = line.split(";");
                
                String existName = staffDetails[0].trim();
                String existEmail = staffDetails[2].trim();
                
                if (existName.equals(name.trim()) || existEmail.equals(email.trim())){
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; 
    }
    
    
    // method to add new scheduler staff
    public void addStaff (String name, String phoneNum, String email, String password, String role, String status) {
        try {
            if (isStaffExists(name, email)) {
                JOptionPane.showMessageDialog(null, "Staff with same name or email already exists.", "Duplicate Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // set date time created 
            LocalDateTime currentDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");
            String formattedDateTime = currentDateTime.format(formatter);
            
            // set status to active
            status = "active";
            
            try (FileWriter fw = new FileWriter("users.txt", true)) {
                fw.write(name + ";" + phoneNum + ";" + email + ";" + password + ";" + formattedDateTime + ";" + status + ";" + role + ";" +  "\n");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
            }
            JOptionPane.showMessageDialog(null, "Staff added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // delete staff/user
    public void deleteUser(String email) {
        // prompt confirmation 
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this user?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
        
        // if yes
        if (confirm == JOptionPane.YES_OPTION) {
            File file = new File("users.txt");
            File tempfile = new File("tempUsers.txt");
            boolean found = false;
        
            try(BufferedReader reader = new BufferedReader(new FileReader(file));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(tempfile))) {
                String line;
                while((line = reader.readLine()) != null) {
                    String[] details = line.split(";");
                    if(details[2].equals(email)) {
                        found = true;
                        continue;
                    }
                    writer.write(line + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            if (found) {
                if(file.delete() && tempfile.renameTo(file)) {
                    JOptionPane.showMessageDialog(null, "User deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "User not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Deletion cancelled.", "Cancellation", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    // update user
    public void updateStaff(String name, String role, String status, String newPhoneNum, String email, String newPass) {
        File file = new File("users.txt");
        File tempFile = new File("tempStaff.txt");
        boolean found = false;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            
            String line;
            while ((line = reader. readLine()) != null) {
                String [] staffDetails = line.split(";");
                if (staffDetails[0].equals(name) && staffDetails[6].equalsIgnoreCase(role)) {
                    staffDetails[1] = newPhoneNum;
                    staffDetails[2] = email;
                    staffDetails[3] = newPass;
                    staffDetails[5] = status;
                    found = true; 
                }

                writer.write(String.join(";", staffDetails) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        if (found) {
            if (file.delete() && tempFile.renameTo(file)) {
                JOptionPane.showMessageDialog(null, "Staff information updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Error updating staff information.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Staff not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // define user status 
    public enum userStatus {
        ACTIVE("active"),
        BLOCKED("blocked"),
        INACTIVE("inactive");
        
        private final String status;
        
        userStatus(String status) {
            this.status = status;
        }
        
        public String getStatus() {
            return status;
        }
    }
    
    // method to update status 
    // can be reused if want to set user to active inactive block
    public void updateUserStatus(String email, userStatus newStatus) {
        File file = new File("users.txt");
        File tempFile = new File("tempUser.txt");
        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(";");
                if (userDetails[2].equals(email)) { // check username based on the index
                    userDetails[5] = newStatus.getStatus(); // status at index 5
                    found = true;
                }
                writer.write(String.join(";", userDetails) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (found) {
            if (file.delete() && tempFile.renameTo(file)) {
                JOptionPane.showMessageDialog(null, "User blocked successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "User not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // read all bookings
    public ArrayList<String[]> readBookings() {
        ArrayList<String[]> bookingList = new ArrayList<>();
        File file = new File("bookings.txt");
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] bookingDetails = line.split(";");
                bookingList.add(bookingDetails);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookingList;
    }
    
    
    // filter bookings
    public ArrayList<String[]> filterBookings(String type) {
        ArrayList<String[]> filteredList = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        
        // read all bookings in the bookings.txt
        ArrayList<String[]> allBookings = readBookings();
        
        // filter 
        for (String[] booking : allBookings) {
            try {
                Date bookDate = dateFormat.parse(booking[3]);
                String bookStatus = booking[8];
                
                // switch case to filter
                switch(type) {
                    case "upcoming":
                        if (bookDate.after(currentDate)) {
                            filteredList.add(booking);
                        }
                        break;
                    case "past":
                        if (bookDate.before(currentDate)) {
                            filteredList.add(booking);
                        }
                        break;
                    case "cancelled":
                        if (bookStatus.equalsIgnoreCase("Cancelled")) {
                            filteredList.add(booking);
                        }
                        break;
                    case "all":
                    default:
                        filteredList.add(booking);
                        break;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return filteredList;
    }
}
