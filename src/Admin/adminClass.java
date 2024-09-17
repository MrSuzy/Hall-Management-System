package admin;

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
import java.util.regex.Pattern;

public class adminClass {
    private String name;
    private String contact;
    private String email;
    private String password;
    private String status;
    private String role;
    
    public adminClass (String name, String contact, String email, String password, String status, String role) {
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.password = password;
        this.status = status;
        this.role = role;
    }
    
    // getters
    public String getName() {
        return name;
    }
    
    public String getContact() {
        return contact;
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
    
    public void setContact(String contact) {
        this.contact = contact;
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
    
    
    // method to check if staff exists
    private boolean isStaffExists (String username, String email) {
        try (BufferedReader reader = new BufferedReader(new FileReader("staff.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] staffDetails = line.split(";");
                
                String existUname = staffDetails[2].trim();
                String existEmail = staffDetails[4].trim();
                
                if (existUname.equals(username.trim()) || existEmail.equals(email.trim())){
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
        // Validate email
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" + 
                "[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        Pattern pattern = Pattern.compile(emailRegex);
        
        if (!pattern.matcher(email).matches()) {
            JOptionPane.showMessageDialog(null, "Invalid email format.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            if (isStaffExists(username, email)) {
                JOptionPane.showMessageDialog(null, "Staff with same username or email already exists.", "Duplicate Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // set date time created 
            LocalDateTime currentDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");
            String formattedDateTime = currentDateTime.format(formatter);
            
            // set status to active
            String status = "active";
            
            try (FileWriter fw = new FileWriter("staff.txt", true)) {
                fw.write(name + ";" + username + ";" + contact + ";" + email + ";" + formattedDateTime + ";" + password + ";" + status + ";" + role + "\n");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
            }
            JOptionPane.showMessageDialog(null, "Staff added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // method to edit staff information 
    public void editStaff (String name, String role, String newUsername, String newContact, String email, String newPassword) {
        File file = new File("staff.txt");
        File tempFile = new File("tempStaff.txt");
        boolean found = false;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            
            String line;
            while ((line = reader. readLine()) != null) {
                String [] staffDetails = line.split(";");
                if (staffDetails[0].equals(name) || staffDetails[7].equals(role)) {
                    staffDetails[1] = newUsername;
                    staffDetails[2] = newContact;
                    staffDetails[4] = newPassword;
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
            JOptionPane.showMessageDialog(null, e.getMessage());
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
    public void updateUserStatus(String username, userStatus newStatus) {
        File file = new File("staff.txt");
        File tempFile = new File("tempUser.txt");
        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(";");
                if (userDetails[1].equals(username)) { // check username based on the index
                    userDetails[6] = newStatus.getStatus(); // status at index 7
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
    public void blockUser(String username) {
        updateUserStatus(username, userStatus.BLOCKED);
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
