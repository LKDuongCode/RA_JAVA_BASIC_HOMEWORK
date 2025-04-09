package portal_homeworks.hw05;

import portal_homeworks.config.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Hw05 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement deptStmt = null;
        PreparedStatement empStmt = null;

        int departmentId = 101;
        String departmentName = "Phòng Công nghệ";

        String[][] employees = {
                {"201", "Nguyen Van G"},
                {"202", "Tran Thi H"},
                {"203", "Le Van I"}
        };

        try {
            conn = DatabaseConnection.connectToDatabase();
            if (conn == null) {
                System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
                return;
            }

            conn.setAutoCommit(false);
            System.out.println("Đã kết nối và tắt auto-commit.");

            String deptSql = "INSERT INTO departments (id, name) VALUES (?, ?)";
            deptStmt = conn.prepareStatement(deptSql);
            deptStmt.setInt(1, departmentId);
            deptStmt.setString(2, departmentName);
            deptStmt.executeUpdate();
            System.out.println("Đã thêm phòng ban mới.");

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
            System.out.println("Giao dịch hoàn tất. Đã commit toàn bộ.");

        } catch (SQLException e) {
            System.err.println("Lỗi trong giao dịch: " + e.getMessage());
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