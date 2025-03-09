import java.util.Scanner;
import java.util.Arrays;

public class Hw10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số phần tử của mảng: ");
        int n = Integer.parseInt(sc.nextLine());

        if (n <= 0) {
            System.out.println("Mảng không hợp lệ");
            return;
        }

        int[] arr = new int[n];

        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(sc.nextLine());
        }

        int maxSum = arr[0], currentSum = 0;
        int start = 0, end = 0, tempStart = 0;
        boolean allNegative = true;
        int maxElement = arr[0];

        for (int i = 0; i < n; i++) {
            currentSum += arr[i];

            if (arr[i] >= 0) {
                allNegative = false;
            }
            if (arr[i] > maxElement) {
                maxElement = arr[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }

            if (currentSum < 0) {
                currentSum = 0;
                tempStart = i + 1;
            }
        }

        if (allNegative) {
            System.out.println(maxElement + " (Chọn phần tử lớn nhất vì tất cả số đều âm)");
        } else {
            int[] subarray = Arrays.copyOfRange(arr, start, end + 1);
            System.out.println(maxSum + " (Dãy con " + Arrays.toString(subarray) + " có tổng lớn nhất)");
        }
    }
}
