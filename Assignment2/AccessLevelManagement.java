package Assignment2;



import java.util.Scanner;

public class AccessLevelManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("Enter Your Role");
            String role = sc.nextLine();
            switch (role) {
                case "Manager":
                    System.out.println("Generate report");
                    break;
                case "Viewer":
                    System.out.println("Read only access");
                    break;
                case "Admin":
                    System.out.println("Manage settings");
                    break;
                case "Exit":
                    flag = false;
                    break;
            }
        }
    }
}

