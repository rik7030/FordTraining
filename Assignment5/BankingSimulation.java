package Assignment5;

interface SecurityCheck {
    static void logAttempt(String user) {
        System.out.println("Login attempt by: " + user);
    }

    default void showSecurityStatus() {
        System.out.println("Secure connection established");
    }

    boolean verifyUser(String username, String password);
}

class TransactionProcessor {
    public void process(int accountNumber, double amount) {
        System.out.println("Processed deposit of $" + amount + " to account " + accountNumber);
    }

    public void process(int fromAccount, int toAccount, double amount) {
        System.out.println("Transferred $" + amount + " from account " + fromAccount + " to account " + toAccount);
    }
}

class BankAccount {
    public double calculateInterest(double balance) {
        return 0;
    }
}

class SavingsAccount extends BankAccount {
    @Override
    public double calculateInterest(double balance) {
        return balance * 0.04;
    }
}

class CurrentAccount extends BankAccount {
    @Override
    public double calculateInterest(double balance) {
        return balance * 0.01;
    }
}

class UserSecurity implements SecurityCheck {
    @Override
    public boolean verifyUser(String username, String password) {
        return username.equals("admin") && password.equals("1234");
    }
}

public class BankingSimulation {
    public static void main(String[] args) {
        SecurityCheck.logAttempt("admin");
        UserSecurity user = new UserSecurity();
        if (user.verifyUser("admin", "1234")) {
            user.showSecurityStatus();

            TransactionProcessor processor = new TransactionProcessor();
            processor.process(1001, 5000.0);
            processor.process(1001, 1002, 1500.0);

            BankAccount savings = new SavingsAccount();
            BankAccount current = new CurrentAccount();

            System.out.println("Savings Interest: $" + savings.calculateInterest(10000));
            System.out.println("Current Interest: $" + current.calculateInterest(10000));
        } else {
            System.out.println("Access Denied");
        }
    }
}
