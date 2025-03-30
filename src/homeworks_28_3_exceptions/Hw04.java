package homeworks_28_3_exceptions;

import java.util.Scanner;

public class Hw04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("nhập số nguyên:");
            int number = Integer.parseInt(sc.nextLine());
            System.out.println("bạn đã nhập số " + number);
        }catch (NumberFormatException e){
            System.out.println("bạn cần nhập vào một số nguyên");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("cảm ơn bạn đã sử dụng chương trình.");
        }
    }
}
