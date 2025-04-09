package portal_homeworks.hw06;

import portal_homeworks.config.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Hw06 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement deptStmt = null;
        PreparedStatement empStmt = null;

        int departmentId = 200;
        String departmentName = "Phòng Đào tạo";

        String[][] employees = {
                {"301", "Nguyen Van J"},
                {"302", "Tran Thi K"},
                {"303", "Pham Van L"}
        };

        try {
            conn = DatabaseConnection.connectToDatabase();
            if (conn == null) {
                System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
                return;
            }

            conn.setAutoCommit(false);
            System.out.println("Đã tắt auto-commit. Bắt đầu giao dịch.");

            String deptSql = "INSERT INTO departments (id, name) VALUES (?, ?)";
            deptStmt = conn.prepareStatement(deptSql);
            deptStmt.setInt(1, departmentId);
            deptStmt.setString(2, departmentName);
            deptStmt.executeUpdate();
            System.out.println("Thêm phòng ban thành công.");

            String empSql = "INSERT INTO employees (id, name, department_id) VALUES (?, ?, ?)";
            empStmt = conn.prepareStatement(empSql);

            for (String[] emp : employees) {
                int empId = Integer.parseInt(emp[0]);
                String empName = emp[1];

                empStmt.setInt(1, empId);
                empStmt.setString(2, empName);
                empStmt.setInt(3, departmentId);
                empStmt.executeUpdate();
                System.out.println("Đã thêm nhân viên: " + empName);
            }

            conn.commit();
            System.out.println("Giao dịch thành công. Đã commit toàn bộ.");

        } catch (SQLException e) {
            System.err.println("Lỗi trong quá trình giao dịch: " + e.getMessage());
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
                if (deptStmt != null) deptStmt.close();
                if (empStmt != null) empStmt.close();
                if (conn != null) conn.close();
                System.out.println("Đã đóng kết nối.");
            } catch (SQLException e) {
                System.err.println("Lỗi khi đóng kết nối: " + e.getMessage());
            }
        }
    }
}