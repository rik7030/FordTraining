package StreamAPIs;

import java.util.List;
import java.util.Arrays;
import java.util.Optional;

public class FirstPassingScores {

    public static void main(String[] args) {

        List<Integer> marks = Arrays.asList(30, 45, 60, 75, 40);

        System.out.println("All Marks: " + marks);

        Optional<Integer> firstPass = marks.stream()
                .filter(mark -> mark > 50)
                .findFirst();

        if (firstPass.isPresent()) {
            System.out.println("\nFirst Passing Score: " + firstPass.get());
        } else {
            System.out.println("\nNo passing scores found");
        }
    }
}
