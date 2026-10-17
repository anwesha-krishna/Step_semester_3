import java.util.Scanner;

// Problem 3: College Fee Counter
// Every student has a name and a tuition rule: abstract base class CollegeStudent.
// Only some students use the college bus: that ability is the UsesBus interface,
// and the transport fee is written once, inside that interface.
// The fee counter asks "does this student use the bus?" with instanceof UsesBus,
// instead of checking the student type by name.

abstract class CollegeStudent {
    static final double NORMAL_TUITION = 40000;

    String name;

    CollegeStudent(String name) {
        this.name = name;
    }

    abstract double calculateTuition();
}

// The "uses the college bus" ability
interface UsesBus {
    double TRANSPORT_FEE = 12000; // written once, here

    default double getTransportFee() {
        return TRANSPORT_FEE;
    }
}

class DayScholarStudent extends CollegeStudent implements UsesBus {
    DayScholarStudent(String name) {
        super(name);
    }

    double calculateTuition() {
        return NORMAL_TUITION;
    }
}

class HostellerStudent extends CollegeStudent {
    HostellerStudent(String name) {
        super(name);
    }

    double calculateTuition() {
        return NORMAL_TUITION + 60000; // tuition + hostel fee
    }
}

class ScholarshipStudent extends CollegeStudent implements UsesBus {
    ScholarshipStudent(String name) {
        super(name);
    }

    double calculateTuition() {
        return NORMAL_TUITION / 2; // half of the normal tuition
    }
}

public class Problem3_CollegeFeeCounter {
    // The only place that reads the type text: it just decides which object to build
    static CollegeStudent createStudent(String type, String name) {
        switch (type) {
            case "DAY_SCHOLAR":
                return new DayScholarStudent(name);
            case "HOSTELLER":
                return new HostellerStudent(name);
            case "SCHOLAR":
                return new ScholarshipStudent(name);
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double totalCollected = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            CollegeStudent student = createStudent(parts[0], parts[1]);
            if (student == null) {
                System.out.println("Unknown student type: " + parts[0]);
                continue;
            }

            double fee = student.calculateTuition();

            // Ask about the ability, not the type name
            if (student instanceof UsesBus) {
                fee += ((UsesBus) student).getTransportFee();
            }

            System.out.println(student.name + ": " + String.format("%.2f", fee));
            totalCollected += fee;
        }

        System.out.println("Total Collected: " + String.format("%.2f", totalCollected));
    }
}
