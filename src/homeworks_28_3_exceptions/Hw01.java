package homeworks_28_3_exceptions;

import java.util.Scanner;

public class Hw01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("a = ");
            int a = Integer.parseInt(sc.nextLine());
            System.out.print("b = ");
            int b = Integer.parseInt(sc.nextLine());
            System.out.println("result = " + (a/b));
        }
        catch (NumberFormatException e){
            System.out.println("đầu vào không hợp lệ");
        }
        catch (ArithmeticException e){
            System.out.println("không chia được cho 0");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
