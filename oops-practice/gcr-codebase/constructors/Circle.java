import java.util.Scanner;

public class Circle {

    double radius;

    // Default constructor
    Circle() {
        this(1.0);   // constructor chaining
        System.out.println("Default Radius = " + radius);
    }

    // Parameterized constructor
    Circle(double radius) {
        this.radius = radius;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // CALLING DEFAULT CONSTRUCTOR
        Circle C1 = new Circle();

        // User input
        System.out.print("Enter radius: ");
        double R = sc.nextDouble();

        // CALLING PARAMETERIZED CONSTRUCTOR
        Circle C2 = new Circle(R);
        System.out.println("User Radius = " + C2.radius);
    }
}
