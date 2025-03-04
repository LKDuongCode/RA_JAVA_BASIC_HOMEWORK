import java.util.Scanner;

public class Hw5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập num1: ");
        double num1 = scanner.nextDouble();

        System.out.print("Nhập (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        System.out.print("Nhập num2: ");
        double num2 = scanner.nextDouble();
        double result;

        switch (operator) {
            case '+':
                result = num1 + num2;
                System.out.println("Kết quả: " + result);
                break;
            case '-':
                result = num1 - num2;
                System.out.println("Kết quả: " + result);
                break;
            case '*':
                result = num1 * num2;
                System.out.println("Kết quả: " + result);
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("Không thể chia cho 0.");
                } else {
                    result = num1 / num2;
                    System.out.println("Kết quả: " + result);
                }
                break;
            default:
                System.out.println("Phép toán không hợp lệ.");
                break;
        }

        scanner.close();
    }
}