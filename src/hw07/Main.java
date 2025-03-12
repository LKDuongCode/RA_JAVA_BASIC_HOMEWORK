package hw07;

public class Main {
    public static void main(String[] args) {
        QuadraticEquation qe1 = new QuadraticEquation(1, -3, 2);

        System.out.println("Phương trình: " + qe1.a + "x² + " + qe1.b + "x + " + qe1.c + " = 0");

        if (!qe1.hasRealRoots()) {
            System.out.println("Phương trình không có nghiệm thực.");
        } else if (qe1.getRoot1() == qe1.getRoot2()) {
            System.out.println("Phương trình có nghiệm kép: x = " + qe1.getRoot1());
        } else {
            System.out.println("Phương trình có nghiệm");
            System.out.println("x1 = " + qe1.getRoot1());
            System.out.println("x2 = " + qe1.getRoot2());
        }
    }
}
