package Assignment3;

import java.util.Scanner;

class Person {
    private String name;
    private String email;
    private int age;

    public Person(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }
}

class Student extends Person {
    private String studentId;

    public Student(String name, String email, int age, String studentId) {
        super(name, email, age);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }
}

class Professor extends Person {
    private String subject;

    public Professor(String name, String email, int age, String subject) {
        super(name, email, age);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }
}

class Course {
    private String courseName;
    private Professor professor;
    private Student[] students = new Student[10]; // max 10 students
    private int studentCount = 0;

    public Course(String courseName, Professor professor) {
        this.courseName = courseName;
        this.professor = professor;
    }

    public void registerStudent(Student student) {
        if (studentCount < students.length) {
            students[studentCount++] = student;
            System.out.println(student.getName() + " registered for " + courseName);
        } else {
            System.out.println("Course is full.");
        }
    }

    public void listStudents() {
        System.out.println("\nStudents in " + courseName + ":");
        for (int i = 0; i < studentCount; i++) {
            System.out.println("- " + students[i].getName() + " (" + students[i].getStudentId() + ")");
        }
    }
}

public class UniverityCourseRegistrationSytem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a professor and course
        Professor prof = new Professor("Dr. John", "john@university.com", 45, "Math");
        Course course = new Course("Algebra 101", prof);

        // Register students
        System.out.print("How many students? ");
        int n = scanner.nextInt();
        scanner.nextLine(); // clear buffer

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for student " + (i + 1));
            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            System.out.print("Student ID: ");
            String id = scanner.nextLine();

            Student student = new Student(name, email, age, id);
            course.registerStudent(student);
        }

        // Show all registered students
        course.listStudents();

        scanner.close();
    }
}
