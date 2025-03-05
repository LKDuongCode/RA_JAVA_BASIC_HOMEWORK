import java.util.Scanner;

public class Homework03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap n: ");
        int n = Integer.parseInt(sc.nextLine());

        // kiểm tra n
        if (n < 0){
            System.out.println("Số nhập vào không hợp lệ.");
            System.exit(0);
        }

        System.out.println("Bảng cửu chương:" + n);
        for(int i = 1; i<= 10 ; i++){
            System.out.println(n + " x " + i + " = " + (n*i));
        }
        sc.close();
    }
}
