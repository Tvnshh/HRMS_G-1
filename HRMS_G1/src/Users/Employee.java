/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Users;

/**
 *
 * @author tvanm
 */
public class Employee extends Users {

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

    public void clockIn(String employeeUsername) {
        TimeAttendance VerifyAttendance = new TimeAttendance(employeeUsername);
        VerifyAttendance.Clocking(employeeUsername, "in");
        VerifyAttendance.setTimeAttendanceDetails();

    }

    public void clockOut(String employeeUsername) {
        TimeAttendance VerifyAttendance = new TimeAttendance(employeeUsername);
        VerifyAttendance.Clocking(employeeUsername, "out");
        VerifyAttendance.setTimeAttendanceDetails();
    }

    public int[] monthlyReport(String username, String month) {
        int[] attendanceInfo = {0, 0};
        TimeAttendance Attendance = new TimeAttendance(username);
        String[][] FileInfo = Attendance.getEmployeeAttendanceInfo();
        for (String[] info : FileInfo) {
            if (Integer.parseInt(info[1].split("-")[1]) == Integer.parseInt(month)){
                attendanceInfo[0] += 1;
                if (info[4].equals("1")){
                    attendanceInfo[1] += 1;
                }
            }
        }
        return attendanceInfo;
    }

    public int[] annualReport(String username, String currentYear) {
        int[] attendanceInfo = {0, 0};
        TimeAttendance Attendance = new TimeAttendance(username);
        String[][] FileInfo = Attendance.getEmployeeAttendanceInfo();
        for (String[] info : FileInfo) {
            if (Integer.parseInt(info[1].split("-")[2]) == Integer.parseInt(currentYear)){
                attendanceInfo[0] += 1;
                if (info[4].equals("1")){
                    attendanceInfo[1] += 1;
                }
            }
        }
        return attendanceInfo;
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

