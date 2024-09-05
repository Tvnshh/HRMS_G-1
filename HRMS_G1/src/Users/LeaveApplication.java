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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tvanm
 */
class LeaveApplication {
    private List<String> leaveInfo = new ArrayList<>();
    private String leaveType;
    private int duration;
    private String date;
    private String approvalStatus;
    private String employeeUsername;
    private String[] leaveDetails = new String[5];
    String[][] employeeFileInfo;

    public LeaveApplication() {
        String filepath = "leave_request.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.split(",")[4].equals("pending")) {
                    leaveInfo.add(line);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LeaveApplication.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LeaveApplication.class.getName()).log(Level.SEVERE, null, ex);
        }

        employeeFileInfo = new String[leaveInfo.size()][];

        // Iterate through the list and split each string
        for (int i = 0; i < leaveInfo.size(); i++) {
            String[] splitArray = leaveInfo.get(i).split(",");
            employeeFileInfo[i] = splitArray;
        }
    }

    public LeaveApplication(String leaveType, int duration, String date, String approvalStatus,
            String employeeUsername) {
        this.leaveType = leaveType;
        this.duration = duration;
        this.date = date;
        this.approvalStatus = approvalStatus;
        this.employeeUsername = employeeUsername;
    }

    public LeaveApplication(String username) {
        String filepath = "leave_request.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.split(",")[0].equals(username)) {
                    leaveDetails = line.split(",");
                }
                leaveInfo.add(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LeaveApplication.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LeaveApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.employeeUsername = leaveDetails[0];
        this.leaveType = leaveDetails[1];
        this.duration = Integer.parseInt(leaveDetails[2]);
        this.date = leaveDetails[3];
        this.approvalStatus = leaveDetails[4];
    }

    public String[][] getEmployeeFileInfo() {
        return employeeFileInfo;
    }

    public void setLeaveDetails() {
        String filepath = "leave_request.txt";
        System.out.println("Leave Info List: "+leaveInfo);
        if (leaveInfo.isEmpty()){
            System.out.println("Leave Info List is Null");
            try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    leaveInfo.add(line);
                    System.out.println("Lines: "+line);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(LeaveApplication.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(LeaveApplication.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        boolean userFound = false;
        System.out.println("Leave Info List: "+leaveInfo);
        for (int i = 0; i < leaveInfo.size(); i++) {
            String leave[] = leaveInfo.get(i).split(",");
            if (leave[0].equals(employeeUsername)) {
                leaveInfo.set(i, String.join(",", getLeaveDetails()));
                userFound = true;
            }
        }
        if (!userFound){
            leaveInfo.add(String.join(",", getLeaveDetails()));
        }

        try (FileWriter writer = new FileWriter(filepath, false)) {
            for (String leave : leaveInfo) {
                writer.write(leave + "\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(LeaveApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteLeave(String date) {
        for (int i = 0; i < leaveInfo.size(); i++) {
            String leave = leaveInfo.get(i);
            if (leave.split(",")[0].equals(employeeUsername) && leave.split(",")[3].equals(date)) {
                leaveInfo.remove(i);
                i--; // Adjust index after removal
            }
        }
        try (FileWriter writer = new FileWriter("leave_request.txt", false)) {
            for (String leave : leaveInfo) {
                writer.write(leave + "\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(LeaveApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getLeaveType() {
        return leaveType;
    }

    public int getDuration() {
        return duration;
    }

    public String getDate() {
        return date;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public String[] getLeaveDetails() {
        return new String[] { this.employeeUsername, this.leaveType, Integer.toString(this.duration), this.date,
                this.approvalStatus };

    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public void setLeaveDetails(String[] leaveDetails) {
        System.out.println(Arrays.toString(leaveDetails));
        this.leaveDetails = leaveDetails;
    }

    // leave request & leave history

}

