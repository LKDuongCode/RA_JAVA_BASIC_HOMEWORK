package portal_homeworks.config;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

public class ResourceManager {
    private static final Logger logger = Logger.getLogger(ResourceManager.class.getName());

    public static void close (Connection c){
        try {
            if(c != null && !c.isClosed()) c.close();
        }
        catch (SQLException e){
            logger.warning(e.getMessage());
        }
        catch (Exception e){
            logger.severe("Lỗi đóng connection " + e.getMessage());
        }
    }

    public static void close (CallableStatement call){
        try {
            if(call != null && !call.isClosed()) call.close();
        }
        catch (SQLException e){
            logger.warning(e.getMessage());
        }
        catch (Exception e){
            logger.severe("Lỗi đóng callable statement " + e.getMessage());
        }
    }
}
