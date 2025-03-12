package hw09;

public class Main {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(3, 4);
        Fraction f2 = new Fraction(2, 5);

        System.out.println("f1: " + f1);
        System.out.println("f2: " + f2);

        System.out.println("Cộng: " + f1.add(f2));
        System.out.println("Trừ: " + f1.subtract(f2));
        System.out.println("Nhân: " + f1.multiply(f2));
        System.out.println("Chia: " + f1.divide(f2));
    }
}
