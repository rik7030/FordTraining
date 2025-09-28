package Assignment5;

public class MathOperations {

    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int add(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        MathOperations math = new MathOperations();

        int intSum = math.add(5, 10);
        System.out.println("Sum of two integers: " + intSum);

        double doubleSum = math.add(4.5, 3.2);
        System.out.println("Sum of two doubles: " + doubleSum);

        int[] array = {1, 2, 3, 4, 5};
        int arraySum = math.add(array);
        System.out.println("Sum of integer array: " + arraySum);
    }
}
