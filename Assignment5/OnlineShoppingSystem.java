package Assignment5;

class Customer {
    // Overloaded method 1
    public double calculateDiscount(double purchaseAmount) {
        return purchaseAmount * 0.05; // 5% discount for base customer
    }

    // Overloaded method 2
    public double calculateDiscount(double purchaseAmount, int loyaltyPoints) {
        double discount = purchaseAmount * 0.05;
        discount += loyaltyPoints * 0.01; // extra discount based on loyalty points
        return discount;
    }
}

class RegularCustomer extends Customer {
    @Override
    public double calculateDiscount(double purchaseAmount) {
        return purchaseAmount * 0.10; // 10% discount for regular customers
    }
}

class PremiumCustomer extends Customer {
    @Override
    public double calculateDiscount(double purchaseAmount) {
        return purchaseAmount * 0.20; // 20% discount for premium customers
    }
}

public class OnlineShoppingSystem {
    public static void main(String[] args) {
        Customer baseCust = new Customer();
        Customer regularCust = new RegularCustomer();
        Customer premiumCust = new PremiumCustomer();

        double amount = 1000.0;
        int points = 50;

        // Static polymorphism: overloaded method calls resolved at compile time
        System.out.println("Base customer discount (no points): $" + baseCust.calculateDiscount(amount));
        System.out.println("Base customer discount (with points): $" + baseCust.calculateDiscount(amount, points));

        // Dynamic polymorphism: overridden method calls resolved at runtime
        System.out.println("Regular customer discount: $" + regularCust.calculateDiscount(amount));
        System.out.println("Premium customer discount: $" + premiumCust.calculateDiscount(amount));
    }
}
