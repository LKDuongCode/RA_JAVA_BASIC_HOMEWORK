import java.util.Arrays;
import java.util.Scanner;

public class Hw04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("n = ");
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = new int[n];

        if (arr.length == 0){
            System.out.println("kích thước rỗng");
        }else {
            // nhập giá trị
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(sc.nextLine());
            }
            System.out.println(Arrays.toString(arr));
            //đảo ngược mảng
            for (int i = 0, j = n - 1; i < j; i++, j--) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            System.out.println(Arrays.toString(arr));

        }
    }
}
