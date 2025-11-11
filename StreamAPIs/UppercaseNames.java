package StreamAPIs;

import java.util.List;
import java.util.Arrays;

public class UppercaseNames {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("john", "emma", "alex");

        System.out.println("Original Names: " + names);

        System.out.println("\nUppercase Names:");
        names.stream()
                .map(name -> name.toUpperCase())
                .forEach(name -> System.out.println(name));
    }
}

