package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.logging.Logger;

public class InputUtils {
    private static final Logger logger = Logger.getLogger(InputUtils.class.getName());

    public static int validateInt (Scanner sc){
        while (true){
            try{
                int i = Integer.parseInt(sc.nextLine());
                return i;
            }catch (NumberFormatException e){
                logger.warning("hãy nhập số nguyên.");
            }catch (Exception e){
                logger.severe("lỗi bất định " + e.getMessage());
            }
        }
    }

    public static double validateDouble (Scanner sc){
        while (true){
            try{
                double d = Double.parseDouble(sc.nextLine());
                return d;
            }catch (NumberFormatException e){
                logger.warning("hãy nhập số thực.");
            }catch (Exception e){
                logger.severe("lỗi bất định" + e.getMessage());
            }
        }
    }

    public static String validateString (Scanner sc, String attribute, int min, int max){
        while(true){
            try{
                String s = sc.nextLine().trim();

                if(s.length() == 0) throw new IllegalArgumentException("chuỗi không được để trống.");

                if(s.length() < min || s.length() > max) throw new IllegalArgumentException(attribute + "cần từ " + min + "-" + max + " kí tự ");
            }
            catch (IllegalArgumentException e){
                logger.warning(e.getMessage());
            }
            catch (Exception e){
                logger.severe("lỗi bất định " + e.getMessage());
            }
        }
    }

    public static LocalDate validateLocalDate (Scanner sc, String mes){
        System.out.println(mes);
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true){
            try{
                String date = sc.nextLine().trim();
                return LocalDate.parse(date,f);
            }
            catch (DateTimeParseException e){
                logger.warning("hãy nhập theo định dạng ngày dd/MM/yyyy");
            }
            catch (Exception e){
                logger.severe("lỗi bất định " + e.getMessage());
            }
        }
    }

    public static LocalDateTime validateLocalDateTime (Scanner sc){
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        while (true){
            try{
                System.out.println("nhập ngày:");
                String date = sc.nextLine().trim();

                System.out.println("nhập giờ:");
                String hour = sc.nextLine().trim();

                String dateTime = date + " " + hour;
                return LocalDateTime.parse(dateTime,f);
            }
            catch (DateTimeParseException e){
                logger.warning("hãy nhập theo định dạng ngày dd/MM/yyyy - giờ HH:mm:ss");
            }
            catch (Exception e){
                logger.severe("lỗi bất định " + e.getMessage());
            }
        }
    }

    public static boolean validateBoolean (Scanner sc, String mes){
        System.out.println(mes);
        while(true){
            try{
                String b = sc.nextLine().trim().toLowerCase();

                if(b.equals("true") || b.equals("false")){
                    return Boolean.parseBoolean(b);
                }
            logger.warning("hãy nhập true hoặc false.");
            }catch (Exception e){
                logger.severe("lỗi bất định " + e.getMessage());
            }
        }
    }

    public static <T extends Enum<T>> T validateEnum (Scanner sc, String mes, Class<T> enumClass){
        System.out.println(mes + " (" + String.join(", ", getEnumNames(enumClass)) + "): ");
        while (true){
            try{
                String input = sc.nextLine().toUpperCase();

                for(T constant : enumClass.getEnumConstants()){
                    if(constant.name().equals(input)){
                        return Enum.valueOf(enumClass,input);
                    }
                }

                throw new IllegalArgumentException("hãy chọn 1 trong các giá trị " + String.join("| ",getEnumNames(enumClass)));
            }
            catch (IllegalArgumentException e){
                logger.warning(e.getMessage());
            }
            catch (Exception e){
                logger.severe("lỗi bất định " + e.getMessage());
            }
        }
    }

    // chuyển enum sang mảng string.
    public static <T extends Enum<T>> String [] getEnumNames (Class<T> enumType){
            T[] arrEnums = enumType.getEnumConstants();
            String[] stringEnums = new String[arrEnums.length];

            for(int i = 0; i < arrEnums.length; i++) {
                stringEnums[i] = arrEnums[i].name();
            }

            return stringEnums;
        }

}
