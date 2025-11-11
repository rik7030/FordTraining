package Assignment8;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

class CartItem {
    private int itemId;
    private String itemName;
    private int quantity;
    private double pricePerUnit;

    public CartItem(int itemId, String itemName, int quantity, double pricePerUnit) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return quantity * pricePerUnit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CartItem item = (CartItem) obj;
        return itemId == item.itemId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId);
    }

    @Override
    public String toString() {
        return "ID: " + itemId + " | " + itemName + " | Qty: " + quantity + " | Price: $" + pricePerUnit + " | Total: $" + getTotalPrice();
    }
}

class ShoppingCart {
    private ArrayList<CartItem> cart;

    public ShoppingCart() {
        cart = new ArrayList<>();
    }

    public void addItem(CartItem item) {
        if (cart.contains(item)) {
            int index = cart.indexOf(item);
            CartItem existing = cart.get(index);
            existing.setQuantity(existing.getQuantity() + item.getQuantity());
            System.out.println("Item already exists, quantity updated");
        } else {
            cart.add(item);
            System.out.println("Item added to cart");
        }
    }

    public void removeItem(int itemId) {
        CartItem temp = new CartItem(itemId, "", 0, 0);

        if (cart.contains(temp)) {
            int index = cart.indexOf(temp);
            cart.remove(index);
            System.out.println("Item removed from cart");
        } else {
            System.out.println("Item not found");
        }
    }

    public void updateQuantity(int itemId, int newQuantity) {
        CartItem temp = new CartItem(itemId, "", 0, 0);

        if (cart.contains(temp)) {
            int index = cart.indexOf(temp);
            CartItem item = cart.get(index);
            item.setQuantity(newQuantity);
            System.out.println("Quantity updated");
        } else {
            System.out.println("Item not found");
        }
    }

    public void searchItem(int itemId) {
        CartItem temp = new CartItem(itemId, "", 0, 0);

        if (cart.contains(temp)) {
            int index = cart.indexOf(temp);
            System.out.println("Item found at index " + index);
            System.out.println(cart.get(index));
        } else {
            System.out.println("Item not found");
        }
    }

    public double getTotalBill() {
        double total = 0;
        for (int i = 0; i < cart.size(); i++) {
            total += cart.get(i).getTotalPrice();
        }
        return total;
    }

    public void displayCart() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty");
            return;
        }

        System.out.println("\nYour Cart:");
        for (int i = 0; i < cart.size(); i++) {
            System.out.println(cart.get(i));
        }
        System.out.println("\nTotal Bill: $" + getTotalBill());
    }
}

public class OnlineShoppingCart {

    public static void main(String[] args) {

        ShoppingCart myCart = new ShoppingCart();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Update Quantity");
            System.out.println("4. Search Item");
            System.out.println("5. View Cart");
            System.out.println("6. Exit");
            System.out.print("\nChoice: ");

            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter Item ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Item Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Quantity: ");
                int qty = sc.nextInt();
                System.out.print("Enter Price per Unit: ");
                double price = sc.nextDouble();

                myCart.addItem(new CartItem(id, name, qty, price));

            } else if (choice == 2) {
                System.out.print("Enter Item ID to remove: ");
                int id = sc.nextInt();
                myCart.removeItem(id);

            } else if (choice == 3) {
                System.out.print("Enter Item ID: ");
                int id = sc.nextInt();
                System.out.print("Enter New Quantity: ");
                int qty = sc.nextInt();
                myCart.updateQuantity(id, qty);

            } else if (choice == 4) {
                System.out.print("Enter Item ID to search: ");
                int id = sc.nextInt();
                myCart.searchItem(id);

            } else if (choice == 5) {
                myCart.displayCart();

            } else if (choice == 6) {
                System.out.println("Thank you for shopping!");
                break;

            } else {
                System.out.println("Invalid choice");
            }
        }
    }
}
