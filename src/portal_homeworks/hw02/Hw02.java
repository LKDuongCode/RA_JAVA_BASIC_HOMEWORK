package portal_homeworks.hw02;

import portal_homeworks.config.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Hw02 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;

        try {
            conn = DatabaseConnection.connectToDatabase();
            if (conn == null) {
                System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
                return;
            }

            System.out.println("Đã kết nối đến cơ sở dữ liệu.");
            conn.setAutoCommit(false);
            System.out.println("Đã tắt auto-commit.");

            String sql1 = "INSERT INTO users (id, name, email) VALUES (?, ?, ?)";
            pstmt1 = conn.prepareStatement(sql1);
            pstmt1.setInt(1, 1002);
            pstmt1.setString(2, "Nguyen Van C");
            pstmt1.setString(3, "c@example.com");
            pstmt1.executeUpdate();
            System.out.println("Đã thêm user hợp lệ.");

            String sql2 = "INSERT INTO users (id, name, email) VALUES (?, ?, ?)";
            pstmt2 = conn.prepareStatement(sql2);
            pstmt2.setInt(1, 1002);  // Trùng ID -> lỗi khóa chính
            pstmt2.setString(2, "Nguyen Van D");
            pstmt2.setString(3, "d@example.com");
            pstmt2.executeUpdate();
            System.out.println("Đã thêm user lỗi (đáng lẽ không tới đây).");

            conn.commit();
            System.out.println("Đã commit thay đổi (đáng lẽ không nên thấy dòng này).");

        } catch (SQLException e) {
            System.err.println("Lỗi xảy ra: " + e.getMessage());
            try {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("Đã rollback – Không có dữ liệu nào được thêm vào.");
                }
            } catch (SQLException ex) {
                System.err.println("Lỗi khi rollback: " + ex.getMessage());
            }
        } finally {
            try {
                if (pstmt1 != null) pstmt1.close();
                if (pstmt2 != null) pstmt2.close();
                if (conn != null) conn.close();
                System.out.println("Đã đóng kết nối.");
            } catch (SQLException e) {
                System.err.println("Lỗi khi đóng kết nối: " + e.getMessage());
            }
        }
    }
}