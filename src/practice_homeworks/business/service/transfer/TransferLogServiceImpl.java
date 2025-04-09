package practice_homeworks.business.service.transfer;

import practice_homeworks.business.dao.transfer.TransferLogDAO;
import practice_homeworks.business.dao.transfer.TransferLogDAOImpl;
import practice_homeworks.business.model.TransferLog;

import java.time.LocalDate;
import java.util.List;

public class TransferLogServiceImpl implements TransferLogService {

    private final TransferLogDAO dao = new TransferLogDAOImpl();

    @Override
    public List<TransferLog> getAllLogs() {
        return dao.findAll();
    }

    @Override
    public double getTotalTransferredBetween(LocalDate from, LocalDate to) {
        return dao.getTotalTransferredBetween(from, to);
    }

    @Override
    public double getTotalReceivedByAccountId(int accountId) {
        return dao.getTotalReceivedByAccountId(accountId);
    }

    @Override
    public int countSuccessfulTransfersBetween(LocalDate from, LocalDate to) {
        return dao.countSuccessfulTransfersBetween(from, to);
    }


}
