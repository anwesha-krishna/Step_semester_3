import java.util.Scanner;

// Problem 5: Home Appliance Energy Report
// Every appliance works out its units the same way from its own power rating:
// abstract base class Appliance (power rating is the part that changes).
// Only some appliances have a saver mode: the SaverMode interface.
// The report asks "does this appliance support saver mode?" with instanceof SaverMode,
// so there is no list of if-else checks on appliance names.

abstract class Appliance {
    static final double COST_PER_UNIT = 8;

    String name;
    double hours;

    Appliance(String name, double hours) {
        this.name = name;
        this.hours = hours;
    }

    abstract double getPowerWatts();

    double calculateUnits() {
        return getPowerWatts() * hours / 1000; // kWh
    }
}

// The "has a saver mode" ability
interface SaverMode {
    double SAVER_REDUCTION = 0.25; // 25% less energy, written once

    default double applySaver(double units) {
        return units - units * SAVER_REDUCTION;
    }
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super("FRIDGE", hours);
    }

    double getPowerWatts() {
        return 150;
    }
}

class AirConditioner extends Appliance implements SaverMode {
    AirConditioner(double hours) {
        super("AC", hours);
    }

    double getPowerWatts() {
        return 1500;
    }
}

class Tv extends Appliance {
    Tv(double hours) {
        super("TV", hours);
    }

    double getPowerWatts() {
        return 100;
    }
}

class WashingMachine extends Appliance implements SaverMode {
    WashingMachine(double hours) {
        super("WASHER", hours);
    }

    double getPowerWatts() {
        return 500;
    }
}

public class Problem5_ApplianceEnergy {
    // The only place that reads the appliance text: it just decides which object to build
    static Appliance createAppliance(String name, double hours) {
        switch (name) {
            case "FRIDGE":
                return new Fridge(hours);
            case "AC":
                return new AirConditioner(hours);
            case "TV":
                return new Tv(hours);
            case "WASHER":
                return new WashingMachine(hours);
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            Appliance appliance = createAppliance(parts[0], Double.parseDouble(parts[1]));
            if (appliance == null) {
                System.out.println("Unknown appliance: " + parts[0]);
                continue;
            }

            boolean saverRequested = parts.length > 2 && parts[2].equals("SAVER");

            double units = appliance.calculateUnits();

            if (saverRequested) {
                // Ask about the ability, not the appliance name
                if (appliance instanceof SaverMode) {
                    units = ((SaverMode) appliance).applySaver(units);
                } else {
                    System.out.println(appliance.name + ": saver mode not supported");
                    continue; // no cost is calculated for this one
                }
            }

            double cost = units * Appliance.COST_PER_UNIT;
            System.out.println(appliance.name + ": Units=" + String.format("%.2f", units)
                    + " Cost=" + String.format("%.2f", cost));
            totalCost += cost;
        }

        System.out.println("Total Cost: " + String.format("%.2f", totalCost));
    }
}
