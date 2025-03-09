import java.util.Arrays;
import java.util.Scanner;

public class Hw08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Nhập số phần tử của mảng: ");
        int n =  Integer.parseInt(sc.nextLine());

        if (n == 0) {
            System.out.println("Mảng không hợp lệ");
            return;
        }

        int[] originalArray = new int[n];

        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            System.out.printf("arr[%d] = ", i);
            originalArray[i] =  Integer.parseInt(sc.nextLine());
        }

        int[] valueArray = new int[n];
        int[] countArray = new int[n];
        int uniqueSize = 0;

        for (int num : originalArray) {
            boolean found = false;
            for (int i = 0; i < uniqueSize; i++) {
                if (valueArray[i] == num) {
                    countArray[i]++;
                    found = true;
                    break;
                }
            }
            if (!found) {
                valueArray[uniqueSize] = num;
                countArray[uniqueSize] = 1;
                uniqueSize++;
            }
        }

        int[] newArray = new int[n];
        int newSize = 0;

        for (int i = 0; i < uniqueSize; i++) {
            if (countArray[i] == 1) {
                newArray[newSize++] = valueArray[i];
            }
        }

        if (newSize == 0) {
            System.out.println("Không có phần tử nào duy nhất trong mảng");
        } else {
            originalArray = new int[newSize];
            System.arraycopy(newArray, 0, originalArray, 0, newSize);

            System.out.print("Mảng sau khi loại bỏ phần tử trùng lặp: ");
            System.out.println(Arrays.toString(originalArray));
        }
    }
}
