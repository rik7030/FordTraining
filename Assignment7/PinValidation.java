package Assignment7;

import java.util.Scanner;

class InvalidPinException extends Exception {
    public InvalidPinException(String message) {
        super(message);
    }
}

class ATM {
    private static final String VALID_PIN = "1234";

    public void validatePin(String enteredPin) throws InvalidPinException {
        if (enteredPin.length() != 4) {
            throw new InvalidPinException("PIN must be exactly 4 digits.");
        }
        if (!enteredPin.equals(VALID_PIN)) {
            throw new InvalidPinException("Incorrect PIN.");
        }
    }
}

public class PinValidation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM();
        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();
        try {
            atm.validatePin(pin);
            System.out.println("Access Granted. Welcome!");
        } catch (InvalidPinException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}