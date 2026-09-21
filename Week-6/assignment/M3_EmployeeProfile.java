// M3. Employee Profile Creation
// Note: this file defines its own "Employee" class, separate from
// the one in M5_EmployeeCompany.java. Compile/run these files one
// at a time (or in separate folders) since both classes share a name.
// Demonstrates constructor chaining with this(...) so interns don't
// repeat the same setup logic as permanent employees.

class Employee {
    String empId;
    String empName;
    double salary;
    boolean isIntern;

    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    // Interns chain to the 3-argument constructor with salary = 0,
    // then override isIntern afterwards
    public Employee(String empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }
}

public class M3_EmployeeProfile {
    public static void main(String[] args) {
        Employee permanent = new Employee("E-101", "Divya", 65000);
        Employee intern = new Employee("E-102", "Arjun");

        permanent.printProfile();
        intern.printProfile();
    }
}
