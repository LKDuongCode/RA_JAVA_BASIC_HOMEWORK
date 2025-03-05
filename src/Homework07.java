import java.util.Scanner;

public class Homework07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("n = ");
        int n = sc.nextInt();
        System.out.print("Các số Happy từ 1 đến " + n + " là: ");

        // Duyệt từ 1 đến n
        for (int i = 1; i <= n; i++) {
            int num = i;
            int count = 0; // Giới hạn số lần lặp để tránh vòng lặp vô hạn

            // Kiểm tra số Happy
            while (num != 1 && count < 100) {
                int sum = 0, temp = num;

                // Tính tổng bình phương chữ số
                while (temp > 0) {
                    int digit = temp % 10;
                    sum += digit * digit;
                    temp /= 10;
                }

                num = sum;
                count++;
            }

            if (num == 1) {
                System.out.print(i + " ");
            }
        }

        System.out.println();
        sc.close();
    }
}
