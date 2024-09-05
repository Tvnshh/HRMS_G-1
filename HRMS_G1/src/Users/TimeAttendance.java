/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Users;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tvanm
 */
class TimeAttendance {
    private List<String> timeAttendanceInfo = new ArrayList<>();
    // time attendance
    private String employeeUsername;
    private String date;
    private String time;
    private String timeIn;
    private String timeOut;
    private int lateAttendance;
    private String[] timeAttendanceDetails = new String[5];
    private String[][] employeeAttendanceInfo;
    List<String[]> matchedDataList = new ArrayList<>();

    public TimeAttendance(String username) {
        System.out.println("-------------------");
        System.out.println("Time Attendance, setting up object data from database");
        System.out.println("-------------------");
        String filepath = "time_attendance.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.split(",")[0].equals(username) && line.split(",")[1].equals(getCurrentDate())) {
                    timeAttendanceDetails = line.split(",");
                    System.out.println("Found the username, and writing onto timeAttendanceDetails");
                }
                if (line!=null){
                    timeAttendanceInfo.add(line);
                    System.out.println("Either way, writing onto timeAttendanceInfo");
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TimeAttendance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TimeAttendance.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Username in array before setting value: " + username);
        if (timeAttendanceDetails[0] == null) {
            timeAttendanceDetails[0] = username;
            timeAttendanceDetails[1] = getCurrentDate();
            timeAttendanceDetails[2] = " ";
            timeAttendanceDetails[3] = " ";
            timeAttendanceDetails[4] = "1";
            System.out.println("Setting the values to default values.");
            System.out.println("Username in method parameter: " + username);
        }
        this.employeeUsername = timeAttendanceDetails[0];
        System.out.println("Object variable: " + this.employeeUsername);
        this.date = timeAttendanceDetails[1];
        this.timeIn = timeAttendanceDetails[2];
        this.timeOut = timeAttendanceDetails[3];
        this.lateAttendance = Integer.parseInt(timeAttendanceDetails[4]);
        

        // Iterate through the list and split each string
        for (String record : timeAttendanceInfo) {
            String[] splitArray = record.split(",");
            if (splitArray[0].equals(username)) {
                matchedDataList.add(splitArray);
            }
        }
        employeeAttendanceInfo = new String[matchedDataList.size()][];
        matchedDataList.toArray(employeeAttendanceInfo);    
    }

    public void Clocking(String username, String Clock) {
        System.out.println("-------------------");
        System.out.println("Time Attendance, setting up clock in/out data from current date or time");
        System.out.println("-------------------");
        date = getCurrentDate();
        time = getTime();
        System.out.println("username: " + username);
        System.out.println("Date is: " + date);
        System.out.println("Time is: " + time);
        
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

        this.lateAttendance = (hour > 8 || (hour == 8 && minute > 30)) ? 1 : 0;
        System.out.println("Late Attendance: " + lateAttendance);

        // Set timeIn or timeOut based on the "Clock" input
        if ("in".equalsIgnoreCase(Clock)) {
            this.timeIn = time;
            System.out.println("Clock Value: " + Clock);
        } else if ("out".equalsIgnoreCase(Clock)) {
            this.timeOut = time;
            System.out.println("Clock Value: " + Clock);
        }
    }

    public static String getCurrentDate() {
        LocalDate myObj = LocalDate.now(); // Create a date object
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return myObj.format(formatter);
    }

    public static String getTime() {
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        return currentTime.format(timeFormatter);
    }

    public void setTimeAttendanceDetails() {
        System.out.println("-------------------");
        System.out.println("Set Attendance Details");
        System.out.println("-------------------");
        System.out.println("Object variable: " + this.employeeUsername);
        timeAttendanceDetails[0] = this.employeeUsername;
        timeAttendanceDetails[1] = this.date;
        timeAttendanceDetails[2] = this.timeIn;
        timeAttendanceDetails[3] = this.timeOut;
        timeAttendanceDetails[4] = Integer.toString(this.lateAttendance);
        for (int i = 0; i < timeAttendanceDetails.length; i++) {
            System.out.println(timeAttendanceDetails[i]);
        }
        boolean userFound = false;
        for (int i = 0; i < timeAttendanceInfo.size(); i++) {
            String timeAttendance = timeAttendanceInfo.get(i);
            System.out.println("Username from the big list: "+ timeAttendance.split(",")[0] + timeAttendance.split(",")[0].equals(employeeUsername));
            System.out.println("Date from the big list: " + timeAttendance.split(",")[1] + timeAttendance.split(",")[1].equals(date));
            if (timeAttendance.split(",")[0].equals(employeeUsername) && timeAttendance.split(",")[1].equals(date)) {
                timeAttendanceInfo.set(i, String.join(",", getTimeAttendanceDetails()));
                System.out.println("setTimeAttendanceDetails, List look setting the detail according to username");
                userFound = true;
                break;
            } else {
                System.out.println("setTimeAttendanceDetails, List didnt find the username and date, so appending on to the list");
            }
        }
        if (!userFound){
            timeAttendanceInfo.add(String.join(",", getTimeAttendanceDetails()));
        }
        System.out.println(timeAttendanceInfo);
        try (FileWriter writer = new FileWriter("time_attendance.txt", false)) {
            for (String timeAttendance : timeAttendanceInfo) {
                writer.write(timeAttendance + "\n");
                System.out.println("System is writing onto the text file");
            }
        } catch (IOException ex) {
            Logger.getLogger(TimeAttendance.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public String[][] getEmployeeAttendanceInfo() {
        return employeeAttendanceInfo;
    }


    public String getEmployeeUsername() {
        return employeeUsername;
    }

    public String getDate() {
        return date;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public int getLateAttendance() {
        return lateAttendance;
    }

    public String[] getTimeAttendanceDetails() {
        return new String[] {
                this.employeeUsername,
                this.date,
                this.timeIn,
                this.timeOut,
                Integer.toString(this.lateAttendance)
        };
    }

    public void setEmployeeUsername(String employeeUsername) {
        this.employeeUsername = employeeUsername;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

    public void setLateAttendance(int lateAttendance) {
        this.lateAttendance = lateAttendance;
    }

    public void setTimeAttendanceDetails(String[] timeAttendanceDetails) {
        this.timeAttendanceDetails = timeAttendanceDetails;
    }
}


