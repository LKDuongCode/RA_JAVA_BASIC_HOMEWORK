package portal_homeworks.config;

import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class DatabaseConfig {
    // 0 tạo file name.properties sau đó chuyển thư mục chứa file đó thành resource root (tránh lỗi không đọc được.)

    private static final Logger logger = Logger.getLogger(DatabaseConfig.class.getName());

    // 1 tạo file name đến file cần đọc
    private static final String FILE_NAME = "database.properties";

    public static Properties load(){
        // 2 tạo Properties để lưu cặp k-v nếu đọc được.
        Properties props = new Properties();

        // 3 lấy đường dẫn đến file
        try (InputStream i = DatabaseConfig.class.getClassLoader().getResourceAsStream(FILE_NAME)){

            if(i == null) throw new IllegalArgumentException("không thấy file cấu hình " + FILE_NAME);
            props.load(i);
        }
        catch (IllegalArgumentException e){
            logger.warning(e.getMessage());
            return null;
        }
        catch (Exception e){
            logger.severe("Lỗi bất định " + e.getMessage());
        }

        return props;
    }


}
