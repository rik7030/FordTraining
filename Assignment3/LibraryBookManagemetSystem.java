package Assignment3;

public class LibraryBookManagemetSystem {
    protected String title;
    protected String author;
    protected String ISBN;
    protected double price;

    public LibraryBookManagemetSystem(String title, String author, String ISBN, double price) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + ISBN);
        System.out.println("Price: $" + price);
    }
}
class PrintedBook extends LibraryBookManagemetSystem {
    private int pages;
    private String coverType;

    public PrintedBook(String title, String author, String ISBN, double price, int pages, String coverType) {
        super(title, author, ISBN, price);
        this.pages = pages;
        this.coverType = coverType;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Pages: " + pages);
        System.out.println("Cover Type: " + coverType);
        System.out.println("--------------------------------");
    }
}
class EBook extends LibraryBookManagemetSystem {
    private double fileSize; // in MB
    private String format;

    public EBook(String title, String author, String ISBN, double price, double fileSize, String format) {
        super(title, author, ISBN, price);
        this.fileSize = fileSize;
        this.format = format;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("File Size: " + fileSize + "MB");
        System.out.println("Format: " + format);
        System.out.println("--------------------------------");
    }
}
class AudioBook extends LibraryBookManagemetSystem {
    private double duration; // in hours
    private String narrator;

    public AudioBook(String title, String author, String ISBN, double price, double duration, String narrator) {
        super(title, author, ISBN, price);
        this.duration = duration;
        this.narrator = narrator;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Duration: " + duration + " hours");
        System.out.println("Narrator: " + narrator);
        System.out.println("--------------------------------");
    }
}


