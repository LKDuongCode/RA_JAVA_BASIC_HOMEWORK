import java.util.Scanner;

public class Hw4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập một số nguyên từ 1 đến 7: ");
        int number = scanner.nextInt();

        String nameDay;
        switch (number) {
            case 1:
                nameDay = "Chủ nhật";
                break;
            case 2:
                nameDay = "Thứ hai";
                break;
            case 3:
                nameDay = "Thứ ba";
                break;
            case 4:
                nameDay = "Thứ tư";
                break;
            case 5:
                nameDay = "Thứ năm";
                break;
            case 6:
                nameDay = "Thứ sáu";
                break;
            case 7:
                nameDay = "Thứ bảy";
                break;
            default:
                nameDay = "Số nhập vào không hợp lệ";
                break;
        }

        System.out.println(nameDay);

        scanner.close();
    }
}
