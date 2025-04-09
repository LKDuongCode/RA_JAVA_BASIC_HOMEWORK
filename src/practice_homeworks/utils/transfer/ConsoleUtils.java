package practice_homeworks.utils.transfer;

import practice_homeworks.business.model.TransferLog;

import java.util.List;

public class ConsoleUtils {
    public static void printTransferMenu (){
        System.out.println("*****************FT MENU***************");
        System.out.println("1. Lịch sử giao dịch");
        System.out.println("2. Thống kê số tiền chuyển trong khoảng từ ngày đến ngày");
        System.out.println("3. Thống kê số tiền nhận theo tài khoản");
        System.out.println("4. Thống kê số giao dịch thành công từ ngày đến ngày");
        System.out.println("5. Thoát");
    }

    public static void printTransferLogList(List<TransferLog> logs) {
        if (logs.isEmpty()) {
            System.out.println("Không có giao dịch nào.");
            return;
        }

        System.out.printf("%-5s | %-10s | %-10s | %-10s | %-20s | %-8s\n", "ID", "Người gửi", "Người nhận", "Số tiền", "Thời gian", "Trạng thái");
        for (TransferLog log : logs) {
            System.out.printf("%-5d | %-10d | %-10d | %-10.2f | %-20s | %-8s\n",
                    log.getId(),
                    log.getSenderId(),
                    log.getReceiverId(),
                    log.getAmount(),
                    log.getCreatedAt(),
                    log.getStatus());
        }
    }
}
