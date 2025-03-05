import java.util.Scanner;

public class Homework04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sumNum = 0;
        int n = 1;

        while (n != 0){
            System.out.println("Nhập thêm: ");
            n = Integer.parseInt(sc.nextLine());
            sumNum += n;
        }

        System.out.println("Sum = " + sumNum);
        sc.close();
    }
}
