import java.util.Scanner;

// Problem 1: Payment System Fee Calculation
// Each payment type is its own class and decides its own fee (polymorphism).

abstract class PaymentMethod {
    abstract double calculateFinalAmount(double amount);
}

class CardPayment extends PaymentMethod {
    double calculateFinalAmount(double amount) {
        return amount + amount * 0.02; // 2% processing fee
    }
}

class WalletPayment extends PaymentMethod {
    double calculateFinalAmount(double amount) {
        return amount + amount * 0.01; // 1% processing fee
    }
}

class BankTransferPayment extends PaymentMethod {
    double calculateFinalAmount(double amount) {
        return amount; // no processing fee
    }
}

public class Problem1_PaymentFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split(" ");
            String type = parts[0];
            double amount = Double.parseDouble(parts[1]);

            // Pick the right object once; after this, the same call works for every type
            PaymentMethod payment;
            if (type.equals("CARD")) {
                payment = new CardPayment();
            } else if (type.equals("WALLET")) {
                payment = new WalletPayment();
            } else if (type.equals("BANKTRANSFER")) {
                payment = new BankTransferPayment();
            } else {
                System.out.println("Unknown payment type: " + type);
                continue;
            }

            double finalAmount = payment.calculateFinalAmount(amount);
            System.out.println(type + ": " + String.format("%.2f", finalAmount));
            grandTotal += finalAmount;
        }

        System.out.println("Total: " + String.format("%.2f", grandTotal));
    }
}
