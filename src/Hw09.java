import java.util.Scanner;
import java.util.regex.*;

public class Hw09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập URL: ");
        String url = sc.nextLine().trim();

        String regex = "^(https?)://([^/]+)(/.*)?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);

        if (matcher.matches()) {
            String protocol = matcher.group(1);
            String domain = matcher.group(2);
            String path = matcher.group(3);

            System.out.print("Giao thức: " + protocol + ", Tên miền: " + domain + ", ");
            if (path != null) {
                System.out.println("Đường dẫn: " + path);
            } else {
                System.out.println("Đường dẫn: Không có đường dẫn.");
            }
        } else {
            System.out.println("URL không hợp lệ.");
        }
    }
}
