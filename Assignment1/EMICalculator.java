package Assignment1;

import java.util.Scanner;

public class EMICalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter principal amount (double): ");
        Double principal = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter annual interest rate in % (float): ");
        Float annualRate = Float.parseFloat(scanner.nextLine());

        System.out.print("Enter loan tenure in years (int): ");
        Integer tenureYears = Integer.parseInt(scanner.nextLine());


        double monthlyRate = (double) annualRate / 12 / 100;
        int numberOfMonths = tenureYears * 12;

        double emi = (principal * monthlyRate * Math.pow(1 + monthlyRate, numberOfMonths))
                / (Math.pow(1 + monthlyRate, numberOfMonths) - 1);

        double totalPayment = emi * numberOfMonths;


        System.out.printf("Monthly EMI: %.2f\n", emi);
        System.out.printf("Total Payment: %.2f\n", totalPayment);


    }
}
