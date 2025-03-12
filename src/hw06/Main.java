package hw06;

public class Main {
    public static void main(String[] args) {
        Point2D p1 = new Point2D(1,3);
        Point2D p2 = new Point2D(5,7);

        System.out.println("distance = " + p1.distanceTo(p2));

        System.out.println("old:");
        p1.displayPoint();

        System.out.println("new:");
        p1.setX(9);
        p1.setY(19);
        p1.displayPoint();
    }
}
