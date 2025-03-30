package homeworks_28_3_exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Hw06 {
    static final Logger logger = Logger.getLogger(Hw06.class.getName());
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> data = inputData(sc);
        List<String> validString = new ArrayList<>();
        List<String> invalidString = new ArrayList<>();

        numFormat(data, validString, invalidString);

        System.out.println(validString.size() + " | " + validString);
        System.out.println(invalidString.size() + " | " + invalidString);
    }

    static List<String> inputData(Scanner sc) {
        List<String> stringList = new ArrayList<>();
        try {
            System.out.println("nhập số chuỗi trong danh sách:");

            int size = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < size; i++) {
                System.out.printf("list[%d] = ", i);
                String element = sc.nextLine();
                stringList.add(element);
            }
        }catch (NumberFormatException e){
            System.out.println("nhập không hợp lệ");
        }

        return stringList;
    }

    static void numFormat(List<String> strs, List<String> valids, List<String> invalids) {
        for (String s : strs) {
            try {
                Integer.parseInt(s);
                valids.add(s);
            } catch (NumberFormatException e) {
                invalids.add(s);
            } catch (Exception e) {
                logger.severe(e.getMessage());
            }
        }
    }
}
