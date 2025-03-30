package homeworks_28_3_exceptions;

import java.util.Scanner;

public class Hw03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập tuổi của bạn:");
        checkAge(sc);
    }

    static void checkAge(Scanner sc){
        try {
             int age = Integer.parseInt(sc.nextLine());
             if(age < 18) throw new Exception("bạn chưa đủ 18 tuổi");

            System.out.println("chào mừng bạn!");
        }
        catch (NumberFormatException e){
            System.out.println("dữ liệu đầu vào không hợp lệ");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
