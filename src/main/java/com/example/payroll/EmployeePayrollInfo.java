package com.example.payroll;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EmployeePayrollInfo {
    public static void main(String[] args) {
        //Read employee data from file
        //generate pay information
        //Print it out
        try {
            FileReader fileReader = new FileReader("PayDataFile");
            BufferedReader bufReader = new BufferedReader(fileReader);
            String input;
            System.out.println("Employee Gross Pay Information.");
            while ((input = bufReader.readLine()) != null) {
                String[] data =
                        input.split("\\|");
                Employee e =
                        new Employee(data[0], data[1], Double.parseDouble(data[2]), Double.parseDouble(data[3]));
                System.out.printf("%s %-40s $%.2f\n",e.getEmployeeId(),e.getName(),e.getGrossPay());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}