import java.util.Scanner;

public class Hw2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter num1 = ");
        int num1 = Integer.parseInt(sc.nextLine());

        System.out.println("Enter num2 = ");
        int num2 = Integer.parseInt(sc.nextLine());
        System.out.println("Enter num3 = ");
        int num3 = Integer.parseInt(sc.nextLine());

        if(num1 == num2 && num1 == num3){
            System.out.println("Ba số nguyên bằng nhau.");
            return;
        }

        if(num1 > num2 && num1 > num3){
            System.out.printf("Số lớn nhất là %d", num1);
        } else if (num2 > num1 && num2 > num3) {
            System.out.printf("Số lớn nhất là %d", num2);
        } else {
            System.out.printf("Số lớn nhất là %d", num3);
        }
    }
}
