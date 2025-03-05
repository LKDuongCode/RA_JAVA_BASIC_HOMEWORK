import java.util.Scanner;

public class Homework06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("n = ");
        int n = Integer.parseInt(sc.nextLine());

        //chuyển thành dương
        if(n < 0){
            n = n * (-1);
        }

        int sum = 0;
       // tách
        while (n > 0){
            int temp = n % 10;
            sum += temp;
            n = n / 10;
        }

        System.out.println("Sum = " + sum);
        sc.close();
    }
}
