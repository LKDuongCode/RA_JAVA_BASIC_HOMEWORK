import java.util.Scanner;

public class Hw03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("str = ");
        String str = sc.nextLine();
        System.out.println("original = " + str);

        // đao ngược chuỗi
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        System.out.println("reverse = " + sb);
        sc.close();
    }
}
