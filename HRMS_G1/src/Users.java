import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;

//helloooo

public abstract class Users {

    public Users() {
    }

    protected String username;
    protected String password;
    protected int loginAttempts = 0;

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void login(String username, String password) {
        // Login logic
    }

    public void logout() {
        // Logout logic
    }

    public boolean verifyPassword(String username, String password) {
        EmployeeProfile employee = new EmployeeProfile(username);
        return password.equals(employee.getEmployeePassword());
    }

    public void changePassword(String username, String newPassword) {
        EmployeeProfile employee = new EmployeeProfile(username);
        employee.setEmployeePassword(newPassword);
        employee.setEmployeeInfo();
    }

    public static void main(String[] args) {
        //Employee emp = new Employee();
        //emp.clockOut("A0007");
        //emp.clockOut("A0007");
        //EmployeeProfile profile = new EmployeeProfile("A0009");
        //System.out.println(profile.getName());
        // TimeAttendance timeA = new TimeAttendance("A0007");

        // DepartmentManager hr = new DepartmentManager();
        // System.out.println(dm.leaveApplicationList()[1][1]);
        // System.out.println(hr.checkLeaveStatus("A0006","2023-07-01"));
        // SystemAdministrator admin = new SystemAdministrator();
        // admin.deleteUserAccount("Tarun");
        // admin.changePassword("A0007", "abc");
        // admin.createUser(1, "Tarun", "123", 0, 0, "Tarun Krishnan", "012123456",
        // "em", "addd", "emarg", 1, "a", "b", "c");
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
// SystemAdministrator admin = new SystemAdministrator();
// admin.createUser(role, employeeUsername, employeePassword, loginAttempts,
// accountStatus, name, contact, email, address, emergencyContact,
// workExperience, position, department, monthlyGSalary)

class SystemAdministrator extends Users {
    private List<String> employeeDetails = new ArrayList<>();

    public void createUser(int role, String employeeUsername, String employeePassword, String name) {
        EmployeeProfile newEmployee = new EmployeeProfile(role, employeeUsername, employeePassword,
                /* loginattempt */ 0, 1, name, " ", " ", " ", " ", 0, " ", " ", " ");
        newEmployee.setEmployeeInfo();
    }

    public String[] retrieveUserDetails(String username) {
        EmployeeProfile employee = new EmployeeProfile(username);
        return employee.getEmployeeInfo();
    }

    public void deleteUserAccount(String username) {
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
                if (!(employee.split(",")[1].equals(username))) {
                    writer.write(employee + "\n");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(SystemAdministrator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String[] searchUserAccount(String username) {
        EmployeeProfile employee = new EmployeeProfile(username);
        return employee.getEmployeeInfo();
    }

    public void updateAccountDetails(String[] employeeInfo) {
        EmployeeProfile employee = new EmployeeProfile(employeeInfo[0]);
        employee.setEmployeeInfo(employeeInfo);
        employee.setEmployeeInfo();
    }

    public void updateAccountStatus(String username, String accountStatus) {
        EmployeeProfile employee = new EmployeeProfile(username);
        employee.setEmployeeInfo();
    }
}

class HumanResourceOfficer extends Users {

    public void createEmployeeProfile(int role, String employeeUsername, String employeePassword, int loginAttempts,
            int accountStatus, String name, String contact, String email, String address, String emergencyContact,
            int workExperience, String position, String department, String monthlyGSalary) {
        EmployeeProfile newEmployee = new EmployeeProfile(employeeUsername);
        String[] employeeInfo = { Integer.toString(role), employeeUsername, employeePassword,
                Integer.toString(loginAttempts), Integer.toString(accountStatus), name, contact, email, address,
                emergencyContact, Integer.toString(workExperience), position, department, monthlyGSalary };
        newEmployee.setEmployeeInfo(employeeInfo);
        newEmployee.setEmployeeInfo();
    }

    public String[] retrieveUserDetails(String username) {
        EmployeeProfile employee = new EmployeeProfile(username);
        return employee.getEmployeeInfo();
    }

    public void updateEmployeeProfile(String[] employeeInfo) {
        EmployeeProfile employee = new EmployeeProfile(employeeInfo[0]);
        employee.setEmployeeInfo(employeeInfo);
        employee.setEmployeeInfo();
    }

    public void applyLeave(String leaveType, int duration, String date, String approvalStatus,
            String employeeUsername) {
        LeaveApplication newLeave = new LeaveApplication(leaveType, duration, date, approvalStatus, employeeUsername);
        newLeave.setLeaveDetails();
    }

    public void cancelLeave(String username, String date) {
        LeaveApplication leave = new LeaveApplication(username);
        leave.deleteLeave(date);
        leave.setLeaveDetails();
    }

    public String checkLeaveStatus(String username, String date) {
        LeaveApplication leave = new LeaveApplication(username);
        return leave.getLeaveDetails()[4];
    }
}

class DepartmentManager extends Users {

    public void applyLeave(String leaveType, int duration, String date, String approvalStatus,
            String employeeUsername) {
        LeaveApplication newLeave = new LeaveApplication(leaveType, duration, date, approvalStatus, employeeUsername);
        newLeave.setLeaveDetails();
    }

    public void cancelLeave(String username, String date) {
        LeaveApplication leave = new LeaveApplication(username);
        leave.deleteLeave(date);
        leave.setLeaveDetails();
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

    public void approveLeave(String username, String date) {
        LeaveApplication leave = new LeaveApplication(username);
        leave.setApprovalStatus("approved");
        leave.setLeaveDetails();
    }

    public void rejectLeave(String username, String date) {
        LeaveApplication leave = new LeaveApplication(username);
        leave.setApprovalStatus("rejected");
        leave.setLeaveDetails();
    }

}

class PayrollOfficer extends Users {

    public void applyLeave(String leaveType, int duration, String date, String approvalStatus,
            String employeeUsername) {
        LeaveApplication newLeave = new LeaveApplication(leaveType, duration, date, approvalStatus, employeeUsername);
        newLeave.setLeaveDetails();
    }

    public void cancelLeave(String username, String date) {
        LeaveApplication leave = new LeaveApplication(username);
        leave.deleteLeave(date);
        leave.setLeaveDetails();
    }

    public String checkLeaveStatus(String username, String date) {
        LeaveApplication leave = new LeaveApplication(username);
        return leave.getLeaveDetails()[4];
    }

    public void createPayroll(String username, int grossSalary) {
        Payroll payroll = new Payroll(username, grossSalary);
        payroll.setPayrollDetails();
    }

    public String[] getPayrollDataMonth(String username, String month) {
        Payroll payroll = new Payroll(username, month);
        // Get_Payroll_Data logic
        return payroll.getPayrollDetails();
    }
    // public String[] getPayrollData(String username) {
    // Payroll payroll = new Payroll(username);
    // // Get_Payroll_Data logic
    // return payroll.getPayrollDetails();
    // }

    public void updatePayroll(String username, String month, int newGrossSalary) {
        Payroll payroll = new Payroll(username, month);
        payroll.setGrossSalary(newGrossSalary);
        payroll.setPayrollDetails();
    }

}

class Employee extends Users {

    public void applyLeave(String leaveType, int duration, String date, String approvalStatus, String employeeUsername) {
        LeaveApplication newLeave = new LeaveApplication(leaveType, duration, date, approvalStatus, employeeUsername);
        newLeave.setLeaveDetails();
    }

    public void cancelLeave(String username, String date) {
        LeaveApplication leave = new LeaveApplication(username);
        leave.deleteLeave(date);
        leave.setLeaveDetails();
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
        if (Integer.parseInt(month) < 10 && month.length() < 2){
            month = "0"+month;
        }
        TimeAttendance Attendance = new TimeAttendance(username);
        String[][] FileInfo = Attendance.getEmployeeAttendanceInfo();
        for (String[] info : FileInfo) {
            if (info[1].split("-")[1].equals(month)){
                attendanceInfo[0] += 1;
                if (info[4].equals("1")){
                    attendanceInfo[1] += 1;
                }
            }
        }
        return attendanceInfo;
    }

    public void annualReport(String username, String currentYear) {
        // Annual_Report logic
    }
}

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
    private String[] employeeInfo = new String[14];

    public EmployeeProfile(int role, String employeeUsername, String employeePassword, int loginAttempts,
            int accountStatus, String name, String contact, String email, String address, String emergencyContact,
            int workExperience, String position, String department, String monthlyGSalary) {
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
    }

    public EmployeeProfile(String username) {
        String filepath = "user_profile.txt";
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
    }

    public void setEmployeeInfo() {

        for (int i = 0; i < employeeDetails.size(); i++) {
            String employee = employeeDetails.get(i);
            if (employee.split(",")[1].equals(employeeUsername)) {
                employeeDetails.set(i, String.join(",", getEmployeeInfo()));
            }
        }
        try (FileWriter writer = new FileWriter("user_profile.txt", false)) {
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
        employeeInfo[5] = this.name;
        employeeInfo[6] = this.contact;
        employeeInfo[7] = this.email;
        employeeInfo[8] = this.address;
        employeeInfo[9] = this.emergencyContact;
        employeeInfo[10] = Integer.toString(this.workExperience);
        employeeInfo[11] = this.position;
        employeeInfo[12] = this.department;
        employeeInfo[13] = this.monthlyGSalary;
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

    public void setEmployeeInfo(String[] employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

}

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
        for (int i = 0; i < leaveInfo.size(); i++) {
            String leave = leaveInfo.get(i);
            if (leave.split(",")[1].equals(employeeUsername)) {
                leaveInfo.set(i, String.join(",", getLeaveDetails()));
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

    public void deleteLeave(String date) {
        for (int i = 0; i < leaveInfo.size(); i++) {
            String leave = leaveInfo.get(i);
            if (leave.split(",")[0].equals(employeeUsername) && leave.split(",")[3].equals(date)) {
                leaveInfo.remove(i);
                i--; // Adjust index after removal
            }
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
        this.leaveDetails = leaveDetails;
    }

    // leave request & leave history

}

class Payroll {
    private List<String> payrollInfo = new ArrayList<>();
    // payroll transaction
    private String employeeUsername;
    private int grossSalary;
    private double epf;
    private double socso;
    private double eis;
    private double annualTax;
    private double netSalary;
    private String date;
    private String[] payrollDetails = new String[8];

    public Payroll(String username, int grossSalary) {
        LocalDate myObj = LocalDate.now(); // Create a date object
        this.employeeUsername = username;
        this.grossSalary = grossSalary;
        this.epf = grossSalary * 0.11;
        this.socso = grossSalary * 0.005;
        this.eis = grossSalary * 0.002;
        this.annualTax = grossSalary * 0.41666;
        this.netSalary = grossSalary - epf - socso - eis - annualTax;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.date = myObj.format(formatter);
    }

    public Payroll(String username) {
        String filepath = "payroll_transaction.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.split(",")[0].equals(username)) {
                    payrollDetails = line.split(",");
                }
                payrollInfo.add(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Payroll.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Payroll.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.employeeUsername = payrollDetails[0];
        this.grossSalary = Integer.parseInt(payrollDetails[1]);
        this.epf = Integer.parseInt(payrollDetails[2]);
        this.socso = Integer.parseInt(payrollDetails[3]);
        this.eis = Integer.parseInt(payrollDetails[4]);
        this.annualTax = Integer.parseInt(payrollDetails[5]);
        this.netSalary = Integer.parseInt(payrollDetails[6]);
        this.date = payrollDetails[7];
    }

    public Payroll(String username, String month) {
        String filepath = "payroll_transaction.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.split(",")[0].equals(username) && line.split(",")[4].split("-")[1].equals(month)) {
                    payrollDetails = line.split(",");
                }
                payrollInfo.add(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Payroll.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Payroll.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.employeeUsername = payrollDetails[0];
        this.grossSalary = Integer.parseInt(payrollDetails[1]);
        this.epf = Integer.parseInt(payrollDetails[2]);
        this.socso = Integer.parseInt(payrollDetails[3]);
        this.eis = Integer.parseInt(payrollDetails[4]);
        this.annualTax = Integer.parseInt(payrollDetails[5]);
        this.netSalary = Integer.parseInt(payrollDetails[6]);
        this.date = payrollDetails[7];
    }

    public void setPayrollDetails() {
        // put into database

        for (int i = 0; i < payrollInfo.size(); i++) {
            String payroll = payrollInfo.get(i);
            if (payroll.split(",")[1].equals(employeeUsername)) {
                payrollInfo.set(i, String.join(",", getPayrollDetails()));
            }
        }
        try (FileWriter writer = new FileWriter("payroll_transaction.txt", false)) {
            for (String payroll : payrollInfo) {
                writer.write(payroll + "\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(Payroll.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getGrossSalary() {
        return grossSalary;
    }

    public double getEpf() {
        return epf;
    }

    public double getSocso() {
        return socso;
    }

    public double getEis() {
        return eis;
    }

    public double getAnnualTax() {
        return annualTax;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public String getDate() {
        return date;
    }

    public String[] getPayrollDetails() {
        payrollDetails[0] = this.employeeUsername;
        payrollDetails[1] = Integer.toString(this.grossSalary);
        payrollDetails[2] = Double.toString(this.epf);
        payrollDetails[3] = Double.toString(this.socso);
        payrollDetails[4] = Double.toString(this.eis);
        payrollDetails[5] = Double.toString(this.annualTax);
        payrollDetails[6] = Double.toString(this.netSalary);
        payrollDetails[7] = this.date;
        return payrollDetails;
    }

    public String getEmployeeUsername() {
        return employeeUsername;
    }

    public void setEmployeeUsername(String employeeUsername) {
        this.employeeUsername = employeeUsername;
    }

    public void setGrossSalary(int grossSalary) {
        this.grossSalary = grossSalary;
    }

    public void setEpf(double epf) {
        this.epf = epf;
    }

    public void setSocso(double socso) {
        this.socso = socso;
    }

    public void setEis(double eis) {
        this.eis = eis;
    }

    public void setAnnualTax(double annualTax) {
        this.annualTax = annualTax;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPayrollDetails(String[] payrollDetails) {
        this.payrollDetails = payrollDetails;
    }
}

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

        this.lateAttendance = Integer.parseInt(time.split(":")[0]) > 8 ? 1 : 0;
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
