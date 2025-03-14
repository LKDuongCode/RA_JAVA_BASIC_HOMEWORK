package hw10;

public class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        super("Hình tròn");
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle | Bán kính: " + radius + " | Diện tích: " + calculateArea() + " | Chu vi: " + calculatePerimeter();
    }
}
