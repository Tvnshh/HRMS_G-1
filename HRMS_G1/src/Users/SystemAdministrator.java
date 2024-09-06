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
public class SystemAdministrator extends Users {
    
    private List<String> employeeDetails = new ArrayList<>();

    public void createUser(int role, String employeeUsername, String employeePassword, String name) {
        EmployeeProfile newEmployee = new EmployeeProfile(role, employeeUsername, employeePassword,/* loginattempt */ 0, 1, name, "0", "0", "0", "0", 0, "0", "0", "0", "0");
        String[] employeeInfo = newEmployee.getEmployeeInfo();
        newEmployee.setEmployeeInfo(employeeInfo);
        newEmployee.setEmployeeInfo();
    }

    public String[] retrieveUserDetails(String employeeUsername) {
        EmployeeProfile employee = new EmployeeProfile(employeeUsername);
        return employee.getEmployeeInfo();
    }

    public void deleteUserAccount(String employeeUsername) {
        // EmployeeProfile employee = new EmployeeProfile(username);
        // String[] employeeInfo = new String[14];
        String filepath = "user_profile.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                employeeDetails.add(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SystemAdministrator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SystemAdministrator.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (FileWriter writer = new FileWriter(filepath, false)) {
            for (String employee : employeeDetails) {
                if (!(employee.split(",")[1].equals(employeeUsername))) {
                    writer.write(employee + "\n");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(SystemAdministrator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateAccountDetails(String[] employeeInfo) {
        System.out.println("Array Data: " + Arrays.toString(employeeInfo));
        EmployeeProfile employee = new EmployeeProfile(employeeInfo[1]);
        employee.setEmployeeInfo(employeeInfo);
        employee.setEmployeeInfo();
    }

    public void updateAccountStatus(String employeeUsername, int accountStatus) {
        EmployeeProfile employee = new EmployeeProfile(employeeUsername);
        employee.setAccountStatus(accountStatus);
        String []employeeInfo = employee.getEmployeeInfo();
        employee.setEmployeeInfo(employeeInfo);
        employee.setEmployeeInfo();
    }
    @Override
    public boolean verifyPassword(String username, String password) {
        EmployeeProfile employee = new EmployeeProfile(username);
        return password.equals(employee.getEmployeePassword());
    }
    @Override
    public void changePassword(String username, String newPassword) {
        EmployeeProfile employee = new EmployeeProfile(username);
        employee.setEmployeePassword(newPassword);
        employee.setEmployeeInfo();
    }
    @Override
    public String[] viewProfile(String username){
        EmployeeProfile Profile = new EmployeeProfile(username);
        return Profile.getEmployeeInfo();
    }
}