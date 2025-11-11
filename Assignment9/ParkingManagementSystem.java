package Assignment9;

import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Objects;

class Vehicle {
    private String plateNumber;
    private String ownerName;
    private String type;

    public Vehicle(String plateNumber, String ownerName, String type) {
        this.plateNumber = plateNumber;
        this.ownerName = ownerName;
        this.type = type;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getType() {
        return type;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vehicle vehicle = (Vehicle) obj;
        return plateNumber.equals(vehicle.plateNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plateNumber);
    }

    @Override
    public String toString() {
        return "Plate: " + plateNumber + " | Owner: " + ownerName + " | Type: " + type;
    }
}

class ParkingSlot {
    private int slotId;
    private String location;

    public ParkingSlot(int slotId, String location) {
        this.slotId = slotId;
        this.location = location;
    }

    public int getSlotId() {
        return slotId;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ParkingSlot slot = (ParkingSlot) obj;
        return slotId == slot.slotId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(slotId);
    }

    @Override
    public String toString() {
        return "Slot ID: " + slotId + " | Location: " + location;
    }
}

class VehicleOwnerComparator implements Comparator<Vehicle> {
    @Override
    public int compare(Vehicle v1, Vehicle v2) {
        return v1.getOwnerName().compareTo(v2.getOwnerName());
    }
}

class SlotIdComparator implements Comparator<ParkingSlot> {
    @Override
    public int compare(ParkingSlot s1, ParkingSlot s2) {
        return Integer.compare(s1.getSlotId(), s2.getSlotId());
    }
}

public class ParkingManagementSystem {

    static HashSet<Vehicle> vehicles = new HashSet<>();
    static HashMap<ParkingSlot, Vehicle> parking = new HashMap<>();
    static ArrayList<ParkingSlot> allSlots = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        initializeSlots();

        while (true) {
            System.out.println("\n1. Park Vehicle");
            System.out.println("2. Remove Vehicle");
            System.out.println("3. Update Vehicle Details");
            System.out.println("4. View All Occupied Slots");
            System.out.println("5. Find Vehicle Slot");
            System.out.println("6. Find Vehicles by Type");
            System.out.println("7. Sort Vehicles by Owner");
            System.out.println("8. Sort Slots by ID");
            System.out.println("9. View Available Slots");
            System.out.println("10. Exit");
            System.out.print("\nChoice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                parkVehicle();
            } else if (choice == 2) {
                removeVehicle();
            } else if (choice == 3) {
                updateVehicle();
            } else if (choice == 4) {
                viewOccupiedSlots();
            } else if (choice == 5) {
                findVehicleSlot();
            } else if (choice == 6) {
                findVehiclesByType();
            } else if (choice == 7) {
                sortVehiclesByOwner();
            } else if (choice == 8) {
                sortSlotsByID();
            } else if (choice == 9) {
                viewAvailableSlots();
            } else if (choice == 10) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }

    static void initializeSlots() {
        allSlots.add(new ParkingSlot(1, "Ground Floor - A1"));
        allSlots.add(new ParkingSlot(2, "Ground Floor - A2"));
        allSlots.add(new ParkingSlot(3, "Ground Floor - A3"));
        allSlots.add(new ParkingSlot(4, "First Floor - B1"));
        allSlots.add(new ParkingSlot(5, "First Floor - B2"));
        allSlots.add(new ParkingSlot(6, "Second Floor - C1"));
        allSlots.add(new ParkingSlot(7, "Second Floor - C2"));
        allSlots.add(new ParkingSlot(8, "Second Floor - C3"));
        System.out.println("Parking system initialized with 8 slots");
    }

    static void parkVehicle() {
        System.out.print("Enter Plate Number: ");
        String plate = sc.nextLine();
        System.out.print("Enter Owner Name: ");
        String owner = sc.nextLine();
        System.out.print("Enter Vehicle Type (Car/SUV/Bike): ");
        String type = sc.nextLine();

        Vehicle vehicle = new Vehicle(plate, owner, type);

        if (vehicles.contains(vehicle)) {
            System.out.println("Vehicle already parked!");
            return;
        }

        System.out.print("Enter Slot ID (1-8): ");
        int slotId = sc.nextInt();

        ParkingSlot slot = findSlot(slotId);

        if (slot == null) {
            System.out.println("Invalid slot ID");
            return;
        }

        if (parking.containsKey(slot)) {
            System.out.println("Slot already occupied!");
            return;
        }

        vehicles.add(vehicle);
        parking.put(slot, vehicle);
        System.out.println("Vehicle parked successfully at " + slot.getLocation());
    }

    static void removeVehicle() {
        System.out.print("Enter Plate Number: ");
        String plate = sc.nextLine();

        Vehicle vehicle = findVehicle(plate);

        if (vehicle == null) {
            System.out.println("Vehicle not found");
            return;
        }

        ParkingSlot slot = null;
        for (ParkingSlot s : parking.keySet()) {
            if (parking.get(s).equals(vehicle)) {
                slot = s;
                break;
            }
        }

        if (slot != null) {
            parking.remove(slot);
            vehicles.remove(vehicle);
            System.out.println("Vehicle removed from slot " + slot.getSlotId());
        }
    }

    static void updateVehicle() {
        System.out.print("Enter Plate Number: ");
        String plate = sc.nextLine();

        Vehicle vehicle = findVehicle(plate);

        if (vehicle == null) {
            System.out.println("Vehicle not found");
            return;
        }

        System.out.println("Current: " + vehicle);
        System.out.println("\n1. Update Owner Name");
        System.out.println("2. Update Vehicle Type");
        System.out.print("Choice: ");
        int ch = sc.nextInt();
        sc.nextLine();

        if (ch == 1) {
            System.out.print("New Owner Name: ");
            String name = sc.nextLine();
            vehicle.setOwnerName(name);
            System.out.println("Owner name updated");
        } else if (ch == 2) {
            System.out.print("New Type: ");
            String type = sc.nextLine();
            vehicle.setType(type);
            System.out.println("Type updated");
        }
    }

    static void viewOccupiedSlots() {
        if (parking.isEmpty()) {
            System.out.println("No vehicles parked");
            return;
        }

        System.out.println("\nOccupied Slots:");
        for (ParkingSlot slot : parking.keySet()) {
            Vehicle vehicle = parking.get(slot);
            System.out.println(slot + " -> " + vehicle);
        }
    }

    static void findVehicleSlot() {
        System.out.print("Enter Plate Number: ");
        String plate = sc.nextLine();

        Vehicle vehicle = findVehicle(plate);

        if (vehicle == null) {
            System.out.println("Vehicle not found");
            return;
        }

        for (ParkingSlot slot : parking.keySet()) {
            if (parking.get(slot).equals(vehicle)) {
                System.out.println("Vehicle found at:");
                System.out.println(slot);
                return;
            }
        }

        System.out.println("Vehicle not parked");
    }

    static void findVehiclesByType() {
        System.out.print("Enter Vehicle Type (Car/SUV/Bike): ");
        String type = sc.nextLine();

        ArrayList<Vehicle> result = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getType().equalsIgnoreCase(type)) {
                result.add(vehicle);
            }
        }

        if (result.isEmpty()) {
            System.out.println("No vehicles of type " + type + " found");
        } else {
            System.out.println("\nVehicles of type " + type + ":");
            for (Vehicle vehicle : result) {
                System.out.println(vehicle);
            }
        }
    }

    static void sortVehiclesByOwner() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles parked");
            return;
        }

        ArrayList<Vehicle> list = new ArrayList<>(vehicles);
        Collections.sort(list, new VehicleOwnerComparator());

        System.out.println("\nVehicles sorted by Owner Name:");
        for (Vehicle vehicle : list) {
            System.out.println(vehicle);
        }
    }

    static void sortSlotsByID() {
        if (parking.isEmpty()) {
            System.out.println("No vehicles parked");
            return;
        }

        ArrayList<ParkingSlot> list = new ArrayList<>(parking.keySet());
        Collections.sort(list, new SlotIdComparator());

        System.out.println("\nOccupied Slots sorted by ID:");
        for (ParkingSlot slot : list) {
            System.out.println(slot + " -> " + parking.get(slot));
        }
    }

    static void viewAvailableSlots() {
        ArrayList<ParkingSlot> available = new ArrayList<>();

        for (ParkingSlot slot : allSlots) {
            if (!parking.containsKey(slot)) {
                available.add(slot);
            }
        }

        if (available.isEmpty()) {
            System.out.println("No available slots");
        } else {
            System.out.println("\nAvailable Slots:");
            for (ParkingSlot slot : available) {
                System.out.println(slot);
            }
        }
    }

    static Vehicle findVehicle(String plate) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPlateNumber().equalsIgnoreCase(plate)) {
                return vehicle;
            }
        }
        return null;
    }

    static ParkingSlot findSlot(int id) {
        for (ParkingSlot slot : allSlots) {
            if (slot.getSlotId() == id) {
                return slot;
            }
        }
        return null;
    }
}
