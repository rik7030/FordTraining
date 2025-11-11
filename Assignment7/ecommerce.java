package Assignment7;

class InvalidOrderQuantityException extends RuntimeException {
    public InvalidOrderQuantityException(String message) {
        super(message);
    }
}

class OrderService {
    public void placeOrder(String productName, int quantity) {
        if (quantity <= 0) {
            throw new InvalidOrderQuantityException("Order quantity must be greater than zero.");
        }
        System.out.println("Placing order for " + productName + " (Quantity: " + quantity + ")... Order placed successfully.");
    }
}

public class ecommerce {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        try {
            orderService.placeOrder("Laptop", 1);
            orderService.placeOrder("Phone", 0);
        } catch (InvalidOrderQuantityException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}