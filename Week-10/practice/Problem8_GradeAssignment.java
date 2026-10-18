import java.util.Scanner;

// Problem 8: Student Grade Assignment
// An if / else-if ladder, checked from the highest boundary down.
// A: 90 or above, B: 75 to 89, C: 60 to 74, D: 40 to 59, F: below 40.

public class Problem8_GradeAssignment {
    static String getGrade(double marks) {
        if (marks >= 90) {
            return "A";
        } else if (marks >= 75) {
            return "B";
        } else if (marks >= 60) {
            return "C";
        } else if (marks >= 40) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }

            double marks = Double.parseDouble(line);
            System.out.println("Grade " + getGrade(marks));
        }
    }
}
