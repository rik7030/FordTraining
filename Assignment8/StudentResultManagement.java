package Assignment8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Objects;

class Student implements Comparable<Student> {
    private int rollNo;
    private String name;
    private double marks;

    public Student(int rollNo, String name, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public int compareTo(Student other) {
        return Double.compare(other.marks, this.marks);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return rollNo == student.rollNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNo);
    }

    @Override
    public String toString() {
        return "Roll No: " + rollNo + " | Name: " + name + " | Marks: " + marks;
    }
}

class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }
}

class RollNoComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.getRollNo(), s2.getRollNo());
    }
}

public class StudentResultManagement {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Update Marks");
            System.out.println("4. Search Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Sort by Marks (Descending)");
            System.out.println("7. Sort by Name");
            System.out.println("8. Sort by Roll Number");
            System.out.println("9. Exit");
            System.out.print("\nChoice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                addStudent();
            } else if (choice == 2) {
                deleteStudent();
            } else if (choice == 3) {
                updateMarks();
            } else if (choice == 4) {
                searchStudent();
            } else if (choice == 5) {
                displayAll();
            } else if (choice == 6) {
                sortByMarks();
            } else if (choice == 7) {
                sortByName();
            } else if (choice == 8) {
                sortByRollNo();
            } else if (choice == 9) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }

    static void addStudent() {
        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();
        sc.nextLine();

        Student temp = new Student(roll, "", 0);
        if (students.contains(temp)) {
            System.out.println("Student with this roll number already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        students.add(new Student(roll, name, marks));
        System.out.println("Student added successfully");
    }

    static void deleteStudent() {
        System.out.print("Enter Roll Number to delete: ");
        int roll = sc.nextInt();

        Student temp = new Student(roll, "", 0);

        if (students.contains(temp)) {
            int index = students.indexOf(temp);
            students.remove(index);
            System.out.println("Student deleted");
        } else {
            System.out.println("Student not found");
        }
    }

    static void updateMarks() {
        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();

        Student temp = new Student(roll, "", 0);

        if (!students.contains(temp)) {
            System.out.println("Student not found");
            return;
        }

        int index = students.indexOf(temp);
        Student student = students.get(index);

        System.out.println("Current: " + student);
        System.out.print("Enter New Marks: ");
        double marks = sc.nextDouble();
        student.setMarks(marks);
        System.out.println("Marks updated");
    }

    static void searchStudent() {
        System.out.print("Enter Roll Number to search: ");
        int roll = sc.nextInt();

        Student temp = new Student(roll, "", 0);

        if (students.contains(temp)) {
            int index = students.indexOf(temp);
            System.out.println("Student found at index: " + index);
            System.out.println(students.get(index));
        } else {
            System.out.println("Student not found");
        }
    }

    static void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No students in the system");
            return;
        }

        System.out.println("\nAll Students:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }
    }

    static void sortByMarks() {
        Collections.sort(students);
        System.out.println("\nSorted by Marks (Descending):");
        displayAll();
    }

    static void sortByName() {
        Collections.sort(students, new NameComparator());
        System.out.println("\nSorted by Name:");
        displayAll();
    }

    static void sortByRollNo() {
        Collections.sort(students, new RollNoComparator());
        System.out.println("\nSorted by Roll Number:");
        displayAll();
    }
}

