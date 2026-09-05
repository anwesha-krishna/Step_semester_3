import java.util.Arrays;

class Candidate implements Comparable<Candidate> {
    String name;
    double cgpa;
    int codingScore;
    double composite;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
        this.composite = (cgpa * 10) + (codingScore * 0.5);
    }

    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.composite, this.composite); // descending
    }

    static String p5(Candidate[] candidates) {
        // Step 1: shortlist
        Candidate[] temp = new Candidate[candidates.length];
        int count = 0;
        for (Candidate c : candidates) {
            if (isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore)) {
                temp[count++] = c;
            }
        }

        Candidate[] shortlisted = Arrays.copyOf(temp, count);

        // Step 2: rank
        Arrays.sort(shortlisted);

        // Step 3: build output
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            result.append(i + 1).append(". ")
                    .append(shortlisted[i].name).append(" (")
                    .append(shortlisted[i].composite).append(")");
            if (i != shortlisted.length - 1) result.append(" | ");
        }
        return result.toString();
    }
}