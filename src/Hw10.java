import java.util.Scanner;

public class Hw10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("str =  ");
        StringBuilder sb = new StringBuilder(sc.nextLine());
        
        do {
            System.out.println("\n===== MENU QUẢN LÝ CHUỖI =====");
            System.out.println("1. Đảo ngược chuỗi");
            System.out.println("2. Chèn chuỗi vào vị trí bất kỳ");
            System.out.println("3. Xóa một đoạn trong chuỗi");
            System.out.println("4. Thay thế một đoạn trong chuỗi");
            System.out.println("5. Chuyển đổi toàn bộ chuỗi thành chữ hoa/chữ thường");
            System.out.println("6. Thoát chương trình");
            System.out.print("Chọn chức năng (1-6): ");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    sb.reverse();
                    System.out.println("Chuỗi sau khi đảo ngược: " + sb);
                    break;

                case 2:
                    System.out.print("chuỗi cần chèn: ");
                    String insertStr = sc.nextLine();
                    System.out.print("vị trí: ");
                    int insertPos = Integer.parseInt(sc.nextLine());

                    if (insertPos >= 0 && insertPos <= sb.length()) {
                        sb.insert(insertPos, insertStr);
                        System.out.println("Chuỗi sau khi chèn: " + sb);
                    } else {
                        System.out.println("Vị trí không hợp lệ!");
                    }
                    break;

                case 3:
                    System.out.print("start = ");
                    int startDel = Integer.parseInt(sc.nextLine());
                    System.out.print("end = ");
                    int endDel = Integer.parseInt(sc.nextLine());

                    if (startDel >= 0 && endDel <= sb.length() && startDel < endDel) {
                        sb.delete(startDel, endDel);
                        System.out.println("Chuỗi sau khi xóa: " + sb);
                    } else {
                        System.out.println("Vị trí không hợp lệ!");
                    }
                    break;

                case 4:
                    System.out.print("start = ");
                    int startReplace = Integer.parseInt(sc.nextLine());
                    System.out.print("end = ");
                    int endReplace = Integer.parseInt(sc.nextLine());
                    System.out.print("chuỗi thay thế: ");
                    String replaceStr = sc.nextLine();

                    if (startReplace >= 0 && endReplace <= sb.length() && startReplace < endReplace) {
                        sb.replace(startReplace, endReplace, replaceStr);
                        System.out.println("Chuỗi sau khi thay thế: " + sb);
                    } else {
                        System.out.println("Vị trí không hợp lệ!");
                    }
                    break;

                case 5:
                    System.out.println("1 - Chuyển thành chữ HOA");
                    System.out.println("2 - Chuyển thành chữ thường");
                    int convertChoice = Integer.parseInt(sc.nextLine());

                    if (convertChoice == 1) {
                        sb = new StringBuilder(sb.toString().toUpperCase());
                        System.out.println("Chuỗi sau khi chuyển thành chữ HOA: " + sb);
                    } else if (convertChoice == 2) {
                        sb = new StringBuilder(sb.toString().toLowerCase());
                        System.out.println("Chuỗi sau khi chuyển thành chữ thường: " + sb);
                    } else {
                        System.out.println("Lựa chọn không hợp lệ!");
                    }
                    break;

                case 6:
                    System.out.println("Thoát chương trình.");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (true);
    }
}
