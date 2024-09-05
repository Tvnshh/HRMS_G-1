/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Users;

import java.util.Arrays;

/**
 *
 * @author tvanm
 */
public class HumanResourceOfficer extends Users {

    public void createEmployeeProfile(int role, String employeeUsername, String employeePassword, int loginAttempts, int accountStatus, String name, String contact, String email, String address, String emergencyContact, int workExperience, String position, String department, String monthlyGSalary) {
        EmployeeProfile newEmployee = new EmployeeProfile(employeeUsername);
        String[] employeeInfo = {Integer.toString(role), employeeUsername, employeePassword,Integer.toString(loginAttempts), Integer.toString(accountStatus), name, contact, email, address, emergencyContact, Integer.toString(workExperience), position, department, monthlyGSalary };
        newEmployee.setEmployeeInfo(employeeInfo);
        newEmployee.setEmployeeInfo();
    }

    public String[] retrieveUserDetails(String employeeUsername) {
        EmployeeProfile employee = new EmployeeProfile(employeeUsername);
        return employee.getEmployeeInfo();
    }

    public void updateEmployeeProfile(String[] employeeInfo) {
        System.out.println("Array Data: " + Arrays.toString(employeeInfo));
        EmployeeProfile employee = new EmployeeProfile(employeeInfo[1]);
        employee.setEmployeeInfo(employeeInfo);
        employee.setEmployeeInfo();
    }

    public void applyLeave(String leaveType, int duration, String date, String approvalStatus, String username) {
        LeaveApplication newLeave = new LeaveApplication(leaveType, duration, date, approvalStatus, username);
        newLeave.setLeaveDetails(newLeave.getLeaveDetails());
        newLeave.setLeaveDetails();
    }

    public void cancelLeave(String username, String date) {
        LeaveApplication leave = new LeaveApplication(username);
        leave.deleteLeave(date);
    }

    public String checkLeaveStatus(String username, String date) {
        LeaveApplication leave = new LeaveApplication(username);
        return leave.getLeaveDetails()[4];
    }
}