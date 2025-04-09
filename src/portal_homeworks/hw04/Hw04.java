package portal_homeworks.hw04;

import portal_homeworks.config.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Hw04 {
    public static void main(String[] args) {
        int fromAccountId = 1;
        int toAccountId = 2;
        double amount = 500;

        Connection connA = null;
        Connection connB = null;

        try {
            connA = DatabaseConnection.connectToDatabase();
            connB = DatabaseConnection.connectToDatabase();

            if (connA == null || connB == null) {
                System.out.println("Không thể kết nối đến một trong hai ngân hàng.");
                return;
            }

            connA.setAutoCommit(false);
            connB.setAutoCommit(false);

            System.out.println("Đã kết nối đến cả hai ngân hàng. Tắt auto-commit.");

            String checkBalanceSql = "SELECT balance FROM bank_accounts WHERE account_id = ?";
            PreparedStatement checkStmt = connA.prepareStatement(checkBalanceSql);
            checkStmt.setInt(1, fromAccountId);
            ResultSet rs = checkStmt.executeQuery();

            if (!rs.next()) {
                throw new SQLException("Tài khoản gửi không tồn tại.");
            }

            double balance = rs.getDouble("balance");
            if (balance < amount) {
                throw new SQLException("Số dư không đủ để chuyển khoản.");
            }

            String deductSql = "UPDATE bank_accounts SET balance = balance - ? WHERE account_id = ?";
            PreparedStatement deductStmt = connA.prepareStatement(deductSql);
            deductStmt.setDouble(1, amount);
            deductStmt.setInt(2, fromAccountId);
            deductStmt.executeUpdate();

            String addSql = "UPDATE bank_accounts SET balance = balance + ? WHERE account_id = ?";
            PreparedStatement addStmt = connB.prepareStatement(addSql);
            addStmt.setDouble(1, amount);
            addStmt.setInt(2, toAccountId);
            addStmt.executeUpdate();

            connA.commit();
            connB.commit();
            System.out.println("Chuyển khoản liên ngân hàng thành công. Đã commit cả hai bên.");

        } catch (SQLException e) {
            System.err.println("Lỗi xảy ra trong quá trình chuyển khoản: " + e.getMessage());
            try {
                if (connA != null) {
                    connA.rollback();
                    System.out.println("Rollback ngân hàng A.");
                }
                if (connB != null) {
                    connB.rollback();
                    System.out.println("Rollback ngân hàng B.");
                }
            } catch (SQLException ex) {
                System.err.println("Lỗi khi rollback: " + ex.getMessage());
            }
        } finally {
            try {
                if (connA != null) connA.close();
                if (connB != null) connB.close();
                System.out.println("Đã đóng kết nối đến cả hai ngân hàng.");
            } catch (SQLException e) {
                System.err.println("Lỗi khi đóng kết nối: " + e.getMessage());
            }
        }
    }
}