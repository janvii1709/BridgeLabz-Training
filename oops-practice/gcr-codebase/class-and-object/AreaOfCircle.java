class AreaOfCircle {
    double Radius;
    double Area() {
        return 3.1415 * Radius * Radius;
    }
    double Circumference() {
        return 2 * 3.1415 * Radius;
    }

    public static void main(String[] args) {
        AreaOfCircle c = new AreaOfCircle();
        c.Radius = 2.5;
        System.out.printf("Area of circle: %.4f\n", c. Area());
        System.out.printf("Circumference of circle: %.4f\n", c.Circumference());
    }
}