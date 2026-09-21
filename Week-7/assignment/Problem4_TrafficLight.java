// Problem 4. The Traffic Light
// The color can only move forward through next(): RED -> GREEN ->
// YELLOW -> RED. There is no direct setter for the color.

class TrafficLight {
    private String color;
    private final String id;

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED";
    }

    String next() {
        if (color.equals("RED")) {
            color = "GREEN";
        } else if (color.equals("GREEN")) {
            color = "YELLOW";
        } else {
            color = "RED";
        }
        return color;
    }

    String getColor() {
        return color;
    }
}

public class Problem4_TrafficLight {
    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");

        System.out.println(t.getColor());
        System.out.println(t.next());
        System.out.println(t.next());
        System.out.println(t.next());
    }
}
