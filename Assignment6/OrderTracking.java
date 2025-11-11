package Assignment6;

public class OrderTracking {
    public static void main(String[] args) {
        Order.displayTotalOrders();

        Order o1 = new Order(101, "Alice", "Laptop");
        Order o2 = new Order(102, "Bob", "Smartphone");
        Order o3 = new Order(103, "Charlie", "Tablet");

        o1.printOrderDetails();
        o2.printOrderDetails();
        o3.printOrderDetails();

        Order.displayTotalOrders();
    }
}

class Order {
    private static int totalOrders = 0;

    private int orderId;
    private String customerName;
    private String product;

    public Order(int orderId, String customerName, String product) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.product = product;
        totalOrders++;
    }

    public void printOrderDetails() {
        System.out.println("Order ID: " + orderId + ", Customer: " + customerName + ", Product: " + product);
    }

    public static void displayTotalOrders() {
        System.out.println("Total Orders Placed: " + totalOrders);
    }
}