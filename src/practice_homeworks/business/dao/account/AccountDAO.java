package practice_homeworks.business.dao.account;

import practice_homeworks.business.dao.BaseDAO;
import practice_homeworks.business.model.Account;

public interface AccountDAO extends BaseDAO<Account,Integer> {
    int transfer (int sendId, int receiveId, double amount);
}
