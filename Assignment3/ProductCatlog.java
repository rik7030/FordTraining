package Assignment3;

import java.util.Scanner;

public class ProductCatlog {
    int productid;
    String productname;
    Double price;
    String category;
    public ProductCatlog() {

    }
    public ProductCatlog(int productid, String productname, Double price, String category) {
        this.productid = productid;
        this.productname = productname;
        this.price = price;
        this.category = category;

    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }



    public void setCategory(String category) {
        this.category = category;
    }
    public void displayproduct() {
        System.out.println("Product Id: " + productid);
        System.out.println("Product Name: " + productname);
        System.out.println("Product Price: " + price);
        System.out.println("Category: " + category);

    }
}
class Electronics extends ProductCatlog {
    int Waranty;
    public Electronics() {

    }
    public Electronics(int productid, String productname, Double price, String category,int Waranty) {
        super(productid, productname, price, category);
        this.Waranty = Waranty;
    }
    public int getWaranty() {
        return Waranty;
    }
    public void setWaranty(int Waranty) {
        this.Waranty = Waranty;
    }
    @Override
    public void displayproduct() {
        super.displayproduct();
        System.out.println("Waranty: " + Waranty);
    }

}
class Cloths extends ProductCatlog {
    String brand;
    public Cloths() {

    }
    public Cloths(int productid, String productname, Double price, String category) {
        super(productid, productname, price, category);
        this.brand = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    @Override
    public void displayproduct() {
        super.displayproduct();
        System.out.println("Brand: " + brand);
    }
    public static void main(String arg[]){
        Scanner input = new Scanner(System.in);
        Electronics electronics = new Electronics();
        electronics.setProductid(1);
        electronics.setProductname("Laptop");
        electronics.setPrice(100000.0);
        electronics.setWaranty(3);
        electronics.displayproduct();
        System.out.println("--------------------------------------------------");
        Cloths cloths = new Cloths();
        cloths.setProductid(1);
        cloths.setProductname("tshirt");
        cloths.setPrice(1000.0);
        cloths.setBrand("zara");
        cloths.displayproduct();
    }
}

