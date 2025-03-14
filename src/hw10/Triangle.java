package hw10;

public class Triangle extends Shape {
    private double a;
    private double b;
    private  double c;

    public Triangle(double a, double b, double c) {
        super("Hình tam giác");
        if (a + b > c && a + c > b && b + c > a) {
            this.a = a;
            this.b = b;
            this.c = c;
        } else {
            throw new IllegalArgumentException("Ba cạnh không hợp lệ để tạo tam giác!");
        }
    }

    @Override
    public double calculatePerimeter() {
        return a + b + c;
    }

    @Override
    public double calculateArea() {
        double p = calculatePerimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public String toString() {
        return "Triangle | Cạnh a: " + a + " | Cạnh b: " + b + " | Cạnh c: " + c + " | Diện tích: " + calculateArea() + " | Chu vi: " + calculatePerimeter();
    }
}
