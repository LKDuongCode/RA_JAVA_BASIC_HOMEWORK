package refactoringByGPT.services;

import refactoringByGPT.entity.Product;
import java.util.Scanner;

public class ProductManagement {
    private static final int MAX_PRODUCTS = 100;
    private static final Product[] products = new Product[MAX_PRODUCTS];
    private static int productCurIdx = 0;

    public static void manageProducts(Scanner sc) {
        int choice;

        do {
            displayMenu();
            choice = getValidIntegerInput(sc, "Nhập lựa chọn của bạn: ");

            switch (choice) {
                case 1 -> listProducts();
                case 2 -> addProduct(sc);
                case 3 -> updateProduct(sc);
                case 4 -> deleteProduct(sc);
                case 5 -> searchProductByNameOrTitle(sc);
                case 6 -> searchProductByPriceRange(sc);
                case 7 -> sortProductsByPrice();
                case 8 -> sellProduct(sc);
                case 9 -> countProductsByCategory();
                case 10 -> System.out.println("Thoát khỏi quản lý sản phẩm...");
                default -> System.out.println("Lựa chọn không hợp lệ");
            }
        } while (choice != 10);
    }

    private static void displayMenu() {
        System.out.println("\n===== QUẢN LÝ SẢN PHẨM =====");
        System.out.println("1. Danh sách sản phẩm");
        System.out.println("2. Thêm mới sản phẩm");
        System.out.println("3. Cập nhật sản phẩm");
        System.out.println("4. Xóa sản phẩm");
        System.out.println("5. Tìm kiếm sản phẩm theo tên hoặc tiêu đề");
        System.out.println("6. Tìm kiếm sản phẩm theo khoảng giá bán");
        System.out.println("7. Sắp xếp sản phẩm theo giá bán tăng dần");
        System.out.println("8. Bán sản phẩm");
        System.out.println("9. Thống kê số lượng sản phẩm theo danh mục");
        System.out.println("10. Thoát");
    }

    private static void listProducts() {
        if (productCurIdx == 0) {
            System.out.println("Không có sản phẩm nào.");
        } else {
            System.out.println("Danh sách sản phẩm:");
            for (int i = 0; i < productCurIdx; i++) {
                products[i].displayData();
            }
        }
    }

    private static void addProduct(Scanner sc) {
        if (productCurIdx >= MAX_PRODUCTS) {
            System.out.println("Danh sách sản phẩm đã đầy.");
            return;
        }
        Product newProduct = new Product();
        newProduct.inputData(sc);
        products[productCurIdx++] = newProduct;
        System.out.println("Thêm sản phẩm thành công!");
    }

    private static void updateProduct(Scanner sc) {
        System.out.print("Nhập mã sản phẩm cần cập nhật: ");
        String productId = sc.nextLine();
        for (int i = 0; i < productCurIdx; i++) {
            if (products[i].getProductId().equals(productId)) {
                System.out.println("Cập nhật thông tin sản phẩm:");
                products[i].inputData(sc);
                System.out.println("Cập nhật thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm với mã này!");
    }

    private static void deleteProduct(Scanner sc) {
        System.out.print("Nhập mã sản phẩm cần xóa: ");
        String productId = sc.nextLine();
        for (int i = 0; i < productCurIdx; i++) {
            if (products[i].getProductId().equals(productId)) {
                System.out.println("Xóa sản phẩm: " + products[i].getProductName());
                System.arraycopy(products, i + 1, products, i, productCurIdx - i - 1);
                products[--productCurIdx] = null;
                System.out.println("Xóa sản phẩm thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm để xóa!");
    }

    private static void searchProductByNameOrTitle(Scanner sc) {
        System.out.print("Nhập tên hoặc tiêu đề sản phẩm cần tìm: ");
        String keyword = sc.nextLine().toLowerCase();
        boolean found = false;
        for (int i = 0; i < productCurIdx; i++) {
            if (products[i].getProductName().toLowerCase().contains(keyword) ||
                    (products[i].getTitle() != null && products[i].getTitle().toLowerCase().contains(keyword))) {
                products[i].displayData();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sản phẩm nào!");
        }
    }

    private static void searchProductByPriceRange(Scanner sc) {
        float minPrice = getValidFloatInput(sc, "Nhập giá bán tối thiểu: ");
        float maxPrice = getValidFloatInput(sc, "Nhập giá bán tối đa: ");
        boolean found = false;
        for (int i = 0; i < productCurIdx; i++) {
            if (products[i].getExportPrice() >= minPrice && products[i].getExportPrice() <= maxPrice) {
                products[i].displayData();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sản phẩm nào trong khoảng giá này!");
        }
    }

    private static void sortProductsByPrice() {
        for (int i = 0; i < productCurIdx - 1; i++) {
            for (int j = i + 1; j < productCurIdx; j++) {
                if (products[i].getExportPrice() > products[j].getExportPrice()) {
                    Product temp = products[i];
                    products[i] = products[j];
                    products[j] = temp;
                }
            }
        }
        System.out.println("Danh sách sau khi sắp xếp:");
        listProducts();
    }

    private static void sellProduct(Scanner sc) {
        System.out.print("Nhập mã sản phẩm cần bán: ");
        String productId = sc.nextLine();
        int quantityToSell = getValidIntegerInput(sc, "Nhập số lượng cần bán: ");
        for (int i = 0; i < productCurIdx; i++) {
            if (products[i].getProductId().equals(productId)) {
                if (products[i].getQuantity() >= quantityToSell) {
                    products[i].setQuantity(products[i].getQuantity() - quantityToSell);
                    System.out.println("Bán sản phẩm thành công!");
                } else {
                    System.out.println("Không đủ hàng để bán!");
                }
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm!");
    }

    private static void countProductsByCategory() {
        System.out.println("Thống kê số lượng sản phẩm theo danh mục:");
        String[] categoryIds = new String[MAX_PRODUCTS];
        int[] categoryCounts = new int[MAX_PRODUCTS];
        int categoryIdx = 0;

        for (int i = 0; i < productCurIdx; i++) {
            String catId = products[i].getCategoryId();
            boolean found = false;
            for (int j = 0; j < categoryIdx; j++) {
                if (categoryIds[j].equals(catId)) {
                    categoryCounts[j]++;
                    found = true;
                    break;
                }
            }
            if (!found) {
                categoryIds[categoryIdx] = catId;
                categoryCounts[categoryIdx++] = 1;
            }
        }

        for (int i = 0; i < categoryIdx; i++) {
            System.out.println("Danh mục " + categoryIds[i] + ": " + categoryCounts[i] + " sản phẩm.");
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

    private static float getValidFloatInput(Scanner sc, String message) {
        while (true) {
            try {
                System.out.print(message);
                return Float.parseFloat(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số thực hợp lệ.");
            }
        }
    }
}
