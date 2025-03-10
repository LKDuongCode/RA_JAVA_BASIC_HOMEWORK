import java.util.Scanner;
import java.util.regex.Pattern;

public class Hw03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String email, password;

        while (true) {
            System.out.print("Nhập email: ");
            email = sc.nextLine();

            String emailRegex = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.(com|vn|org|net|edu|gov)$";
            if (Pattern.matches(emailRegex, email)) {
                break;
            } else {
                System.out.println("Email không hợp lệ, vui lòng nhập lại!");
            }
        }

        while (true) {
            System.out.print("Nhập mật khẩu: ");
            password = sc.nextLine();

            String passwordRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%!&*]).{8,}$";
            if (Pattern.matches(passwordRegex, password)) {
                break;
            } else {
                System.out.println("Mật khẩu không hợp lệ, vui lòng nhập lại!");
            }
        }
        
        System.out.println("Email và mật khẩu hợp lệ!");
    }
}
