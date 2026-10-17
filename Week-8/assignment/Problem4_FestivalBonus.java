import java.util.ArrayList;
import java.util.Scanner;

// Problem 4: The Festival Bonus Calculator
// Name and salary are common to every worker, so they live in the parent class.
// Each worker type has its own bonus rule (polymorphism).
// The main loop calls the same method on every worker, with no type checking.

abstract class Worker {
    String name;
    double monthlySalary;

    Worker(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    abstract double calculateBonus();
}

class FullTimeWorker extends Worker {
    FullTimeWorker(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    double calculateBonus() {
        return monthlySalary * 0.10; // 10% of monthly salary
    }
}

class PartTimeWorker extends Worker {
    PartTimeWorker(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    double calculateBonus() {
        return monthlySalary * 0.05; // 5% of monthly salary
    }
}

class InternWorker extends Worker {
    InternWorker(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    double calculateBonus() {
        return 2000; // fixed bonus, whatever the salary
    }
}

public class Problem4_FestivalBonus {
    // The only place that reads the type text: it just decides which object to build
    static Worker createWorker(String type, String name, double monthlySalary) {
        switch (type) {
            case "FULLTIME":
                return new FullTimeWorker(name, monthlySalary);
            case "PARTTIME":
                return new PartTimeWorker(name, monthlySalary);
            case "INTERN":
                return new InternWorker(name, monthlySalary);
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        ArrayList<Worker> workers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            Worker worker = createWorker(parts[0], parts[1], Double.parseDouble(parts[2]));
            if (worker == null) {
                System.out.println("Unknown employee type: " + parts[0]);
            } else {
                workers.add(worker);
            }
        }

        // Same call for every worker - each object applies its own rule
        double grandTotal = 0;
        for (Worker worker : workers) {
            double bonus = worker.calculateBonus();
            System.out.println(worker.name + ": " + String.format("%.2f", bonus));
            grandTotal += bonus;
        }

        System.out.println("Total Bonus: " + String.format("%.2f", grandTotal));
    }
}
