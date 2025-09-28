package Assignment3;

import java.util.Scanner;

class EmployeeManagement {
    int id;
    String name;
    double salary;
    String department;

    public EmployeeManagement() {}

    public EmployeeManagement(int id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public void displayDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: $" + salary);
        System.out.println("Department: " + department);
    }
}

class Manager extends EmployeeManagement {
    int teamSize;
    String teamName;

    public Manager() {}

    public Manager(int id, String name, double salary, String department, int teamSize, String teamName) {
        super(id, name, salary, department); // Correct super call
        this.teamSize = teamSize;
        this.teamName = teamName;
    }

    public int getTeamSize() { return teamSize; }
    public void setTeamSize(int teamSize) { this.teamSize = teamSize; }

    public String getTeamName() { return teamName; }
    public void setTeamName(String teamName) { this.teamName = teamName; }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
        System.out.println("Team Name: " + teamName);
    }
    public static void main(String[] args) {
        Manager manager = new Manager(1, "Deepak", 1000000, "ET", 10, "FODBOM");
        manager.displayDetails();
    }
}


