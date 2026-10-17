import java.util.ArrayList;
import java.util.Scanner;

// Problem 3: Library Late Fine Counter
// BorrowedItem is an abstract base class: every item has a title and days late,
// and every item type must supply its own fine rule through calculateFine().

abstract class BorrowedItem {
    String title;
    int daysLate;

    BorrowedItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    abstract double calculateFine();
}

class BorrowedBook extends BorrowedItem {
    BorrowedBook(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return 2 * daysLate; // 2 per day late
    }
}

class BorrowedDvd extends BorrowedItem {
    BorrowedDvd(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        double fine = 5 * daysLate; // 5 per day late
        if (fine > 50) {
            fine = 50; // maximum fine
        }
        return fine;
    }
}

class BorrowedMagazine extends BorrowedItem {
    BorrowedMagazine(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return 1 * daysLate; // 1 per day late
    }
}

public class Problem3_LibraryLateFine {
    // The only place that reads the type text: it just decides which object to build
    static BorrowedItem createItem(String[] parts) {
        String type = parts[0];
        String title = parts[1];
        int daysLate = Integer.parseInt(parts[2]);

        switch (type) {
            case "BOOK":
                return new BorrowedBook(title, daysLate);
            case "DVD":
                return new BorrowedDvd(title, daysLate);
            case "MAGAZINE":
                return new BorrowedMagazine(title, daysLate);
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        ArrayList<BorrowedItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            BorrowedItem item = createItem(parts);
            if (item == null) {
                System.out.println("Unknown item type: " + parts[0]);
            } else {
                items.add(item);
            }
        }

        // Same call for every item - each type uses its own fine rule
        double totalFines = 0;
        for (BorrowedItem item : items) {
            double fine = item.calculateFine();
            System.out.println(item.title + ": " + String.format("%.2f", fine));
            totalFines += fine;
        }

        System.out.println("Total Fines: " + String.format("%.2f", totalFines));
    }
}
