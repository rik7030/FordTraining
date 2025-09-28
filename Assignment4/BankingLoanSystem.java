package Assignment4;

abstract class Loan {
    public void calculateEMI(double principal, double rate, int tenureMonths) {
        double monthlyRate = rate / 12 / 100;
        double emi = (principal * monthlyRate * Math.pow(1 + monthlyRate, tenureMonths)) /
                (Math.pow(1 + monthlyRate, tenureMonths) - 1);
        System.out.printf("EMI for $%.0f is $%.0f/month\n", principal, emi);
    }
}

interface ApprovalProcess {
    void approveLoan();
}

class HomeLoan extends Loan implements ApprovalProcess {

    @Override
    public void approveLoan() {
        System.out.println("Home Loan Approved");
    }

    public void processLoan(double principal, double rate, int tenureMonths) {
        System.out.print("Home Loan ");
        calculateEMI(principal, rate, tenureMonths);
        approveLoan();
    }
}

class CarLoan extends Loan implements ApprovalProcess {

    @Override
    public void approveLoan() {
        System.out.println("Car Loan Approved");
    }

    public void processLoan(double principal, double rate, int tenureMonths) {
        System.out.print("Car Loan ");
        calculateEMI(principal, rate, tenureMonths);
        approveLoan();
    }
}

public class BankingLoanSystem {
    public static void main(String[] args) {
        HomeLoan homeLoan = new HomeLoan();
        homeLoan.processLoan(50000, 7.5, 60);

        CarLoan carLoan = new CarLoan();
        carLoan.processLoan(20000, 9.0, 48);
    }
}
