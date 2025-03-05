import java.util.Scanner;

public class Homework10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMENU:");
            System.out.println("1. Kiểm tra số nguyên tố");
            System.out.println("2. Kiểm tra số hoàn hảo");
            System.out.println("3. Tìm và tính tổng tất cả các ước của một số");
            System.out.println("4. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");

            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Nhập số cần kiểm tra số nguyên tố: ");
                    int n = Integer.parseInt(sc.nextLine());

                    // Kiểm tra số nhập vào
                    if (n < 2) {
                        System.out.println(n + " không phải số nguyên tố.");
                    } else {
                        // Đặt flag
                        boolean checkingNumber = true;
                        for (int i = 2; i <= Math.sqrt(n); i++) {
                            if (n % i == 0) {
                                checkingNumber = false;
                                break;
                            }
                        }

                        if (checkingNumber) {
                            System.out.println(n + " là số nguyên tố.");
                        } else {
                            System.out.println(n + " không phải số nguyên tố.");
                        }
                    }
                    break;

                case 2:
                    System.out.print("Nhập số cần kiểm tra số hoàn hảo: ");
                    int n2 = Integer.parseInt(sc.nextLine());
                    int sum = 0;

                    for (int i = 1; i <= n2 / 2; i++) {
                        if (n2 % i == 0) {
                            sum += i;
                        }
                    }

                    if (sum == n2) {
                        System.out.println(n2 + " là số hoàn hảo.");
                    } else {
                        System.out.println(n2 + " không phải số hoàn hảo.");
                    }
                    break;

                case 3:
                    System.out.print("Nhập số cần tìm các ước và tính tổng: ");
                    int n3 = Integer.parseInt(sc.nextLine());
                    int sum3 = 0;

                    System.out.print("Các ước của " + n3 + " là: ");
                    for (int i = 1; i <= n3; i++) {
                        if (n3 % i == 0) {
                            System.out.print(i + " ");
                            sum3 += i;
                        }
                    }

                    System.out.println("\nTổng các ước của " + n3 + " là: " + sum3);
                    break;

                case 4:
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Không hợp lệ. Vui lòng nhập lại.");
                    break;
            }

        } while (choice != 4);

        sc.close();
    }
}
