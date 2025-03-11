import java.util.Scanner;

public class Hw01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào 3 chuỗi.");
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        String str3 = sc.nextLine();

        // nối chuỗi
        StringBuilder sb = new StringBuilder();
        sb.append(str1).append(" ").append(str2).append(" ").append(str3);

        // chuyển thành chuỗi tường và chuyển thành chữ in hoa
        String result = sb.toString();
        result = result.toUpperCase();
        System.out.println(result);

        sc.close();
    }
}
