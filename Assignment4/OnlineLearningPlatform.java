package Assignment4;

abstract class Course {
    protected String courseName;
    protected int duration; // duration in weeks or hours

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public abstract void enrollStudent(String studentName);
    public abstract void startCourse();
}

interface CertificateProvider {
    void generateCertificate(String studentName);
}

class ProgrammingCourse extends Course implements CertificateProvider {

    public ProgrammingCourse(String courseName, int duration) {
        super(courseName, duration);
    }

    @Override
    public void enrollStudent(String studentName) {
        System.out.println("Enrolling " + studentName + " in " + courseName);
    }

    @Override
    public void startCourse() {
        System.out.println("Starting " + courseName);
    }

    @Override
    public void generateCertificate(String studentName) {
        System.out.println("Certificate generated for " + studentName + " in " + courseName);
    }
}

class DesignCourse extends Course implements CertificateProvider {

    public DesignCourse(String courseName, int duration) {
        super(courseName, duration);
    }

    @Override
    public void enrollStudent(String studentName) {
        System.out.println("Enrolling " + studentName + " in " + courseName);
    }

    @Override
    public void startCourse() {
        System.out.println("Starting " + courseName);
    }

    @Override
    public void generateCertificate(String studentName) {
        System.out.println("Certificate generated for " + studentName + " in " + courseName);
    }
}

public class OnlineLearningPlatform {
    public static void main(String[] args) {
        ProgrammingCourse javaCourse = new ProgrammingCourse("Java Programming Course", 6);
        javaCourse.enrollStudent("John");
        javaCourse.startCourse();
        javaCourse.generateCertificate("John");

        DesignCourse designCourse = new DesignCourse("Graphic Design Course", 4);
        designCourse.enrollStudent("Alice");
        designCourse.startCourse();
        designCourse.generateCertificate("Alice");
    }
}
