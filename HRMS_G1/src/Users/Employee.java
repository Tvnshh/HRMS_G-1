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
        // String date = TimeAttendance.getCurrentDate();
        // String time = VerifyAttendance.getTime();
        VerifyAttendance.Clocking(employeeUsername, "in");
        VerifyAttendance.setTimeAttendanceDetails();

    }

    public void clockOut(String employeeUsername) {
        TimeAttendance VerifyAttendance = new TimeAttendance(employeeUsername);
        //String date = TimeAttendance.getCurrentDate();
        // String time = VerifyAttendance.getTime();
        // if
        // (!(VerifyAttendance.getEmployeeUsername().equals(employeeUsername)&&(VerifyAttendance.getDate().equals(date)))){
        // TimeAttendance Attendance = new TimeAttendance(employeeUsername, "out");
        // Attendance.setTimeAttendanceDetails();
        // }
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
}

