import java.util.Scanner;

public class Hw05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("str = ");
        String str = sc.nextLine();

        // loại bỏ khoảng trắng thừa
        str = str.trim();

        // tách thành từng từ và đảo ngược từng từ
        String[] strArr = str.split("\\s+");


        // nối lại và cách nhau một khoảng trắng
        StringBuilder result = new StringBuilder();
        for (int i = strArr.length - 1; i >= 0; i--) {
            result.append(strArr[i]).append(" ");
        }

        System.out.println("result = " + result);
    }
}
