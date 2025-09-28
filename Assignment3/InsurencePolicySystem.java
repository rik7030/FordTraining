package Assignment3;

public class InsurencePolicySystem {
    private String policyNumber;
    private String holderName;
    private double amount;

    public InsurencePolicySystem(String policyNumber, String holderName, double amount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.amount = amount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getAmount() {
        return amount;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double calculatePremium() {
        return 0.0; // Base implementation
    }

    public void displayPolicy() {
        System.out.println("Policy Number: " + policyNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Amount: $" + amount);
    }
}


class LifeInsurance extends InsurencePolicySystem {
    private String nominee;

    public LifeInsurance(String policyNumber, String holderName, double amount, String nominee) {
        super(policyNumber, holderName, amount);
        this.nominee = nominee;
    }

    @Override
    public double calculatePremium() {
        return getAmount() * 0.05;
    }

    @Override
    public void displayPolicy() {
        super.displayPolicy();
        System.out.println("Nominee: " + nominee);
        System.out.println("Premium: $" + calculatePremium());
    }
}


class HealthInsurance extends InsurencePolicySystem {
    private String hospitalCoverage;

    public HealthInsurance(String policyNumber, String holderName, double amount, String hospitalCoverage) {
        super(policyNumber, holderName, amount);
        this.hospitalCoverage = hospitalCoverage;
    }

    @Override
    public double calculatePremium() {
        return getAmount() * 0.08;
    }

    @Override
    public void displayPolicy() {
        super.displayPolicy();
        System.out.println("Hospital Coverage: " + hospitalCoverage);
        System.out.println("Premium: $" + calculatePremium());
    }

    public static void main(String arg[]) {
        InsurencePolicySystem[] policies = new InsurencePolicySystem[2];

        policies[0] = new LifeInsurance("LI001", "Alice", 100000, "Bob");
        policies[1] = new HealthInsurance("HI002", "John", 75000, "Apollo Hospital");


        // Loop through the array and call displayPolicy (polymorphic method)
        for (int i = 0; i < policies.length; i++) {
            System.out.println("=== Policy Details ===");
            policies[i].displayPolicy();
            System.out.println();
        }
    }
}


