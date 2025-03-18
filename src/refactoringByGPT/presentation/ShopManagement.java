package refactoringByGPT.presentation;

import refactoringByGPT.services.CategoryManagement;
import refactoringByGPT.services.ProductManagement;
import java.util.Scanner;

public class ShopManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mainChoice;

        do {
            displayMenu();
            mainChoice = getValidIntegerInput(sc, "Nhập lựa chọn của bạn: ");

            switch (mainChoice) {
                case 1 -> CategoryManagement.manageCategories(sc);
                case 2 -> ProductManagement.manageProducts(sc);
                case 3 -> exitProgram(sc);
                default -> System.out.println("Lựa chọn không hợp lệ");
            }
        } while (true);
    }

    private static void displayMenu() {
        System.out.println("\n===== SHOP MENU =====");
        System.out.println("1. Quản lý danh mục");
        System.out.println("2. Quản lý sản phẩm");
        System.out.println("3. Thoát");
    }

    private static int getValidIntegerInput(Scanner sc, String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên hợp lệ.");
            }
        }
    }

    private static void exitProgram(Scanner sc) {
        System.out.println("Thoát chương trình.");
        sc.close();
        System.exit(0);
    }
}
