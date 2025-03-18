package opp_practices.functions;

import opp_practices.entity.Category;
import java.util.Scanner;

public class CategoryManagement {
    public static void manageCategories(Scanner sc) {
        Category[] categories = new Category[100];
        int categoryCurIdx = 0;
        int choice;
        do {
            System.out.println("===== QUẢN LÝ DANH MỤC =====");
            System.out.println("1. Danh sách danh mục");
            System.out.println("2. Thêm mới danh mục");
            System.out.println("3. Cập nhật danh mục");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Tìm kiếm danh mục theo tên");
            System.out.println("6. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");

            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    if (categoryCurIdx == 0) {
                        System.out.println("Không có danh mục nào để hiển thị.");
                    } else {
                        System.out.println("Danh sách danh mục:");
                        for (int i = 0; i < categoryCurIdx; i++) {
                            categories[i].displayData();
                        }
                    }
                    break;
                case 2:
                    if (categoryCurIdx >= categories.length) {
                        System.out.println("Không thể thêm danh mục, mảng đã đầy!");
                    } else {
                        Category newCategory = new Category();
                        newCategory.inputData(sc);
                        categories[categoryCurIdx++] = newCategory;
                        System.out.println("Thêm danh mục thành công!");
                    }
                    break;
                case 3:
                    System.out.print("Nhập mã danh mục cần cập nhật: ");
                    int id = Integer.parseInt(sc.nextLine());
                    boolean updated = false;
                    for (int i = 0; i < categoryCurIdx; i++) {
                        if (categories[i].getCategoryId() == id) {
                            System.out.println("Cập nhật thông tin danh mục:");
                            categories[i].inputData(sc);
                            System.out.println("Cập nhật thành công!");
                            updated = true;
                            break;
                        }
                    }
                    if (!updated) {
                        System.out.println("Không tìm thấy danh mục với mã ID này!");
                    }
                    break;
                case 4:
                    System.out.print("Nhập mã danh mục cần xóa: ");
                    id = Integer.parseInt(sc.nextLine());
                    boolean deleted = false;
                    for (int i = 0; i < categoryCurIdx; i++) {
                        if (categories[i].getCategoryId() == id) {
                            System.out.println("Xóa danh mục: " + categories[i].getCategoryName());
                            for (int j = i; j < categoryCurIdx - 1; j++) {
                                categories[j] = categories[j + 1];
                            }
                            categories[categoryCurIdx - 1] = null;
                            categoryCurIdx--;
                            System.out.println("Xóa danh mục thành công!");
                            deleted = true;
                            break;
                        }
                    }
                    if (!deleted) {
                        System.out.println("Không tìm thấy danh mục để xóa!");
                    }
                    break;
                case 5:
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
                    break;
                case 6:
                    System.out.println("Thoát khỏi quản lý danh mục...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (choice != 6);
    }
}
