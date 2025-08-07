package Day1;

public class emi {
    public static void main(String[] args) {
        double principle= 10000.00;
        float interest= 0.05f;
        int tenure= 10;

        double emi=(principle*interest*(Math.pow((interest+1),tenure)))/(Math.pow((interest+1),tenure)-1);
        System.out.println("EMI: "+emi);
        System.out.println("Total payment:"+emi*tenure*12);

    }
}