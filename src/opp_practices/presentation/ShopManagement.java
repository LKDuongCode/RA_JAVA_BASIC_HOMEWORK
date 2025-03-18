package opp_practices.presentation;

import opp_practices.functions.CategoryManagement;
import opp_practices.functions.ProductManagement;

import java.util.Scanner;

public class ShopManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mainChoice;

        do {
            System.out.println("===== SHOP MENU =====");
            System.out.println("1. Quản lý danh mục");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");

            mainChoice = Integer.parseInt(sc.nextLine());

            switch (mainChoice) {
                case 1:
                    CategoryManagement.manageCategories(sc);
                    break;
                case 2:
                    ProductManagement.manageProducts(sc);
                    break;
                case 3:
                    System.out.println("Thoát chương trình.");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (true);

    }
}
