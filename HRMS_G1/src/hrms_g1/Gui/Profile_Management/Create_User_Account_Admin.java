/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hrms_g1.Gui.Profile_Management;
import Users.SystemAdministrator;
import Users.HumanResourceOfficer;
import javax.swing.JFrame;


/**
 *
 * @author tvanm
 */
public class Create_User_Account_Admin extends javax.swing.JFrame {
    private String username;
    private final JFrame previousWindow;  
    
    public Create_User_Account_Admin(JFrame previousWindow, String username) {
        this.previousWindow = previousWindow;
        this.username = username;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        createUser = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        getUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        getName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        getRole = new javax.swing.JComboBox<>();
        jSeparator3 = new javax.swing.JSeparator();
        getPassword = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(727, 405));
        setPreferredSize(new java.awt.Dimension(727, 405));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Create Account");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(280, 10, 140, 44);

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton);
        backButton.setBounds(10, 20, 72, 23);

        createUser.setText("Create");
        createUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserActionPerformed(evt);
            }
        });
        getContentPane().add(createUser);
        createUser.setBounds(320, 360, 72, 23);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(120, 130, 60, 15);
        getContentPane().add(getUsername);
        getUsername.setBounds(120, 150, 210, 22);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(242, 242, 242));
        jLabel3.setText("Name :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(120, 180, 50, 15);

        getName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getNameActionPerformed(evt);
            }
        });
        getContentPane().add(getName);
        getName.setBounds(120, 200, 210, 22);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(242, 242, 242));
        jLabel4.setText("Password :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(120, 230, 60, 15);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(242, 242, 242));
        jLabel8.setText("Department :");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(380, 190, 70, 15);

        getRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "General Employee", "HR Officer", "Payroll Officer", "Department Manager" }));
        getContentPane().add(getRole);
        getRole.setBounds(380, 210, 136, 22);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(100, 50, 530, 10);
        getContentPane().add(getPassword);
        getPassword.setBounds(120, 250, 210, 22);

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\images\\profile_management_km.jpg")); // NOI18N
        getContentPane().add(jLabel10);
        jLabel10.setBounds(0, -4, 730, 410);
        getContentPane().add(jPanel1);
        jPanel1.setBounds(530, 270, 10, 10);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserActionPerformed
        String employeeUsername = getUsername.getText();
        String employeePassword = new String(getPassword.getPassword());
        String name = getName.getText();

        // Get the selected department and convert it to the role number
        String department = (String) getRole.getSelectedItem();
        int role;

        switch (department) {
            case "Admin" -> role = 1;
            case "HR Officer" -> role = 2;
            case "Department Manager" -> role = 3;
            case "Payroll Officer" -> role = 4;
            case "General Employee" -> role = 5;
            default -> {
                role = 5;
                System.out.println("Invalid Department");
                return;
            }
        }

        SystemAdministrator systemAdmin = new SystemAdministrator();
        systemAdmin.createUser(role, employeeUsername, employeePassword, name);

        javax.swing.JOptionPane.showMessageDialog(this, "User Created Successfully!");
        this.dispose();
        previousWindow.setVisible(true);
    }//GEN-LAST:event_createUserActionPerformed

    private void getNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_getNameActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.dispose();
        previousWindow.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton createUser;
    private javax.swing.JTextField getName;
    private javax.swing.JPasswordField getPassword;
    private javax.swing.JComboBox<String> getRole;
    private javax.swing.JTextField getUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
