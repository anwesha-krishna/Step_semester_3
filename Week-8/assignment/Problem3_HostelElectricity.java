import java.util.ArrayList;
import java.util.Scanner;

// Problem 3: The Hostel Electricity Bill
// Each room type is its own class with its own billing rule (polymorphism).
// A shared room needs one extra value (occupants), so that value is stored inside
// SharedRoom itself. This way the main loop treats every room the same way.

abstract class Room {
    String type;
    int units;

    Room(String type, int units) {
        this.type = type;
        this.units = units;
    }

    abstract double calculateBill();
}

class SingleRoom extends Room {
    SingleRoom(int units) {
        super("SINGLE", units);
    }

    double calculateBill() {
        return 8 * units; // Rs 8 per unit
    }
}

class SharedRoom extends Room {
    int occupants; // extra value that only shared rooms need

    SharedRoom(int units, int occupants) {
        super("SHARED", units);
        this.occupants = occupants;
    }

    double calculateBill() {
        return (6.0 * units) / occupants; // Rs 6 per unit, split equally
    }
}

class AcRoom extends Room {
    AcRoom(int units) {
        super("AC", units);
    }

    double calculateBill() {
        return 10 * units + 200; // Rs 10 per unit + fixed Rs 200
    }
}

public class Problem3_HostelElectricity {
    // The only place that reads the type text: it just decides which object to build
    static Room createRoom(String type, int units, int occupants) {
        switch (type) {
            case "SINGLE":
                return new SingleRoom(units);
            case "SHARED":
                return new SharedRoom(units, occupants);
            case "AC":
                return new AcRoom(units);
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        ArrayList<Room> rooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            int units = Integer.parseInt(parts[1]);

            int occupants = 1; // only present for SHARED rooms
            if (parts.length > 2) {
                occupants = Integer.parseInt(parts[2]);
            }

            Room room = createRoom(parts[0], units, occupants);
            if (room == null) {
                System.out.println("Unknown room type: " + parts[0]);
            } else {
                rooms.add(room);
            }
        }

        // Same call for every room - each object applies its own rule
        double grandTotal = 0;
        for (Room room : rooms) {
            double bill = room.calculateBill();
            System.out.println(room.type + ": " + String.format("%.2f", bill));
            grandTotal += bill;
        }

        System.out.println("Total: " + String.format("%.2f", grandTotal));
    }
}
