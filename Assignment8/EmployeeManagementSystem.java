package Assignment8;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Objects;

class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Department: " + department + " | Salary: $" + salary;
    }
}

public class EmployeeManagementSystem {

    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Display All");
            System.out.println("6. Exit");
            System.out.print("\nChoice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                addEmployee();
            } else if (choice == 2) {
                updateEmployee();
            } else if (choice == 3) {
                deleteEmployee();
            } else if (choice == 4) {
                searchEmployee();
            } else if (choice == 5) {
                displayAll();
            } else if (choice == 6) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }

    static void addEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Employee temp = new Employee(id, "", "", 0);
        if (employees.contains(temp)) {
            System.out.println("Employee already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Department: ");
        String dept = sc.nextLine();
        System.out.print("Enter Salary: ");
        double sal = sc.nextDouble();

        employees.add(new Employee(id, name, dept, sal));
        System.out.println("Employee added");
    }

    static void updateEmployee() {
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        Employee temp = new Employee(id, "", "", 0);

        if (!employees.contains(temp)) {
            System.out.println("Employee not found");
            return;
        }

        int index = employees.indexOf(temp);
        Employee emp = employees.get(index);

        System.out.println("Current: " + emp);
        System.out.println("\n1. Update Department");
        System.out.println("2. Update Salary");
        System.out.println("3. Update Both");
        System.out.print("Choice: ");
        int ch = sc.nextInt();
        sc.nextLine();

        if (ch == 1) {
            System.out.print("New Department: ");
            String dept = sc.nextLine();
            emp.setDepartment(dept);
        } else if (ch == 2) {
            System.out.print("New Salary: ");
            double sal = sc.nextDouble();
            emp.setSalary(sal);
        } else if (ch == 3) {
            System.out.print("New Department: ");
            String dept = sc.nextLine();
            System.out.print("New Salary: ");
            double sal = sc.nextDouble();
            emp.setDepartment(dept);
            emp.setSalary(sal);
        }

        System.out.println("Updated: " + emp);
    }

    static void deleteEmployee() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        Employee temp = new Employee(id, "", "", 0);

        if (employees.contains(temp)) {
            int index = employees.indexOf(temp);
            employees.remove(index);
            System.out.println("Employee deleted");
        } else {
            System.out.println("Employee not found");
        }
    }

    static void searchEmployee() {
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();

        Employee temp = new Employee(id, "", "", 0);

        if (employees.contains(temp)) {
            int index = employees.indexOf(temp);
            System.out.println("Found at index: " + index);
            System.out.println(employees.get(index));
        } else {
            System.out.println("Not found");
        }
    }

    static void displayAll() {
        if (employees.isEmpty()) {
            System.out.println("No employees");
            return;
        }

        System.out.println("\nAll Employees:");
        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i));
        }
    }
}

