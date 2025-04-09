package portal_homeworks.hw01;

import portal_homeworks.config.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Hw01 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DatabaseConnection.connectToDatabase();
            if (conn == null) {
                System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
                return;
            }

            System.out.println("Đã kết nối đến cơ sở dữ liệu.");
            System.out.println("Trạng thái auto-commit ban đầu: " + conn.getAutoCommit());

            conn.setAutoCommit(false);
            System.out.println("Đã tắt auto-commit.");

            String sql = "INSERT INTO users (id, name, email) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 1001);
            pstmt.setString(2, "Nguyen Van B");
            pstmt.setString(3, "b@example.com");

            int rows = pstmt.executeUpdate();
            System.out.println("Số dòng bị ảnh hưởng: " + rows);

            conn.commit();
            System.out.println("Đã commit thay đổi.");

        } catch (SQLException e) {
            System.err.println("Lỗi khi thao tác: " + e.getMessage());
            try {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("Đã rollback.");
                }
            } catch (SQLException ex) {
                System.err.println("Lỗi khi rollback: " + ex.getMessage());
            }
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
                System.out.println("Đã đóng kết nối.");
            } catch (SQLException e) {
                System.err.println("Lỗi khi đóng kết nối: " + e.getMessage());
            }
        }
    }
}