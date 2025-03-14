package hw10;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[10];
        int curIdx = 0;

        shapes[curIdx++] = new Circle(5);
        shapes[curIdx++] = new Rectangle(4, 6);
        shapes[curIdx++] = new Triangle(3, 4, 5);

        System.out.println("Danh sách hình học ==");
        for (int i = 0; i < curIdx; i++) {
            System.out.println(shapes[i].toString());
        }
    }
}
