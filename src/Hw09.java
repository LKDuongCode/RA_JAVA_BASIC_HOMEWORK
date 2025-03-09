import java.util.Arrays;
import java.util.Scanner;

public class Hw09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Nhập n =  ");
        int n = Integer.parseInt(sc.nextLine());
        if (n <= 0) {
            System.out.println("Ma trận không hợp lệ");
            return;
        }

        int[][] arr = new int[n][n];
        
        System.out.println("Nhập các phần tử của ma trận:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(sc.nextLine());
            }
        }

        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }

        //  Chuyển vị ma trận
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        //  Đảo từng hàng
        for (int i = 0; i < n; i++) {
            for (int j = 0, k = n - 1; j < k; j++, k--) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][k];
                arr[i][k] = temp;
            }
        }
        System.out.println("result = ");
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }

    }
}
