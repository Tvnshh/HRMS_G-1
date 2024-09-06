/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hrms_g1.Gui.Leave_Management;
import Users.DepartmentManager;
import Users.HumanResourceOfficer;
import javax.swing.JFrame;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author tvanm
 */
public class Check_Leave_Status extends javax.swing.JFrame {
    private String username;
    private final JFrame previousWindow;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
    
    public Check_Leave_Status(JFrame previousWindow, String username) {
        this.previousWindow = previousWindow;
        this.username = username;
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        setDate = new javax.swing.JTextPane();
        selectDate = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayLeaveType = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        displayDuration = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        displayStatus = new javax.swing.JTextPane();
        searchButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(582, 328));
        setResizable(false);
        getContentPane().setLayout(null);

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(6, 15, 72, 22);

        jLabel1.setFont(new java.awt.Font("Bauhaus 93", 0, 14)); // NOI18N
        jLabel1.setText("Select Date ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(140, 90, 90, 20);

        setDate.setBackground(new java.awt.Color(153, 153, 153));
        setDate.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        getContentPane().add(setDate);
        setDate.setBounds(240, 160, 140, 19);
        getContentPane().add(selectDate);
        selectDate.setBounds(240, 90, 140, 22);

        jLabel2.setFont(new java.awt.Font("Bauhaus 93", 0, 14)); // NOI18N
        jLabel2.setText("Leave Type ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(140, 130, 80, 20);

        displayLeaveType.setBackground(new java.awt.Color(153, 153, 153));
        displayLeaveType.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(displayLeaveType);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(240, 130, 140, 21);

        jLabel3.setFont(new java.awt.Font("Bauhaus 93", 0, 14)); // NOI18N
        jLabel3.setText("Date ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(180, 170, 40, 20);

        jLabel4.setFont(new java.awt.Font("Bauhaus 93", 0, 14)); // NOI18N
        jLabel4.setText("Duration ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(160, 200, 70, 20);

        displayDuration.setBackground(new java.awt.Color(153, 153, 153));
        displayDuration.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jScrollPane3.setViewportView(displayDuration);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(240, 200, 140, 21);

        jLabel5.setFont(new java.awt.Font("Bauhaus 93", 0, 14)); // NOI18N
        jLabel5.setText("Status ");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(170, 250, 50, 15);

        displayStatus.setBackground(new java.awt.Color(153, 153, 153));
        displayStatus.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jScrollPane4.setViewportView(displayStatus);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(240, 240, 140, 21);

        searchButton.setBackground(new java.awt.Color(153, 153, 153));
        searchButton.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        searchButton.setText("Search ");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        getContentPane().add(searchButton);
        searchButton.setBounds(400, 90, 72, 22);

        jLabel6.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        jLabel6.setText("Check Leave Status");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(200, 30, 220, 30);

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\images\\beach 2.0.jpg")); // NOI18N
        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 0, 580, 330);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        previousWindow.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        DepartmentManager hr = new DepartmentManager();
        String date = selectDate.getText();

        String[] userDetails = hr.getLeaveDetails(username);

        if (userDetails != null) {
            displayLeaveType.setText(userDetails[1]);
            setDate.setText(userDetails[3]);
            displayDuration.setText(userDetails[2]);
            displayStatus.setText(userDetails[4]);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "User not found!");
        }

    }//GEN-LAST:event_searchButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane displayDuration;
    private javax.swing.JTextPane displayLeaveType;
    private javax.swing.JTextPane displayStatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField selectDate;
    private javax.swing.JTextPane setDate;
    // End of variables declaration//GEN-END:variables
}
