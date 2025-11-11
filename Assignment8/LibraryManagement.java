package Assignment8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Book implements Comparable<Book> {
    private int bookId;
    private String title;
    private String author;
    private double price;

    public Book(int bookId, String title, String author, double price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }

    @Override
    public String toString() {
        return "ID: " + bookId + " | Title: " + title + " | Author: " + author + " | Price: $" + price;
    }
}

class PriceComparator implements Comparator<Book> {
    @Override
    public int compare(Book b1, Book b2) {
        return Double.compare(b1.getPrice(), b2.getPrice());
    }
}

class AuthorComparator implements Comparator<Book> {
    @Override
    public int compare(Book b1, Book b2) {
        return b1.getAuthor().compareTo(b2.getAuthor());
    }
}

public class LibraryManagement {

    public static void main(String[] args) {

        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book(101, "The Great Gatsby", "F. Scott Fitzgerald", 15.99));
        books.add(new Book(102, "1984", "George Orwell", 12.50));
        books.add(new Book(103, "To Kill a Mockingbird", "Harper Lee", 18.00));
        books.add(new Book(104, "Animal Farm", "George Orwell", 10.99));
        books.add(new Book(105, "Pride and Prejudice", "Jane Austen", 14.25));
        books.add(new Book(106, "Moby Dick", "Herman Melville", 20.00));

        System.out.println("Original List:");
        printBooks(books);

        Collections.sort(books);
        System.out.println("\n\nSorted by Title (using Comparable):");
        printBooks(books);

        Collections.sort(books, new PriceComparator());
        System.out.println("\n\nSorted by Price (using Comparator):");
        printBooks(books);

        Collections.sort(books, new AuthorComparator());
        System.out.println("\n\nSorted by Author (using Comparator):");
        printBooks(books);
    }

    static void printBooks(ArrayList<Book> books) {
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
    }
}
