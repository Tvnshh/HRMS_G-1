package hrms_g1.Gui;
import hrms_g1.Gui.Dep_Manager.Dep_Manager_Menu;
import hrms_g1.Gui.Employee.Employee_Menu;
import hrms_g1.Gui.HR_Officer.HR_Officer_Menu;
import hrms_g1.Gui.Payroll_Officer.Payroll_Officer_Menu;
import hrms_g1.Gui.System_Admin.System_Admin_Menu;

import Users.Login;
import Users.SystemAdministrator;

public class HRMS_Login extends javax.swing.JFrame {
    private String username;    
    private String password;
    int attempt = 0;
    public HRMS_Login() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        getUsername = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        getPassword = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(403, 294));
        setPreferredSize(new java.awt.Dimension(403, 294));
        setResizable(false);
        getContentPane().setLayout(null);

        getUsername.setBackground(new java.awt.Color(153, 153, 153));
        getContentPane().add(getUsername);
        getUsername.setBounds(140, 80, 160, 22);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Login Page");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(130, 10, 150, 29);

        loginButton.setBackground(new java.awt.Color(0, 0, 255));
        loginButton.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setText("LOGIN");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        getContentPane().add(loginButton);
        loginButton.setBounds(160, 200, 80, 22);

        getPassword.setBackground(new java.awt.Color(153, 153, 153));
        getContentPane().add(getPassword);
        getPassword.setBounds(140, 130, 160, 22);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(120, 40, 160, 10);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Username ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 80, 120, 20);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Password ");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(70, 130, 120, 15);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\images\\HR_Menu.jpg")); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 430, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
    username = getUsername.getText();
    password = getPassword.getText();
    Login login = new Login(username, password);
    int role = login.login();
    
    if (role == 0) {
        attempt += 1;
        if (attempt < 4) {
            javax.swing.JOptionPane.showMessageDialog(this, "Invalid login, please try again. Attempts left: " + (4 - attempt));
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Maximum login attempts reached. Please contact admin.");
            this.dispose(); // Closes the login window
        }
    } else {
        // Navigate to appropriate menu based on role
        switch (role) {
            case 1:
                new System_Admin_Menu(username).setVisible(true);
                break;
            case 2:
                new HR_Officer_Menu(username).setVisible(true);
                break;
            case 3:
                new Dep_Manager_Menu(username).setVisible(true);
                break;
            case 4:
                new Payroll_Officer_Menu(username).setVisible(true);
                break;
            case 5:
                new Employee_Menu(username).setVisible(true);
                break;
            default:
                javax.swing.JOptionPane.showMessageDialog(this, "Invalid role. Please contact admin.");
                break;
        }
        this.setVisible(false); // Hide login window after successful login
    }
    }//GEN-LAST:event_loginButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HRMS_Login login = new HRMS_Login();
                login.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField getPassword;
    private javax.swing.JTextField getUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton loginButton;
    // End of variables declaration//GEN-END:variables
}
