package practice_homeworks.business.dao.account;

import practice_homeworks.business.config.DatabaseConnection;
import practice_homeworks.business.model.Account;
import practice_homeworks.business.model.enums.AccountStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class AccountDAOImpl implements AccountDAO{
    private static final Logger logger = Logger.getLogger(AccountDAOImpl.class.getName());
    @Override
    public List<Account> findAll() {
        List<Account> accs = new ArrayList<>();


        try (Connection c = DatabaseConnection.connectToDatabase()){
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from account");

            while(rs.next()){
                Account a = new Account();
                a.setId(rs.getInt("id"));
                a.setName(rs.getString("name"));
                a.setBalance(rs.getDouble("balance"));
                a.setStatus(AccountStatus.valueOf(rs.getString("status").toUpperCase()));

                accs.add(a);
            }
        }
        catch (SQLException e){
            logger.warning(e.getMessage());
        }
        catch (Exception e){
            logger.severe("Lỗi bất định " + e.getMessage());
        }

        return accs;
    }

    @Override
    public void insert(Account element) {

    }

    @Override
    public Account findById(Integer integer) {
        return null;
    }

    @Override
    public void update(Account element) {

    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public int transfer(int sendId, int receiveId, double amount) {
        String selectSQL = "SELECT * FROM Account WHERE id = ?";
        String updateSQL = "UPDATE Account SET balance = ? WHERE id = ?";
        String logSQL = "INSERT INTO Transfer_log(send_id, receive_id, amount, status) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connectToDatabase()) {
            conn.setAutoCommit(false);

            Account sender = getAccountById(conn, sendId);
            Account receiver = getAccountById(conn, receiveId);

            if (sender == null || receiver == null) {
                conn.rollback();
                return 0;
            }

            if (!sender.getStatus().equals(AccountStatus.ACTIVE) || sender.getBalance() < amount) {
                logTransfer(conn, sendId, receiveId, amount, "failed");
                conn.rollback();
                return -1;
            }

            updateBalance(conn, sendId, sender.getBalance() - amount);
            updateBalance(conn, receiveId, receiver.getBalance() + amount);

            logTransfer(conn, sendId, receiveId, amount, "success");

            conn.commit();
            return 1;

        }
        catch (SQLException e){
            logger.warning(e.getMessage());
        }
        catch (Exception e) {
            logger.severe(e.getMessage());
        }

        return -2;
    }

    private Account getAccountById(Connection conn, int id) throws SQLException {
        String sql = "SELECT * FROM Account WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Account(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("balance"),
                        AccountStatus.valueOf(rs.getString("status").toUpperCase())
                );
            }
        }
        return null;
    }

    private void updateBalance(Connection conn, int id, double balance) throws SQLException {
        String sql = "UPDATE Account SET balance = ? WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, balance);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    private void logTransfer(Connection conn, int sendId, int receiveId, double amount, String status) throws SQLException {
        String sql = "INSERT INTO Transfer_log(send_id, receive_id, amount, status) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, sendId);
            ps.setInt(2, receiveId);
            ps.setDouble(3, amount);
            ps.setString(4, status);
            ps.executeUpdate();
        }
    }


}
