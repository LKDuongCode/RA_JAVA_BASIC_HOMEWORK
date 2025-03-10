import java.util.Scanner;
import java.util.regex.*;

public class Hw07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số lượng email: ");
        int n = Integer.parseInt(sc.nextLine());

        String[] emails = new String[n];

        System.out.println("Nhập danh sách email:");
        for (int i = 0; i < n; i++) {
            System.out.printf("emails[%d] = ", i);
            emails[i] = sc.nextLine();
        }

        String emailRegex = "^([a-zA-Z0-9._]+)@([a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6})$";
        Pattern pattern = Pattern.compile(emailRegex);

        for (String email : emails) {
            Matcher matcher = pattern.matcher(email);

            if (matcher.matches()) {
                String username = matcher.group(1);
                String domain = matcher.group(2);


                System.out.println("Tên người dùng: " + username + ", Tên miền: " + domain);
            } else {
                System.out.println("Email không hợp lệ: " + email);
            }
        }
    }
}
