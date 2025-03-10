import java.util.Scanner;

public class Hw03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập chuỗi: ");
        String input = sc.nextLine();

        System.out.print("Nhập từ cần tìm: ");
        String word = sc.nextLine();

        int index = input.indexOf(word);

        if (index != -1) {
            System.out.println("Từ \"" + word + "\" xuất hiện tại vị trí " + index + " trong chuỗi.");
        } else {
            System.out.println("Không tìm thấy từ \"" + word + "\" trong chuỗi.");
        }
    }
}
