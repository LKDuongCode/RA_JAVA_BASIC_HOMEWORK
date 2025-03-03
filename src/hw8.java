import java.util.Scanner;

public class hw8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("-----------Nhập thông tin sinh viên------------");
        System.out.print("Nhập mã sinh viên: ");
        String studentID = scanner.nextLine();
        System.out.print("Nhập tên sinh viên: ");
        String studentName = scanner.nextLine();
        System.out.print("Nhập số điện thoại sinh viên: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Nhập ngày sinh sinh viên (dd/mm/yyyy): ");
        String birthDate = scanner.nextLine();
        System.out.print("Nhập giới tính sinh viên (1: Nam, 0: Nữ): ");
        int genderInput = scanner.nextInt();
        String gender = (genderInput == 1) ? "Nam" : "Nữ";


        System.out.println("\n-----------Nhập điểm sinh viên------------");
        System.out.print("Nhập điểm Toán: ");
        float math = scanner.nextFloat();
        System.out.print("Nhập điểm Lý: ");
        float physics = scanner.nextFloat();
        System.out.print("Nhập điểm Hóa: ");
        float chemistry = scanner.nextFloat();
        System.out.print("Nhập điểm Sinh học: ");
        float biology = scanner.nextFloat();
        System.out.print("Nhập điểm Ngoại ngữ: ");
        float foreignLanguage = scanner.nextFloat();

        float averageScore = (math + physics + chemistry + biology + foreignLanguage) / 5;

        System.out.println("\n------------Hiển thị thông tin sinh viên------------");
        System.out.printf("Mã sinh viên : %s | Tên sinh viên : %s | Giới tính : %s%n", studentID, studentName, gender);
        System.out.printf("Ngày sinh : %s | Số điện thoại : %s%n", birthDate, phoneNumber);
        System.out.printf("Điểm Toán : %.2f | Điểm Vật lý = %.2f | Điểm Hóa học : %.2f | Điểm Sinh học : %.2f | Điểm Ngoại ngữ : %.2f%n", math, physics, chemistry, biology, foreignLanguage);
        System.out.printf("Điểm trung bình : %.2f%n", averageScore);

        scanner.close();
    }
}
