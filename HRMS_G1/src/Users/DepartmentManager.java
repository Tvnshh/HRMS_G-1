/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Users;

/**
 *
 * @author tvanm
 */
public class DepartmentManager extends Users {

    public void applyLeave(String leaveType, int duration, String date, String approvalStatus, String username) {
        LeaveApplication newLeave = new LeaveApplication(leaveType, duration, date, approvalStatus, username);
        newLeave.setLeaveDetails(newLeave.getLeaveDetails());
        newLeave.setLeaveDetails();
    }

    public void cancelLeave(String username, String date) {
        LeaveApplication leave = new LeaveApplication(username);
        leave.deleteLeave(date);
    }

    public String[][] leaveApplicationList() {
        LeaveApplication leave = new LeaveApplication();
        // return a nested array
        String[][] employeeFileInfo = leave.getEmployeeFileInfo();
        return employeeFileInfo;
    }

    public String checkLeaveStatus(String username, String date) {
        LeaveApplication leave = new LeaveApplication(username);
        return leave.getLeaveDetails()[4];
    }

    public void approveLeave(String employeeUsername, String date) {
        LeaveApplication leave = new LeaveApplication(employeeUsername);
        leave.setApprovalStatus("approved");
        leave.setLeaveDetails();
    }

    public void rejectLeave(String employeeUsername, String date) {
        LeaveApplication leave = new LeaveApplication(employeeUsername);
        leave.setApprovalStatus("rejected");
        leave.setLeaveDetails();
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
