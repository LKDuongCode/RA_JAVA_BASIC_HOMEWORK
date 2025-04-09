package practice_homeworks.presentation;

import practice_homeworks.business.model.Account;
import practice_homeworks.business.model.enums.AccountStatus;
import practice_homeworks.business.service.account.AccountService;
import practice_homeworks.business.service.account.AccountServiceImpl;
import practice_homeworks.utils.account.ConsoleUtils;

import java.util.List;
import java.util.Scanner;

public class AccountUI {

    private final AccountService accountService = new AccountServiceImpl();

    public void handle(Scanner sc) {
        boolean back = false;

        while (!back) {
            ConsoleUtils.printAccountMenu();
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    List<Account> list = accountService.getAll();
                    ConsoleUtils.printAccountList(list);
                    break;
                case 2:
                    Account newAcc = ConsoleUtils.inputAccount(sc);
                    boolean created = accountService.create(newAcc);

                    if (created) {
                        System.out.println("Tạo tài khoản thành công!");
                    } else {
                        System.err.println("Tạo tài khoản thất bại!");
                    }
                    break;
                case 3:
                    Account toUpdate = ConsoleUtils.inputAccountToUpdate(sc);
                    Account current = accountService.getById(toUpdate.getId());

                    if (current == null) {
                        System.err.println(" Không tìm thấy tài khoản có ID " + toUpdate.getId());
                        break;
                    }

                    toUpdate.setBalance(current.getBalance());

                    boolean updated = accountService.update(toUpdate);
                    if (updated) {
                        System.out.println(" Cập nhật tài khoản thành công!");
                    } else {
                        System.err.println("Cập nhật thất bại!");
                    }
                    break;
                case 4:
                    System.out.print("Nhập ID tài khoản cần xoá: ");
                    int deleteId = Integer.parseInt(sc.nextLine());

                    Account acc = accountService.getById(deleteId);
                    if (acc == null) {
                        System.err.println("Không tìm thấy tài khoản với ID " + deleteId);
                        break;
                    }

                    acc.setStatus(AccountStatus.INACTIVE);
                    boolean deleted = accountService.update(acc);

                    if (deleted) {
                        System.out.println("Đã xoá tài khoản (chuyển sang trạng thái INACTIVE)");
                    } else {
                        System.err.println("Xoá tài khoản thất bại!");
                    }
                    break;
                case 5:
                    System.out.print("Nhập ID người gửi: ");
                    int senderId = Integer.parseInt(sc.nextLine());

                    System.out.print("Nhập ID người nhận: ");
                    int receiverId = Integer.parseInt(sc.nextLine());

                    System.out.print("Nhập số tiền cần chuyển: ");
                    double amount = Double.parseDouble(sc.nextLine());

                    boolean success = accountService.transferMoney(senderId, receiverId, amount);

                    if (success) {
                        System.out.println("Chuyển khoản thành công!");
                    } else {
                        System.err.println(" Chuyển khoản thất bại. Kiểm tra lại tài khoản hoặc số dư.");
                    }
                    break;
                case 6:
                    System.out.print("Nhập ID tài khoản cần tra cứu: ");
                    int accId = Integer.parseInt(sc.nextLine());

                    Account a = accountService.getById(accId);
                    if (a == null) {
                        System.err.println(" Không tìm thấy tài khoản có ID: " + accId);
                    } else {
                        System.out.println(" Thông tin tài khoản:");
                        System.out.printf(" Tên: %s\n", a.getName());
                        System.out.printf(" Số dư: %.2f\n", a.getBalance());
                        System.out.printf(" Trạng thái: %s\n", a.getStatus());
                    }
                    break;

                case 7:
                    back = true;
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1 đến 7!");
            }

            System.out.println();
        }
    }
}
