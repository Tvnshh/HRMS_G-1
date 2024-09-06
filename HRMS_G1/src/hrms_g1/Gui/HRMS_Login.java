package hrms_g1.Gui;
import hrms_g1.Gui.Dep_Manager.Dep_Manager_Menu;
import hrms_g1.Gui.Employee.Employee_Menu;
import hrms_g1.Gui.HR_Officer.HR_Officer_Menu;
import hrms_g1.Gui.Payroll_Officer.Payroll_Officer_Menu;
import hrms_g1.Gui.System_Admin.System_Admin_Menu;

import Users.Login;
import Users.SystemAdministrator;

public class HRMS_Login extends javax.swing.JFrame {
    private String username;    
    private String password;
    int attempt = 0;
    public HRMS_Login() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 403, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 294, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HRMS_Login login = new HRMS_Login();
                login.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
