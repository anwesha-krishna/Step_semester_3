// Problem 4. The Locker Code
// Write-only field: the combination can be changed but never read
// back from outside the class (no getter at all).

class Locker {
    private String combination;
    private final int lockerNumber;

    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.combination = initialCode;
    }

    void changeCode(String oldCode, String newCode) {
        if (!oldCode.equals(combination)) {
            System.out.println("Change rejected: current code is incorrect");
            return;
        }
        combination = newCode;
        System.out.println("Code changed successfully");
    }
}

public class Problem4_Locker {
    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");

        l.changeCode("1234", "5678"); // succeeds
        l.changeCode("0000", "9999"); // rejected, code stays "5678"
    }
}
