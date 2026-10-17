import java.util.Scanner;

// Problem 4: City Cab Fare Meter
// The minimum-fare rule applies to EVERY cab, so it is written once in the abstract
// base class (MIN_FARE, inside the final calculateFare method).
// Night service is an ability only some cabs have: the NightService interface.
// A new cab type chooses to offer night service just by writing "implements NightService".

abstract class Cab {
    static final double MIN_FARE = 100;

    String type;

    Cab(String type) {
        this.type = type;
    }

    abstract double getRatePerKm();

    final double calculateFare(double km) {
        double fare = km * getRatePerKm();
        if (fare < MIN_FARE) {
            fare = MIN_FARE; // no trip costs less than 100
        }
        return fare;
    }
}

// The "offers night service" ability
interface NightService {
    double NIGHT_SURCHARGE = 0.20; // 20% extra, written once

    default double addNightCharge(double fare) {
        return fare + fare * NIGHT_SURCHARGE;
    }
}

class MiniCab extends Cab {
    MiniCab() {
        super("MINI");
    }

    double getRatePerKm() {
        return 10;
    }
}

class SedanCab extends Cab implements NightService {
    SedanCab() {
        super("SEDAN");
    }

    double getRatePerKm() {
        return 14;
    }
}

class SuvCab extends Cab implements NightService {
    SuvCab() {
        super("SUV");
    }

    double getRatePerKm() {
        return 18;
    }
}

public class Problem4_CabFareMeter {
    // The only place that reads the cab text: it just decides which object to build
    static Cab createCab(String type) {
        switch (type) {
            case "MINI":
                return new MiniCab();
            case "SEDAN":
                return new SedanCab();
            case "SUV":
                return new SuvCab();
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            Cab cab = createCab(parts[0]);
            if (cab == null) {
                System.out.println("Unknown cab type: " + parts[0]);
                continue;
            }

            double km = Double.parseDouble(parts[1]);
            String time = parts[2];

            double fare = cab.calculateFare(km); // minimum fare is applied here

            if (time.equals("NIGHT")) {
                // Ask about the ability, not the cab name
                if (cab instanceof NightService) {
                    fare = ((NightService) cab).addNightCharge(fare);
                } else {
                    System.out.println(cab.type + ": night service not available");
                    continue; // rejected trips are not added to the total
                }
            }

            System.out.println(cab.type + ": " + String.format("%.2f", fare));
            total += fare;
        }

        System.out.println("Total: " + String.format("%.2f", total));
    }
}
