import java.time.LocalDate;
import java.util.Scanner;

public class hw9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập ngày (yyyy-MM-dd): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());

        LocalDate nextDay = date.plusDays(1);
        System.out.println("\nNgày tiếp theo: " + nextDay);


        System.out.print("\nNhập ngày thứ hai (yyyy-MM-dd): ");
        LocalDate secondDate = LocalDate.parse(scanner.nextLine());

        long daysBetween = Math.abs(secondDate.toEpochDay() - date.toEpochDay());
        System.out.println("Số ngày giữa hai ngày: " + daysBetween);

        scanner.close();
    }
}
