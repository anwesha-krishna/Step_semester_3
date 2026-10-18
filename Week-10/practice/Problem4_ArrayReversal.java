import java.util.Arrays;
import java.util.Scanner;

// Problem 4: In-Place Array Reversal
// Two pointers: one at the start, one at the end. Swap, then move both towards the centre
// until they meet or cross. No second array is created, so the original array is modified directly.

public class Problem4_ArrayReversal {
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

    static void reverseInPlace(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int temp = numbers[left];
            numbers[left] = numbers[right];
            numbers[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }

            int[] numbers = parseList(line);
            reverseInPlace(numbers);
            System.out.println(Arrays.toString(numbers));
        }
    }
}
