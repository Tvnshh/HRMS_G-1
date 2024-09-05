package hrms_g1.Gui.Profile_Management;

import Users.SystemAdministrator;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Change_Password extends javax.swing.JFrame {
    private String username;
    private final JFrame previousWindow;  
    
    public Change_Password(JFrame previousWindow, String username) {
        this.previousWindow = previousWindow;
        this.username = username;
        SystemAdministrator user = new SystemAdministrator();
        initComponents();
    }
    
    private boolean validatePasswords(String oldPassword, String newPassword, String verifyPassword) {
        if (newPassword.equals(verifyPassword)) {
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "New password and confirmation do not match.");
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        getVerifyPassword = new javax.swing.JTextField();
        getNewPassword = new javax.swing.JTextField();
        getOldPassword = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        changePassword = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(566, 335));
        setPreferredSize(new java.awt.Dimension(566, 335));
        setResizable(false);
        getContentPane().setLayout(null);

        getVerifyPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getVerifyPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(getVerifyPassword);
        getVerifyPassword.setBounds(260, 190, 160, 20);

        getNewPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getNewPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(getNewPassword);
        getNewPassword.setBounds(260, 150, 160, 20);

        getOldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getOldPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(getOldPassword);
        getOldPassword.setBounds(260, 110, 160, 20);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(6, 19, 72, 23);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Old Password :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(158, 110, 80, 15);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("New Password :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(150, 150, 90, 15);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Confirm Password :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(135, 190, 102, 25);

        changePassword.setText("Change");
        changePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordActionPerformed(evt);
            }
        });
        getContentPane().add(changePassword);
        changePassword.setBounds(249, 252, 72, 23);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Change Password");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(220, 48, 145, 21);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(127, 32, 342, 10);

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\images\\profile_management_km.jpg")); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(-3, -4, 570, 340);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(127, 287, 342, 10);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void changePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePasswordActionPerformed
        String oldPassword = getOldPassword.getText();
        String newPassword = getNewPassword.getText();
        String verifyPassword = getVerifyPassword.getText();

        if (!validatePasswords(oldPassword, newPassword, verifyPassword)) {
            return;
        }

        SystemAdministrator admin = new SystemAdministrator();
        
        if (admin.verifyPassword(username, oldPassword)) {
            admin.changePassword(username, newPassword);
            JOptionPane.showMessageDialog(this, "Password changed successfully.");
        } else {
            JOptionPane.showMessageDialog(this, "Old password is incorrect.");
        }
        this.setVisible(false);
        previousWindow.setVisible(true);
    }//GEN-LAST:event_changePasswordActionPerformed

    private void getOldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getOldPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_getOldPasswordActionPerformed

    private void getNewPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getNewPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_getNewPasswordActionPerformed

    private void getVerifyPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getVerifyPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_getVerifyPasswordActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changePassword;
    private javax.swing.JTextField getNewPassword;
    private javax.swing.JTextField getOldPassword;
    private javax.swing.JTextField getVerifyPassword;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
