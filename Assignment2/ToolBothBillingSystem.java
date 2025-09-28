package Assignment2;

import java.util.Scanner;

class TollBothBuidingSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int carCollection=0;
        int bikeCollection=0;
        int truckCollection=0;
        int busCollection=0;
        int totalCollection=0;
        System.out.println("Enter Vechile Name");
        String vechile[]=new String[5];
        for(int a=0;a<5;a++){
            vechile[a]=input.nextLine();
        }
        for(int a=0;a<5;a++){
            switch(vechile[a]){
                case "Car":
                    carCollection+=100;
                    break;
                case "Bike":
                    bikeCollection+=50;
                    break;
                case "Truck":
                    truckCollection+=250;
                    break;
                case "Bus":
                    busCollection+=200;
                    break;

            }
        }
        System.out.println("Car Collection: "+carCollection);
        System.out.println("Bike Collection: "+bikeCollection);
        System.out.println("Truck Collection: "+truckCollection);
        System.out.println("Bus Collection: "+busCollection);
        System.out.println("_______________________________________");
        int totalCollection1 = totalCollection;
        totalCollection1=carCollection+bikeCollection+truckCollection+busCollection;
        System.out.println("Total Collection: "+totalCollection1);
    }
}
