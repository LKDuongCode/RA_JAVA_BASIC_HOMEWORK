package opp_practices.functions;

import opp_practices.entity.Product;
import java.util.Scanner;

public class ProductManagement {
    public static void manageProducts(Scanner sc) {
        Product[] products = new Product[100];
        int productCurIdx = 0;
        int choice;

        do {
            System.out.println("===== QUẢN LÝ SẢN PHẨM =====");
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
            System.out.print("Nhập lựa chọn của bạn: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    if (productCurIdx == 0) {
                        System.out.println("Không có sản phẩm nào.");
                    } else {
                        System.out.println("Danh sách sản phẩm:");
                        for (int i = 0; i < productCurIdx; i++) {
                            products[i].displayData();
                        }
                    }
                    break;

                case 2:
                    if (productCurIdx >= products.length) {
                        System.out.println("Danh sách sản phẩm đã đầy.");
                    } else {
                        Product newProduct = new Product();
                        newProduct.inputData(sc);
                        products[productCurIdx++] = newProduct;
                        System.out.println("Thêm sản phẩm thành công!");
                    }
                    break;

                case 3:
                    System.out.print("Nhập mã sản phẩm cần cập nhật: ");
                    String productId = sc.nextLine();
                    boolean updated = false;
                    for (int i = 0; i < productCurIdx; i++) {
                        if (products[i].getProductId().equals(productId)) {
                            System.out.println("Cập nhật thông tin sản phẩm:");
                            products[i].inputData(sc);
                            System.out.println("Cập nhật thành công!");
                            updated = true;
                            break;
                        }
                    }
                    if (!updated) {
                        System.out.println("Không tìm thấy sản phẩm với mã này!");
                    }
                    break;

                case 4:
                    System.out.print("Nhập mã sản phẩm cần xóa: ");
                    productId = sc.nextLine();
                    boolean deleted = false;
                    for (int i = 0; i < productCurIdx; i++) {
                        if (products[i].getProductId().equals(productId)) {
                            System.out.println("Xóa sản phẩm: " + products[i].getProductName());
                            for (int j = i; j < productCurIdx - 1; j++) {
                                products[j] = products[j + 1];
                            }
                            products[productCurIdx - 1] = null;
                            productCurIdx--;
                            System.out.println("Xóa sản phẩm thành công!");
                            deleted = true;
                            break;
                        }
                    }
                    if (!deleted) {
                        System.out.println("Không tìm thấy sản phẩm để xóa!");
                    }
                    break;

                case 5:
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
                    break;

                case 6:
                    System.out.print("Nhập giá bán tối thiểu: ");
                    float minPrice = Float.parseFloat(sc.nextLine());
                    System.out.print("Nhập giá bán tối đa: ");
                    float maxPrice = Float.parseFloat(sc.nextLine());
                    found = false;
                    for (int i = 0; i < productCurIdx; i++) {
                        if (products[i].getExportPrice() >= minPrice && products[i].getExportPrice() <= maxPrice) {
                            products[i].displayData();
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Không tìm thấy sản phẩm nào trong khoảng giá này!");
                    }
                    break;

                case 7:
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
                    for (int i = 0; i < productCurIdx; i++) {
                        products[i].displayData();
                    }
                    break;

                case 8:
                    System.out.print("Nhập mã sản phẩm cần bán: ");
                    productId = sc.nextLine();
                    System.out.print("Nhập số lượng cần bán: ");
                    int quantityToSell = Integer.parseInt(sc.nextLine());
                    boolean sold = false;
                    for (int i = 0; i < productCurIdx; i++) {
                        if (products[i].getProductId().equals(productId)) {
                            if (products[i].getQuantity() >= quantityToSell) {
                                products[i].setQuantity(products[i].getQuantity() - quantityToSell);
                                System.out.println("Bán sản phẩm thành công!");
                            } else {
                                System.out.println("Không đủ hàng để bán!");
                            }
                            sold = true;
                            break;
                        }
                    }
                    if (!sold) {
                        System.out.println("Không tìm thấy sản phẩm!");
                    }
                    break;

                case 9:
                    System.out.println("Thống kê số lượng sản phẩm theo danh mục:");

                    String[] categoryIds = new String[100];
                    int[] categoryCounts = new int[100];
                    int categoryIdx = 0;

                    for (int i = 0; i < productCurIdx; i++) {
                        String catId = products[i].getCategoryId();
                        boolean foundCat = false;

                        for (int j = 0; j < categoryIdx; j++) {
                            if (categoryIds[j].equals(catId)) {
                                categoryCounts[j]++;
                                foundCat = true;
                                break;
                            }
                        }

                        if (!foundCat) {
                            categoryIds[categoryIdx] = catId;
                            categoryCounts[categoryIdx] = 1;
                            categoryIdx++;
                        }
                    }

                    if (categoryIdx == 0) {
                        System.out.println("Không có sản phẩm nào để thống kê.");
                    } else {
                        for (int i = 0; i < categoryIdx; i++) {
                            System.out.println("Danh mục " + categoryIds[i] + ": " + categoryCounts[i] + " sản phẩm.");
                        }
                    }
                    break;

                case 10:
                    System.out.println("Thoát khỏi quản lý sản phẩm...");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (choice != 10);
    }
}
