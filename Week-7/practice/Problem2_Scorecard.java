// Problem 2. The Quiz Scorecard
// Results are stored privately; only the computed score is exposed,
// never the raw array.

class Scorecard {
    private final boolean[] results;
    private int answeredCount;

    public Scorecard(int totalQuestions) {
        this.results = new boolean[totalQuestions];
        this.answeredCount = 0;
    }

    void recordAnswer(boolean correct) {
        if (answeredCount >= results.length) {
            System.out.println("Record rejected: all questions already answered");
            return;
        }
        results[answeredCount] = correct;
        answeredCount++;
    }

    int getScore() {
        int score = 0;
        for (boolean result : results) {
            if (result) {
                score++;
            }
        }
        return score;
    }
}

public class Problem2_Scorecard {
    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score: " + sc.getScore());
    }
}
