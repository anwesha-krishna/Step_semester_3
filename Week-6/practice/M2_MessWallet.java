// M2. Hostel Mess Wallet Management
// Encapsulates the wallet balance so it can never be set directly
// or pushed negative from outside the class.

class MessWallet {
    private double balance;

    public MessWallet(double openingBalance) {
        if (openingBalance < 0) {
            System.out.println("Warning: negative opening balance given. Starting at 0 instead.");
            this.balance = 0;
        } else {
            this.balance = openingBalance;
        }
    }

    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up rejected: amount must be positive");
            return;
        }
        balance += amount;
        System.out.println("Balance after top-up: " + balance);
    }

    public void deduct(double amount) {
        if (amount > balance) {
            System.out.println("Deduct rejected: insufficient balance");
            return;
        }
        balance -= amount;
        System.out.println("Balance after deduction: " + balance);
    }

    public double getBalance() {
        return balance;
    }
}

public class M2_MessWallet {
    public static void main(String[] args) {
        MessWallet wallet = new MessWallet(500);
        wallet.topUp(200);
        wallet.deduct(1000);
        System.out.println("Final balance: " + wallet.getBalance());
    }
}
