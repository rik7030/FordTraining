package Assignment1;
import java.util.Scanner;

public class AgeGroup {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter patient ages separated by spaces: ");
        String[] ageStrings = scanner.nextLine().split(" ");

        int childCount = 0;
        int teenCount = 0;
        int adultCount = 0;
        int seniorCount = 0;

        for (String ageStr : ageStrings) {
            int age = Integer.parseInt(ageStr);
            if (age >= 0 && age <= 12) {
                childCount++;
            } else if (age >= 13 && age <= 19) {
                teenCount++;
            } else if (age >= 20 && age <= 59) {
                adultCount++;
            } else if (age >= 60) {
                seniorCount++;
            }
        }

        int total = childCount + teenCount + adultCount + seniorCount;

        System.out.println("Total Patients: " + total);
        System.out.printf("Children: %d (%.2f%%)\n", childCount, (childCount * 100.0) / total);
        System.out.printf("Teens: %d (%.2f%%)\n", teenCount, (teenCount * 100.0) / total);
        System.out.printf("Adults: %d (%.2f%%)\n", adultCount, (adultCount * 100.0) / total);
        System.out.printf("Seniors: %d (%.2f%%)\n", seniorCount, (seniorCount * 100.0) / total);
    }
}

