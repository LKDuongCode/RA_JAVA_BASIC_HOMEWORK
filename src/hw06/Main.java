package hw06;

public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(3, 4);
        System.out.println("Point ban đầu: " + p1);

        MoveablePoint mp1 = new MoveablePoint(3, 4, 2, 3);
        System.out.println("MoveablePoint ban đầu: " + mp1);

        mp1.move();
        System.out.println("MoveablePoint sau khi di chuyển: " + mp1);

        mp1.setXSpeed(5);
        mp1.setYSpeed(-2);
        System.out.println("MoveablePoint sau khi thay đổi tốc độ: " + mp1);

        mp1.move();
        System.out.println("MoveablePoint sau khi di chuyển với tốc độ mới: " + mp1);
    }
}
