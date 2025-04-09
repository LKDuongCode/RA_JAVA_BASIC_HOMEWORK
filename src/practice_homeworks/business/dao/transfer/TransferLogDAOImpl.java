package practice_homeworks.business.dao.transfer;

import practice_homeworks.business.config.DatabaseConnection;
import practice_homeworks.business.model.TransferLog;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransferLogDAOImpl implements TransferLogDAO {

    @Override
    public List<TransferLog> findAll() {
        List<TransferLog> logs = new ArrayList<>();
        String sql = "SELECT * FROM transfer_log ORDER BY created DESC";

        try (Connection c = DatabaseConnection.connectToDatabase();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                TransferLog log = new TransferLog(
                        rs.getInt("id"),
                        rs.getInt("send_id"),
                        rs.getInt("receive_id"),
                        rs.getDouble("amount"),
                        rs.getTimestamp("created").toLocalDateTime(),
                        rs.getString("status")
                );
                logs.add(log);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return logs;
    }

    @Override
    public double getTotalTransferredBetween(LocalDate from, LocalDate to) {
        String sql = "SELECT SUM(amount) FROM Transfer_log WHERE status = 'success' AND DATE(created) BETWEEN ? AND ?";
        double total = 0;

        try (Connection c = DatabaseConnection.connectToDatabase();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setDate(1, Date.valueOf(from));
            ps.setDate(2, Date.valueOf(to));

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getDouble(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return total;
    }

    @Override
    public double getTotalReceivedByAccountId(int accountId) {
        String sql = "SELECT SUM(amount) FROM Transfer_log WHERE receive_id = ? AND status = 'success'";
        double total = 0;

        try (Connection c = DatabaseConnection.connectToDatabase();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, accountId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                total = rs.getDouble(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return total;
    }


    @Override
    public int countSuccessfulTransfersBetween(LocalDate from, LocalDate to) {
        String sql = "SELECT COUNT(*) FROM Transfer_log WHERE status = 'success' AND DATE(created) BETWEEN ? AND ?";
        int count = 0;

        try (Connection c = DatabaseConnection.connectToDatabase();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setDate(1, Date.valueOf(from));
            ps.setDate(2, Date.valueOf(to));

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

}
