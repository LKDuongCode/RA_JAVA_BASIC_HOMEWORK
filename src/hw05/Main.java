package hw05;

public class Main {
    public static void main(String[] args) {
        Circle circle1 = new Circle(2);
        Cylinder cylinder1 = new Cylinder(3,3);

        System.out.println("area circle = " + circle1.getArea());
        System.out.println("volume cyliner = " + cylinder1.getVolume());

        circle1.setRadius(3);
        cylinder1.setHeight(2);
        System.out.println("area circle = " + circle1.getArea());
        System.out.println("volume cyliner = " + cylinder1.getVolume());
    }
}
