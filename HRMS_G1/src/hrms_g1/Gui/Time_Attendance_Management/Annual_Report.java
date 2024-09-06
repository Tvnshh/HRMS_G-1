package hrms_g1.Gui.Time_Attendance_Management;
import Users.Employee;
import javax.swing.JFrame;

public class Annual_Report extends javax.swing.JFrame {
    private String username;
    private final JFrame previousWindow;    
    
    public Annual_Report(JFrame previousWindow, String username) {
        String currentYear = "2024";
        this.previousWindow = previousWindow;
        this.username = username;
        initComponents();
        loadAnnualReport(username, currentYear);
    }
    
    private void loadAnnualReport(String username, String currentYear) {
        // Create an Employee instance
        Employee employee = new Employee();
        
        // Get the annual attendance report
        int[] report = employee.annualReport(username, currentYear);
        
        // Set the total attendance and late attendance data in the text fields
        totalAttendanceYear.setText(String.valueOf(report[0])); // Total attendance
        totalLateAttendanceYear.setText(String.valueOf(report[1])); // Late attendance
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        totalAttendanceYear = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        totalLateAttendanceYear = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Annual Report");
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
        jLabel1.setForeground(new java.awt.Color(255, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Total Attendance for current Year");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setMaximumSize(new java.awt.Dimension(191, 16));
        jLabel1.setMinimumSize(new java.awt.Dimension(191, 16));
        jLabel1.setPreferredSize(new java.awt.Dimension(191, 16));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 101, 250, -1));

        totalAttendanceYear.setBackground(new java.awt.Color(153, 153, 153));
        totalAttendanceYear.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(totalAttendanceYear);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 135, 100, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Late Attendance");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 196, 241, -1));

        totalLateAttendanceYear.setBackground(new java.awt.Color(153, 153, 153));
        totalLateAttendanceYear.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jScrollPane2.setViewportView(totalLateAttendanceYear);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 231, 100, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Annual Report");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 37, 165, -1));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 51));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 190, 20));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\images\\backgroundimg_tk1.jpg")); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        previousWindow.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextPane totalAttendanceYear;
    private javax.swing.JTextPane totalLateAttendanceYear;
    // End of variables declaration//GEN-END:variables
}
