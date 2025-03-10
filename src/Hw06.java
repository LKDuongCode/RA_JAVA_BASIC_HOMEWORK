import java.util.Scanner;

public class Hw06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("===== MENU CHÍNH =====");
            System.out.println("1. Xử lý chuỗi");
            System.out.println("2. Xử lý mảng số nguyên");
            System.out.println("3. Thoát chương trình");
            System.out.print("Chọn chức năng (1-3): ");

            choice = Integer.parseInt(sc.nextLine());

            if (choice == 1) {
                String str = "";
                int subChoice;
                do {
                    System.out.println("\n===== MENU XỬ LÝ CHUỖI =====");
                    System.out.println("1. Nhập chuỗi");
                    System.out.println("2. Loại bỏ khoảng trắng thừa trong chuỗi");
                    System.out.println("3. Đếm số lần xuất hiện của từng ký tự");
                    System.out.println("4. Chuyển đổi chuỗi thành dạng chuẩn (viết hoa chữ cái đầu mỗi từ)");
                    System.out.println("5. Quay lại menu chính");
                    System.out.print("Chọn chức năng (1-5): ");

                    subChoice = Integer.parseInt(sc.nextLine());

                    if (subChoice == 1) {
                        System.out.print("Nhập chuỗi: ");
                        str = sc.nextLine();
                    } else if (subChoice == 2) {
                        System.out.println("Chuỗi sau khi loại bỏ khoảng trắng: " + str.replaceAll("\\s+", " ").trim());
                    } else if (subChoice == 3) {
                        int[] mark = new int[256]; 

                        for (char c : str.toCharArray()) {
                            mark[c]++; 
                        }

                        System.out.println("Số lần xuất hiện của từng ký tự:");
                        for (int i = 0; i < 256; i++) {
                            if (mark[i] > 0) {
                                System.out.println("'" + (char) i + "' xuất hiện " + mark[i] + " lần");
                            }
                        }
                    } else if (subChoice == 4) {
                        String[] words = str.toLowerCase().trim().split("\\s+");
                        String result = "";
                        for (String word : words) {
                            result += Character.toUpperCase(word.charAt(0)) + word.substring(1) + " ";
                        }
                        System.out.println("Chuỗi chuẩn hóa: " + result.trim());
                    } else if (subChoice != 5) {
                        System.out.println("Lựa chọn không hợp lệ!");
                    }
                } while (subChoice != 5);

            } else if (choice == 2) {
                int[] arr = {};
                int subChoice;
                do {
                    System.out.println("\n===== MENU XỬ LÝ MẢNG SỐ NGUYÊN =====");
                    System.out.println("1. Nhập mảng số nguyên");
                    System.out.println("2. Tìm số nguyên tố lớn nhất trong mảng");
                    System.out.println("3. Đếm số phần tử có chữ số đầu tiên là số lẻ");
                    System.out.println("4. Kiểm tra mảng có phải là mảng đối xứng không");
                    System.out.println("5. Quay lại menu chính");
                    System.out.print("Chọn chức năng (1-5): ");

                    subChoice = Integer.parseInt(sc.nextLine());

                    if (subChoice == 1) {
                        System.out.print("Nhập số lượng phần tử: ");
                        int n = Integer.parseInt(sc.nextLine());
                        arr = new int[n];
                        System.out.println("Nhập các phần tử của mảng:");
                        for (int i = 0; i < n; i++) {
                            arr[i] = Integer.parseInt(sc.nextLine());
                        }
                    } else if (subChoice == 2) {
                        int maxPrime = -1;
                        for (int num : arr) {
                            if (num >= 2) {
                                boolean isPrime = true;
                                for (int i = 2; i * i <= num; i++) {
                                    if (num % i == 0) {
                                        isPrime = false;
                                        break;
                                    }
                                }
                                if (isPrime && num > maxPrime) {
                                    maxPrime = num;
                                }
                            }
                        }
                        System.out.println("Số nguyên tố lớn nhất: " + maxPrime);
                    } else if (subChoice == 3) {
                        int count = 0;
                        for (int num : arr) {
                            if (String.valueOf(num).charAt(0) % 2 != 0) {
                                count++;
                            }
                        }
                        System.out.println("Số phần tử có chữ số đầu là số lẻ: " + count);
                    } else if (subChoice == 4) {
                        boolean isSymmetric = true;
                        for (int i = 0; i < arr.length / 2; i++) {
                            if (arr[i] != arr[arr.length - 1 - i]) {
                                isSymmetric = false;
                                break;
                            }
                        }
                        System.out.println(isSymmetric ? "Mảng đối xứng" : "Mảng không đối xứng");
                    } else if (subChoice != 5) {
                        System.out.println("Lựa chọn không hợp lệ!");
                    }
                } while (subChoice != 5);

            } else if (choice != 3) {
                System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập từ 1 đến 3.");
            }

        } while (choice != 3);

        System.out.println("Đã thoát chương trình.");
    }
}
