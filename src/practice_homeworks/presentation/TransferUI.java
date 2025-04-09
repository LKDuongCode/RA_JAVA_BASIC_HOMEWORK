package practice_homeworks.presentation;

import practice_homeworks.business.model.TransferLog;
import practice_homeworks.business.service.transfer.TransferLogService;
import practice_homeworks.business.service.transfer.TransferLogServiceImpl;
import practice_homeworks.utils.transfer.ConsoleUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class TransferUI {

    public void handle(Scanner sc) {
        boolean back = false;

        while (!back) {
            ConsoleUtils.printTransferMenu();
            System.out.print("Lựa chọn: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    TransferLogService logService = new TransferLogServiceImpl();
                    List<TransferLog> logs = logService.getAllLogs();
                    ConsoleUtils.printTransferLogList(logs);
                    break;

                case 2:
                    TransferLogService transferService = new TransferLogServiceImpl();

                    System.out.print("Nhập ngày bắt đầu (yyyy-MM-dd): ");
                    LocalDate from = LocalDate.parse(sc.nextLine());

                    System.out.print("Nhập ngày kết thúc (yyyy-MM-dd): ");
                    LocalDate to = LocalDate.parse(sc.nextLine());

                    double total = transferService.getTotalTransferredBetween(from, to);
                    System.out.printf("Tổng số tiền đã chuyển từ %s đến %s là: %.2f \n", from, to, total);
                    break;

                case 3:
                    TransferLogService logService3 = new TransferLogServiceImpl();

                    System.out.print("Nhập ID tài khoản muốn tra cứu tiền đã nhận: ");
                    int accId = Integer.parseInt(sc.nextLine());

                    double received = logService3.getTotalReceivedByAccountId(accId);
                    System.out.printf(" Tổng số tiền tài khoản ID %d đã nhận: %.2f\n", accId, received);
                    break;

                case 4:
                    TransferLogService logService4 = new TransferLogServiceImpl();

                    System.out.print("Nhập ngày bắt đầu (yyyy-MM-dd): ");
                    LocalDate fromDate = LocalDate.parse(sc.nextLine());

                    System.out.print("Nhập ngày kết thúc (yyyy-MM-dd): ");
                    LocalDate toDate = LocalDate.parse(sc.nextLine());

                    int count = logService4.countSuccessfulTransfersBetween(fromDate, toDate);
                    System.out.printf("Có tổng cộng %d giao dịch thành công từ %s đến %s\n", count, fromDate, toDate);
                    break;

                case 5:
                    back = true;
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1 đến 5!");
            }
            System.out.println();
        }
    }
}
