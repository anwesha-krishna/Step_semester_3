import java.util.ArrayList;
import java.util.Scanner;

// Problem 1: Garden Plot Area Report
// Plot is an abstract base class: it holds what every plot shares (owner, shape name)
// and forces every shape to provide its own area formula.
// The report loop only talks to Plot, so adding a new shape never changes the reporting code.

abstract class Plot {
    String owner;
    String shape;

    Plot(String owner, String shape) {
        this.owner = owner;
        this.shape = shape;
    }

    abstract double calculateArea();
}

class CirclePlot extends Plot {
    double radius;

    CirclePlot(String owner, double radius) {
        super(owner, "CIRCLE");
        this.radius = radius;
    }

    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class RectanglePlot extends Plot {
    double length;
    double width;

    RectanglePlot(String owner, double length, double width) {
        super(owner, "RECTANGLE");
        this.length = length;
        this.width = width;
    }

    double calculateArea() {
        return length * width;
    }
}

class TrianglePlot extends Plot {
    double base;
    double height;

    TrianglePlot(String owner, double base, double height) {
        super(owner, "TRIANGLE");
        this.base = base;
        this.height = height;
    }

    double calculateArea() {
        return 0.5 * base * height;
    }
}

public class Problem1_GardenPlots {
    // The only place that reads the shape text: it just decides which object to build
    static Plot createPlot(String[] parts) {
        String shape = parts[0];
        String owner = parts[1];

        switch (shape) {
            case "CIRCLE":
                return new CirclePlot(owner, Double.parseDouble(parts[2]));
            case "RECTANGLE":
                return new RectanglePlot(owner, Double.parseDouble(parts[2]), Double.parseDouble(parts[3]));
            case "TRIANGLE":
                return new TrianglePlot(owner, Double.parseDouble(parts[2]), Double.parseDouble(parts[3]));
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        ArrayList<Plot> plots = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            Plot plot = createPlot(parts);
            if (plot == null) {
                System.out.println("Unknown shape: " + parts[0]);
            } else {
                plots.add(plot);
            }
        }

        // Same call for every plot - each shape uses its own formula
        double totalArea = 0;
        for (Plot plot : plots) {
            double area = plot.calculateArea();
            System.out.println(plot.owner + " (" + plot.shape + "): " + String.format("%.2f", area));
            totalArea += area;
        }

        System.out.println("Total Area: " + String.format("%.2f", totalArea));
    }
}
