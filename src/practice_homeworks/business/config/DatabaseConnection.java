package practice_homeworks.business.config;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

public class DatabaseConnection {
    private static final Logger logger = Logger.getLogger(DatabaseConnection.class.getName());

    public static Connection connectToDatabase (){
        Connection c = null;

        try {
            //lấy cấu hình file từ database.properties
            Properties p = DatabaseConfig.load();
            if(p == null){
                throw new IllegalArgumentException("không load được file cấu hình db.");
            }

            String url = p.getProperty("db.url");
            String username = p.getProperty("db.username");
            String password = p.getProperty("db.password");

            c = DriverManager.getConnection(url,username,password);
        }
        catch (SQLException e){
            logger.warning("lỗi kết nối - " + e.getMessage());
        }
        catch (Exception e){
            logger.severe("Lỗi bất định " + e.getMessage());
        }

        return c;
    }

}
