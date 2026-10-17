import java.util.Scanner;

// Problem 4: Examination Question Grader
// Each question type has its own grading rule; the main loop just calls grade().

abstract class Question {
    String correctAnswer;
    String studentAnswer;
    int points;

    Question(String correctAnswer, String studentAnswer, int points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double grade();
}

class McqQuestion extends Question {
    McqQuestion(String correctAnswer, String studentAnswer, int points) {
        super(correctAnswer, studentAnswer, points);
    }

    double grade() {
        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }
        return 0;
    }
}

class TrueFalseQuestion extends Question {
    TrueFalseQuestion(String correctAnswer, String studentAnswer, int points) {
        super(correctAnswer, studentAnswer, points);
    }

    double grade() {
        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }
        return 0;
    }
}

class EssayQuestion extends Question {
    EssayQuestion(String correctAnswer, String studentAnswer, int points) {
        super(correctAnswer, studentAnswer, points);
    }

    double grade() {
        String[] keywords = correctAnswer.split(",");
        String answer = studentAnswer.toLowerCase();

        int matches = 0;
        for (String keyword : keywords) {
            if (answer.contains(keyword.trim().toLowerCase())) {
                matches++;
            }
        }

        if (matches >= 2) {
            return points * 0.75;
        } else if (matches == 1) {
            return points * 0.50;
        }
        return 0;
    }
}

public class Problem4_QuestionGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double totalScore = 0;

        for (int i = 0; i < n; i++) {
            // Splitting on the quote mark gives:
            // [type, questionText, space, correctAnswer, space, studentAnswer, points]
            String[] parts = sc.nextLine().split("\"");
            String type = parts[0].trim();
            String correct = parts[3];
            String student = parts[5];
            int points = Integer.parseInt(parts[6].trim());

            Question question;
            if (type.equals("MCQ")) {
                question = new McqQuestion(correct, student, points);
            } else if (type.equals("TF")) {
                question = new TrueFalseQuestion(correct, student, points);
            } else if (type.equals("ESSAY")) {
                question = new EssayQuestion(correct, student, points);
            } else {
                System.out.println("Unknown question type: " + type);
                continue;
            }

            double score = question.grade();
            System.out.println(type + ": " + String.format("%.2f", score));
            totalScore += score;
        }

        System.out.println("Total Score: " + String.format("%.2f", totalScore));
    }
}
