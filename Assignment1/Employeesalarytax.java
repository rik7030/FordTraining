package Assignment1;
import java.util.Scanner;

public class Employeesalarytax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double tax = 0.0;
        double AnnualSalary=0.0;
        System.out.println("enter salary per month");
        double salary=sc.nextDouble();
        if(salary>=0 && salary<=10000){
            tax=0.0;
        } else if (salary>10000 && salary<=50000) {
            tax=3.0;
        }
        else if(salary>50000 && salary<=100000){
            tax=4.0;
        }else {
            System.out.println("Invalid input");
        }
        AnnualSalary=12*salary;
        double totaltax=(((tax/100)*salary)*12);
        double netAnnualSalary=AnnualSalary-totaltax;
        System.out.println("Annual salary is "+AnnualSalary);
        System.out.println("Net Annual salary is "+netAnnualSalary);
    }
}

