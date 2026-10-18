import java.util.Arrays;

// Problem 8: Duty Roster Rotation
// rotateRoster(names, k) returns the roster rotated to the right by k places (names wrap around to the front).
// k % n removes the full turns, and the name at index i moves to index (i + k) % n.
//
// Complexity
//   Time O(n): every name is moved once, no matter how large k is.
//   Space O(n): a new array holds the rotated roster (the original is left unchanged).
//
// Why rotating one place at a time, k times, is slow
//   Each one-place rotation touches all n names, which costs O(n). Doing it k times costs O(n * k).
//   With k up to 10^9 and n up to 100 that is around 10^11 steps, far too many.
//   It is also wasted work: rotating by exactly n places brings the roster back to where it started,
//   so only k % n places ever matter.

public class Problem8_DutyRoster {
    static String[] rotateRoster(String[] names, int k) {
        int n = names.length;
        int shift = k % n; // full turns change nothing

        String[] rotated = new String[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + shift) % n] = names[i];
        }
        return rotated;
    }

    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E"};

        System.out.println("Sample 1: " + Arrays.toString(rotateRoster(names, 2)));
        System.out.println("Sample 2: " + Arrays.toString(rotateRoster(names, 7)));
    }
}
