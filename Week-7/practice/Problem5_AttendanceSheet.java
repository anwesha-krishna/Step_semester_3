// Problem 5. The Attendance Sheet
// Present students are stored privately; only a count and a yes/no
// lookup are exposed, never the full list.

class AttendanceSheet {
    private final String[] presentStudents;
    private int count;

    public AttendanceSheet(int maxClassSize) {
        this.presentStudents = new String[maxClassSize];
        this.count = 0;
    }

    void markPresent(String name) {
        if (isPresent(name)) {
            return; // already marked, avoid duplicates
        }
        presentStudents[count] = name;
        count++;
    }

    int getPresentCount() {
        return count;
    }

    boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (presentStudents[i].equals(name)) {
                return true;
            }
        }
        return false;
    }
}

public class Problem5_AttendanceSheet {
    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present count: " + sheet.getPresentCount());
        System.out.println("isPresent(Ben): " + sheet.isPresent("Ben"));
        System.out.println("isPresent(Chen): " + sheet.isPresent("Chen"));
    }
}
