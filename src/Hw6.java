import java.util.Scanner;

public class Hw6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập một tháng: ");
        int month = scanner.nextInt();

        String name;
        int totalDay;

        switch (month) {
            case 1:
                name = "Tháng 1";
                totalDay = 31;
                break;
            case 2:
                name = "Tháng 2";
                totalDay = 28;
                break;
            case 3:
                name = "Tháng 3";
                totalDay = 31;
                break;
            case 4:
                name = "Tháng 4";
                totalDay = 30;
                break;
            case 5:
                name = "Tháng 5";
                totalDay = 31;
                break;
            case 6:
                name = "Tháng 6";
                totalDay = 30;
                break;
            case 7:
                name = "Tháng 7";
                totalDay = 31;
                break;
            case 8:
                name = "Tháng 8";
                totalDay = 31;
                break;
            case 9:
                name = "Tháng 9";
                totalDay = 30;
                break;
            case 10:
                name = "Tháng 10";
                totalDay = 31;
                break;
            case 11:
                name = "Tháng 11";
                totalDay = 30;
                break;
            case 12:
                name = "Tháng 12";
                totalDay = 31;
                break;
            default:
                name = "Tháng không hợp lệ";
                totalDay = 0;
                break;
        }


        if (month >= 1 && month <= 12) {
            System.out.println(name + " có " + totalDay + " ngày.");
        } else {
            System.out.println(name);
        }

        scanner.close();
    }
}