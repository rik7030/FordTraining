package Assignment1;

import java.util.Scanner;

public class Iotsensor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter 8-bit sensor data (0-255): ");
        Integer sensorData = Integer.parseInt(scanner.nextLine());

        String binaryString = String.format("%8s", Integer.toBinaryString(sensorData)).replace(' ', '0');

        boolean motionDetected = (sensorData & 0b00000001) != 0;
        boolean lightIsOff = (sensorData & 0b00000010) != 0;
        boolean doorOpen = (sensorData & 0b00000100) != 0;
        boolean windowOpen = (sensorData & 0b00001000) != 0;
        boolean smokeDetected = (sensorData & 0b00010000) != 0;
        boolean waterLeak = (sensorData & 0b00100000) != 0;
        boolean temperatureHigh = (sensorData & 0b01000000) != 0;
        boolean humidityHigh = (sensorData & 0b10000000) != 0;

        System.out.println("Binary Representation: " + binaryString);
        System.out.println("Motion Detected: " + motionDetected);
        System.out.println("Light is Off: " + lightIsOff);
        System.out.println("Door Open: " + doorOpen);
        System.out.println("Window Open: " + windowOpen);
        System.out.println("Smoke Detected: " + smokeDetected);
        System.out.println("Water Leak: " + waterLeak);
        System.out.println("High Temperature: " + temperatureHigh);
        System.out.println("High Humidity: " + humidityHigh);

        if (motionDetected && lightIsOff) {
            System.out.println("Action: Turn on the light.");
        }

        if (smokeDetected || waterLeak) {
            System.out.println("Alert: Emergency! Check for smoke or water leak.");
        }

        if (doorOpen && windowOpen) {
            System.out.println("WarninAssignment1;g: Both door and window are open.");
        }

        if (temperatureHigh && humidityHigh) {
            System.out.println("Suggestion: Turn on AC or dehumidifier.");
        }
    }
}
