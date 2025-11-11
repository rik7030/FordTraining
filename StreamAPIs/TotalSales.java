package StreamAPIs;

import java.util.List;
import java.util.Arrays;

public class TotalSales {

    public static void main(String[] args) {

        List<Integer> sales = Arrays.asList(200, 450, 300, 150, 600);

        System.out.println("Daily Sales: " + sales);

        int total = sales.stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println("\nTotal Sales: $" + total);
    }
}

