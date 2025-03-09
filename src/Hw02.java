import java.util.Arrays;
import java.util.Scanner;

public class Hw02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // nhập size mảng và nhập giá trị
        System.out.println("nhập size: ");
        int size = Integer.parseInt(sc.nextLine());
        int[] arr = new int[size];
        for(int i = 0; i< size; i++){
            System.out.printf("arr[%d] = ", i);
            arr[i] = Integer.parseInt(sc.nextLine());
        }

        System.out.println(Arrays.toString(arr));
        // tạo biến lưu trứ sum
        int sum = 0;

        // duyệt mảng và cộng dồn vào sum
        for(int e : arr){
            sum += e;
        }

        System.out.println("sum = " + sum);
    }
}
