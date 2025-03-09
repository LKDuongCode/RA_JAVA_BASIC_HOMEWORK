import java.util.Arrays;
import java.util.Scanner;

public class Hw07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("n = ");
        int n = Integer.parseInt(sc.nextLine());
        
        if (n == 0) {
            System.out.println("Mảng không có phần tử");
            return;
        }

        int[] originalArray = new int[n];
        int[] evenArray = new int[n];
        int[] oddArray = new int[n];
        int evenCount = 0, oddCount = 0;

        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            originalArray[i] = Integer.parseInt(sc.nextLine());
            if (originalArray[i] % 2 == 0) {
                evenArray[evenCount++] = originalArray[i];
            } else {
                oddArray[oddCount++] = originalArray[i];
            }
        }

        int index = 0;
        for (int i = 0; i < evenCount; i++) {
            originalArray[index++] = evenArray[i];
        }
        for (int i = 0; i < oddCount; i++) {
            originalArray[index++] = oddArray[i];
        }

        System.out.println(Arrays.toString(oddArray));
    }
}
