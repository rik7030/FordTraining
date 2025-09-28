package Assignment3;

import java.util.Scanner;

public class OnlineBankingSystem {
    private String accountNumber;
    private double balance;
    private String ownerName;

    public OnlineBankingSystem(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void displayInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Balance: " + balance);
    }
}
class SavingsAccount extends OnlineBankingSystem {
    private double interestRate;

    public SavingsAccount(String accountNumber, String ownerName, double initialBalance, double interestRate) {
        super(accountNumber, ownerName, initialBalance);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        double interest = getBalance() * (interestRate / 100);
        deposit(interest);
        System.out.println("Interest of " + interest + " added.");
    }
}
class CurrentAccount extends OnlineBankingSystem {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String ownerName, double initialBalance, double overdraftLimit) {
        super(accountNumber, ownerName, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= (getBalance() + overdraftLimit)) {
            double newBalance = getBalance() - amount;
            super.deposit(-amount);
            if (newBalance < 0) {
                System.out.println("Overdraft used: " + (-newBalance));
            }
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Withdrawal exceeds overdraft limit or is invalid.");
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SavingsAccount savings = new SavingsAccount("002", "Deepak", 1000.0, 4.5);
        System.out.println("---- Savings Account ----");
        savings.displayInfo();
        savings.deposit(500);
        savings.addInterest();
        savings.withdraw(300);
        savings.displayInfo();

        System.out.println();

        // Create a CurrentAccount
        CurrentAccount current = new CurrentAccount("002", "Deepak", 500.0, 200.0);
        System.out.println("---- Current Account ----");
        current.displayInfo();
        current.deposit(300);
        current.withdraw(900);  // within overdraft limit
        current.withdraw(200);  // exceeds overdraft
        current.displayInfo();
    }
}

