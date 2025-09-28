package Assignment1;

import java.util.Arrays;
import java.util.Scanner;

public class
Ecommerce {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("WEnter the product orginal price!");
        int orginalPrice = sc.nextInt();
        String[] websitename=new String[3];
        int product[] = new int[3];
        int difference[]=new int[3];
        int diff;
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter product number " + (i + 1));
            product[i] = sc.nextInt();
            System.out.println("Enter the webiste name " + (i + 1));
            websitename[i] = sc.next();
        }
        System.out.println("the product are" + Arrays.toString(product));
        System.out.println("the websitename are" + Arrays.toString(websitename));
        int max=product[0];
        int min=product[0];
        for(int i=1;i<product.length;i++){
            if(product[i]>max){
                max=product[i];
            }
            if(product[i]<min){
                min=product[i];
            }
        }
        System.out.println("the maximum price is " + max);
        System.out.println("the minimum price is " + min);
        for(int i=0;i<3;i++){
            if(orginalPrice>product[i] || product[i]==0){
                diff=product[i];
                difference[i]=diff;
            }
            else{
                diff=orginalPrice%product[i];
                difference[i]=diff;
            }

        }
        System.out.println("the difference price is " + Arrays.toString(difference));
    }
}

