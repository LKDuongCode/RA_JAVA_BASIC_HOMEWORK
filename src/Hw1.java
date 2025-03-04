import java.util.Scanner;

public class Hw1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number : ");
        int num = Integer.parseInt(sc.nextLine());

        if (num == 0) {
            System.out.println("Số không phải chẵn cũng không phải lẻ \n");
        }else if (num % 2 == 0) {
            System.out.printf("Số %d là số chẵn ", num);
        } else if (num != 0) {
            System.out.printf("Số %d là số lẻ", num);
        }
    }
}
