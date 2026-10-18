import java.util.Scanner;

// Problem 3: Even and Odd Numbers in a List
// The list is typed like [3, 8, 12, 5, 7, 10]; the brackets and commas are removed first.
// The modulo operator (%) tells us whether each number is even or odd.

public class Problem3_EvenOddCounter {
    static int[] parseList(String line) {
        String cleaned = line.replace("[", " ").replace("]", " ").replace(",", " ").trim();
        if (cleaned.isEmpty()) {
            return new int[0];
        }

        String[] parts = cleaned.split("\\s+");
        int[] numbers = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            numbers[i] = Integer.parseInt(parts[i]);
        }
        return numbers;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }

            int[] numbers = parseList(line);

            int evenCount = 0;
            int oddCount = 0;
            for (int number : numbers) {
                if (number % 2 == 0) {
                    evenCount++;
                } else {
                    oddCount++;
                }
            }

            System.out.println("Even: " + evenCount);
            System.out.println("Odd: " + oddCount);
        }
    }
}
