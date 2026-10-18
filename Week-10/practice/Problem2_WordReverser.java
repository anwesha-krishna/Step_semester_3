import java.util.Scanner;

// Problem 2: Word Reverser and Palindrome Checker
// Reverses each word with a StringBuilder (a mutable text class) and checks the palindrome property.
// The question doesn't say whether case matters, so the comparison ignores case ("Level" counts).

public class Problem2_WordReverser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String word = sc.nextLine().trim();
            if (word.isEmpty()) {
                continue;
            }

            StringBuilder builder = new StringBuilder(word);
            String reversed = builder.reverse().toString();

            boolean isPalindrome = word.equalsIgnoreCase(reversed);

            if (isPalindrome) {
                System.out.println(reversed + " - palindrome");
            } else {
                System.out.println(reversed + " - not a palindrome");
            }
        }
    }
}
