import java.util.Scanner;

// Problem 10: Student Result Card Generator
// StudentResult holds a name and an array of marks, and works out the average itself.
// Grade rules: B for an average of 75 or more (as the question says), C for 60 to 74,
// D for 40 to 59, F below 40. The name is printed in capital letters.

class StudentResult {
    String name;
    double[] marks;

    StudentResult(String name, double[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double calculateAverage() {
        double sum = 0;
        for (double mark : marks) {
            sum += mark;
        }
        return sum / marks.length;
    }

    char getGrade() {
        double average = calculateAverage();

        if (average >= 75) {
            return 'B';
        } else if (average >= 60) {
            return 'C';
        } else if (average >= 40) {
            return 'D';
        } else {
            return 'F';
        }
    }
}

public class Problem10_ResultCard {
    // Reads a line like: Asha [80, 90, 70]
    static StudentResult parseStudent(String line) {
        int open = line.indexOf('[');
        int close = line.indexOf(']');

        String name = line.substring(0, open).trim();
        String[] markParts = line.substring(open + 1, close).split(",");

        double[] marks = new double[markParts.length];
        for (int i = 0; i < markParts.length; i++) {
            marks[i] = Double.parseDouble(markParts[i].trim());
        }

        return new StudentResult(name, marks);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }

            StudentResult student = parseStudent(line);

            System.out.println(student.name.toUpperCase() + ": Average "
                    + String.format("%.1f", student.calculateAverage())
                    + ", Grade " + student.getGrade());
        }
    }
}
