import java.util.Scanner;

public class Homework09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("n = ");
        int n = Integer.parseInt(sc.nextLine());

        if(n <= 0){
            System.out.println("không hợp lệ");
            System.exit(0);
        }

        System.out.print("Các số Palindrome là: ");

        // Duyệt từ 1 đến N
        for (int i = 1; i <= n; i++) {
            int original = i, reversed = 0, temp = i;

            // Đảo ngược số
            while (temp > 0) {
                int digit = temp % 10;
                reversed = reversed * 10 + digit;
                temp /= 10;
            }

            if (original == reversed) {
                System.out.print(i + " ");
            }
        }

        System.out.println();
        sc.close();
    }
}
