import java.util.Arrays;
import java.util.Scanner;

public class Hw03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("n = ");
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = new int[n];
        int countEven = 0;

        System.out.println("Nhập các giá trị cho mảng:");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(sc.nextLine());
        }
        System.out.println(Arrays.toString(arr));
        for (int e : arr){
            if (e % 2 == 0){
                countEven++;
            }
        }

        if(countEven == 0){
            System.out.println("không thấy phần tử chẵn trong mảng ");
        }else{
            System.out.println("countEven = "+ countEven);
        }

    }
}
