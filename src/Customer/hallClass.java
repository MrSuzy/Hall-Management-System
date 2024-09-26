/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Customer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 *
 * @author xuen_
 */
public class hallClass {
    private String hallID;
    private String hallType;
    private double price;
    private Date bookingDate;
    private Date startTime;
    private Date endTime;
    private int capacity;
    private String availability;
    
    // date formatter
    private static final SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    
    // time formatter
    private static final SimpleDateFormat time = new SimpleDateFormat("HH:mm");
    
    public hallClass(String hallID, String hallType, double price, Date bookingDate, Date startTime, Date endTime, int capacity, String availability) {
        this.hallID = hallID;
        this.hallType = hallType;
        this.price = price;
        this.bookingDate = bookingDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.capacity = capacity;
        this.availability = availability;
    }
    
    public hallClass() {}
    
    // getters method
    public String getHallID() {
        return hallID;
    }
    
    public String getHallType() {
        return hallType;
    }
    
    public double getPrice() {
        return price;
    }
    
    public Date getBookingDate() {
        return bookingDate;
    }
    
    public Date getStartTime() {
        return startTime;
    }
    
    public Date getEndTime() {
        return endTime;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    public String getAvailabilty() {
        return availability;
    }
    
    // setters method 
    public void setHallID(String hallID) {
        this.hallID = hallID;
    }
    
    public void setHallType(String hallType) {
        this.hallType = hallType;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }
    
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public void setAvailabiliy(String availability) {
        this.availability = availability;
    }
   public List<String> getAllHallIDs() {
       String fileName = "hall.txt";
       List<String> hallIDs = new ArrayList<>();
       
       try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
           String line;
           while ((line = reader.readLine()) != null) {
               String[] details = line.split(";");
               if (details.length > 0) {
                   hallIDs.add(details[0]);    
               }
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
       
       return hallIDs;
   }
    
   public String updateMaintenanceRecord(String hallID, Date bookingDate, Date startTime, Date endTime) {
    String fileName = "hall.txt";
    File file = new File(fileName);
    List<String> fileContent = new ArrayList<>();
    boolean recordUpdated = false;

    // Format for writing dates and times
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        String line;
        
        // Read the file line by line
        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(";");  // Assuming fields are separated by semicolons (;)
            
            // Check if this line matches the hallID
            if (fields[0].equals(hallID)) {
                // Modify the line with new values for bookingDate, startTime, and endTime
                fields[3] = dateFormat.format(bookingDate); // Booking Date
                fields[4] = timeFormat.format(startTime);   // Start Time
                fields[5] = timeFormat.format(endTime);     // End Time
                fields[7] = "Maintenance";
                
                // Rebuild the updated line
                line = String.join(";", fields);
                recordUpdated = true;
            }
            
            // Add the (modified or unmodified) line back to fileContent
            fileContent.add(line);
        }
        
    } catch (IOException e) {
        return "Error reading the file: " + e.getMessage();
    }

    // If the record was updated, write the updated content back to the file
    if (recordUpdated) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String fileLine : fileContent) {
                writer.write(fileLine);
                writer.newLine();
            }
            return "success";
        } catch (IOException e) {
            return "Error writing to the file: " + e.getMessage();
        }
    } else {
        return "Hall ID not found.";
    }
}
   
   public Object[] getSpecificHallDetails(String hallID) {
    String fileName = "hall.txt";
    Object[] hallDetails = null;

    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
        String line;

        while ((line = reader.readLine()) != null) {
            String[] details = line.split(";"); // Split the line by semicolon
            if (details[0].equals(hallID)) { // Check if the first element matches the hallID
                hallDetails = new Object[4]; // Create an array for the details
                hallDetails[0] = details[0]; // Hall ID
                hallDetails[1] = details[1]; // Hall Type
                hallDetails[2] = Double.valueOf(details[2]); // Price
                hallDetails[3] = Integer.valueOf(details[6]); // Capacity (second last column)
                break; // Exit loop once found
            }
        }
    } catch (IOException e) {
        e.printStackTrace(); // Optionally log the error
    }

    return hallDetails; // Returns null if not found
}
   public Object[][] getHallDetails() {
    List<Object[]> hallList = new ArrayList<>();
    
    try (BufferedReader reader = new BufferedReader(new FileReader("hall.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] details = line.split(";");

            // Additional check to ensure we have enough details
            if (details.length < 8) {
                continue;
            }

            // Parse data to create hallClass objects
            String hallID = details[0];
            String hallType = details[1];
            double price = Double.parseDouble(details[2]);
            Date bookingDate = details[3].equals("null") ? null : date.parse(details[3]);
            Date startTime = details[4].equals("null") ? null : time.parse(details[4]);
            Date endTime = details[5].equals("null") ? null : time.parse(details[5]);
            int capacity = Integer.parseInt(details[6]);
            String availability = details[7];

            hallList.add(new Object[]{hallID, hallType, capacity, price, availability});
        }
    } catch (IOException e) {
        System.out.println("Error reading hall file: " + e.getMessage());
    } catch (ParseException e) {
        System.out.println("Error parsing date/time: " + e.getMessage());
    }
    
    return hallList.toArray(new Object[0][]);
}
    
   public String editHall(String hallID, String hallType, double price, int capacity) {
    String fileName = "hall.txt";
    StringBuilder updatedData = new StringBuilder();
    boolean hallFound = false;

    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
        String line;

        while ((line = reader.readLine()) != null) {
            String[] details = line.split(";");

            // Check if the current hall matches the hallID
            if (details[0].equals(hallID)) {
                // Update hall details
                details[1] = hallType; // Update hall type
                details[2] = String.valueOf(price); // Update price
                details[6] = String.valueOf(capacity); // Update capacity
                hallFound = true;
            }

            // Append the (potentially updated) line to the updatedData
            updatedData.append(String.join(";", details)).append("\n");
        }
    } catch (IOException e) {
        e.printStackTrace();
        return "error";
    }

    // If the hall was found and updated, write the changes back to the file
    if (hallFound) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(updatedData.toString());
            return "success";
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    } else {
        return "hall not found"; // If no hall matched the hallID
    }
}
    public String addHall(String hallID, String hallType,  double price, Date bookingDate, Date startTime, Date endTime, int capacity, String availability) {
        String fileName = "hall.txt";
        String content = hallID + ";" + hallType + ";" + price + ";" + bookingDate + ";" + startTime + ";" + endTime + ";" + capacity + ";" + availability + System.lineSeparator();
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(content);
            return "success";
        } catch (IOException e) {
            e.printStackTrace(); // Optionally log the error
            return "Error while adding hall.";
        }
    }
    
    public String deleteHall(String hallID) {
    String fileName = "hall.txt";
    StringBuilder fileContents = new StringBuilder();
    boolean found = false;

    // Read the existing halls
    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] hallDetails = line.split(";");
            if (!hallDetails[0].equals(hallID)) {
                fileContents.append(line).append(System.lineSeparator());
            } else {
                found = true; // Hall found and will be deleted
            }
        }
    } catch (IOException e) {
        return "Error while reading the hall file.";
    }

    // If the hall was found, write the new contents back to the file
    if (found) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(fileContents.toString());
        } catch (IOException e) {
            return "Error while writing to the hall file.";
        }
        return "success";
    } else {
        return "Hall not found.";
    }
}
    
    // check hall availabilty before booking method 
    public static List<String> hallAvailability(Date selectedDate, Date selectedStartTime, Date selectedEndTime, String hallType) {
        List<String> available = new ArrayList<>();
        
        try{
            FileReader fr = new FileReader("hall.txt");
            BufferedReader br = new BufferedReader(fr);
            String read;
            
            while ((read = br.readLine()) != null) {
                String[] details = read.split(";");
                if (details.length == 8) {
                    String hallID = details[0];
                    String type = details[1];
                    String availability = details[7];
                    
                    // parse date and time 
                    Date bookingDate = details[3].equals("null") ? null : date.parse(details[3]);
                    Date startTime = details[4].equals("null") ? null : time.parse(details[4]);
                    Date endTime = details[5].equals("null") ? null : time.parse(details[5]);
                    
                    // debug
                    System.out.println("Hall ID" + hallID);
                    System.out.println("Type" + type + "Availability" + availability);
                    System.out.println("Date" + bookingDate + "Start time" + startTime + "End time" + endTime);
                    
                    // check hall type
                    if (type.equals(hallType)) {
                        // check date first
                        if (bookingDate != null && bookingDate.equals(selectedDate) && availability.equals("Booked")) {
                            
                            // check time clash
                            if (!(selectedEndTime.before(startTime) || selectedStartTime.after(endTime))) {
                                continue;
                            }

                        }
                        
                        available.add(hallID);
                    }
                }
            }
            br.close();
        } catch (IOException | ParseException e) {
            System.out.println("Error" + e.getMessage());
        }
        return available;
    }
    
    // write updated availability to text file after booking
    public static void updatedAvailability(String hallID, Date bookingDate, Date startTime, Date endTime) {
        List<hallClass> hall = new ArrayList<>();
        try{
            FileReader fr = new FileReader("hall.txt");
            BufferedReader br = new BufferedReader(fr);
            String read;
            
            while ((read = br.readLine()) != null) {
                String[] details = read.split(";");
                if (details.length == 8) {
                    String HallID = details[0];
                    String hallType = details[1];
                    double price = Double.parseDouble(details[2]);
                    Date selectedBookingDate = date.parse(details[3]);
                    Date selectedStartTime = time.parse(details[4]);
                    Date selectedEndTime = time.parse(details[5]);
                    int capacity = Integer.parseInt(details[6]);
                    String availability = details[7];
                    
                    if (HallID.equals(hallID)) {
                        hall.add(new hallClass(HallID, hallType, price, selectedBookingDate, selectedStartTime, selectedEndTime, capacity, "Booked"));
                    } else {
                        hall.add(new hallClass(HallID, hallType, price, selectedBookingDate, selectedStartTime, selectedEndTime, capacity, availability));
                    }
                }
            }
        } catch (IOException | ParseException e) {
            System.out.println("Error" + e.getMessage());
        }
        
        try{
            FileWriter fw = new FileWriter("hall.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (hallClass halls : hall) {
                bw.write(halls.getHallID() + ";" + halls.getHallType() + ";" + halls.getPrice() + ";" + 
                        date.format(halls.getBookingDate()) + ";" + time.format(halls.getStartTime()) + ";" + 
                        time.format(halls.getEndTime()) + ";" + halls.getCapacity() + ";" + halls.getAvailabilty());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        hallClass hall = new hallClass();
        List<String> result = hall.getAllHallIDs();
    }
}
