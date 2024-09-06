package hrms_g1.Gui.Payroll_management;
import Users.PayrollOfficer;
import javax.swing.JFrame;

public class Update_Payroll extends javax.swing.JFrame {
    private String username;
    private final JFrame previousWindow;    
    
    public Update_Payroll(JFrame previousWindow, String username) {
        this.previousWindow = previousWindow;
        this.username = username;
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        getUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        setMonth = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        epf = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        socso = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        eis = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        setAnnualTax = new javax.swing.JTextPane();
        grossSalary = new javax.swing.JTextField();
        searchDetails = new javax.swing.JButton();
        updateDetails = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
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
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, -1, -1));

        getUsername.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        getUsername.setToolTipText("");
        getContentPane().add(getUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Constantia", 1, 12)); // NOI18N
        jLabel2.setText("Month :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, -1, -1));

        setMonth.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        getContentPane().add(setMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Constantia", 1, 12)); // NOI18N
        jLabel3.setText("Gross Salary :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 102, -1, -1));

        jLabel4.setFont(new java.awt.Font("Constantia", 1, 12)); // NOI18N
        jLabel4.setText("EPF :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 37, -1));

        jLabel5.setFont(new java.awt.Font("Constantia", 1, 12)); // NOI18N
        jLabel5.setText("SOCSO :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, -1, -1));

        jLabel6.setFont(new java.awt.Font("Constantia", 1, 12)); // NOI18N
        jLabel6.setText("EIS :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 30, -1));

        jLabel7.setFont(new java.awt.Font("Constantia", 1, 12)); // NOI18N
        jLabel7.setText("Annual Tax :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, -1, -1));

        epf.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        epf.setAutoscrolls(false);
        jScrollPane2.setViewportView(epf);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, -1, -1));

        socso.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        socso.setAutoscrolls(false);
        jScrollPane3.setViewportView(socso);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, -1, -1));

        eis.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        eis.setAutoscrolls(false);
        jScrollPane4.setViewportView(eis);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, -1, -1));

        setAnnualTax.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        jScrollPane5.setViewportView(setAnnualTax);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, -1, -1));
        getContentPane().add(grossSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, -1, -1));

        searchDetails.setBackground(new java.awt.Color(0, 0, 0));
        searchDetails.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        searchDetails.setForeground(new java.awt.Color(255, 255, 255));
        searchDetails.setText("Search");
        searchDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchDetailsActionPerformed(evt);
            }
        });
        getContentPane().add(searchDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, -1, -1));

        updateDetails.setBackground(new java.awt.Color(0, 0, 0));
        updateDetails.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        updateDetails.setForeground(new java.awt.Color(255, 255, 255));
        updateDetails.setText("Update");
        updateDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateDetailsActionPerformed(evt);
            }
        });
        getContentPane().add(updateDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, -1, -1));

        jLabel8.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel8.setText("Update Payroll");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 8, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 27, 300, -1));

        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel9MousePressed(evt);
            }
        });
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\images\\veva_background.jpeg")); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 450, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        previousWindow.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void searchDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchDetailsActionPerformed
        // Retrieve the username and month from the fields
        String username = getUsername.getText();
        String month = setMonth.getValue().toString();

        // Create an instance of PayrollOfficer (assuming you have a way to obtain it)
        PayrollOfficer payrollOfficer = new PayrollOfficer(); // Adjust as needed

        // Call the method to get payroll data
        String[] payrollData = payrollOfficer.getPayrollDataMonth(username, month);

        // Update the text panes with the retrieved data
        if (payrollData != null) {
            grossSalary.setText(payrollData[1]);  // payrollData[1] is the gross salary
            epf.setText(payrollData[2]);  // payrollData[2] is the EPF
            socso.setText(payrollData[3]);  // payrollData[3] is the SOCSO
            eis.setText(payrollData[4]);  // payrollData[4] is the EIS
            setAnnualTax.setText(payrollData[5]);  // payrollData[5] is the annual tax
        } else {
            // Handle the case where no data is found or an error occurs
            grossSalary.setText("No data found");
            epf.setText("No data found");
            socso.setText("No data found");
            eis.setText("No data found");
            setAnnualTax.setText("No data found");
        }
    }//GEN-LAST:event_searchDetailsActionPerformed

    private void updateDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateDetailsActionPerformed
        // Retrieve the username, month, and updated values from the fields
        String username = getUsername.getText();
        String month = setMonth.getValue().toString();
        int newGrossSalary;

        try {
            newGrossSalary = Integer.parseInt(grossSalary.getText());
        } catch (NumberFormatException e) {
            // Handle invalid gross salary input
            grossSalary.setText("Invalid value");
            return;
        }

        // Create an instance of PayrollOfficer (assuming you have a way to obtain it)
        PayrollOfficer payrollOfficer = new PayrollOfficer(); // Adjust as needed

        // Call the method to update payroll data
        payrollOfficer.updatePayroll(username, month, newGrossSalary);

        // Optionally show a confirmation message or update the UI
        javax.swing.JOptionPane.showMessageDialog(this, "Payroll updated successfully.");
    }//GEN-LAST:event_updateDetailsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane eis;
    private javax.swing.JTextPane epf;
    private javax.swing.JTextField getUsername;
    private javax.swing.JTextField grossSalary;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton searchDetails;
    private javax.swing.JTextPane setAnnualTax;
    private javax.swing.JSpinner setMonth;
    private javax.swing.JTextPane socso;
    private javax.swing.JButton updateDetails;
    // End of variables declaration//GEN-END:variables
}
