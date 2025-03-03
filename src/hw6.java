import java.util.Scanner;

public class hw6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("-----------Nhập thông tin sinh viên------------");
        System.out.print("Nhập tên sinh viên: ");
        scanner.nextLine();
        String studentName = scanner.nextLine();

        System.out.print("Nhập điểm môn học 1: ");
        float subject1 = scanner.nextFloat();

        System.out.print("Nhập điểm môn học 2: ");
        float subject2 = scanner.nextFloat();

        System.out.print("Nhập điểm môn học 3: ");
        float subject3 = scanner.nextFloat();

        float averageScore = (subject1 + subject2 + subject3) / 3;

        String evaluation = (averageScore >= 5) ? "Lên lớp" : "Học lại";

        System.out.println("\n------------Hiển thị thông tin sinh viên--------------");
        System.out.println("Tên sinh viên : " + studentName);
        System.out.printf("Điểm môn 1 : %.2f | Điểm môn 2 = %.2f | Điểm môn 3 : %.2f%n", subject1, subject2, subject3);
        System.out.printf("Điểm trung bình : %.2f%n", averageScore);
        System.out.println("Đánh giá : " + evaluation);

        scanner.close();
    }
}
