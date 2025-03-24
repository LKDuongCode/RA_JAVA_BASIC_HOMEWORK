package first_oop_practice.services;

import first_oop_practice.entity.Book;
import first_oop_practice.entity.GlobalData;

import java.util.Iterator;
import java.util.Scanner;

public class Validator {
    public static String validateId(Scanner sc) {
        while (true) {
            String id = sc.nextLine();
            boolean isDuplicate = false;

            for (Book book : GlobalData.books) {
                if (book.equals(id)) {
                    System.out.println("ID đã tồn tại. Vui lòng nhập lại.");
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                return id;
            }
        }
    }

    public static String validateName (Scanner sc){
        while (true){
            String name = sc.nextLine();
            boolean isDuplicate = false;
            String regex = "^B\\w{4}";

            for (Book book : GlobalData.books) {
                if(!name.matches(regex)){
                    isDuplicate = true;
                    break;
                }

                if (book.getBookName().equals(name)) {
                    System.out.println("Tên đã tồn tại. Vui lòng nhập lại.");
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                return name;
            }

        }
    }

    public static float validatePrice (Scanner sc){
            while(true){
                float iPrice = Float.parseFloat(sc.nextLine());
                if(iPrice <= 0){
                    System.out.println("giá nhập cần lớn hơn 0");
                }else {
                    return iPrice;
                }
            }
    }

    public static float validatePrice (Scanner sc, float iPrice){
            while(true){
                float ePrice = Float.parseFloat(sc.nextLine());
                boolean validEprice = ePrice > (iPrice + (iPrice*(30/100)));
                if(!validEprice){
                    System.out.println("giá xuất cần lớn hơn ít nhất 30% so với giá nhập.");
                }else {
                    return ePrice;
                }
            }

    }

    public static String validateAuthor (Scanner sc) {
        while(true){
            String name = sc.nextLine();
            if(name.length() < 6 || name.length() > 50){
                System.out.println(" tên cần 6 - 50 kí tự");
            }else {
                return name;
            }
        }
    }

    public static int validateYear (Scanner sc){
        while(true){
            int year = Integer.parseInt(sc.nextLine());
            if(year < 2000){
                System.out.println("năm xuất bản phải sau 2000");
            }else{
                return year;
            }
        }
    }
}
