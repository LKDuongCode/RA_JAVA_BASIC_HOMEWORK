import java.util.Scanner;

public class hw3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("x = ");
        int x = scanner.nextInt();
        System.out.print("y =");
        int y = scanner.nextInt();

        System.out.println("\n result:");
        System.out.println("x == y  : " + (x == y));
        System.out.println("x != y  : " + (x != y));
        System.out.println("x > y   : " + (x > y));
        System.out.println("x < y   : " + (x < y));
        System.out.println("x >= y  : " + (x >= y));
        System.out.println("x <= y  : " + (x <= y));

        scanner.close();
    }
}
