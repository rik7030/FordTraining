package StreamAPIs;

import java.util.List;
import java.util.Arrays;

public class EligibleVoters {

    public static void main(String[] args) {

        List<Integer> ages = Arrays.asList(12, 18, 25, 16, 40, 30);

        System.out.println("All Ages: " + ages);

        System.out.println("\nEligible Voters (18+):");
        ages.stream()
                .filter(age -> age >= 18)
                .forEach(age -> System.out.println(age));
    }
}

