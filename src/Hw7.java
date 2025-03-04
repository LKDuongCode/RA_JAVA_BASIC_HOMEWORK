import java.util.Scanner;

public class Hw7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập cạnh thứ nhất: ");
        int a = scanner.nextInt();
        System.out.print("Nhập cạnh thứ hai: ");
        int b = scanner.nextInt();
        System.out.print("Nhập cạnh thứ ba: ");
        int c = scanner.nextInt();


        if (a + b > c && a + c > b && b + c > a) {
            String type;

            if (a == b && b == c) {
                type = "Tam giác đều";
            } else if (a == b || a == c || b == c) {
                type = "Tam giác cân";
            } else if (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a) {
                type = "Tam giác vuông";
            } else {
                type = "Tam giác thường";
            }

            System.out.println("Ba cạnh tạo thành " + type );
        } else {
            System.out.println("Ba cạnh không tạo thành tam giác.");
        }

        scanner.close();
    }
}