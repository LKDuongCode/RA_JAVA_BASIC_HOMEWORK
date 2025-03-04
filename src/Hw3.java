import java.util.Scanner;

public class Hw3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập điểm trung bình của sinh viên (0.0 đến 10.0): ");
        double diemTrungBinh = scanner.nextDouble();

        if (diemTrungBinh < 0 || diemTrungBinh > 10) {
            System.out.println("Điểm không hợp lệ.");
        } else {
            String xepLoai;
            if (diemTrungBinh >= 8.5) {
                xepLoai = "Giỏi";
            } else if (diemTrungBinh >= 6.5) {
                xepLoai = "Khá";
            } else if (diemTrungBinh >= 5.0) {
                xepLoai = "Trung bình";
            } else {
                xepLoai = "Yếu";
            }

            System.out.println("Xếp loại: " + xepLoai);
        }

        scanner.close();
    }
}
