import java.util.Scanner;

// Problem 9: Leap Year Detector
// A leap year is divisible by 4, but not by 100, unless it is also divisible by 400.

public class Problem9_LeapYear {
    static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }

            int year = Integer.parseInt(line);

            if (isLeapYear(year)) {
                System.out.println("Leap year");
            } else {
                System.out.println("Not a leap year");
            }
        }
    }
}
