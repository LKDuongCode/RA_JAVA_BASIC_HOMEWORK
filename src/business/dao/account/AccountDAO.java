package business.dao.account;

import business.dao.BaseDAO;
import business.model.account.Account;

import java.util.Optional;

public interface AccountDAO{
    Optional<Account> login (String username, String password);
}
