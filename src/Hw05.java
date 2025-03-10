import java.util.Scanner;
import java.util.regex.*;

public class Hw05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập chuỗi văn bản: ");
        String input = sc.nextLine();

        String[] words = input.split("\\s+");

        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");

        int count = 0;
        String specialWords = "";

        for (String word : words) {
            Matcher matcher = pattern.matcher(word);
            if (matcher.find()) {
                count++;
                specialWords += word + " ";
            }
        }

        System.out.println("Số lượng từ chứa ký tự đặc biệt: " + count);
        System.out.println("Các từ chứa ký tự đặc biệt: " + (count > 0 ? specialWords.trim() : "Không có từ nào"));
    }
}
