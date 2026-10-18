// Problem 7: Second-Best Score
// secondHighest(scores) returns the second-highest DISTINCT score, or -1 if it does not exist.
// The array is not sorted: two variables (highest and second) are updated as each score is visited once.
//
// Complexity
//   This solution: O(n) time (one pass), O(1) space (two variables).
//   Sorting first:  O(n log n) time, and it either changes the array or needs an O(n) copy.
//                   It also skips nothing: all the work of ordering every score is wasted,
//                   because only the top two distinct values are needed.
//   For n <= 1000 both are fast, but the single pass is the better design, and the question says not to sort.

public class Problem7_SecondHighest {
    static int secondHighest(int[] scores) {
        int highest = -1; // scores are never negative, so -1 safely means "none yet"
        int second = -1;

        for (int score : scores) {
            if (score > highest) {
                second = highest; // the old highest becomes the second
                highest = score;
            } else if (score < highest && score > second) {
                second = score;
            }
            // a score equal to the current highest is skipped (it is not a distinct score)
        }

        return second; // stays -1 when every score is the same
    }

    public static void main(String[] args) {
        System.out.println("Sample 1: " + secondHighest(new int[]{45, 78, 92, 78, 60}));
        System.out.println("Sample 2: " + secondHighest(new int[]{50, 50, 50}));
    }
}
