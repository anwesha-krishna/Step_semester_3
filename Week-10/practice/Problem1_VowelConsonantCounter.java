import java.util.Scanner;

// Problem 1: Vowel and Consonant Counter
// Counts the vowels and consonants in a word (alphabetic characters only, case-insensitive).

public class Problem1_VowelConsonantCounter {
    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String word = sc.nextLine().trim();
            if (word.isEmpty()) {
                continue;
            }

            int vowels = 0;
            int consonants = 0;

            for (int i = 0; i < word.length(); i++) {
                char c = Character.toLowerCase(word.charAt(i)); // case-insensitive
                if (Character.isLetter(c)) {
                    if (isVowel(c)) {
                        vowels++;
                    } else {
                        consonants++;
                    }
                }
            }

            System.out.println("Vowels: " + vowels);
            System.out.println("Consonants: " + consonants);
        }
    }
}
