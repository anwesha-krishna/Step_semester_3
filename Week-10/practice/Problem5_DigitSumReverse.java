import java.util.Scanner;

// Problem 5: Digit Sum and Number Reversal
// number % 10 gives the last digit; number / 10 removes it.
// The reversed number is built by multiplying the current reversed value by 10 and adding the digit.

public class Problem5_DigitSumReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }

            long number = Long.parseLong(line);
            long sum = 0;
            long reversed = 0;

            while (number > 0) {
                long digit = number % 10; // last digit
                sum += digit;
                reversed = reversed * 10 + digit;
                number = number / 10; // remove the last digit
            }

            System.out.println("Sum of digits: " + sum);
            System.out.println("Reverse: " + reversed);
        }
    }
}
