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
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;

public class adminClass1 {
    private String name;
    private String phoneNum;
    private String email;
    private String password;
    private String status;
    private String role;
    
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
    
    // load users to display in table
    public void loadUserByRole(String selectedRole, String selectedStatus, DefaultTableModel model) {
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
                String dateTime = read.split(";")[4];
                String status = read.split(";")[5];
                String role = read.split(";")[6];
                
                // match selected role
                if (role.equalsIgnoreCase(selectedRole) && status.equalsIgnoreCase(selectedStatus)) {
                    model.addRow(new Object[]{name, phoneNum, email, dateTime, status, role});
                }
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
    }
    
    // method to edit staff information 
    public void editStaff (String name, String role, String newStatus, String newPhoneNum, String email, String newPassword) {
        File file = new File("users.txt");
        File tempFile = new File("tempStaff.txt");
        boolean found = false;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            
            String line;
            while ((line = reader. readLine()) != null) {
                String [] staffDetails = line.split(";");
                if (staffDetails[0].equals(name) && staffDetails[6].equals(role)) {
                    staffDetails[1] = newPhoneNum;
                    staffDetails[3] = newPassword;
                    staffDetails[5] = newStatus;
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
    
    // method to block user using the updateUserStatus method
    public void blockUser(String email) {
        updateUserStatus(email, userStatus.BLOCKED);
    }
    
    // method to view bookings 
    public ArrayList<String[]> viewBooking(String status) {
        ArrayList<String[]> bookingList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("booking.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] bookingDetails = line.split(";");
                if (bookingDetails[5]. equalsIgnoreCase(status)) {
                    bookingList.add(bookingDetails);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookingList;
    }
    
    // method to view all users 
    /* public ArrayList<String[]> viewUser() {
        ArrayList<String[]> userList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(";");
                userList.add(userDetails);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userList;
    }*/
}
