package Assignment9;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Objects;

class Employee {
    private int id;
    private String name;
    private String department;

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
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

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee emp = (Employee) obj;
        return id == emp.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Department: " + department;
    }
}

class NameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getName().compareTo(e2.getName());
    }
}

class DepartmentIdComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        int deptCompare = e1.getDepartment().compareTo(e2.getDepartment());
        if (deptCompare != 0) {
            return deptCompare;
        }
        return Integer.compare(e1.getId(), e2.getId());
    }
}

public class EmployeeDirectory {

    static HashSet<Employee> employees = new HashSet<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Update Department");
            System.out.println("4. View All Employees");
            System.out.println("5. Search by ID");
            System.out.println("6. Search by Department");
            System.out.println("7. Sort by Name");
            System.out.println("8. Sort by Department and ID");
            System.out.println("9. Exit");
            System.out.print("\nChoice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                addEmployee();
            } else if (choice == 2) {
                removeEmployee();
            } else if (choice == 3) {
                updateDepartment();
            } else if (choice == 4) {
                viewAll();
            } else if (choice == 5) {
                searchById();
            } else if (choice == 6) {
                searchByDepartment();
            } else if (choice == 7) {
                sortByName();
            } else if (choice == 8) {
                sortByDeptAndId();
            } else if (choice == 9) {
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
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        Employee emp = new Employee(id, name, dept);

        if (employees.add(emp)) {
            System.out.println("Employee added successfully");
        } else {
            System.out.println("Employee with this ID already exists!");
        }
    }

    static void removeEmployee() {
        System.out.print("Enter ID to remove: ");
        int id = sc.nextInt();

        Employee temp = new Employee(id, "", "");

        if (employees.remove(temp)) {
            System.out.println("Employee removed");
        } else {
            System.out.println("Employee not found");
        }
    }

    static void updateDepartment() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Employee found = null;
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                found = emp;
                break;
            }
        }

        if (found != null) {
            System.out.println("Current: " + found);
            System.out.print("Enter New Department: ");
            String dept = sc.nextLine();
            found.setDepartment(dept);
            System.out.println("Department updated");
        } else {
            System.out.println("Employee not found");
        }
    }

    static void viewAll() {
        if (employees.isEmpty()) {
            System.out.println("No employees");
            return;
        }

        System.out.println("\nAll Employees:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    static void searchById() {
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();

        Employee found = null;
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                found = emp;
                break;
            }
        }

        if (found != null) {
            System.out.println("Employee found:");
            System.out.println(found);
        } else {
            System.out.println("Employee not found");
        }
    }

    static void searchByDepartment() {
        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        ArrayList<Employee> result = new ArrayList<>();

        for (Employee emp : employees) {
            if (emp.getDepartment().equalsIgnoreCase(dept)) {
                result.add(emp);
            }
        }

        if (result.isEmpty()) {
            System.out.println("No employees found in this department");
        } else {
            System.out.println("\nEmployees in " + dept + ":");
            for (Employee emp : result) {
                System.out.println(emp);
            }
        }
    }

    static void sortByName() {
        if (employees.isEmpty()) {
            System.out.println("No employees");
            return;
        }

        ArrayList<Employee> list = new ArrayList<>(employees);
        Collections.sort(list, new NameComparator());

        System.out.println("\nSorted by Name:");
        for (Employee emp : list) {
            System.out.println(emp);
        }
    }

    static void sortByDeptAndId() {
        if (employees.isEmpty()) {
            System.out.println("No employees");
            return;
        }

        ArrayList<Employee> list = new ArrayList<>(employees);
        Collections.sort(list, new DepartmentIdComparator());

        System.out.println("\nSorted by Department and ID:");
        for (Employee emp : list) {
            System.out.println(emp);
        }
    }
}
