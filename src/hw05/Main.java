package hw05;

public class Main {
    public static void main(String[] args) {
        C_Circle c = new C_Circle(2);
        C_Square s = new C_Square(2);
        C_Rectangle r = new C_Rectangle(3,2);

        c.setColor("red");
        s.setColor("yellow");
        r.setColor("blue");

        System.out.println(String.join(" ", c.color, s.color, r.color));
    }
}
