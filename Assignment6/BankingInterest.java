package Assignment6;

public class BankingInterest {
    public static void main(String[] args) {
        BankAccount.displayInterestRate();

        BankAccount acc1 = new BankAccount(1001, 5000);
        BankAccount acc2 = new BankAccount(1002, 10000);
        BankAccount acc3 = new BankAccount(1003, 7500);

        acc1.printAccountDetails();
        acc2.printAccountDetails();
        acc3.printAccountDetails();

        BankAccount.updateInterestRate(4.5);
        BankAccount.displayInterestRate();

        System.out.println("Interest rate for acc1: " + acc1.getInterestRate() + "%");
        System.out.println("Interest rate for acc2: " + acc2.getInterestRate() + "%");
        System.out.println("Interest rate for acc3: " + acc3.getInterestRate() + "%");
    }
}

class BankAccount {
    private static double interestRate = 3.5;

    private int accountNumber;
    private double balance;

    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public static void updateInterestRate(double newRate) {
        interestRate = newRate;
    }

    public static void displayInterestRate() {
        System.out.println("Current Bank Interest Rate: " + interestRate + "%");
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void printAccountDetails() {
        System.out.println("Account: " + accountNumber + ", Balance: $" + balance);
    }
}