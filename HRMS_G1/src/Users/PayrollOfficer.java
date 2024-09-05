/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Users;

/**
 *
 * @author tvanm
 */
public class PayrollOfficer extends Users {

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

    public void createPayroll(String employeeUsername, int grossSalary) {
        Payroll payroll = new Payroll(employeeUsername, grossSalary);
        payroll.setPayrollDetails();
    }

    public String[] getPayrollDataMonth(String employeeUsername, String month) {
        Payroll payroll = new Payroll(employeeUsername, month);
        // Get_Payroll_Data logic
        return payroll.getPayrollDetails();
    }
    // public String[] getPayrollData(String username) {
    // Payroll payroll = new Payroll(username);
    // // Get_Payroll_Data logic
    // return payroll.getPayrollDetails();
    // }

    public void updatePayroll(String employeeUsername, String month, int newGrossSalary) {
        Payroll payroll = new Payroll(employeeUsername, month);
        payroll.setGrossSalary(newGrossSalary);
        payroll.setPayrollDetails(payroll.getPayrollDetails());
        payroll.setPayrollDetails();
    }

}

