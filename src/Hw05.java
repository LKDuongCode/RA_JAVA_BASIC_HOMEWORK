import java.util.Scanner;

public class Hw05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số phần tử của mảng: ");
        int n = Integer.parseInt(sc.nextLine());

        if (n == 0) {
            System.out.println("Mảng không có phần tử");
            return;
        }

        int[] arr = new int[n];

        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(sc.nextLine());
        }

        int minOdd = -1, maxOdd = -1;

        for (int num : arr) {
            if (num > 0 && num % 2 != 0) {
                if (minOdd == -1 || num < minOdd) {
                    minOdd = num;
                }
                if (maxOdd == -1 || num > maxOdd) {
                    maxOdd = num;
                }
            }
        }

        if (minOdd == -1) {
            System.out.println("Không có phần tử lẻ trong mảng");
        } else {
            System.out.println("Phần tử lẻ nguyên dương nhỏ nhất: " + minOdd);
            System.out.println("Phần tử lẻ nguyên dương lớn nhất: " + maxOdd);
        }
    }
}
