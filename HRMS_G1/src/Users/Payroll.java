/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Users;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tvanm
 */
class Payroll {
    private List<String> payrollInfo = new ArrayList<>();
    // payroll transaction
    private String employeeUsername;
    private int grossSalary;
    private double epf;
    private double socso;
    private double eis;
    private double annualTax;
    private double netSalary;
    private String date;
    private String[] payrollDetails = new String[8];
    DecimalFormat df = new DecimalFormat("#.00");

    public Payroll(String username, int grossSalary) {
        LocalDate myObj = LocalDate.now(); // Create a date object
        this.employeeUsername = username;
        this.grossSalary = grossSalary;
        this.epf = Double.parseDouble(df.format(grossSalary * 0.11));
        this.socso = Double.parseDouble(df.format(grossSalary * 0.005));
        this.eis = Double.parseDouble(df.format(grossSalary * 0.002));
        this.annualTax = Double.parseDouble(df.format(grossSalary * 0.41666));
        this.netSalary = Double.parseDouble(df.format(grossSalary - epf - socso - eis - annualTax));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.date = myObj.format(formatter);
    }

    public Payroll(String username) {
        String filepath = "payroll_transaction.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.split(",")[0].equals(username)) {
                    payrollDetails = line.split(",");
                }
                payrollInfo.add(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Payroll.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Payroll.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.employeeUsername = payrollDetails[0];
        this.grossSalary = Integer.parseInt(payrollDetails[1]);
        this.epf = Integer.parseInt(payrollDetails[2]);
        this.socso = Integer.parseInt(payrollDetails[3]);
        this.eis = Integer.parseInt(payrollDetails[4]);
        this.annualTax = Integer.parseInt(payrollDetails[5]);
        this.netSalary = Integer.parseInt(payrollDetails[6]);
        this.date = payrollDetails[7];
    }

    public Payroll(String username, String month) {
        String filepath = "payroll_transaction.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
               if (line.split(",")[0].equals(username) && Integer.parseInt(line.split(",")[7].split("-")[1]) == Integer.parseInt(month)) {
                    payrollDetails = line.split(",");
                }
                payrollInfo.add(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Payroll.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Payroll.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.employeeUsername = payrollDetails[0];
        this.grossSalary = Integer.parseInt(payrollDetails[1]);
        this.epf = Double.parseDouble(df.format(grossSalary * 0.11));
        this.socso = Double.parseDouble(df.format(grossSalary * 0.005));
        this.eis = Double.parseDouble(df.format(grossSalary * 0.002));
        this.annualTax = Double.parseDouble(df.format(grossSalary * 0.41666));
        this.netSalary = Double.parseDouble(df.format(grossSalary - epf - socso - eis - annualTax));
        this.date = payrollDetails[7];
    }

    public void setPayrollDetails() {
        String filepath = "payroll_transaction.txt";
        boolean userFound = false;
        if (payrollInfo.isEmpty()){
            try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    payrollInfo.add(line);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Payroll.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Payroll.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for (int i = 0; i < payrollInfo.size(); i++) {
            String payroll = payrollInfo.get(i);
            System.out.println("The list username: " + payroll.split(",")[0]);
            System.out.println("The list date: " + payroll.split(",")[7]);
            System.out.println("The obj username: " + employeeUsername);
            System.out.println("The obj date: " + date);
            if (payroll.split(",")[0].equals(employeeUsername) && payroll.split(",")[7].equals(date)) {
                payrollInfo.set(i,String.join(",",getPayrollDetails()));               
                userFound = true;
                System.out.println("Changed for date and username");
                break;
            } 
            if (!userFound && payroll.split(",")[1].equals(employeeUsername)){
                payrollInfo.set(i, String.join(",", getPayrollDetails()));
                userFound = true;
                System.out.println("Changed for username");
                break;
            }
        }
        if (!userFound){
            payrollInfo.add(String.join(",",getPayrollDetails()));
            System.out.println("Added for didnt find username");
        }
        
        try (FileWriter writer = new FileWriter("payroll_transaction.txt", false)) {
            for (String payroll : payrollInfo) {
                writer.write(payroll + "\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(Payroll.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getGrossSalary() {
        return grossSalary;
    }

    public double getEpf() {
        return epf;
    }

    public double getSocso() {
        return socso;
    }

    public double getEis() {
        return eis;
    }

    public double getAnnualTax() {
        return annualTax;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public String getDate() {
        return date;
    }

    public String[] getPayrollDetails() {
        this.epf = Double.parseDouble(df.format(grossSalary * 0.11));
        this.socso = Double.parseDouble(df.format(grossSalary * 0.005));
        this.eis = Double.parseDouble(df.format(grossSalary * 0.002));
        this.annualTax = Double.parseDouble(df.format(grossSalary * 0.41666));
        this.netSalary = Double.parseDouble(df.format(grossSalary - epf - socso - eis - annualTax));

        payrollDetails[0] = this.employeeUsername;
        payrollDetails[1] = Integer.toString(this.grossSalary);
        payrollDetails[2] = Double.toString(this.epf);
        payrollDetails[3] = Double.toString(this.socso);
        payrollDetails[4] = Double.toString(this.eis);
        payrollDetails[5] = Double.toString(this.annualTax);
        payrollDetails[6] = Double.toString(this.netSalary);
        payrollDetails[7] = this.date;
        return payrollDetails;
    }

    public String getEmployeeUsername() {
        return employeeUsername;
    }

    public void setEmployeeUsername(String employeeUsername) {
        this.employeeUsername = employeeUsername;
    }

    public void setGrossSalary(int grossSalary) {
        this.grossSalary = grossSalary;
    }

    public void setEpf(double epf) {
        this.epf = epf;
    }

    public void setSocso(double socso) {
        this.socso = socso;
    }

    public void setEis(double eis) {
        this.eis = eis;
    }

    public void setAnnualTax(double annualTax) {
        this.annualTax = annualTax;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPayrollDetails(String[] payrollDetails) {
        this.payrollDetails = payrollDetails;
    }
}

