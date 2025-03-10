import java.util.Scanner;

public class Hw01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập một chuỗi: ");
        String input = sc.nextLine().trim();

        if (input.isEmpty()) {
            System.out.println("Số từ trong chuỗi: 0");
            return;
        }

        String[] words = input.split("\\s+");

        System.out.println("Số từ trong chuỗi: " + words.length);
    }
}
