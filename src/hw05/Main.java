package hw05;

public class Main {
    public static void main(String[] args) {
        Vector2D vt1 = new Vector2D(1,3);
        Vector2D vt2 = new Vector2D(4,8);

        System.out.println("vt 1: ");
        vt1.displayVector();
        System.out.println("Magnitude = " + vt1.calculateMagnitude());

        System.out.print("add = " );
        vt1.add(vt2).displayVector();
        System.out.print("subtract = ");
        vt1.subtract(vt2).displayVector();
        System.out.print("dot = ");
        System.out.println("dot = " + vt1.dotProduct(vt2));



        System.out.println("vt 2: ");
        vt2.displayVector();
        System.out.println("Magnitude = " + vt2.calculateMagnitude());
        System.out.print("add = " );
        vt2.add(vt1).displayVector();
        System.out.print("subtract = ");
        vt2.subtract(vt1).displayVector();
        System.out.println("dot = " + vt2.dotProduct(vt1));
    }
}
