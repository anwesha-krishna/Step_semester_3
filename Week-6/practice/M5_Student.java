// M5. Student and College Information Management
// Moves the shared college name and a running student count into
// static fields instead of duplicating them per instance.

class Student {
    String name;
    int attendance;

    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    public Student(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}

public class M5_Student {
    public static void main(String[] args) {
        Student s1 = new Student("Ravi", 90);
        Student s2 = new Student("Anitha", 85);

        System.out.println(Student.studentCount + " Student objects created");
        Student.printCollegeInfo();
    }
}
