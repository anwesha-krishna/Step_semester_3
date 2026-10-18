import java.math.BigInteger;
import java.util.Scanner;

// Problem 7: Factorial Calculation
// A loop multiplies 1 x 2 x ... x n. 0! is the special case and is defined as 1.
// BigInteger is used so larger inputs (21 and above) don't overflow a normal long.

public class Problem7_Factorial {
    static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;

        if (n == 0) {
            return result; // 0! = 1
        }

        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }

            int n = Integer.parseInt(line);
            System.out.println(factorial(n));
        }
    }
}
