package utils;


import entity.Person;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class ValidatePersonUtils {
    private static final Logger logger = Logger.getLogger(ValidatePersonUtils.class.getName());

    // name, address, sex đã được xử lí bên input.

    public static int validateAge (Scanner sc){
        while(true){
            try {
                int age = InputUtils.validateInt(sc);

                if(age < 18) throw new IllegalArgumentException("tuổi tối thiểu là 18.");
                return age;
            }
            catch (IllegalArgumentException e){
                logger.warning(e.getMessage());
            }
            catch (Exception e){
                logger.severe("Lỗi bất định " + e.getMessage());
            }
        }
    }

    public static <T extends Person> String validatePhone (Scanner sc, List<T> tList){
        while (true){
            try {
                String phone = InputUtils.validateString(sc,"phone",10,10);

                if(!Pattern.matches("^0[35789][0-9]{8}$",phone)) throw new IllegalArgumentException("số điện thoại cần có định dạng số việt nam.");

                boolean isExist = tList.stream().anyMatch(t-> t.getPhone().equals(phone));
                if(isExist) throw new IllegalArgumentException("số điện thoại đã tồn tại.");

                return phone;

            }
            catch (IllegalArgumentException e){
                logger.warning(e.getMessage());
            }
            catch (Exception e){
                logger.severe("Lỗi bất định " + e.getMessage());
            }
        }
    }

    public static <T extends Person> String validateEmail (Scanner sc, List<T> tList){
        while (true){
            try {
                String email = InputUtils.validateString(sc,"email",16,50);

                if(!Pattern.matches("[a-zA-z]+@gmail\\.com$",email)) throw new IllegalArgumentException("email sai định dạng.");

                boolean isExist = tList.stream().anyMatch(t-> t.getEmail().equals(email));
                if(isExist) throw new IllegalArgumentException("email đã tồn tại.");

                return email;

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
