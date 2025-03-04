import java.util.Scanner;

public class Hw10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập a: ");
        double a = scanner.nextDouble();
        System.out.print("Nhập b: ");
        double b = scanner.nextDouble();
        System.out.print("Nhập c: ");
        double c = scanner.nextDouble();
        System.out.print("Nhập d: ");
        double d = scanner.nextDouble();

        if (a == 0) {
            // chuyển thành phương trình bậc hai
            if (b == 0) {
                if (c == 0) {
                    if (d == 0) {
                        System.out.println("Phương trình có vô số nghiệm.");
                    } else {
                        System.out.println("Phương trình vô nghiệm.");
                    }
                } else {
                    double x = -d / c;
                    System.out.println("Phương trình bậc nhất có nghiệm: x = " + x);
                }
            } else {
                double delta = c * c - 4 * b * d;
                if (delta > 0) {
                    double x1 = (-c + Math.sqrt(delta)) / (2 * b);
                    double x2 = (-c - Math.sqrt(delta)) / (2 * b);
                    System.out.println("Phương trình bậc hai có 2 nghiệm phân biệt: x1 = " + x1 + ", x2 = " + x2);
                } else if (delta == 0) {
                    double x = -c / (2 * b);
                    System.out.println("Phương trình bậc hai có 1 nghiệm kép: x = " + x);
                } else {
                    System.out.println("Phương trình bậc hai vô nghiệm.");
                }
            }
        } else { // a != 0
            double f = ((3 * c / a) - ((b * b) / (a * a))) / 3;
            double g = ((2 * Math.pow(b, 3) / (Math.pow(a, 3))) - (9 * b * c / (a * a)) + (27 * d / a)) / 27;
            double h = Math.pow(g, 2) / 4 + Math.pow(f, 3) / 27;

            if (h > 0) {
                double r = -(g / 2) + Math.sqrt(h);
                double s = Math.cbrt(r);
                double t = -(g / 2) - Math.sqrt(h);
                double u = Math.cbrt(t);

                double x1 = (s + u) - (b / (3 * a));
                System.out.println("Phương trình có một nghiệm thực: x = " + x1);
            } else if (h == 0) {
                double r = -(g / 2);
                double s = Math.cbrt(r);

                double x1 = 2 * s - (b / (3 * a));
                double x2 = -s - (b / (3 * a));
                System.out.println("Phương trình có ba nghiệm thực: x1 = " + x1 + ", x2 = " + x2);
            } else {
                double i = Math.sqrt((Math.pow(g, 2) / 4) - h);
                double j = Math.cbrt(i);
                double k = Math.acos(-(g / (2 * i)));
                double m = Math.cos(k / 3);
                double n = Math.sqrt(3) * Math.sin(k / 3);
                double p = -(b / (3 * a));

                double x1 = 2 * j * m + p;
                double x2 = -j * (m + n) + p;
                double x3 = -j * (m - n) + p;

                System.out.println("Phương trình có ba nghiệm thực phân biệt: x1 = " + x1 + ", x2 = " + x2 + ", x3 = " + x3);
            }
        }

        scanner.close();
    }
}