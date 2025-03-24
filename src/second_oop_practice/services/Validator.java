package second_oop_practice.services;

import java.util.Scanner;
import second_oop_practice.entity.Product;
import second_oop_practice.entity.GlobalData;

public class Validator {
    public static String validateProductId(Scanner sc) {
        while (true) {
            String id = sc.nextLine().trim();
            if (!id.matches("^\\w{4}$")) {
                System.out.println("Mã sản phẩm phải gồm đúng 4 ký tự (chữ/số/gạch dưới). Nhập lại:");
                continue;
            }

            boolean isDuplicate = false;
            for (Product p : GlobalData.products) {
                if (p.getProductId().equals(id)) {
                    System.out.println("ID đã tồn tại. Nhập lại:");
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) return id;
        }
    }

    public static String validateProductName(Scanner sc) {
        while (true) {
            String name = sc.nextLine().trim();
            if (name.length() < 6 || name.length() > 50) {
                System.out.println("Tên sản phẩm phải từ 6 đến 50 ký tự. Nhập lại:");
                continue;
            }

            boolean isDuplicate = false;
            for (Product p : GlobalData.products) {
                if (p.getProductName().equalsIgnoreCase(name)) {
                    System.out.println("Tên sản phẩm đã tồn tại. Nhập lại:");
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) return name;
        }
    }

    public static float validateImportPrice(Scanner sc) {
        while (true) {
            try {
                float price = Float.parseFloat(sc.nextLine());
                if (price > 0) {
                    return price;
                } else {
                    System.out.println("Giá nhập phải lớn hơn 0. Nhập lại:");
                }
            } catch (Exception e) {
                System.out.println("Không đúng định dạng số. Nhập lại:");
            }
        }
    }

    public static float validateExportPrice(Scanner sc, float importPrice) {
        while (true) {
            try {
                float exportPrice = Float.parseFloat(sc.nextLine());
                if (exportPrice >= importPrice * 1.2f) {
                    return exportPrice;
                } else {
                    System.out.println("Giá xuất phải lớn hơn ít nhất 20% so với giá nhập. Nhập lại:");
                }
            } catch (Exception e) {
                System.out.println(" Không đúng định dạng số. Nhập lại:");
            }
        }
    }

    public static int validateQuantity(Scanner sc) {
        while (true) {
            try {
                int quantity = Integer.parseInt(sc.nextLine());
                if (quantity > 0) {
                    return quantity;
                } else {
                    System.out.println(" Số lượng phải lớn hơn 0. Nhập lại:");
                }
            } catch (Exception e) {
                System.out.println(" Không đúng định dạng số. Nhập lại:");
            }
        }
    }
}
