import java.util.Scanner;

public class Homework01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập n: ");
        int n = Integer.parseInt(sc.nextLine());

        // kiểm tra n dương
        if(n <= 0){
            System.out.println("Số nhập vào không hợp lệ: ");
        }else{
            // tính tổng từ 1 đến n
            int result = 0;
            for (int i = 1; i<=n; i++){
                result += i;
            }

            System.out.println("result = " + result);
        }
        sc.close();
    }
}