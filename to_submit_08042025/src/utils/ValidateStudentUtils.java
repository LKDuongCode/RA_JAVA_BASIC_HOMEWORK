package utils;

import business.CourseBusiness;
import business.StudentBusiness;

import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class ValidateStudentUtils {
    private static final Logger logger = Logger.getLogger(ValidateStudentUtils.class.getName());

    public static String validateStudentId (Scanner sc){
        while (true){
            try {
                String id = InputUtils.validateString(sc,"studentId",1,5);

                if(!Pattern.matches("^SV[a-zA-z0-9]{3}$",id)) throw new IllegalArgumentException("id sinh viên không hợp lệ.");

                boolean isExist = StudentBusiness.STUDENTS.stream().anyMatch(s -> s.getStudentId().equals(id));
                if(isExist) throw new IllegalArgumentException("id ssinh viên đã tồn tại.");

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

}
