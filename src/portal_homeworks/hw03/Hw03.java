package portal_homeworks.hw03;

import portal_homeworks.config.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Hw03 {
    public static void main(String[] args) {
        int fromAccountId = 1;
        int toAccountId = 2;
        double amount = 300;

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.connectToDatabase();
            if (conn == null) {
                System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
                return;
            }

            conn.setAutoCommit(false);
            System.out.println("Auto-commit đã bị tắt.");

            String checkBalanceSql = "SELECT balance FROM accounts WHERE id = ?";
            pstmt = conn.prepareStatement(checkBalanceSql);
            pstmt.setInt(1, fromAccountId);
            rs = pstmt.executeQuery();

            if (!rs.next()) {
                throw new SQLException("Tài khoản A không tồn tại.");
            }

            double balance = rs.getDouble("balance");
            if (balance < amount) {
                throw new SQLException("Tài khoản A không đủ tiền.");
            }

            String deductSql = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
            pstmt = conn.prepareStatement(deductSql);
            pstmt.setDouble(1, amount);
            pstmt.setInt(2, fromAccountId);
            pstmt.executeUpdate();

            String addSql = "UPDATE accounts SET balance = balance + ? WHERE id = ?";
            pstmt = conn.prepareStatement(addSql);
            pstmt.setDouble(1, amount);
            pstmt.setInt(2, toAccountId);
            pstmt.executeUpdate();

            conn.commit();
            System.out.println("Giao dịch chuyển tiền thành công. Đã commit.");

        } catch (SQLException e) {
            System.err.println("Lỗi xảy ra: " + e.getMessage());
            try {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("Giao dịch thất bại. Đã rollback.");
                }
            } catch (SQLException ex) {
                System.err.println("Lỗi khi rollback: " + ex.getMessage());
            }
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
                System.out.println("Đã đóng kết nối.");
            } catch (SQLException e) {
                System.err.println("Lỗi khi đóng kết nối: " + e.getMessage());
            }
        }
    }
}