import java.util.Scanner;

// Problem 3: Delivery Fee Calculator
// Each delivery type has its own pricing rule; the main loop just calls calculateFee().

abstract class Delivery {
    double weight;
    double distance;

    Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    abstract double calculateFee();
}

class StandardDelivery extends Delivery {
    StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    double calculateFee() {
        return 5 + 0.50 * weight + 0.10 * distance;
    }
}

class ExpressDelivery extends Delivery {
    ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    double calculateFee() {
        return 15 + 1.00 * weight + 0.20 * distance;
    }
}

class InternationalDelivery extends Delivery {
    double customsFee;

    InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    double calculateFee() {
        return 25 + 2.00 * weight + 0.50 * distance + customsFee;
    }
}

public class Problem3_DeliveryFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split(" ");
            String type = parts[0];
            double weight = Double.parseDouble(parts[1]);
            double distance = Double.parseDouble(parts[2]);

            Delivery delivery;
            if (type.equals("STANDARD")) {
                delivery = new StandardDelivery(weight, distance);
            } else if (type.equals("EXPRESS")) {
                delivery = new ExpressDelivery(weight, distance);
            } else if (type.equals("INTERNATIONAL")) {
                double customsFee = Double.parseDouble(parts[3]);
                delivery = new InternationalDelivery(weight, distance, customsFee);
            } else {
                System.out.println("Unknown delivery type: " + type);
                continue;
            }

            double fee = delivery.calculateFee();
            System.out.println(type + ": " + String.format("%.2f", fee));
            grandTotal += fee;
        }

        System.out.println("Total: " + String.format("%.2f", grandTotal));
    }
}
