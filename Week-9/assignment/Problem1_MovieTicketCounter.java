import java.util.Scanner;

// Problem 1: Movie Ticket Counter
// Ticket is abstract, so a plain "ticket" with no seat type can never be sold.
// The convenience fee is written ONCE (CONVENIENCE_FEE) in the base class,
// and calculateAmount() is final so every seat type automatically includes it.
// Each seat type only supplies its own ticket price.

abstract class Ticket {
    static final double CONVENIENCE_FEE = 20;

    String seat;
    int count;

    Ticket(String seat, int count) {
        this.seat = seat;
        this.count = count;
    }

    abstract double getTicketPrice();

    final double calculateAmount() {
        return count * (getTicketPrice() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends Ticket {
    RegularTicket(int count) {
        super("REGULAR", count);
    }

    double getTicketPrice() {
        return 150;
    }
}

class PremiumTicket extends Ticket {
    PremiumTicket(int count) {
        super("PREMIUM", count);
    }

    double getTicketPrice() {
        return 250;
    }
}

class ReclinerTicket extends Ticket {
    ReclinerTicket(int count) {
        super("RECLINER", count);
    }

    double getTicketPrice() {
        return 400;
    }
}

public class Problem1_MovieTicketCounter {
    // The only place that reads the seat text: it just decides which object to build
    static Ticket createTicket(String seat, int count) {
        switch (seat) {
            case "REGULAR":
                return new RegularTicket(count);
            case "PREMIUM":
                return new PremiumTicket(count);
            case "RECLINER":
                return new ReclinerTicket(count);
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
            Ticket ticket = createTicket(parts[0], Integer.parseInt(parts[1]));
            if (ticket == null) {
                System.out.println("Unknown seat type: " + parts[0]);
                continue;
            }

            double amount = ticket.calculateAmount();
            System.out.println(ticket.seat + ": " + String.format("%.2f", amount));
            total += amount;
        }

        System.out.println("Total: " + String.format("%.2f", total));
    }
}
