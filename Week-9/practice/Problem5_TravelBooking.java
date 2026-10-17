import java.util.ArrayList;
import java.util.Scanner;

// Problem 5: Travel Booking with a Common Fee
// The booking fee is written in ONE place only: BOOKING_FEE in the abstract base class.
// calculateTotal() is final, so every mode adds the fee and no subclass can skip it.
// Each mode only supplies its own base fare through calculateBaseFare().
// If the fee changes, only the BOOKING_FEE line needs to change.

abstract class Booking {
    static final double BOOKING_FEE = 50;

    String mode;
    double distanceKm;

    Booking(String mode, double distanceKm) {
        this.mode = mode;
        this.distanceKm = distanceKm;
    }

    abstract double calculateBaseFare();

    final double calculateTotal() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends Booking {
    BusBooking(double distanceKm) {
        super("BUS", distanceKm);
    }

    double calculateBaseFare() {
        return 2 * distanceKm; // 2 per km
    }
}

class TrainBooking extends Booking {
    TrainBooking(double distanceKm) {
        super("TRAIN", distanceKm);
    }

    double calculateBaseFare() {
        return 1.5 * distanceKm; // 1.5 per km
    }
}

class FlightBooking extends Booking {
    FlightBooking(double distanceKm) {
        super("FLIGHT", distanceKm);
    }

    double calculateBaseFare() {
        return 2500 + 4 * distanceKm; // 2500 plus 4 per km
    }
}

public class Problem5_TravelBooking {
    // The only place that reads the mode text: it just decides which object to build
    static Booking createBooking(String mode, double distanceKm) {
        switch (mode) {
            case "BUS":
                return new BusBooking(distanceKm);
            case "TRAIN":
                return new TrainBooking(distanceKm);
            case "FLIGHT":
                return new FlightBooking(distanceKm);
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        ArrayList<Booking> bookings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            Booking booking = createBooking(parts[0], Double.parseDouble(parts[1]));
            if (booking == null) {
                System.out.println("Unknown travel mode: " + parts[0]);
            } else {
                bookings.add(booking);
            }
        }

        // Same call for every booking - the fee is added automatically inside calculateTotal()
        for (Booking booking : bookings) {
            System.out.println(booking.mode + ": " + String.format("%.2f", booking.calculateTotal()));
        }
    }
}
