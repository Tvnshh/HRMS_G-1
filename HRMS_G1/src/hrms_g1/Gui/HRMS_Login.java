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
        getPassword = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        getPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getPasswordActionPerformed(evt);
            }
        });

        jLabel1.setText("Login Page");

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(getUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                            .addComponent(getPassword)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(loginButton)))
                .addContainerGap(156, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(getUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(getPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(loginButton)
                .addContainerGap(82, Short.MAX_VALUE))
        );

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

    private void getPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_getPasswordActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HRMS_Login login = new HRMS_Login();
                login.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField getPassword;
    private javax.swing.JTextField getUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton loginButton;
    // End of variables declaration//GEN-END:variables
}
