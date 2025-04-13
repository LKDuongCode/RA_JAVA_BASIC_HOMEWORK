package business.config;

import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig {
    // 1 tạo biến chứa filename resources.
    private static final String FILE_NAME = "database.properties";

    // 2 tạo method load để đọc dữ liệu
    public static Properties load (){
        Properties p = new Properties();

        // 3 lấy đường dẫn đến file
        try(InputStream i = DatabaseConfig.class.getClassLoader().getResourceAsStream(FILE_NAME)){
            if(i == null) throw new IllegalArgumentException("không tìm thấy file cấu hình");
            p.load(i);
        }
        catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
            return null;
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return p;
    }

}
