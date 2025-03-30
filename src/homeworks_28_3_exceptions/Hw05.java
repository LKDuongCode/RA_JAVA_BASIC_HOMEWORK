package homeworks_28_3_exceptions;
import java.util.Scanner;
import java.util.logging.Logger;

public class Hw05 {
    static final  Logger log = Logger.getLogger(Hw05.class.getName());
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("mời ngài nhập một số nguyên dương:");
            int number = Integer.parseInt(sc.nextLine());

            if(number <= 0 ){
                throw new IllegalArgumentException("số nhập vào cần lớn hơn 0");
            }


            if(isPrime(number)) {
                System.out.println("đây là số nguyên tố");
            }else {
                System.out.println("đây không phải số nguyên tố");
            }
        }
        catch (NumberFormatException e){
            System.out.println("dữ liệu nhập vào không hợp lệ");
        }
        catch (IllegalArgumentException e){
            System.out.println("số cần nhập phải lớn hơn 0");
        }
        catch (Exception e){
            log.severe(e.getMessage()); // còn có info - warming ở mức thấp hơn
        }
        finally {
            System.out.println("cảm ơn sử dụng chương trình");
        }
    }

    public static boolean isPrime (int number){
        if(number < 2) return  false;
        for(int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}
