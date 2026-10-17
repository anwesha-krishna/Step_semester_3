import java.util.ArrayList;
import java.util.Scanner;

// Problem 2: The Campus Parking Charge Calculator
// Each vehicle type is its own class with its own charging rule (polymorphism).
// The main loop calls the same method on every vehicle, with no type checking.

abstract class Vehicle {
    String type;
    int hours;

    Vehicle(String type, int hours) {
        this.type = type;
        this.hours = hours;
    }

    abstract double calculateCharge();
}

class Bike extends Vehicle {
    Bike(int hours) {
        super("BIKE", hours);
    }

    double calculateCharge() {
        return 10 * hours; // Rs 10 per hour
    }
}

class Car extends Vehicle {
    Car(int hours) {
        super("CAR", hours);
    }

    double calculateCharge() {
        return 30 + 20 * (hours - 1); // Rs 30 first hour + Rs 20 for each extra hour
    }
}

class Truck extends Vehicle {
    Truck(int hours) {
        super("TRUCK", hours);
    }

    double calculateCharge() {
        double charge = 50 * hours; // Rs 50 per hour
        if (charge < 100) {
            charge = 100; // minimum charge
        }
        return charge;
    }
}

public class Problem2_ParkingCharge {
    // The only place that reads the type text: it just decides which object to build
    static Vehicle createVehicle(String type, int hours) {
        switch (type) {
            case "BIKE":
                return new Bike(hours);
            case "CAR":
                return new Car(hours);
            case "TRUCK":
                return new Truck(hours);
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            Vehicle vehicle = createVehicle(parts[0], Integer.parseInt(parts[1]));
            if (vehicle == null) {
                System.out.println("Unknown vehicle type: " + parts[0]);
            } else {
                vehicles.add(vehicle);
            }
        }

        // Same call for every vehicle - each object applies its own rule
        double grandTotal = 0;
        for (Vehicle vehicle : vehicles) {
            double charge = vehicle.calculateCharge();
            System.out.println(vehicle.type + ": " + String.format("%.2f", charge));
            grandTotal += charge;
        }

        System.out.println("Total: " + String.format("%.2f", grandTotal));
    }
}
