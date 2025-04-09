package practice_homeworks.business.service.account;

import practice_homeworks.business.model.Account;
import practice_homeworks.business.service.BaseService;

public interface AccountService extends BaseService<Account, Integer> {
    boolean transferMoney(int senderId, int receiverId, double amount);
}
