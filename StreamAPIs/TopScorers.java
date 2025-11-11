package StreamAPIs;

import java.util.List;
import java.util.Arrays;

public class TopScorers {

    public static void main(String[] args) {

        List<Integer> scores = Arrays.asList(50, 85, 40, 90, 70);

        System.out.println("Original Scores: " + scores);

        System.out.println("\nSorted Scores (Highest to Lowest):");
        scores.stream()
                .sorted((a, b) -> b - a)
                .forEach(score -> System.out.println(score));
    }
}
