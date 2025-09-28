package Assignment3;

public class FoodDeliverySystem {
    private String name;
    private double price;
    private String type;

    public FoodDeliverySystem(String name, double price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getType() { return type; }

    public void displayItem() {
        System.out.println("Name: " + name);
        System.out.println("Type: " + type);
        System.out.println("Price: ₹" + price);
    }
}

class VegItem extends FoodDeliverySystem {
    private int calories;
    private String spiceLevel;

    public VegItem(String name, double price, int calories, String spiceLevel) {
        super(name, price, "Veg");
        this.calories = calories;
        this.spiceLevel = spiceLevel;
    }

    @Override
    public void displayItem() {
        super.displayItem();
        System.out.println("Calories: " + calories);
        System.out.println("Spice Level: " + spiceLevel);
    }
}

class NonVegItem extends FoodDeliverySystem {
    private int calories;
    private String spiceLevel;

    public NonVegItem(String name, double price, int calories, String spiceLevel) {
        super(name, price, "Non-Veg");
        this.calories = calories;
        this.spiceLevel = spiceLevel;
    }

    @Override
    public void displayItem() {
        super.displayItem();
        System.out.println("Calories: " + calories);
        System.out.println("Spice Level: " + spiceLevel);
    }
}
