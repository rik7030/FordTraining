package StreamAPIs;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FilterBooks {

    public static void main(String[] args) {

        List<String> books = Arrays.asList("Java", "Python", "JavaScript", "C++", "JMeter");

        System.out.println("All Books: " + books);

        List<String> jBooks = books.stream()
                .filter(book -> book.startsWith("J"))
                .collect(Collectors.toList());

        System.out.println("\nBooks starting with 'J': " + jBooks);
    }
}

