// Problem 4: Exam Score Band Counter
// countInBand(scores, low, high) counts the scores s with low <= s <= high in a SORTED array,
// without scanning the scores one by one: two binary searches find the edges of the band.
//
// Complexity
//   Linear scan:   O(n) time, O(1) space. Every query looks at every score.
//   This solution: O(log n) time, O(1) space. Two binary searches, each halves the search area every step.
//
// Effect of duplicates at the edges of the band
//   A normal binary search stops at ANY element equal to the target. With repeated marks (like 42, 42)
//   that element could be in the middle of the run, so the count would be wrong. The search must therefore
//   keep going until it reaches the exact edge:
//     - low:  a score equal to low must still be counted, so on a match we keep moving LEFT
//             until we reach the first copy (first index with score >= low).
//     - high: scores equal to high must also be counted, so on a match we keep moving RIGHT
//             past every copy (first index with score > high).
//   The answer is the difference between those two positions.

public class Problem4_ExamScoreBand {
    // First index whose score is >= target (scores.length if there is none)
    static int firstIndexAtLeast(int[] scores, int target) {
        int left = 0;
        int right = scores.length; // search area is [left, right)

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] >= target) {
                right = mid; // mid might be the first one, so keep looking on the left
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // First index whose score is > target (scores.length if there is none)
    static int firstIndexGreaterThan(int[] scores, int target) {
        int left = 0;
        int right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] > target) {
                right = mid;
            } else {
                left = mid + 1; // equal scores are still inside the band, so move past them
            }
        }
        return left;
    }

    static int countInBand(int[] scores, int low, int high) {
        return firstIndexGreaterThan(scores, high) - firstIndexAtLeast(scores, low);
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};

        System.out.println("Sample 1: " + countInBand(scores, 42, 58));
        System.out.println("Sample 2: " + countInBand(scores, 90, 100));
    }
}
