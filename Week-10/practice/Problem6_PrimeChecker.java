import java.util.Scanner;

// Problem 6: Prime Number Checker
// A number is prime if nothing from 2 up to its square root divides it evenly.
// (i * i <= number is the same as i <= sqrt(number), without needing Math.sqrt.)

public class Problem6_PrimeChecker {
    static boolean isPrime(long number) {
        if (number <= 1) {
            return false;
        }

        for (long i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false; // found a divisor, so it is not prime
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }

            long number = Long.parseLong(line);

            if (isPrime(number)) {
                System.out.println(number + " is prime");
            } else {
                System.out.println(number + " is not prime");
            }
        }
    }
}
