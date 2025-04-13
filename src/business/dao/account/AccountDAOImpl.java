package business.dao.account;

import business.config.DatabaseConnection;
import business.model.account.Account;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Optional;

public class AccountDAOImpl implements AccountDAO{

    @Override
    public Optional<Account> login(String username, String password) {
        try (
                Connection c = DatabaseConnection.connectToDB();
                CallableStatement cs = c.prepareCall("{call login_account(?,?)}");
                ) {

            cs.setString(1, username);
            cs.setString(2, password);

            try (ResultSet rs = cs.executeQuery()) {
                if (rs.next()) {
                    Account a = new Account();
                    a.setUsername(rs.getString("username"));
                    a.setPassword(rs.getString("password"));
                    a.setStatus(rs.getBoolean("status"));
                    return Optional.of(a);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return Optional.empty();
    }
}
