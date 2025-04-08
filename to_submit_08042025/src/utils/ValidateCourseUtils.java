package utils;

import business.CourseBusiness;

import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class ValidateCourseUtils {
    private static final Logger logger = Logger.getLogger(ValidateCourseUtils.class.getName());

    public static String validateCourseId (Scanner sc){
        while (true){
            try {
                String id = InputUtils.validateString(sc,"courseId",1,5);

                if(!Pattern.matches("^C[a-zA-z0-9]{4}$",id)) throw new IllegalArgumentException("id khóa học không hợp lệ.");

                boolean isExist = CourseBusiness.COURSES.stream().anyMatch(c -> c.getCourseId().equals(id));
                if(isExist) throw new IllegalArgumentException("id khóa học đã tồn tại.");

                return id;
            }
            catch (IllegalArgumentException e){
                logger.warning(e.getMessage());
            }
            catch (Exception e){
                logger.severe("Lỗi bất định " + e.getMessage());
            }
        }
    }


    public static String validateCourseName (Scanner sc){
        while(true){
            try {
                String name = InputUtils.validateString(sc,"courseName",20,100);

                boolean isExist = CourseBusiness.COURSES.stream().anyMatch(c -> c.getCourseName().equals(name));

                if(isExist){
                    logger.warning("tên khóa học đã tồn tại!");
                    continue;
                }

                return name;

            }catch (Exception e){
                logger.severe("Lỗi bất định " + e.getMessage());
            }
        }
    }

    //validate boolean bên input.
}
