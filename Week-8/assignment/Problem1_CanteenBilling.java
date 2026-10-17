import java.util.ArrayList;
import java.util.Scanner;

// Problem 1: The Canteen Billing Counter
// Each customer type is its own class with its own pricing rule (polymorphism).
// The billing loop calls the same method on every customer, with no if-else on the type.

abstract class Customer {
    String type;
    double amount;

    Customer(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    abstract double calculateFinalAmount();
}

class StudentCustomer extends Customer {
    StudentCustomer(double amount) {
        super("STUDENT", amount);
    }

    double calculateFinalAmount() {
        return amount - amount * 0.10; // 10% discount
    }
}

class StaffCustomer extends Customer {
    StaffCustomer(double amount) {
        super("STAFF", amount);
    }

    double calculateFinalAmount() {
        return amount - amount * 0.05; // 5% discount
    }
}

class GuestCustomer extends Customer {
    GuestCustomer(double amount) {
        super("GUEST", amount);
    }

    double calculateFinalAmount() {
        return amount + 10; // full amount + Rs 10 service charge
    }
}

public class Problem1_CanteenBilling {
    // The only place that reads the type text: it just decides which object to build
    static Customer createCustomer(String type, double amount) {
        switch (type) {
            case "STUDENT":
                return new StudentCustomer(amount);
            case "STAFF":
                return new StaffCustomer(amount);
            case "GUEST":
                return new GuestCustomer(amount);
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        ArrayList<Customer> bills = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            Customer customer = createCustomer(parts[0], Double.parseDouble(parts[1]));
            if (customer == null) {
                System.out.println("Unknown customer type: " + parts[0]);
            } else {
                bills.add(customer);
            }
        }

        // Same call for every customer - each object applies its own rule
        double grandTotal = 0;
        for (Customer customer : bills) {
            double finalAmount = customer.calculateFinalAmount();
            System.out.println(customer.type + ": " + String.format("%.2f", finalAmount));
            grandTotal += finalAmount;
        }

        System.out.println("Total: " + String.format("%.2f", grandTotal));
    }
}
