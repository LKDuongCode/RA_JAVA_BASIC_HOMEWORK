import java.util.Scanner;

public class Hw02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        while (true) {
            System.out.print("Nhập số phần tử của mảng (n): ");
            n = Integer.parseInt(sc.nextLine());

            if (n > 0) {
                break;
            } else {
                System.out.println("Kích thước không hợp lệ, vui lòng nhập lại!");
            }
        }

        int[] arr = new int[n];
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(sc.nextLine());
        }

        int sum = 0;
        boolean hasDivisibleBy3 = false;

        for (int num : arr) {
            if (num % 3 == 0) {
                sum += num;
                hasDivisibleBy3 = true;
            }
        }

        if (hasDivisibleBy3) {
            System.out.println("Tổng các số chia hết cho 3: " + sum);
        } else {
            System.out.println("Không có số chia hết cho 3.");
        }
    }
}
