static int[] p3(int[] scores) {
    int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;

    for (int score : scores) {
        if (score >= first) {
            third = second;
            second = first;
            first = score;
        } else if (score >= second) {
            third = second;
            second = score;
        } else if (score >= third) {
            third = score;
        }
    }
    return new int[]{first, second, third};
}

void main() {
}