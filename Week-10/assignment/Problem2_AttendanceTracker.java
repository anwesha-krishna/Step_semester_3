// Problem 6: Class Attendance Tracker
// attendanceSummary(days) returns the number of present days and the longest unbroken run of present days.
//
// Complexity
//   Time O(n): the array is visited once.
//   Space O(1): only three counters are used (the 2-element result is a fixed size).
//   Yes, both answers can be found in a single pass: the present-day count and the
//   running streak are both updated as each day is visited.

public class Problem6_AttendanceTracker {
    // Returns {presentDays, longestStreak}
    static int[] attendanceSummary(int[] days) {
        int present = 0;
        int currentStreak = 0;
        int longestStreak = 0;

        for (int day : days) {
            if (day == 1) {
                present++;
                currentStreak++; // the run grows on every 1
                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak; // remember the largest run reached
                }
            } else {
                currentStreak = 0; // the run is broken on every 0
            }
        }

        return new int[]{present, longestStreak};
    }

    static void printSummary(int[] days) {
        int[] result = attendanceSummary(days);
        System.out.println("Present: " + result[0] + ", Longest streak: " + result[1]);
    }

    public static void main(String[] args) {
        System.out.print("Sample 1: ");
        printSummary(new int[]{1, 1, 0, 1, 1, 1, 0, 1});

        System.out.print("Sample 2: ");
        printSummary(new int[]{0, 0, 0});
    }
}
