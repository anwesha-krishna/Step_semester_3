import java.util.ArrayList;
import java.util.Scanner;

// Problem 4: Electricity Connection Billing
// Connection is an abstract base class: it holds the units every connection has,
// and each connection type must supply its own billing rule through calculateBill().

abstract class Connection {
    String type;
    double units;

    Connection(String type, double units) {
        this.type = type;
        this.units = units;
    }

    abstract double calculateBill();
}

class HomeConnection extends Connection {
    HomeConnection(double units) {
        super("HOME", units);
    }

    double calculateBill() {
        if (units <= 100) {
            return 5 * units; // 5 per unit for the first 100 units
        }
        return 5 * 100 + 7 * (units - 100); // 7 per unit after that
    }
}

class ShopConnection extends Connection {
    ShopConnection(double units) {
        super("SHOP", units);
    }

    double calculateBill() {
        return 8 * units + 100; // 8 per unit + fixed charge of 100
    }
}

class FactoryConnection extends Connection {
    FactoryConnection(double units) {
        super("FACTORY", units);
    }

    double calculateBill() {
        double bill = 6 * units; // 6 per unit
        if (bill < 1000) {
            bill = 1000; // minimum bill
        }
        return bill;
    }
}

public class Problem4_ElectricityBilling {
    // The only place that reads the type text: it just decides which object to build
    static Connection createConnection(String type, double units) {
        switch (type) {
            case "HOME":
                return new HomeConnection(units);
            case "SHOP":
                return new ShopConnection(units);
            case "FACTORY":
                return new FactoryConnection(units);
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        ArrayList<Connection> connections = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            Connection connection = createConnection(parts[0], Double.parseDouble(parts[1]));
            if (connection == null) {
                System.out.println("Unknown connection type: " + parts[0]);
            } else {
                connections.add(connection);
            }
        }

        // Same call for every connection - each type uses its own billing rule
        double total = 0;
        for (Connection connection : connections) {
            double bill = connection.calculateBill();
            System.out.println(connection.type + ": " + String.format("%.2f", bill));
            total += bill;
        }

        System.out.println("Total: " + String.format("%.2f", total));
    }
}
