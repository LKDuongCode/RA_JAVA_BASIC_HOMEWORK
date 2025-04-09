package practice_homeworks.business.service.account;

import practice_homeworks.business.dao.account.AccountDAO;
import practice_homeworks.business.dao.account.AccountDAOImpl;
import practice_homeworks.business.model.Account;
import practice_homeworks.business.service.BaseService;

import java.util.List;
import java.util.logging.Logger;

public class AccountServiceImpl implements AccountService {
    private static final Logger logger = Logger.getLogger(AccountServiceImpl.class.getName());
    private final AccountDAO accountDAO = new AccountDAOImpl();

    @Override
    public List<Account> getAll() {
        return accountDAO.findAll();
    }

    @Override
    public Account getById(Integer id) {
        return accountDAO.findById(id);
    }

    @Override
    public boolean create(Account account) {
        try {
            accountDAO.insert(account);
            return true;
        } catch (Exception e) {
            logger.warning("Lỗi tạo tài khoản: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Account account) {
        try {
            accountDAO.update(account);
            return true;
        } catch (Exception e) {
            logger.warning("Lỗi cập nhật tài khoản: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Integer id) {
        try {
            accountDAO.delete(id);
            return true;
        } catch (Exception e) {
            logger.warning("Lỗi xoá tài khoản: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean transferMoney(int senderId, int receiverId, double amount) {
        try {
            int result = accountDAO.transfer(senderId, receiverId, amount);
            return result == 1;
        } catch (Exception e) {
            logger.severe("Lỗi khi chuyển tiền: " + e.getMessage());
            return false;
        }
    }
}
