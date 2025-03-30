package homeworks_28_3_exceptions.hw08;

import java.util.*;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class Hw08 {
    static final Logger logger = Logger.getLogger(Hw08.class.getName());
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập số các số điện thoạy cách nhau bằng dấu phẩy: ");
        String strPhone = sc.nextLine();

        List<String> phones = Arrays.stream(strPhone.split(",")).map(String::trim).toList();
        List<String> valids = new ArrayList<>();
        Map<String,String> invalids = new LinkedHashMap<>();

        try{
            filtingPhone(phones,valids,invalids);
        }
        catch (InvalidPhoneNumberException e){
            logger.warning(e.getMessage());
        }
        catch (Exception e){
            logger.severe(e.getMessage());
        }

        System.out.println("danh sách số hợp lệ:");
        printList(valids);
        System.out.println("danh sách số không hợp lệ:");
        printMaps(invalids);
    }

    static void filtingPhone (List<String> phones, List<String> valids, Map<String,String> invalids) throws IllegalArgumentException{
        for(String p: phones){
            Optional<String> err = isValidPhone(p);
            if(err.isPresent()){
                invalids.put(p,err.get());
            }else {
                valids.add(p);
            }

            if(!invalids.isEmpty()) throw new IllegalArgumentException("Có " + invalids.size() + " số không hợp lệ");
        }
    }

    static Optional<String> isValidPhone (String phone){
        if(phone.length() != 10) return Optional.of("Phải có đúng 10 chữ số");
        if(!Pattern.matches("^0\\d{9}$", phone)) return Optional.of("Số điện thoại không hợp lệ.");

        return Optional.empty();
    }

    static <T> void printList (List<T> lists){
        lists.forEach(e -> System.out.println(e));
    }

    static <K,V> void printMaps (Map<K,V> maps){
        maps.entrySet().forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
    }
}
