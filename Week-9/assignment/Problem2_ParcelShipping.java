import java.util.Scanner;

// Problem 2: Parcel Shipping Desk
// Two different questions are asked about a parcel, so they live in two different places:
//   1. "How much does shipping cost?"  -> every parcel answers it: abstract method in Parcel.
//   2. "Can it be insured?"            -> only some parcels: the Insurable interface.
// Standard parcels do not implement Insurable, so they are never touched when another
// parcel type becomes insurable later.

abstract class Parcel {
    String type;
    double weightKg;
    double declaredValue;

    Parcel(String type, double weightKg, double declaredValue) {
        this.type = type;
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    abstract double calculateCharge();
}

// The "can be insured" ability
interface Insurable {
    double INSURANCE_RATE = 0.02; // 2% of declared value, written once

    double calculateInsurance();
}

class StandardParcel extends Parcel {
    StandardParcel(double weightKg, double declaredValue) {
        this("STANDARD", weightKg, declaredValue);
    }

    // Used by FragileParcel, so it can reuse the standard charge but show its own type name
    StandardParcel(String type, double weightKg, double declaredValue) {
        super(type, weightKg, declaredValue);
    }

    double calculateCharge() {
        return 40 + 10 * weightKg;
    }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double weightKg, double declaredValue) {
        super("EXPRESS", weightKg, declaredValue);
    }

    double calculateCharge() {
        return 80 + 15 * weightKg;
    }

    public double calculateInsurance() {
        return declaredValue * INSURANCE_RATE;
    }
}

class FragileParcel extends StandardParcel implements Insurable {
    FragileParcel(double weightKg, double declaredValue) {
        super("FRAGILE", weightKg, declaredValue);
    }

    double calculateCharge() {
        return super.calculateCharge() + 50; // standard charge + Rs 50 handling fee
    }

    public double calculateInsurance() {
        return declaredValue * INSURANCE_RATE;
    }
}

public class Problem2_ParcelShipping {
    // The only place that reads the type text: it just decides which object to build
    static Parcel createParcel(String type, double weightKg, double declaredValue) {
        switch (type) {
            case "STANDARD":
                return new StandardParcel(weightKg, declaredValue);
            case "EXPRESS":
                return new ExpressParcel(weightKg, declaredValue);
            case "FRAGILE":
                return new FragileParcel(weightKg, declaredValue);
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            Parcel parcel = createParcel(parts[0], Double.parseDouble(parts[1]), Double.parseDouble(parts[2]));
            if (parcel == null) {
                System.out.println("Unknown parcel type: " + parts[0]);
                continue;
            }

            double charge = parcel.calculateCharge();

            // Ask about the ability, not the type name
            double insurance = 0;
            if (parcel instanceof Insurable) {
                insurance = ((Insurable) parcel).calculateInsurance();
            }

            double total = charge + insurance;
            System.out.println(parcel.type + ": Charge=" + String.format("%.2f", charge)
                    + " Insurance=" + String.format("%.2f", insurance)
                    + " Total=" + String.format("%.2f", total));
            grandTotal += total;
        }

        System.out.println("Grand Total: " + String.format("%.2f", grandTotal));
    }
}
