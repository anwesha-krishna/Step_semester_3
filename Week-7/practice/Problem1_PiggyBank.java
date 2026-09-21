// Problem 1. The Piggy Bank
// Savings can only change through deposit/withdraw, never set directly.
// The ID is locked in place forever using final.

class PiggyBank {
    private double savings;
    private final String id;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    void deposit(double amount) {
        savings += amount;
    }

    void withdraw(double amount) {
        if (amount > savings) {
            System.out.println("Withdrawal rejected: insufficient savings");
            return;
        }
        savings -= amount;
    }

    double getSavings() {
        return savings;
    }
}

public class Problem1_PiggyBank {
    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        System.out.println("After deposit(100): savings = " + pb.getSavings());

        pb.withdraw(30);
        System.out.println("After withdraw(30): savings = " + pb.getSavings());

        pb.withdraw(500);
        System.out.println("After withdraw(500): savings = " + pb.getSavings());
    }
}
