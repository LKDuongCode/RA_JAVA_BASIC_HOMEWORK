import java.util.Scanner;

public class Hw10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập chuỗi văn bản: ");
        String input = sc.nextLine().trim();

        if (input.isEmpty()) {
            System.out.println("Không có văn bản để xử lý.");
            return;
        }

        // Loại bỏ ký tự đặc biệt
        String cleanedText = input.replaceAll("[^a-zA-Z0-9\\s]", "");

        // chuyển thành chữ thường, xóa khoảng trắng dư thừa
        String normalizedText = cleanedText.toLowerCase().replaceAll("\\s+", " ").trim();

        // chia chuỗi theo ký tự không phải số
        String[] numberArray = input.split("\\D+");

        // loại bỏ phần tử rỗng
        boolean hasNumber = false;
        for (String num : numberArray) {
            if (!num.isEmpty()) {
                hasNumber = true;
                break;
            }
        }

        System.out.println("Chuẩn hóa văn bản: \"" + normalizedText + "\"");
        System.out.print("Danh sách số: ");
        if (hasNumber) {
            System.out.print("[");
            boolean first = true;
            for (String num : numberArray) {
                if (!num.isEmpty()) {
                    if (!first) {
                        System.out.print(", ");
                    }
                    System.out.print("\"" + num + "\"");
                    first = false;
                }
            }
            System.out.println("]");
        } else {
            System.out.println("[]");
        }
    }
}
