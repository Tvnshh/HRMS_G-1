/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hrms_g1.Gui.Payroll_management;
import Users.Employee;
import Users.PayrollOfficer;
import Users.SystemAdministrator;
import java.text.DecimalFormat;
import javax.swing.JFrame;

/**
 *
 * @author tvanm
 */
public class Generate_Monthly_Slip extends javax.swing.JFrame {
    private String username;
    private final JFrame previousWindow;    
    /**
     * Creates new form Clock_In_Out
     */
    public Generate_Monthly_Slip(JFrame previousWindow, String username) {
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

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        usernameSearchBar = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        generatePaySlip = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        setNetSalary = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(620, 370));
        setPreferredSize(new java.awt.Dimension(620, 370));
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
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 68, -1));

        usernameSearchBar.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        getContentPane().add(usernameSearchBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 71, -1));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 270, 10));

        jLabel3.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel3.setText("Generate Monthly Slip");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 650, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Gross Salary", null, "EmployeeEPF", null, "Employer EPF", null},
                {null, null, "Employee SOCSO", null, "Employer SOCSO", null},
                {null, null, "Employee EIS", null, "Employer EIS", null},
                {null, null, "Income Tax PCB", null, "Income Tax PCB", null},
                {null, null, "Late Attendance", null, "Total", null},
                {null, null, "Total", null, null, null}
            },
            new String [] {
                "Income", "Amount (RM)", "Deduction", "Amount (RM)", "Contribution", "Amount (RM)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.setAlignmentY(1.0F);
        jTable2.setIntercellSpacing(new java.awt.Dimension(0, 5));
        jTable2.setRowHeight(35);
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 107, 570, 260));

        generatePaySlip.setBackground(new java.awt.Color(0, 0, 0));
        generatePaySlip.setFont(new java.awt.Font("Constantia", 1, 12)); // NOI18N
        generatePaySlip.setForeground(new java.awt.Color(255, 255, 255));
        generatePaySlip.setText("Generate");
        generatePaySlip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generatePaySlipActionPerformed(evt);
            }
        });
        getContentPane().add(generatePaySlip, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, -1, -1));

        jScrollPane1.setViewportView(setNetSalary);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, 100, -1));

        jLabel4.setText("Net Salary: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\images\\veva_background.jpeg")); // NOI18N
        jLabel2.setToolTipText("");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -70, 710, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generatePaySlipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generatePaySlipActionPerformed
    SystemAdministrator admin = new SystemAdministrator();
    
    // Retrieve user details based on the input username
    String[] userDetails = admin.retrieveUserDetails(usernameSearchBar.getText());
    
    
    // Get attendance details
    Employee employee = new Employee();
    int[] attendanceDetails = employee.monthlyReport(usernameSearchBar.getText(), "09");

    // Financial formatting
    DecimalFormat df = new DecimalFormat("#.00");
    
    // Extract the gross salary from userDetails
    double grossSalary = Double.parseDouble(userDetails[13]);
    
    // Employer contributions calculation
    double employerEPF = grossSalary * 0.13;
    double employerSOCSO = grossSalary * 0.018;
    double employerEIS = grossSalary * 0.002;
    double annualTax = 0.0; // Annual tax is set to 0 as per your input
    
    // Employee deductions calculation
    double employeeEPF = grossSalary * 0.11;
    double employeeSOCSO = grossSalary * 0.005;
    double employeeEIS = grossSalary * 0.002;
    double incomeTaxPCB = annualTax / 12; // Assuming monthly tax for simplicity
    
    // Total deductions
    double totalDeductions = employeeEPF + employeeSOCSO + employeeEIS + incomeTaxPCB;
    
    // Net salary calculation
    double netSalary = grossSalary - totalDeductions;
    
    // Filling up the table with employer and employee details
    jTable2.setValueAt(df.format(grossSalary), 0, 1); // Gross Salary
    jTable2.setValueAt(df.format(employeeEPF), 0, 3); // Employee EPF
    jTable2.setValueAt(df.format(employerEPF), 0, 5); // Employer EPF
    jTable2.setValueAt(df.format(employeeSOCSO), 1, 3); // Employee SOCSO
    jTable2.setValueAt(df.format(employerSOCSO), 1, 5); // Employer SOCSO
    jTable2.setValueAt(df.format(employeeEIS), 2, 3); // Employee EIS
    jTable2.setValueAt(df.format(employerEIS), 2, 5); // Employer EIS
    jTable2.setValueAt(df.format(incomeTaxPCB), 3, 3); // Income Tax PCB (Employee)
    jTable2.setValueAt(df.format(incomeTaxPCB), 3, 5); // Income Tax PCB (Employer)
    int lateAttendance = attendanceDetails[1];
    jTable2.setValueAt(lateAttendance, 4, 3); // Income Tax PCB (Employer)
    // Late attendance deduction (example: reduce RM 100 if late attendance > 3)
    if (attendanceDetails[1] > 3) {
        netSalary -= 100;
        jTable2.setValueAt(df.format(-100), 4, 1); // Late attendance penalty
    }
    setNetSalary.setText(Double.toString(netSalary));
    
    // Update the total deductions and total contributions
    jTable2.setValueAt(df.format(totalDeductions), 5, 3); // Total deductions
    jTable2.setValueAt(df.format(employerEPF + employerSOCSO + employerEIS), 5, 5); // Total contributions
    }//GEN-LAST:event_generatePaySlipActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        previousWindow.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Generate_Monthly_Slip().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton generatePaySlip;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextPane setNetSalary;
    private javax.swing.JTextField usernameSearchBar;
    // End of variables declaration//GEN-END:variables
}
