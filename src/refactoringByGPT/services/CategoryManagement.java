package refactoringByGPT.services;

import refactoringByGPT.entity.Category;
import java.util.Scanner;

public class CategoryManagement {
    private static final int MAX_CATEGORIES = 100;
    private static final Category[] categories = new Category[MAX_CATEGORIES];
    private static int categoryCurIdx = 0;

    public static void manageCategories(Scanner sc) {
        int choice;
        do {
            displayMenu();
            choice = getValidIntegerInput(sc, "Nhập lựa chọn của bạn: ");

            switch (choice) {
                case 1 -> listCategories();
                case 2 -> addCategory(sc);
                case 3 -> updateCategory(sc);
                case 4 -> deleteCategory(sc);
                case 5 -> searchCategoryByName(sc);
                case 6 -> System.out.println("Thoát khỏi quản lý danh mục...");
                default -> System.out.println("Lựa chọn không hợp lệ");
            }
        } while (choice != 6);
    }

    private static void displayMenu() {
        System.out.println("\n===== QUẢN LÝ DANH MỤC =====");
        System.out.println("1. Danh sách danh mục");
        System.out.println("2. Thêm mới danh mục");
        System.out.println("3. Cập nhật danh mục");
        System.out.println("4. Xóa danh mục");
        System.out.println("5. Tìm kiếm danh mục theo tên");
        System.out.println("6. Thoát");
    }

    private static void listCategories() {
        if (categoryCurIdx == 0) {
            System.out.println("Không có danh mục nào để hiển thị.");
        } else {
            System.out.println("Danh sách danh mục:");
            for (int i = 0; i < categoryCurIdx; i++) {
                categories[i].displayData();
            }
        }
    }

    private static void addCategory(Scanner sc) {
        if (categoryCurIdx >= MAX_CATEGORIES) {
            System.out.println("Không thể thêm danh mục, mảng đã đầy!");
            return;
        }
        Category newCategory = new Category();
        newCategory.inputData(sc);
        categories[categoryCurIdx++] = newCategory;
        System.out.println("Thêm danh mục thành công!");
    }

    private static void updateCategory(Scanner sc) {
        int id = getValidIntegerInput(sc, "Nhập mã danh mục cần cập nhật: ");
        for (int i = 0; i < categoryCurIdx; i++) {
            if (categories[i].getCategoryId() == id) {
                System.out.println("Cập nhật thông tin danh mục:");
                categories[i].inputData(sc);
                System.out.println("Cập nhật thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy danh mục với mã ID này!");
    }

    private static void deleteCategory(Scanner sc) {
        int id = getValidIntegerInput(sc, "Nhập mã danh mục cần xóa: ");
        for (int i = 0; i < categoryCurIdx; i++) {
            if (categories[i].getCategoryId() == id) {
                System.out.println("Xóa danh mục: " + categories[i].getCategoryName());
                System.arraycopy(categories, i + 1, categories, i, categoryCurIdx - i - 1);
                categories[--categoryCurIdx] = null;
                System.out.println("Xóa danh mục thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy danh mục để xóa!");
    }

    private static void searchCategoryByName(Scanner sc) {
        System.out.print("Nhập tên danh mục cần tìm: ");
        String name = sc.nextLine().toLowerCase();
        boolean found = false;
        for (int i = 0; i < categoryCurIdx; i++) {
            if (categories[i].getCategoryName().toLowerCase().contains(name)) {
                categories[i].displayData();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy danh mục nào!");
        }
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
}
