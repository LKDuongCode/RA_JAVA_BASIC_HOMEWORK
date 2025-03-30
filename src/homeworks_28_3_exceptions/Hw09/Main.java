package homeworks_28_3_exceptions.Hw09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
   public static List<BankAccount> accounts = new ArrayList<>(Arrays.asList(
            new BankAccount("112",1000),
            new BankAccount("234",500),
            new BankAccount("654",200)
    ));
    public static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("tài khoản 1: " + accounts.get(0).getBalance());
        System.out.println("tài khoản 2: " +  accounts.get(1).getBalance());

        System.out.println(" rút từ tk 1:");
        try {
            accounts.get(0).withDraw(Double.parseDouble(sc.nextLine()));
            System.out.println("số dư:");
            System.out.println(accounts.get(0).getBalance());

            System.out.println("chuyển từ 1 -> 2");
            accounts.get(0).transfer(accounts.get(1),Double.parseDouble(sc.nextLine()));
            System.out.println("tài khoản 1: " + accounts.get(0).getBalance());
            System.out.println("tài khoản 2:" +  accounts.get(1).getBalance());

            System.out.println("nạp thêm cho 1:");
            accounts.get(0).deposit(Double.parseDouble(sc.nextLine()));
            System.out.println("tài khoản 1: " + accounts.get(0).getBalance());
        }
        catch (NumberFormatException e){
            logger.warning("số tiền nhập vào không hợp lệ,");
        }
        catch (IllegalArgumentException e){
            logger.warning(e.getMessage());
        }
        catch (Exception e){
            logger.severe(e.getMessage());
        }



    }
}
