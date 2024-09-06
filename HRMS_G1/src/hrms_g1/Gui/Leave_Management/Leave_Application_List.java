package hrms_g1.Gui.Leave_Management;
import Users.DepartmentManager;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class Leave_Application_List extends javax.swing.JFrame {
    private String username;
    private final JFrame previousWindow;  
    
    public Leave_Application_List(JFrame previousWindow, String username) {
        this.previousWindow = previousWindow;
        this.username = username;
        initComponents();
        populateLeaveTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        approveLeave = new javax.swing.JButton();
        rejectLeave = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(616, 300));
        setPreferredSize(new java.awt.Dimension(616, 300));
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
        jButton1.setBounds(14, 14, 72, 22);

        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Username", "Leave Type", "Duration", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(110, 50, 452, 127);

        approveLeave.setBackground(new java.awt.Color(102, 255, 102));
        approveLeave.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        approveLeave.setText("Approve ");
        approveLeave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveLeaveActionPerformed(evt);
            }
        });
        getContentPane().add(approveLeave);
        approveLeave.setBounds(190, 220, 90, 23);

        rejectLeave.setBackground(new java.awt.Color(255, 51, 51));
        rejectLeave.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        rejectLeave.setForeground(new java.awt.Color(255, 255, 255));
        rejectLeave.setText("Reject ");
        rejectLeave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectLeaveActionPerformed(evt);
            }
        });
        getContentPane().add(rejectLeave);
        rejectLeave.setBounds(380, 220, 72, 23);

        jLabel2.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Leave Applications");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(220, 10, 210, 30);

        jLabel1.setBackground(new java.awt.Color(255, 0, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\images\\dep_manager_km.jpg")); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-3, -4, 620, 330);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        previousWindow.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void approveLeaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveLeaveActionPerformed
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow != -1) { 
            String employeeUsername = jTable1.getValueAt(selectedRow, 0).toString();
            String date = jTable1.getValueAt(selectedRow, 3).toString();

            DepartmentManager DM = new DepartmentManager();
            DM.approveLeave(employeeUsername, date);

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            javax.swing.JOptionPane.showMessageDialog(this, "Leave approved for " + employeeUsername + " on " + date);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a leave request to approve.");
        }
    }//GEN-LAST:event_approveLeaveActionPerformed

    private void rejectLeaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectLeaveActionPerformed
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow != -1) { 
            String employeeUsername = jTable1.getValueAt(selectedRow, 0).toString();
            String date = jTable1.getValueAt(selectedRow, 3).toString();

            DepartmentManager DM = new DepartmentManager();
            DM.rejectLeave(employeeUsername, date);

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            javax.swing.JOptionPane.showMessageDialog(this, "Leave rejected for " + employeeUsername + " on " + date);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a leave request to approve.");
        }
    }//GEN-LAST:event_rejectLeaveActionPerformed

    private void populateLeaveTable() {
        DepartmentManager DM = new DepartmentManager();
        String[][] leaveApplicationList = DM.leaveApplicationList();

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Clear the existing rows

        // Add leave data to the table
        for (String[] leave : leaveApplicationList) {
            model.addRow(new Object[]{leave[0], leave[1], leave[2], leave[3]});
        }
    }    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton approveLeave;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton rejectLeave;
    // End of variables declaration//GEN-END:variables
}
