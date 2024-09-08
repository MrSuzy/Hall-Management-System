package Admin;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */

// import 
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

public class admin {
    protected String staffID;
    protected String userID;
    protected String name;
    protected String username;
    protected String contact;
    protected String email;
    protected String password;
    protected String status;
    
    // throw away
    // method to generate the staff ID
    private String generateStaffID() {
        String lastID = "";
        try (BufferedReader reader = new BufferedReader(new FileReader("staff.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lastID = line.split(";")[0]; // get the ID of the last staff
            }
        } catch (IOException e) {
            e.printStackTrace(); 
        }
        
        if (lastID.isEmpty()) {
            return "S01";
        } else {
            int idNum = Integer.parseInt(lastID.substring(1)); // extract the numeric part of the ID
            idNum ++; // increment by 1
            return String.format("S%02d", idNum); // format the id to S02 etc
        }
    }
    
    
    // method to check if staff exists
    private boolean isStaffExists (String username, String email) {
        try (BufferedReader reader = new BufferedReader(new FileReader("staff.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] staffDetails = line.split(";");
                if (staffDetails[2].equals(username) || staffDetails[4].equals(email)){
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; 
    }
    
    
    // method to add new scheduler staff
    public void addStaff (String name, String username, String contact, String email, String password, String role) {
        try {
            if (isStaffExists(username, email)) {
                JOptionPane.showMessageDialog(null, "Staff with same username or email already exists.", "Duplicate Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // generate the unique staff ID for new scheduler staff
            // String staffID = generateStaffID(); 
            // set date time created 
            LocalDateTime currentDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");
            String formattedDateTime = currentDateTime.format(formatter);
            
            // set status to active
            String status = "active";
            
            try (FileWriter fw = new FileWriter("staff.txt", true)) {
                fw.write(name + ";" + username + ";" + contact + ";" + email + ";" + formattedDateTime + ";" + password + ";" + status + ";" + role + "\n");
            }
            
            JOptionPane.showMessageDialog(null, "Staff added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // method to edit staff information 
    public void editStaff (String staffID, String name, String newUsername, String newContact, String email, String newPassword) {
        File file = new File("staff.txt");
        File tempFile = new File("tempStaff.txt");
        boolean found = false;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            
            String line;
            while ((line = reader. readLine()) != null) {
                String [] staffDetails = line.split(";");
                if (staffDetails[0].equals(staffID)) {
                    staffDetails[2] = newUsername;
                    staffDetails[3] = newContact;
                    staffDetails[5] = newPassword;
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
    
    // method to view all staff 
    // return in array for table view
    public ArrayList<String[]> viewStaff() {
        ArrayList<String[]> staffList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("staff.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] staffDetails = line.split(";");
                staffList.add(staffDetails);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return staffList;
    }
    

    // method to delete a staff by username
    public void deleteStaff(String username) {
        File file = new File("staff.txt");
        File tempFile = new File("tempStaff.txt");
        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] staffDetails = line.split(";");
                if (staffDetails[2].equals(username)) { // Username is at index 2 
                    found = true;
                    continue; // Skip this line (delete the staff)
                }
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (found) {
            if (file.delete() && tempFile.renameTo(file)) {
                JOptionPane.showMessageDialog(null, "Staff deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Staff not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // method to view all users 
    public ArrayList<String[]> viewUser() {
        ArrayList<String[]> userList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("user.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(";");
                userList.add(userDetails);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userList;
    }
    
    // method to delete user
    public void deleteUser(String username) {
        File file = new File("user.txt");
        File tempFile = new File("tempUser.txt");
        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(";");
                if (userDetails[2].equals(username)) { // username at index 2 
                    found = true;
                    continue; // Skip this line (delete the staff)
                }
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (found) {
            if (file.delete() && tempFile.renameTo(file)) {
                JOptionPane.showMessageDialog(null, "User deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "User not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
        
    // method to block user based on status
    public void blockUser(String username) {
        File file = new File("user.txt");
        File tempFile = new File("tempUser.txt");
        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(";");
                if (userDetails[2].equals(username)) { // check username based on the index
                    userDetails[7] = "blocked"; // status at index 7
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
}
