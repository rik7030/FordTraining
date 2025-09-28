package Assignment2;

import java.util.Scanner;

public class OrderDelivery {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String Product[] = new String[10];
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter product Status " + (i + 1) + ": ");
            Product[i] = input.nextLine();
        }
        int P=0;
        int D=0;
        int F=0;
        int C=0;
        int count = 1;
        for (String s : Product) {
            switch (s) {
                case "P":
                    System.out.println("Order" + (count) + "is Pending Delivery");
                    count++;
                    P++;
                    break;
                case "D":
                    System.out.println("Order" + (count) + "has been deliverid");
                    D++;
                    count++;
                    break;
                case "F":
                    System.out.println("Order" + (count) + "has been Failed");
                    F++;
                    count++;
                    break;
                case "C":
                    System.out.println("Order" + (count) + "has been canceled");
                    C++;
                    count++;
                    break;
            }
        }
        System.out.println("Pending Order"+(P));
        System.out.println("Delivered Order"+(D));
        System.out.println("Failed Order"+(F));
        System.out.println("Canceled Order"+(C));
    }
}
