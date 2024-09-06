package Users;

public class Login extends Users{

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int login(){
        HumanResourceOfficer employee = new HumanResourceOfficer();
        if (employee.verifyPassword(username, password)){
            return Integer.parseInt(employee.retrieveUserDetails(username)[0]);
        } else {
            return 0;
        }
    }

    
    @Override
    public String toString() {
        return "Login{" + "username=" + username + ", password=" + password + '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean verifyPassword(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet.");  
    }

    @Override
    public void changePassword(String username, String newPassword) {
        throw new UnsupportedOperationException("Not supported yet.");  
    }

    @Override
    public String[] viewProfile(String username) {
        throw new UnsupportedOperationException("Not supported yet.");  
    }
    
    
}
