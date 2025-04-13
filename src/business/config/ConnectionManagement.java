package business.config;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionManagement {
    public static void close (Connection c){
        try {
            if(c!= null && !c.isClosed()) c.close();
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
        catch (Exception e){
            System.err.println("lỗi đóng connection.");
        }
    }

    public static void close (CallableStatement c){
        try {
            if(c != null && c.isClosed()) c.close();
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
        catch (Exception e){
            System.err.println("lỗi đóng callableStatement");
        }
    }
}
