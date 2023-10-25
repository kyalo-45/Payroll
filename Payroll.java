package Payroll;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Payroll {
    // Constants
    private static final double PROF_TAX_RATE = 0.2;

    public static void main(String[] args) {
        // Get the current date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String generationDate = dateFormat.format(new Date());

        // Get the number of employees from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of employees: ");
        int numEmployees = scanner.nextInt();

        // Arrays to store employee details
        int[] employeeNumber = new int[numEmployees];
        String[] employeeName = new String[numEmployees];
        String[] designation = new String[numEmployees];
        int[] daysWorked = new int[numEmployees];
        int[] payRate = new int[numEmployees];
        int[] basicPay = new int[numEmployees];
        int[] pf = new int[numEmployees];
        int[] profTax = new int[numEmployees];

        // Get employee details from the user
        for (int i = 0; i < numEmployees; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1) + ":");
            System.out.print("Employee Number: ");
            employeeNumber[i] = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            System.out.print("Employee Name: ");
            employeeName[i] = scanner.nextLine();

            System.out.print("Designation: ");
            designation[i] = scanner.nextLine();

            System.out.print("Days Worked: ");
            daysWorked[i] = scanner.nextInt();

            System.out.print("Pay Rate: ");
            payRate[i] = scanner.nextInt();

            // Compute basic pay, PF, and professional tax
            basicPay[i] = daysWorked[i] * payRate[i];
            pf[i] = (int) (basicPay[i] / 10);
            profTax[i] = (int) (basicPay[i] * PROF_TAX_RATE);
        }

        // Display the output
        System.out.print("ENTER THE EMPLOYEE NO TO GENERATE PAYSLIP: ");
        int empno = scanner.nextInt();
        for (int i = 0; i < numEmployees; i++) {
            if (empno == employeeNumber[i]) {
                System.out.println("\n\n\t\t\tSHREE KRISHNA CHEMISTS AND DRUGGIST");
                System.out.println("\t\t\t\tSALARY MONTH 9 2013");
                System.out.println("\tEMP.NO.: " + employeeNumber[i] + "\tEMP.NAME: " + employeeName[i] + "\tDESIGNATION: " + designation[i]);
                System.out.println("\tDAYS WORKED: " + daysWorked[i] + "\tPAY RATE: " + payRate[i] + "\t\tGEN.DATE: " + generationDate);
                System.out.println("\t_________________________________________________________________________");
                System.out.println("\tEARNINGS\tAMOUNT(RS.)\t\tDEDUCTIONS\tAMOUNT(RS.)");
                System.out.println("\t_________________________________________________________________________");
                System.out.println("\tBASIC PAY\t" + basicPay[i] + "\t\t\tP.F.\t\t" + pf[i]);
                System.out.println("\t\t\t\t\t\tPROF.TAX\t" + profTax[i]);
                System.out.println("\t_________________________________________________________________________");
                System.out.println("\tGROSS EARN.\t" + basicPay[i] + "\t\t\tTOTAL DEDUCT.\t" + (pf[i] + profTax[i]));
                System.out.println("\t\t\t\t\t\tNET PAY\t\t" + (basicPay[i] - (pf[i] + profTax[i])));
                System.out.println("\t_________________________________________________________________________");
                break;
            }
        }

        // Close the scanner
        scanner.close();
    }
}
