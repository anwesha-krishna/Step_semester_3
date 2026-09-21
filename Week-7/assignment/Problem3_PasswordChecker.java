// Problem 3. The Password Checker
// The password is stored privately with no getter; only a computed
// strength rating is ever exposed.

class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    String getStrength() {
        int length = password.length();
        if (length < 6) {
            return "Weak";
        } else if (length < 10) {
            return "Medium";
        } else {
            return "Strong";
        }
    }
}

public class Problem3_PasswordChecker {
    public static void main(String[] args) {
        PasswordChecker pc = new PasswordChecker("abcd");
        System.out.println(pc.getStrength());

        PasswordChecker pc2 = new PasswordChecker("abcdefgh");
        System.out.println(pc2.getStrength());

        PasswordChecker pc3 = new PasswordChecker("abcdefghijkl");
        System.out.println(pc3.getStrength());
    }
}
