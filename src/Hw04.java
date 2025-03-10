import java.util.Scanner;

public class Hw04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String input = sc.nextLine();

        String maskedString = input.replaceAll("\\d", "*");

        System.out.println("Chuỗi sau khi thay thế: " + maskedString);
    }
}
