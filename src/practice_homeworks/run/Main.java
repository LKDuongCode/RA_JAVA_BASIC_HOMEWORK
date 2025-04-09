package practice_homeworks.run;

import practice_homeworks.presentation.AccountUI;
import practice_homeworks.presentation.TransferUI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("************** MENU CHÍNH **************");
            System.out.println("1. Quản lý tài khoản");
            System.out.println("2. Quản lý chuyển khoản");
            System.out.println("3. Thoát");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    new AccountUI().handle(sc);
                    break;
                case 2:
                     new TransferUI().handle(sc);
                    break;
                case 3:
                    System.out.println("thoát");
                    exit = true;
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
