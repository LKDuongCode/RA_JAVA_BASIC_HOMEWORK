package homeworks_28_3_exceptions;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Supplier;

public class Hw02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("nhập số phần tử:");
            int n = Integer.parseInt(sc.nextLine());

            int[] numbers = new int[n];
            generateNum(numbers);
            System.out.println(Arrays.toString(numbers));
            System.out.println("nhập chỉ số muốn truy cập");
            int idx = Integer.parseInt(sc.nextLine());

            System.out.println("arr[" + idx + "] = " +   numbers[idx]);
        } catch (NumberFormatException e) {
            System.out.println("dữ liệu không hợp lệ");
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("chỉ số nhập vào không hợp lệ");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    static public void generateNum (int[] numbers){
        Supplier<Integer> supplier = ()-> (int) (Math.random() * 100) ;
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = supplier.get();
        }
    }
}
