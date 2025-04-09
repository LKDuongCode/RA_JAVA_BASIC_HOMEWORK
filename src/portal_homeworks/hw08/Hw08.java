package portal_homeworks.hw08;

import portal_homeworks.config.DatabaseConnection;

import java.sql.*;

public class Hw08 {

    public static void main(String[] args) {
        int customerId = 1;
        int roomId = 101;

        try {
            bookRoom(customerId, roomId);
        } catch (SQLException e) {
            System.err.println("Lỗi trong quá trình đặt phòng: " + e.getMessage());
        }
    }

    public static void bookRoom(int customerId, int roomId) throws SQLException {
        Connection conn = null;
        PreparedStatement checkRoomStmt = null;
        PreparedStatement updateRoomStmt = null;
        PreparedStatement insertBookingStmt = null;
        PreparedStatement logErrorStmt = null;

        try {
            conn = DatabaseConnection.connectToDatabase();
            if (conn == null) {
                throw new SQLException("Không thể kết nối đến cơ sở dữ liệu.");
            }

            conn.setAutoCommit(false);

            String checkRoomSql = "SELECT availability FROM rooms WHERE room_id = ?";
            checkRoomStmt = conn.prepareStatement(checkRoomSql);
            checkRoomStmt.setInt(1, roomId);
            ResultSet rs = checkRoomStmt.executeQuery();

            if (!rs.next()) {
                throw new SQLException("Phòng không tồn tại.");
            }

            boolean isAvailable = rs.getBoolean("availability");
            if (!isAvailable) {
                throw new SQLException("Phòng đã được đặt.");
            }

            String updateRoomSql = "UPDATE rooms SET availability = FALSE WHERE room_id = ?";
            updateRoomStmt = conn.prepareStatement(updateRoomSql);
            updateRoomStmt.setInt(1, roomId);
            updateRoomStmt.executeUpdate();

            String insertBookingSql = "INSERT INTO bookings (customer_id, room_id, booking_date, status) VALUES (?, ?, CURRENT_TIMESTAMP, 'CONFIRMED')";
            insertBookingStmt = conn.prepareStatement(insertBookingSql);
            insertBookingStmt.setInt(1, customerId);
            insertBookingStmt.setInt(2, roomId);
            insertBookingStmt.executeUpdate();

            conn.commit();
            System.out.println("Đặt phòng thành công.");

        } catch (SQLException e) {
            if (conn != null) {
                String logErrorSql = "INSERT INTO failed_bookings (customer_id, room_id, error_message) VALUES (?, ?, ?)";
                logErrorStmt = conn.prepareStatement(logErrorSql);
                logErrorStmt.setInt(1, customerId);
                logErrorStmt.setInt(2, roomId);
                logErrorStmt.setString(3, e.getMessage());
                logErrorStmt.executeUpdate();

                System.err.println("Đặt phòng thất bại. Đã ghi vào bảng lỗi.");
            }

            if (conn != null) {
                conn.rollback();
                System.out.println("Đã rollback giao dịch.");
            }

            throw e;

        } finally {
            try {
                if (checkRoomStmt != null) checkRoomStmt.close();
                if (updateRoomStmt != null) updateRoomStmt.close();
                if (insertBookingStmt != null) insertBookingStmt.close();
                if (logErrorStmt != null) logErrorStmt.close();
                if (conn != null) conn.close();
                System.out.println("Đã đóng kết nối.");
            } catch (SQLException e) {
                System.err.println("Lỗi khi đóng kết nối: " + e.getMessage());
            }
        }
    }
}