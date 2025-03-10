import java.util.Scanner;
import java.util.regex.*;

public class Hw08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số lượng số điện thoại: ");
        int n = Integer.parseInt(sc.nextLine());

        String[] phoneNumbers = new String[n];

        System.out.println("Nhập các số điện thoại:");
        for (int i = 0; i < n; i++) {
            System.out.printf("phone %d = ", i);
            phoneNumbers[i] = sc.nextLine();
        }

        for (String phone : phoneNumbers) {
            String cleanedPhone = phone.replaceAll("[-.\\s]", "");

            if (cleanedPhone.matches("^0\\d{9}$")) {
                cleanedPhone = "+84" + cleanedPhone.substring(1);
            } else if (!cleanedPhone.matches("^\\+849\\d{8}$")) {
                System.out.println("Số điện thoại không hợp lệ");
                continue;
            }

            String formattedPhone = cleanedPhone.substring(0, 3) + " " +
                    cleanedPhone.substring(3, 6) + " " +
                    cleanedPhone.substring(6, 9) + " " +
                    cleanedPhone.substring(9);

            System.out.println(formattedPhone);
        }
    }
}
