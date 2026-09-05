import java.util.Arrays;

static void p1(int[] scores, int bonus) {
    for (int i = 0; i < scores.length; i++) {
        scores[i] = scores[i] + bonus;
    }
    System.out.println(Arrays.toString(scores));
}

void main() {
}
