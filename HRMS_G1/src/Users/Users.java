package Users;

//Hello Miss, hope you like our project

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
    public String[] viewProfile(String username){
        EmployeeProfile Profile = new EmployeeProfile(username);
        return Profile.getEmployeeInfo();
    }

    public static void main(String[] args) {
        //Testing
        SystemAdministrator testObj = new SystemAdministrator();
        
        testObj.createUser(2, "Tarun Krishnan", "1234", "Tarun"); //Works

//        String[] testArray = testObj.retrieveUserDetails("Tarun Krishnan");
//        System.out.println(Arrays.toString(testArray)); //Works

//        testObj.deleteUserAccount("A0006");//Works

//        String[] testArray = testObj.retrieveUserDetails("Tarun Krishnan");
//        testArray[2] = "123"; //Works
//        testObj.updateAccountDetails(testArray);

//        testObj.updateAccountStatus("Tarun Krishnan", 0);//Works
                
//        HumanResourceOfficer testObj = new HumanResourceOfficer();
        
//        testObj.createEmployeeProfile(3, "A0009", "GOAT NO 1", 0, 1, "Kuthire Savari", "0128820192", "tkri05@gmail.com", "Jalan Klang, Penang", "999", 3, "Officer", "Payroll", "5000");
//        Works

//        String[] testArray = testObj.retrieveUserDetails("Tarun Krishnan");
//        System.out.println(Arrays.toString(testArray)); //Works

//        String[] testArray = testObj.retrieveUserDetails("Tarun Krishnan");
//        testArray[2] = "123"; //Works
//        testObj.updateEmployeeProfile(testArray);

//        testObj.applyLeave("Annual", 3, "02-02-2024", "pending", "Tarun Krishnan");//Works

//        testObj.cancelLeave("Tarun Krishnan", "02-02-2024");//Works

//        System.out.println(testObj.checkLeaveStatus("A0008", "01-07-2023"));//Works
//                
//        DepartmentManager testObj = new DepartmentManager();
        
//        System.out.println(Arrays.deepToString(testObj.leaveApplicationList()));//Works

//        testObj.approveLeave("A0008", "01-07-2023");//Works

//        testObj.rejectLeave("A0009", "01-07-2023");//Works

//        testObj.applyLeave("Annual", 3, "02-02-2024", "pending", "Tarun Krishnan");//Works

//        testObj.cancelLeave("Tarun Krishnan", "02-02-2024");//Works

//        testObj.checkLeaveStatus(String username, String date);//Works
//                
//        PayrollOfficer testObj = new PayrollOfficer();

//        testObj.createPayroll("Vevalakshan", 2800);

//        System.out.println(Arrays.toString(testObj.getPayrollDataMonth("Vevalakshan", "09")));//Works

//        testObj.updatePayroll("Yuthes", "09", 28000);//Works

//        testObj.applyLeave("Annual", 3, "02-02-2024", "pending", "Tarun Krishnan");//Works

//        testObj.cancelLeave("Tarun Krishnan", "02-02-2024");//Works

//        testObj.checkLeaveStatus(String username, String date);//Works
//        
//        Employee testObj = new Employee();
        
//        testObj.clockIn("Vevalakshan");

//        testObj.clockOut("Vevalakshan");

//        System.out.println(Arrays.toString(testObj.monthlyReport("A0007", "09")));

//        System.out.println(Arrays.toString(testObj.annualReport("Vevalakshan", "2024")));

//        testObj.applyLeave("Annual", 3, "02-02-2024", "pending", "Tarun Krishnan");//Works

//        testObj.cancelLeave("Tarun Krishnan", "02-02-2024");//Works

//        testObj.checkLeaveStatus(String username, String date);//Works

        

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

}
