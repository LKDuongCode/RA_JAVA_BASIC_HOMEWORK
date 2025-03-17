package hw05;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[10];
        int curIdx = 0;

        shapes[curIdx++] = new Circle(2);
        shapes[curIdx++] = new Rectangle(2,3);
        shapes[curIdx++] = new Square(2);

        System.out.println("shapes = ");
        for(int i = 0; i < curIdx; i++) {
            System.out.println(shapes[i].area());
        }
    }
}
