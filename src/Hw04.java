import java.util.Scanner;

public class Hw04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("str = ");
        String str = sc.nextLine();

        // chuyển thành thường
        str = str.toLowerCase();

        // đảo ngược
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();

        // so sánh kiểm tra đối xứng
        if (str.contentEquals(sb)){
            System.out.println("Chuỗi đối xứng");
        }else{
            System.out.println("khoong đối xứng");
        }
        sc.close();
    }
}
