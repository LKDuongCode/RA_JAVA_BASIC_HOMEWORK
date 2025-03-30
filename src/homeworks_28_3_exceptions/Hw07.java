package homeworks_28_3_exceptions;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

public class Hw07 {
    static final Logger logger = Logger.getLogger(Hw07.class.getName());
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Integer,Double> accounts = new LinkedHashMap<>();
        accounts.put(1,(double)1000000);

        try{
            withDrawMoney(accounts,sc);
        }catch (NumberFormatException e){
            logger.info("Lỗi: Vui lòng nhập một số hợp lệ!");
            logger.warning(e.getMessage());
        }catch (IllegalArgumentException e){
            logger.warning(e.getMessage());
        }catch (Exception e){
            logger.severe(e.getMessage());
        }

    }

    static void withDrawMoney (Map<Integer,Double> accs,Scanner sc) throws IllegalArgumentException {
        System.out.println("nhập số tiền cần rút");
        double amountWithDrawn = Double.parseDouble(sc.nextLine());
        double curBalance = accs.get(1);
        if(curBalance < amountWithDrawn) throw new IllegalArgumentException("Lỗi: Số tiền rút vượt quá số dư!");

        double futureBalance = curBalance - amountWithDrawn;

        if((futureBalance) < 50000) throw new IllegalArgumentException( "Lỗi: Tài khoản phải duy trì số dư tối thiểu 50.000 đồng!");

        accs.put(1,futureBalance);
        System.out.println("rút thành công");
        System.out.println("số dư còn lại: " + futureBalance);
    }
}
