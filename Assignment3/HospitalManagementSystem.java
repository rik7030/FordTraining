package Assignment3;

import java.util.Scanner;

public class HospitalManagementSystem {
    private String patientId;
    private String name;
    private int age;

    public HospitalManagementSystem(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }


    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void displayPatientInfo() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
class InPatient extends HospitalManagementSystem {
    private int roomNumber;
    private String admissionDate;

    public InPatient(String patientId, String name, int age, int roomNumber, String admissionDate) {
        super(patientId, name, age);
        this.roomNumber = roomNumber;
        this.admissionDate = admissionDate;
    }

    public int getRoomNumber() { return roomNumber; }
    public void setRoomNumber(int roomNumber) { this.roomNumber = roomNumber; }

    public String getAdmissionDate() { return admissionDate; }
    public void setAdmissionDate(String admissionDate) { this.admissionDate = admissionDate; }

    @Override
    public void displayPatientInfo() {
        super.displayPatientInfo();
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Admission Date: " + admissionDate);
    }
}
class OutPatient extends HospitalManagementSystem {

    private String visitDate;
    private double consultationFee;

    public OutPatient(String patientId, String name, int age, String visitDate, double consultationFee) {
        super(patientId, name, age);
        this.visitDate = visitDate;
        this.consultationFee = consultationFee;
    }

    public String getVisitDate() { return visitDate; }
    public void setVisitDate(String visitDate) { this.visitDate = visitDate; }

    public double getConsultationFee() { return consultationFee; }
    public void setConsultationFee(double consultationFee) { this.consultationFee = consultationFee; }

    @Override
    public void displayPatientInfo() {
        super.displayPatientInfo();
        System.out.println("Visit Date: " + visitDate);
        System.out.println("Consultation Fee: $" + consultationFee);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        InPatient inPatient = new InPatient("01", "Deepak", 22, 302, "2025-08-01");
        OutPatient outPatient = new OutPatient("02", "Kevin", 20, "2025-08-10", 75.50);

        System.out.println("=== In-Patient Record ===");
        inPatient.displayPatientInfo();

        System.out.println("\n=== Out-Patient Record ===");
        outPatient.displayPatientInfo();
    }
}
