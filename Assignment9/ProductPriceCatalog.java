package Assignment9;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ID: " + productId + " | Name: " + name + " | Price: $" + price;
    }
}

class ProductNameComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return p1.getName().compareTo(p2.getName());
    }
}

class ProductPriceAscComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return Double.compare(p1.getPrice(), p2.getPrice());
    }
}

class ProductPriceDescComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return Double.compare(p2.getPrice(), p1.getPrice());
    }
}

public class ProductPriceCatalog {

    static HashMap<Integer, Product> products = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Update Price");
            System.out.println("4. View All Products");
            System.out.println("5. Search by ID");
            System.out.println("6. Find Products Cheaper Than");
            System.out.println("7. Sort by Name");
            System.out.println("8. Sort by Price (Ascending)");
            System.out.println("9. Sort by Price (Descending)");
            System.out.println("10. Exit");
            System.out.print("\nChoice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                addProduct();
            } else if (choice == 2) {
                removeProduct();
            } else if (choice == 3) {
                updatePrice();
            } else if (choice == 4) {
                viewAll();
            } else if (choice == 5) {
                searchById();
            } else if (choice == 6) {
                findCheaperThan();
            } else if (choice == 7) {
                sortByName();
            } else if (choice == 8) {
                sortByPriceAsc();
            } else if (choice == 9) {
                sortByPriceDesc();
            } else if (choice == 10) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }

    static void addProduct() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (products.containsKey(id)) {
            System.out.println("Product with this ID already exists!");
            return;
        }

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        Product product = new Product(id, name, price);
        products.put(id, product);
        System.out.println("Product added successfully");
    }

    static void removeProduct() {
        System.out.print("Enter Product ID to remove: ");
        int id = sc.nextInt();

        if (products.remove(id) != null) {
            System.out.println("Product removed");
        } else {
            System.out.println("Product not found");
        }
    }

    static void updatePrice() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        Product product = products.get(id);

        if (product != null) {
            System.out.println("Current: " + product);
            System.out.print("Enter New Price: ");
            double price = sc.nextDouble();
            product.setPrice(price);
            System.out.println("Price updated");
        } else {
            System.out.println("Product not found");
        }
    }

    static void viewAll() {
        if (products.isEmpty()) {
            System.out.println("No products in catalog");
            return;
        }

        System.out.println("\nAll Products:");
        for (Product product : products.values()) {
            System.out.println(product);
        }
    }

    static void searchById() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        Product product = products.get(id);

        if (product != null) {
            System.out.println("Product found:");
            System.out.println(product);
        } else {
            System.out.println("Product not found");
        }
    }

    static void findCheaperThan() {
        System.out.print("Enter maximum price: ");
        double maxPrice = sc.nextDouble();

        ArrayList<Product> result = new ArrayList<>();

        for (Product product : products.values()) {
            if (product.getPrice() < maxPrice) {
                result.add(product);
            }
        }

        if (result.isEmpty()) {
            System.out.println("No products found cheaper than $" + maxPrice);
        } else {
            System.out.println("\nProducts cheaper than $" + maxPrice + ":");
            for (Product product : result) {
                System.out.println(product);
            }
        }
    }

    static void sortByName() {
        if (products.isEmpty()) {
            System.out.println("No products in catalog");
            return;
        }

        ArrayList<Product> list = new ArrayList<>(products.values());
        Collections.sort(list, new ProductNameComparator());

        System.out.println("\nSorted by Name:");
        for (Product product : list) {
            System.out.println(product);
        }
    }

    static void sortByPriceAsc() {
        if (products.isEmpty()) {
            System.out.println("No products in catalog");
            return;
        }

        ArrayList<Product> list = new ArrayList<>(products.values());
        Collections.sort(list, new ProductPriceAscComparator());

        System.out.println("\nSorted by Price (Ascending):");
        for (Product product : list) {
            System.out.println(product);
        }
    }

    static void sortByPriceDesc() {
        if (products.isEmpty()) {
            System.out.println("No products in catalog");
            return;
        }

        ArrayList<Product> list = new ArrayList<>(products.values());
        Collections.sort(list, new ProductPriceDescComparator());

        System.out.println("\nSorted by Price (Descending):");
        for (Product product : list) {
            System.out.println(product);
        }
    }
}

