package hw04;

public class Main {
    public static void main(String[] args) {
        // overloading
        System.out.println(new Shape().area());
        System.out.println(new Shape().area(2));
        System.out.println(new Shape().area(2,3));

        System.out.println();
        // override
        System.out.println(new Circle(2).area());
        System.out.println(new Rectangle(2,3).area());
    }
}
