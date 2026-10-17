import java.time.LocalDate;
import java.util.Scanner;

// Problem 2: Library Item Due Date Calculator
// Each item type knows its own borrowing period; the main loop treats them all the same.
// (The PDF mentions Python's datetime; LocalDate is the Java equivalent.)

abstract class LibraryItem {
    String title;

    LibraryItem(String title) {
        this.title = title;
    }

    abstract int getBorrowDays();

    LocalDate getDueDate(LocalDate today) {
        return today.plusDays(getBorrowDays());
    }
}

class Book extends LibraryItem {
    Book(String title) {
        super(title);
    }

    int getBorrowDays() {
        return 14;
    }
}

class Dvd extends LibraryItem {
    Dvd(String title) {
        super(title);
    }

    int getBorrowDays() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    Magazine(String title) {
        super(title);
    }

    int getBorrowDays() {
        return 3;
    }
}

public class Problem2_LibraryDueDate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDate today = LocalDate.of(2023, 10, 26); // fixed "current date" from the question

        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {
            // Splitting on the quote mark gives: [type, title, ...]
            String[] parts = sc.nextLine().split("\"");
            String type = parts[0].trim();
            String title = parts[1];

            LibraryItem item;
            if (type.equals("BOOK")) {
                item = new Book(title);
            } else if (type.equals("DVD")) {
                item = new Dvd(title);
            } else if (type.equals("MAGAZINE")) {
                item = new Magazine(title);
            } else {
                System.out.println("Unknown item type: " + type);
                continue;
            }

            System.out.println(item.title + ": " + item.getDueDate(today));
        }
    }
}
