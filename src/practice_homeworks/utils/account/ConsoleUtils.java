package practice_homeworks.utils.account;

import practice_homeworks.business.model.Account;
import practice_homeworks.business.model.enums.AccountStatus;

import java.util.List;
import java.util.Scanner;

public class ConsoleUtils {
    public static void printAccountMenu (){
        System.out.println("***************ACCOUNT MENU**************");
        System.out.println("1. Danh sách tài khoản");
        System.out.println("2. Tạo tài khoản");
        System.out.println("3. Cập nhật tài khoản");
        System.out.println("4. Xóa tài khoản");
        System.out.println("5. Chuyển khoản");
        System.out.println("6. Tra cứu số dư tài khoản");
        System.out.println("7. Thoát");
        System.out.print("Lựa chọn của bạn: ");
    }

    public static void printAccountList(List<Account> accounts) {
        if (accounts == null || accounts.isEmpty()) {
            System.out.println("Không có tài khoản nào.");
            return;
        }

        System.out.printf("%-5s | %-20s | %-10s | %-10s\n", "ID", "Tên", "Số dư", "Trạng thái");

        for (Account acc : accounts) {
            System.out.printf("%-5d | %-20s | %-10.2f | %-10s\n",
                    acc.getId(), acc.getName(), acc.getBalance(), acc.getStatus());
        }
    }

    public static Account inputAccount(Scanner sc) {
        String name;
        double balance;
        AccountStatus status = null;

        System.out.print("Nhập tên tài khoản: ");
        name = sc.nextLine();

        while (true) {
            System.out.print("Nhập số dư: ");
            try {
                balance = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Số dư không hợp lệ");
            }
        }

        while (status == null) {
            System.out.print("Nhập trạng thái (ACTIVE, INACTIVE, BLOCKED): ");
            String input = sc.nextLine().toUpperCase();
            try {
                status = AccountStatus.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.err.println("Trạng thái không hợp lệ");
            }
        }

        return new Account(name, balance, status);

    }

    public static Account inputAccountToUpdate(Scanner sc) {
        System.out.print("Nhập ID tài khoản cần cập nhật: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Nhập tên mới: ");
        String name = sc.nextLine();

        System.out.print("Nhập trạng thái mới (ACTIVE, INACTIVE, BLOCKED): ");
        String statusStr = sc.nextLine().toUpperCase();
        AccountStatus status = AccountStatus.valueOf(statusStr);

        return new Account(id, name, 0, status);
    }

}
