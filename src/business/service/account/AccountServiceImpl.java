package business.service.account;


import business.dao.account.AccountDAO;
import business.dao.account.AccountDAOImpl;
import business.model.account.Account;

public class AccountServiceImpl implements AccountService{
    private AccountDAO accountDAO = new AccountDAOImpl();

    @Override
    public boolean login(String username, String password) {
        if(accountDAO.login(username,password).isEmpty()){
            return false;
        }

        return true;
    }


}
