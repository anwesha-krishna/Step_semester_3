import java.util.Scanner;

// Problem 5: Public Transport Fare Calculator
// Each transport type has its own fare rule; the main loop just calls calculateFare().

abstract class Transport {
    double distance;

    Transport(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();
}

class Bus extends Transport {
    Bus(double distance) {
        super(distance);
    }

    double calculateFare() {
        double fare = 2 + 0.10 * distance;
        if (fare > 10) {
            fare = 10; // max fare
        }
        return fare;
    }
}

class Train extends Transport {
    Train(double distance) {
        super(distance);
    }

    double calculateFare() {
        return 3 + 0.15 * distance;
    }
}

class Metro extends Transport {
    double peakHourFactor;

    Metro(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    double calculateFare() {
        return (1.50 + 0.20 * distance) * peakHourFactor;
    }
}

public class Problem5_TransportFare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split(" ");
            String type = parts[0];
            double distance = Double.parseDouble(parts[1]);

            Transport transport;
            if (type.equals("BUS")) {
                transport = new Bus(distance);
            } else if (type.equals("TRAIN")) {
                transport = new Train(distance);
            } else if (type.equals("METRO")) {
                double peakHourFactor = Double.parseDouble(parts[2]);
                transport = new Metro(distance, peakHourFactor);
            } else {
                System.out.println("Unknown transport type: " + type);
                continue;
            }

            double fare = transport.calculateFare();
            System.out.println(type + ": " + String.format("%.2f", fare));
            grandTotal += fare;
        }

        System.out.println("Total: " + String.format("%.2f", grandTotal));
    }
}
