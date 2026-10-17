import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

// Problem 5: The Streaming Plan Renewal Reminder
// Each plan type is its own class with its own validity period (polymorphism).
// LocalDate.plusDays() takes care of leap years and year changes for us.

abstract class Plan {
    String name;
    LocalDate startDate;

    Plan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract int getValidityDays();

    LocalDate getRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }
}

class BasicPlan extends Plan {
    BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int getValidityDays() {
        return 30;
    }
}

class StandardPlan extends Plan {
    StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int getValidityDays() {
        return 90;
    }
}

class PremiumPlan extends Plan {
    PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int getValidityDays() {
        return 365;
    }
}

public class Problem5_StreamingRenewal {
    // The only place that reads the type text: it just decides which object to build
    static Plan createPlan(String type, String name, LocalDate startDate) {
        switch (type) {
            case "BASIC":
                return new BasicPlan(name, startDate);
            case "STANDARD":
                return new StandardPlan(name, startDate);
            case "PREMIUM":
                return new PremiumPlan(name, startDate);
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        ArrayList<Plan> subscribers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            Plan plan = createPlan(parts[0], parts[1], LocalDate.parse(parts[2]));
            if (plan == null) {
                System.out.println("Unknown plan type: " + parts[0]);
            } else {
                subscribers.add(plan);
            }
        }

        // Same call for every subscriber - each plan applies its own validity
        for (Plan plan : subscribers) {
            System.out.println(plan.name + ": " + plan.getRenewalDate());
        }
    }
}
