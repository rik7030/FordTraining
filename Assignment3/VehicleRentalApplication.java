package Assignment3;

import java.util.Scanner;

public abstract class VehicleRentalApplication {
    String registrationNo;
    String brand;
    double price;

    public VehicleRentalApplication(String registrationNo, String brand, double price) {
        this.registrationNo = registrationNo;
        this.brand = brand;
        this.price = price;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public double calculatePrice(int days) {
        return price*days;
    }


}
class Car extends VehicleRentalApplication {
    private int seatingCapacity;

    public Car(String registrationNo, String brand, double price, int seatingCapacity) {
        super(registrationNo, brand, price);
        this.seatingCapacity = seatingCapacity;
    }

    public int getSeatingCapacity() { return seatingCapacity; }


    public double calculatePrice(int days) {
        return super.calculatePrice(days); // Can customize if needed
    }
}
class Bike extends VehicleRentalApplication {
    private int engineCapacity;

    public Bike(String registrationNumber, String brand, double rentalRate, int engineCapacity) {
        super(registrationNumber, brand, rentalRate);
        this.engineCapacity = engineCapacity;
    }

    public int getEngineCapacity() { return engineCapacity; }

    @Override
    public double calculatePrice(int days) {
        return super.calculatePrice(days);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Number of Days rented: ");
        int rentalDays = input.nextInt();
        VehicleRentalApplication v1 = new Car("TN20", "Ford", 500.0, 5);
       VehicleRentalApplication v2 = new Bike("BIKE456", "Yamaha", 200.0, 150);


        System.out.println("Rental for Car: " + v1.calculatePrice(rentalDays));
        System.out.println("Rental for Bike: " + v2.calculatePrice(rentalDays));
    }
}


