import java.util.Scanner;
public class LineComparisonProblem {
    // Method to calculate length of a line using double points
    // Formula: sqrt((x2-x1)^2 + (y2-y1)^2)
    public static double calculateLength(double x1, double y1,double x2, double y2) {
        // Difference of x coordinates
        double dx = x2 - x1;
        // Difference of y coordinates
        double dy = y2 - y1;
        // Length calculation (square using multiplication, not ^)
        return Math.sqrt(dx * dx + dy * dy);
    }
    public static void main(String[] args) {
        // Welcome message
        System.out.println("Welcome to Line Comparison Computation Program");
        Scanner sc = new Scanner(System.in);
        //Line 1 input
        System.out.println("Enter coordinates for Line 1:");
        System.out.print("Enter x1: ");
        double x1 = sc.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = sc.nextDouble();
        System.out.print("Enter x2: ");
        double x2 = sc.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = sc.nextDouble();

        //Line 2 input
        System.out.println("\nEnter coordinates for Line 2:");
        System.out.print("Enter x3: ");
        double x3 = sc.nextDouble();
        System.out.print("Enter y3: ");
        double y3 = sc.nextDouble();
        System.out.print("Enter x4: ");
        double x4 = sc.nextDouble();
        System.out.print("Enter y4: ");
        double y4 = sc.nextDouble();
        // UC 1: Calculate length of both lines
        Double Length1 = calculateLength(x1, y1, x2, y2);
        Double Length2 = calculateLength(x3, y3, x4, y4);
        System.out.println("\nLength of Line 1: " + Length1);
        System.out.println("Length of Line 2: " + Length2);
        // UC 2: Check equality using equals()
        if (Length1.equals(Length2)) {
            System.out.println("Both lines are Equal");
        } else {
            System.out.println("Both lines are Not Equal");
        }
        // UC 3: Compare two lines using compareTo()
        int CompareOutput = Length1.compareTo(Length2);
        if (CompareOutput == 0) {
            System.out.println("Both lines are Equal");
        } else if (CompareOutput > 0) {
            System.out.println("Line 1 is Greater than Line 2");
        } else {
            System.out.println("Line 1 is Less than Line 2");
        }
    }
}
