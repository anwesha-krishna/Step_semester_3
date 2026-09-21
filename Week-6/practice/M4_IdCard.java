// M4. Library ID Card Management
// Shows the difference between reference copies (==) and separate
// objects with identical field values.

class IdCard {
    String name;
    int booksIssued;

    public IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }
}

public class M4_IdCard {
    public static void main(String[] args) {
        IdCard ravi = new IdCard("Ravi", 0);
        IdCard duplicate = ravi; // points at the same object, not a copy
        duplicate.booksIssued = 3;

        IdCard separate = new IdCard("Ravi", 3); // a genuinely new object

        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}
