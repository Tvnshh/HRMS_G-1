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
class EmployeeProfile {
    private List<String> employeeDetails = new ArrayList<>();
    private int role;
    private String employeeUsername;
    private String employeePassword;
    private int loginAttempts;
    private int accountStatus;
    private String name;
    private String contact;
    private String email;
    private String address;
    private String emergencyContact;
    private int workExperience;
    private String position;
    private String department;
    private String monthlyGSalary;
    private String[] employeeInfo = new String[15];
    private String gender;

    public EmployeeProfile(int role, String employeeUsername, String employeePassword, int loginAttempts,
            int accountStatus, String name, String contact, String email, String address, String emergencyContact,
            int workExperience, String position, String department, String monthlyGSalary, String gender) {
        this.role = role;
        this.employeeUsername = employeeUsername;
        this.employeePassword = employeePassword;
        this.loginAttempts = loginAttempts;
        this.accountStatus = accountStatus;
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.address = address;
        this.emergencyContact = emergencyContact;
        this.workExperience = workExperience;
        this.position = position;
        this.department = department;
        this.monthlyGSalary = monthlyGSalary;
        this.gender = gender;
        System.out.println("Data given by user have been stored to the object variables, Ex: "+employeeUsername);
    }

    public EmployeeProfile(String username) {
        String filepath = "user_profile.txt";
        System.out.println("Username in parameter: " + username);
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.split(",")[1].equals(username)) {
                    employeeInfo = line.split(",");
                }
                employeeDetails.add(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EmployeeProfile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EmployeeProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.role = Integer.parseInt(employeeInfo[0]);
        this.employeeUsername = employeeInfo[1];
        this.employeePassword = employeeInfo[2];
        this.loginAttempts = Integer.parseInt(employeeInfo[3]);
        this.accountStatus = Integer.parseInt(employeeInfo[4]);
        this.name = employeeInfo[5];
        this.contact = employeeInfo[6];
        this.email = employeeInfo[7];
        this.address = employeeInfo[8];
        this.emergencyContact = employeeInfo[9];
        this.workExperience = Integer.parseInt(employeeInfo[10]);
        this.position = employeeInfo[11];
        this.department = employeeInfo[12];
        this.monthlyGSalary = employeeInfo[13];
        this.gender = employeeInfo[14];
    }

    public void setEmployeeInfo() {
        String filepath = "user_profile.txt";
        System.out.println(employeeDetails.toString());
        if (employeeDetails.size()<2){
            try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    employeeDetails.add(line);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(EmployeeProfile.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(EmployeeProfile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(employeeDetails.toString());
        
        boolean userFound = false;
        for (int i = 0; i < employeeDetails.size(); i++) {
            String employee = employeeDetails.get(i);
            if (employee.split(",")[1].equals(employeeUsername)) {
                employeeDetails.set(i, String.join(",", getEmployeeInfo()));
                userFound = true;
            }
        }
        if (!userFound){
            employeeDetails.add(String.join(",", getEmployeeInfo()));
        }
        System.out.println(employeeDetails.toString());
        try (FileWriter writer = new FileWriter(filepath, false)) {
            for (String employee : employeeDetails) {
                writer.write(employee + "\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(EmployeeProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getRole() {
        return role;
    }

    public String getEmployeeUsername() {
        return employeeUsername;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public int getLoginAttempts() {
        return loginAttempts;
    }

    public int getAccountStatus() {
        return accountStatus;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public String getMonthlyGSalary() {
        return monthlyGSalary;
    }

    public String[] getEmployeeInfo() {
        employeeInfo[0] = Integer.toString(this.role);
        employeeInfo[1] = this.employeeUsername;
        employeeInfo[2] = this.employeePassword;
        employeeInfo[3] = Integer.toString(this.loginAttempts);
        employeeInfo[4] = Integer.toString(this.accountStatus);
        System.out.println("Account Status in getEmployeeInfo: "+accountStatus);
        employeeInfo[5] = this.name;
        employeeInfo[6] = this.contact;
        employeeInfo[7] = this.email;
        employeeInfo[8] = this.address;
        employeeInfo[9] = this.emergencyContact;
        employeeInfo[10] = Integer.toString(this.workExperience);
        employeeInfo[11] = this.position;
        employeeInfo[12] = this.department;
        employeeInfo[13] = this.monthlyGSalary;
        employeeInfo[14] = this.gender;
        System.out.println("Data is now being stored to the employeeInfo list, Ex: "+ Arrays.toString(employeeInfo));
        return employeeInfo;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setEmployeeUsername(String employeeUsername) {
        this.employeeUsername = employeeUsername;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    public void setLoginAttempts(int loginAttempts) {
        this.loginAttempts = loginAttempts;
    }

    public void setAccountStatus(int accountStatus) {
        this.accountStatus = accountStatus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setMonthlyGSalary(String monthlyGSalary) {
        this.monthlyGSalary = monthlyGSalary;
    }
    
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmployeeInfo(String[] employeeInfo) {
        this.employeeInfo = employeeInfo;
        this.role = Integer.parseInt(employeeInfo[0]);
        this.employeeUsername = employeeInfo[1];
        this.employeePassword = employeeInfo[2];
        this.loginAttempts = Integer.parseInt(employeeInfo[3]);
        this.accountStatus = Integer.parseInt(employeeInfo[4]);
        this.name = employeeInfo[5];
        this.contact = employeeInfo[6];
        this.email = employeeInfo[7];
        this.address = employeeInfo[8];
        this.emergencyContact = employeeInfo[9];
        this.workExperience = Integer.parseInt(employeeInfo[10]);
        this.position = employeeInfo[11];
        this.department = employeeInfo[12];
        this.monthlyGSalary = employeeInfo[13];
        this.gender = employeeInfo[14];
    }

}
