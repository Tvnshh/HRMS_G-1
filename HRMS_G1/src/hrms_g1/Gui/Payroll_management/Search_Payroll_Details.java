
package hrms_g1.Gui.Payroll_management;
import Users.PayrollOfficer;
import javax.swing.JFrame;

public class Search_Payroll_Details extends javax.swing.JFrame {
    private String username;
    private final JFrame previousWindow;    
    public Search_Payroll_Details(JFrame previousWindow, String username) {
        this.previousWindow = previousWindow;
        this.username = username;
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        selectMonth = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        grossSalary = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        netSalary = new javax.swing.JTextPane();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        jLabel5.setText("jLabel5");

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Constantia", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, -1, -1));

        jLabel1.setFont(new java.awt.Font("Constantia", 1, 12)); // NOI18N
        jLabel1.setText("Username :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 57, -1, -1));

        usernameField.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        getContentPane().add(usernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 54, 71, -1));

        searchButton.setBackground(new java.awt.Color(0, 0, 0));
        searchButton.setFont(new java.awt.Font("Constantia", 1, 12)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        getContentPane().add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 54, -1, -1));

        jLabel2.setFont(new java.awt.Font("Constantia", 1, 12)); // NOI18N
        jLabel2.setText("Month :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 98, -1, -1));

        selectMonth.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        getContentPane().add(selectMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 95, -1, -1));

        jLabel3.setFont(new java.awt.Font("Constantia", 1, 12)); // NOI18N
        jLabel3.setText("Gross Salary :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 150, -1, -1));

        jLabel6.setFont(new java.awt.Font("Constantia", 1, 12)); // NOI18N
        jLabel6.setText("Net Salary :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, -1, -1));

        jScrollPane2.setMinimumSize(new java.awt.Dimension(64, 21));

        grossSalary.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        jScrollPane2.setViewportView(grossSalary);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, -1, -1));

        jScrollPane3.setMinimumSize(new java.awt.Dimension(64, 21));

        netSalary.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        jScrollPane3.setViewportView(netSalary);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 270, -1));

        jLabel8.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel8.setText("Search Payroll Details");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        jLabel7.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\images\\veva_background.jpeg")); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 460, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        previousWindow.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
    String username = usernameField.getText();
    String month = selectMonth.getValue().toString();
    
    String[] payrollData = new PayrollOfficer().getPayrollDataMonth(username, month);
    
    if (payrollData != null) {
        grossSalary.setText(payrollData[1]); // Assuming payrollData[1] is the gross salary
        netSalary.setText(payrollData[6]);   // Assuming payrollData[6] is the net salary
    } else {
        grossSalary.setText("No data found");
        netSalary.setText("No data found");
    }
    }//GEN-LAST:event_searchButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane grossSalary;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane netSalary;
    private javax.swing.JButton searchButton;
    private javax.swing.JSpinner selectMonth;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
