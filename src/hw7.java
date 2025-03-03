import java.util.Scanner;

public class hw7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập giờ bắt đầu: ");
        int startHour = scanner.nextInt();
        System.out.print("Nhập phút bắt đầu: ");
        int startMinute = scanner.nextInt();
        System.out.print("Nhập giây bắt đầu: ");
        int startSecond = scanner.nextInt();

        System.out.print("Nhập giờ cộng thêm: ");
        int addHour = scanner.nextInt();
        System.out.print("Nhập phút cộng thêm: ");
        int addMinute = scanner.nextInt();
        System.out.print("Nhập giây cộng thêm: ");
        int addSecond = scanner.nextInt();

        int totalStartSeconds = (startHour * 3600) + (startMinute * 60) + startSecond;
        int totalAddSeconds = (addHour * 3600) + (addMinute * 60) + addSecond;

        int totalSeconds = totalStartSeconds + totalAddSeconds;

        int finalHour = totalSeconds / 3600;
        totalSeconds %= 3600;
        int finalMinute = totalSeconds / 60;
        int finalSecond = totalSeconds % 60;

        System.out.printf("Tổng thời gian : %d giờ %d phút %d giây\n", finalHour, finalMinute, finalSecond);

        scanner.close();
    }
}
