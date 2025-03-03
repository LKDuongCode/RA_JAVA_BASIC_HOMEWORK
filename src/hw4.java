import java.util.Scanner;

public class hw4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập giá trị a: ");
        boolean a = scanner.nextBoolean();
        System.out.print("Nhập giá trị b: ");
        boolean b = scanner.nextBoolean();
        System.out.print("Nhập giá trị c: ");
        boolean c = scanner.nextBoolean();

        boolean condition1 = a && b;
        boolean condition2 = a || b;
        boolean condition3 = !c;

        System.out.println("\nGiá trị c: " + c);
        c = !c;
        System.out.println("đảo ngược c: " + c);

        System.out.println(condition1 ? "Cả hai giá trị a và b đều đúng." : "Hoặc a sai hoặc b sai.");
        System.out.println(condition2 ? "Trong a và b có ít nhất 1 giá trị đúng." : "Cả 2 giá trị a và b đều sai.");
        System.out.println(condition3 ? "Phủ định của c là đúng." : "Phủ định của c là sai.");

        scanner.close();
    }
}
