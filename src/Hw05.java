import java.util.Arrays;
import java.util.Scanner;

public class Hw05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice, n = 0;
        int[] arr = {};

        do {
            System.out.println("\n******************** MENU ********************");
            System.out.println("1. Nhập giá trị `n` phần tử của mảng");
            System.out.println("2. In giá trị các phần tử trong mảng");
            System.out.println("3. Tính trung bình các phần tử dương");
            System.out.println("4. In ra vị trí các phần tử có giá trị bằng `k`");
            System.out.println("5. Tính số lượng số nguyên tố trong mảng");
            System.out.println("6. Thoát chương trình");
            System.out.print("Chọn chức năng (1-6): ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập số phần tử của mảng (n): ");
                    n = Integer.parseInt(sc.nextLine());
                    arr = new int[n];

                    System.out.println("Nhập các phần tử của mảng:");
                    for (int i = 0; i < n; i++) {
                        arr[i] = Integer.parseInt(sc.nextLine());
                    }
                    break;

                case 2:
                    System.out.println(Arrays.toString(arr));
                    break;

                case 3:
                    int sum = 0, count = 0;
                    for (int num : arr) {
                        if (num > 0) {
                            sum += num;
                            count++;
                        }
                    }
                    if (count > 0) {
                        System.out.println("Trung bình các phần tử dương: " + (double) sum / count);
                    } else {
                        System.out.println("Không có phần tử dương trong mảng.");
                    }
                    break;

                case 4:
                    System.out.print("Nhập giá trị `k` cần tìm: ");
                    int k = Integer.parseInt(sc.nextLine());
                    System.out.print("Vị trí của `k` trong mảng: ");
                    boolean found = false;
                    for (int i = 0; i < arr.length; i++) {
                        if (arr[i] == k) {
                            System.out.print(i + " ");
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.print("Không tìm thấy `k` trong mảng.");
                    }
                    System.out.println();
                    break;

                case 5:
                    int primeCount = 0;

                    for (int num : arr) {
                        if (num >= 2) {
                            boolean isPrime = true;

                            for (int i = 2; i * i <= num; i++) {
                                if (num % i == 0) {
                                    isPrime = false;
                                    break;
                                }
                            }

                            if (isPrime) {
                                primeCount++;
                            }
                        }
                    }

                    System.out.println("Số lượng số nguyên tố trong mảng: " + primeCount);
                    break;

                case 6:
                    System.out.println("Đã thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập từ 1 đến 6.");
            }
        } while (choice != 6);
    }}
