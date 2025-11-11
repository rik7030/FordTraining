package Assignment9;

import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Objects;
import java.util.Set;

class Course {
    private int courseId;
    private String courseName;

    public Course(int courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Course course = (Course) obj;
        return courseId == course.courseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId);
    }

    @Override
    public String toString() {
        return "Course ID: " + courseId + " | " + courseName;
    }
}

class Student {
    private int studentId;
    private String name;

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return studentId == student.studentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId + " | " + name;
    }
}

class CourseNameComparator implements Comparator<Course> {
    @Override
    public int compare(Course c1, Course c2) {
        return c1.getCourseName().compareTo(c2.getCourseName());
    }
}

class StudentNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }
}

public class StudentCourseEnrollment {

    static HashSet<Course> courses = new HashSet<>();
    static HashMap<Student, Set<Course>> enrollments = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n1. Add Course");
            System.out.println("2. Register Student");
            System.out.println("3. Enroll Student in Course");
            System.out.println("4. Drop Course for Student");
            System.out.println("5. Remove Student");
            System.out.println("6. View All Courses");
            System.out.println("7. View Student's Courses");
            System.out.println("8. View Students in a Course");
            System.out.println("9. Sort Courses by Name");
            System.out.println("10. Sort Students by Name");
            System.out.println("11. Exit");
            System.out.print("\nChoice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                addCourse();
            } else if (choice == 2) {
                registerStudent();
            } else if (choice == 3) {
                enrollInCourse();
            } else if (choice == 4) {
                dropCourse();
            } else if (choice == 5) {
                removeStudent();
            } else if (choice == 6) {
                viewAllCourses();
            } else if (choice == 7) {
                viewStudentCourses();
            } else if (choice == 8) {
                viewStudentsInCourse();
            } else if (choice == 9) {
                sortCoursesByName();
            } else if (choice == 10) {
                sortStudentsByName();
            } else if (choice == 11) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }

    static void addCourse() {
        System.out.print("Enter Course ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Course Name: ");
        String name = sc.nextLine();

        Course course = new Course(id, name);

        if (courses.add(course)) {
            System.out.println("Course added successfully");
        } else {
            System.out.println("Course with this ID already exists!");
        }
    }

    static void registerStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        Student student = new Student(id, name);

        if (enrollments.containsKey(student)) {
            System.out.println("Student already registered!");
        } else {
            enrollments.put(student, new HashSet<Course>());
            System.out.println("Student registered successfully");
        }
    }

    static void enrollInCourse() {
        System.out.print("Enter Student ID: ");
        int sid = sc.nextInt();
        sc.nextLine();

        Student student = findStudent(sid);

        if (student == null) {
            System.out.println("Student not found");
            return;
        }

        System.out.print("Enter Course ID to enroll: ");
        int cid = sc.nextInt();

        Course course = findCourse(cid);

        if (course == null) {
            System.out.println("Course not found");
            return;
        }

        Set<Course> studentCourses = enrollments.get(student);

        if (studentCourses.add(course)) {
            System.out.println("Student enrolled in course successfully");
        } else {
            System.out.println("Student already enrolled in this course!");
        }
    }

    static void dropCourse() {
        System.out.print("Enter Student ID: ");
        int sid = sc.nextInt();
        sc.nextLine();

        Student student = findStudent(sid);

        if (student == null) {
            System.out.println("Student not found");
            return;
        }

        System.out.print("Enter Course ID to drop: ");
        int cid = sc.nextInt();

        Course course = findCourse(cid);

        if (course == null) {
            System.out.println("Course not found");
            return;
        }

        Set<Course> studentCourses = enrollments.get(student);

        if (studentCourses.remove(course)) {
            System.out.println("Course dropped successfully");
        } else {
            System.out.println("Student is not enrolled in this course!");
        }
    }

    static void removeStudent() {
        System.out.print("Enter Student ID to remove: ");
        int sid = sc.nextInt();

        Student student = findStudent(sid);

        if (student != null) {
            enrollments.remove(student);
            System.out.println("Student removed from system");
        } else {
            System.out.println("Student not found");
        }
    }

    static void viewAllCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available");
            return;
        }

        System.out.println("\nAll Courses:");
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    static void viewStudentCourses() {
        System.out.print("Enter Student ID: ");
        int sid = sc.nextInt();

        Student student = findStudent(sid);

        if (student == null) {
            System.out.println("Student not found");
            return;
        }

        Set<Course> studentCourses = enrollments.get(student);

        if (studentCourses.isEmpty()) {
            System.out.println("Student is not enrolled in any courses");
        } else {
            System.out.println("\nCourses for " + student.getName() + ":");
            for (Course course : studentCourses) {
                System.out.println(course);
            }
        }
    }

    static void viewStudentsInCourse() {
        System.out.print("Enter Course ID: ");
        int cid = sc.nextInt();

        Course course = findCourse(cid);

        if (course == null) {
            System.out.println("Course not found");
            return;
        }

        ArrayList<Student> enrolledStudents = new ArrayList<>();

        for (Student student : enrollments.keySet()) {
            Set<Course> studentCourses = enrollments.get(student);
            if (studentCourses.contains(course)) {
                enrolledStudents.add(student);
            }
        }

        if (enrolledStudents.isEmpty()) {
            System.out.println("No students enrolled in this course");
        } else {
            System.out.println("\nStudents enrolled in " + course.getCourseName() + ":");
            for (Student student : enrolledStudents) {
                System.out.println(student);
            }
        }
    }

    static void sortCoursesByName() {
        if (courses.isEmpty()) {
            System.out.println("No courses available");
            return;
        }

        ArrayList<Course> list = new ArrayList<>(courses);
        Collections.sort(list, new CourseNameComparator());

        System.out.println("\nCourses sorted by Name:");
        for (Course course : list) {
            System.out.println(course);
        }
    }

    static void sortStudentsByName() {
        if (enrollments.isEmpty()) {
            System.out.println("No students registered");
            return;
        }

        ArrayList<Student> list = new ArrayList<>(enrollments.keySet());
        Collections.sort(list, new StudentNameComparator());

        System.out.println("\nStudents sorted by Name:");
        for (Student student : list) {
            System.out.println(student);
        }
    }

    static Student findStudent(int id) {
        for (Student student : enrollments.keySet()) {
            if (student.getStudentId() == id) {
                return student;
            }
        }
        return null;
    }

    static Course findCourse(int id) {
        for (Course course : courses) {
            if (course.getCourseId() == id) {
                return course;
            }
        }
        return null;
    }
}

