import java.util.Scanner;

public class Homework08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("n = ");
        int n = Integer.parseInt(sc.nextLine());

        if(n <= 0){
            System.out.println("không hợp lệ");
            System.exit(0);
        }


        System.out.print("Các số Armstrong từ 1 đến " + n + " là: ");

        // Duyệt từ 1 đến N
        for (int i = 1; i <= n; i++) {
            int temp = i, sum = 0, numDigits = 0;

            // Tính số chữ số của i
            int tempDigits = temp;
            while (tempDigits > 0) {
                numDigits++;
                tempDigits /= 10;
            }

            // Tính tổng lũy thừa bậc k của từng chữ số
            temp = i;
            while (temp > 0) {
                int digit = temp % 10;
                sum += Math.pow(digit, numDigits);
                temp /= 10;
            }

            if (sum == i) {
                System.out.print(i + " ");
            }
        }

        System.out.println();
        sc.close();
    }
}
