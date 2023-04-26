package com.example.payroll;

import java.io.*;

public class EmployeePayrollInfo {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("PayDataFile");
            BufferedReader bufReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("Report.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            String input;
            printWriter.printf("Employee Gross Pay Information.\n");

            //System.out.println("Employee Gross Pay Information.");
            while ((input = bufReader.readLine()) != null) {
                String[] data = input.split("\\|");
                Employee e = new Employee(data[0],data[1],Double.parseDouble(data[2]),Double.parseDouble(data[3]));
//                System.out.printf("%s %-40s $%.2f\n",e.getEmployeeId(),e.getName(),e.getGrossPay());
                printWriter.printf("%s %-40s $%.2f\n", e.getEmployeeId(), e.getName(), e.getGrossPay());
            }
            printWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
