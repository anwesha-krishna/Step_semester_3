static double rowAverage(int[] row) {
    int sum = 0;
    for (int val : row) {
        sum += val;
    }
    return (double) sum / row.length;
}

static String p4(int[][] seatingScores, int threshold) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < seatingScores.length; i++) {
        double avg = rowAverage(seatingScores[i]);
        String zone = (avg < threshold) ? "Quiet Zone" : "Buzzing Zone";
        result.append("Row ").append(i).append(": ").append(zone);
        if (i != seatingScores.length - 1) {
            result.append(" | ");
        }
    }
    return result.toString();
}

void main() {
}
