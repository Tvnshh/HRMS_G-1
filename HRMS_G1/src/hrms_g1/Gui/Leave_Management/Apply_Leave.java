package hrms_g1.Gui.Leave_Management;
import Users.HumanResourceOfficer;
import javax.swing.JFrame;

public class Apply_Leave extends javax.swing.JFrame {
    private String username;
    private final JFrame previousWindow;  
    
    public Apply_Leave(JFrame previousWindow, String username) {
        this.previousWindow = previousWindow;
        this.username = username;
        populateLeaveTypes();
        initComponents();
    }

    private void populateLeaveTypes() {
        displayLeaveType.removeAllItems();
        displayLeaveType.addItem("Annual");
        displayLeaveType.addItem("Medical");
        displayLeaveType.addItem("Unpaid");
        if (new HumanResourceOfficer().retrieveUserDetails(username)[14].equals("F")) {
            displayLeaveType.addItem("Maternity");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        displayLeaveType = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        leaveDuration = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        leaveDate = new javax.swing.JTextField();
        applyButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(640, 356));
        setPreferredSize(new java.awt.Dimension(640, 356));
        setResizable(false);
        getContentPane().setLayout(null);

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton1.setText("BACK");
        jButton1.setActionCommand("Back ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(6, 18, 72, 22);

        jLabel1.setFont(new java.awt.Font("Bauhaus 93", 0, 18)); // NOI18N
        jLabel1.setText("Leave type ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(210, 80, 100, 20);

        displayLeaveType.setBackground(new java.awt.Color(153, 153, 153));
        displayLeaveType.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        getContentPane().add(displayLeaveType);
        displayLeaveType.setBounds(310, 80, 87, 21);

        jLabel2.setFont(new java.awt.Font("Bauhaus 93", 0, 18)); // NOI18N
        jLabel2.setText("Duration (days) ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(158, 140, 132, 28);

        leaveDuration.setBackground(new java.awt.Color(153, 153, 153));
        leaveDuration.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        getContentPane().add(leaveDuration);
        leaveDuration.setBounds(310, 140, 141, 21);

        jLabel3.setFont(new java.awt.Font("Bauhaus 93", 0, 18)); // NOI18N
        jLabel3.setText("(DD/MM/YY) date ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(140, 210, 160, 28);

        leaveDate.setBackground(new java.awt.Color(153, 153, 153));
        leaveDate.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        getContentPane().add(leaveDate);
        leaveDate.setBounds(310, 210, 141, 21);

        applyButton.setBackground(new java.awt.Color(0, 255, 0));
        applyButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        applyButton.setText("Apply ");
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButtonActionPerformed(evt);
            }
        });
        getContentPane().add(applyButton);
        applyButton.setBounds(270, 280, 72, 22);

        jLabel4.setBackground(new java.awt.Color(255, 51, 51));
        jLabel4.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        jLabel4.setText("Leave Application ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(220, 10, 200, 36);

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\images\\beach 2.0.jpg")); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, -90, 650, 540);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        previousWindow.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonActionPerformed
        String leaveType = (String) displayLeaveType.getSelectedItem();
        int duration = Integer.parseInt(leaveDuration.getText());
        String date = leaveDate.getText();
        String approvalStatus = "pending"; // Assuming it's set to "Pending" initially
        new HumanResourceOfficer().applyLeave(leaveType, duration, date, approvalStatus, username);
    }//GEN-LAST:event_applyButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyButton;
    private javax.swing.JComboBox<String> displayLeaveType;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField leaveDate;
    private javax.swing.JTextField leaveDuration;
    // End of variables declaration//GEN-END:variables
}
