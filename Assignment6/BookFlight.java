package Assignment6;

import java.util.Scanner;

public class BookFlight {
    private boolean[] seats = new boolean[5];

    public void bookSeat(int seatNumber) {
        if (seatNumber < 1 || seatNumber > seats.length) {
            throw new ArrayIndexOutOfBoundsException("Seat number must be between 1 and " + seats.length);
        }
        if (seats[seatNumber - 1]) {
            throw new IllegalStateException("Seat " + seatNumber + " is already booked.");
        }
        seats[seatNumber - 1] = true;
        System.out.println("Seat " + seatNumber + " successfully booked.");
    }

    public void printSeatStatus() {
        System.out.print("Seat status: ");
        for (int i = 0; i < seats.length; i++) {
            System.out.print((i + 1) + (seats[i] ? "[Booked] " : "[Available] "));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BookFlight booking = new BookFlight();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter seat number to book (1-5): ");
        String input = sc.nextLine();

        try {
            int seatNumber = Integer.parseInt(input);
            booking.bookSeat(seatNumber);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid seat number.");
        } catch (ArrayIndexOutOfBoundsException | IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        booking.printSeatStatus();
    }
}