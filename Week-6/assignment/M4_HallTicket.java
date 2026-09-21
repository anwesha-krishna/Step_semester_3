// M4. Exam Hall Ticket Reference Management
// Shows the difference between reference copies (==) and separate
// objects with identical field values.

class HallTicket {
    String studentName;
    int seatNumber;

    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

public class M4_HallTicket {
    public static void main(String[] args) {
        HallTicket priya = new HallTicket("Priya", 0);
        HallTicket copy = priya; // points at the same object, not a copy
        copy.seatNumber = 45;

        HallTicket separate = new HallTicket("Priya", 45); // a genuinely new object

        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));
        System.out.println("separate == priya: " + (separate == priya));
    }
}
