package practice_homeworks.business.service.transfer;

import practice_homeworks.business.model.TransferLog;

import java.time.LocalDate;
import java.util.List;

public interface TransferLogService {
    List<TransferLog> getAllLogs();
    double getTotalTransferredBetween(LocalDate from, LocalDate to);
    double getTotalReceivedByAccountId(int accountId);
    int countSuccessfulTransfersBetween(LocalDate from, LocalDate to);

}