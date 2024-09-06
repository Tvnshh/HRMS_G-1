/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hrms_g1.Gui.Time_Attendance_Management;
import Users.Employee;
import javax.swing.JFrame;
/**
 *
 * @author tvanm
 */
public class Clock_In_Out extends javax.swing.JFrame {
    private String username;
    private final JFrame previousWindow;    

    public Clock_In_Out(JFrame previousWindow, String username) {
        this.username = username;
        this.previousWindow = previousWindow;
        initComponents();
    }
    
    public Clock_In_Out(JFrame previousWindow) {
        this.previousWindow = previousWindow;
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

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        clockInOut = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        passwordField = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(153, 255, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 75, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 204));
        jLabel1.setText("Username:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 95, -1, -1));

        usernameField.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });
        getContentPane().add(usernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 118, 262, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 204));
        jLabel2.setText("Password:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 171, -1, -1));

        clockInOut.setBackground(new java.awt.Color(255, 255, 153));
        clockInOut.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        clockInOut.setText("Clock IN/OUT");
        clockInOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clockInOutActionPerformed(evt);
            }
        });
        getContentPane().add(clockInOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 250, 130, 30));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 102));
        jLabel3.setText("Clock In/Out");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 37, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 190, 20));

        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });
        getContentPane().add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 260, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\images\\backgroundimg_tk2.jpg")); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        previousWindow.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void clockInOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clockInOutActionPerformed
        String enteredUsername = usernameField.getText(); // Get username from the input field
        String enteredPassword = new String(passwordField.getPassword()); // Get password from the input field

        Employee employee = new Employee();

        if (employee.verifyPassword(enteredUsername, enteredPassword)) {
            int clockInOrOut = javax.swing.JOptionPane.showConfirmDialog(
                    this, 
                    "Do you want to clock in? (Click 'No' to clock out)", 
                    "Clock In/Out", 
                    javax.swing.JOptionPane.YES_NO_OPTION);

            if (clockInOrOut == javax.swing.JOptionPane.YES_OPTION) {
                employee.clockIn(enteredUsername);
                javax.swing.JOptionPane.showMessageDialog(this, "Clocked In successfully for " + enteredUsername);
            } else if (clockInOrOut == javax.swing.JOptionPane.NO_OPTION) {
                employee.clockOut(enteredUsername);
                javax.swing.JOptionPane.showMessageDialog(this, "Clocked Out successfully for " + enteredUsername);
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Incorrect username or password!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
        previousWindow.setVisible(false);
    }//GEN-LAST:event_clockInOutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clockInOut;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
