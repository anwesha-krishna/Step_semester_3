import java.util.ArrayList;
import java.util.Scanner;

// Problem 2: Weekly Staff Pay
// StaffMember is abstract, so a generic "staff member" with no pay rule can never be created.
// The name is shared by everyone; each staff type must supply its own calculatePay().

abstract class StaffMember {
    String name;

    StaffMember(String name) {
        this.name = name;
    }

    abstract double calculatePay();
}

class FullTimeStaff extends StaffMember {
    double weeklySalary;

    FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    double calculatePay() {
        return weeklySalary; // fixed weekly salary
    }
}

class HourlyStaff extends StaffMember {
    double hours;
    double rate;

    HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        }
        double overtimeHours = hours - 40;
        return 40 * rate + overtimeHours * rate * 1.5; // overtime is paid at 1.5 x rate
    }
}

class InternStaff extends StaffMember {
    double stipend;

    InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    double calculatePay() {
        return stipend; // fixed stipend
    }
}

public class Problem2_WeeklyStaffPay {
    // The only place that reads the type text: it just decides which object to build
    static StaffMember createStaff(String[] parts) {
        String type = parts[0];
        String name = parts[1];

        switch (type) {
            case "FULLTIME":
                return new FullTimeStaff(name, Double.parseDouble(parts[2]));
            case "HOURLY":
                return new HourlyStaff(name, Double.parseDouble(parts[2]), Double.parseDouble(parts[3]));
            case "INTERN":
                return new InternStaff(name, Double.parseDouble(parts[2]));
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        ArrayList<StaffMember> staff = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            StaffMember member = createStaff(parts);
            if (member == null) {
                System.out.println("Unknown staff type: " + parts[0]);
            } else {
                staff.add(member);
            }
        }

        // Same call for every staff member - each type uses its own pay rule
        double totalPayroll = 0;
        for (StaffMember member : staff) {
            double pay = member.calculatePay();
            System.out.println(member.name + ": " + String.format("%.2f", pay));
            totalPayroll += pay;
        }

        System.out.println("Total Payroll: " + String.format("%.2f", totalPayroll));
    }
}
