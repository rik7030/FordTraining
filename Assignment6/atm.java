package Assignment6;

import java.util.Scanner;

public class atm {
    private double balance = 10000;

    public void withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Invalid amount entered.");
        if (amount > balance) throw new ArithmeticException("Insufficient balance. Available: " + balance);
        balance -= amount;
        System.out.println("Withdrawal successful. Remaining balance: " + balance);
    }

    public static void main(String[] args) {
        atm atm = new atm();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: ");
        String input = sc.nextLine();
        try {
            double amount = Double.parseDouble(input);
            atm.withdraw(amount);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number.");
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}