// M5. Employee and Company Information Management
// Note: this file defines its own "Employee" class, separate from
// the one in M3_EmployeeProfile.java. Compile/run these files one
// at a time (or in separate folders) since both classes share a name.
// Moves the shared company name and a running employee count into
// static fields instead of duplicating them per instance.

class Employee {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class M5_EmployeeCompany {
    public static void main(String[] args) {
        Employee e1 = new Employee("Ravi", 55000);
        Employee e2 = new Employee("Anitha", 60000);
        Employee e3 = new Employee("Karthik", 48000);

        System.out.println(Employee.employeeCount + " Employee objects created");
        Employee.printCompanyInfo();
    }
}
