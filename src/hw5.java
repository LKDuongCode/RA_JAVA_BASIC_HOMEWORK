import java.util.Scanner;

public class hw5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float width, height, area, circumference;

        System.out.print("Nhập chiều rộng: ");
        width = scanner.nextFloat();
        System.out.print("Nhập chiều cao: ");
        height = scanner.nextFloat();

        area = width * height;
        circumference = 2 * (width + height);

        System.out.println("Diện tích : " + area);
        System.out.println("Chu vi: " + circumference);

        scanner.close();
    }
}
