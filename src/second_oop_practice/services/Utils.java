package second_oop_practice.services;

import second_oop_practice.entity.GlobalData;
import second_oop_practice.entity.Product;

import java.util.*;

public class Utils {

    public static void printMenu() {
        System.out.println("*********************MENU******************");
        System.out.println("1. Nhập thông tin n sản phẩm");
        System.out.println("2. Hiển thị thông tin các sản phẩm");
        System.out.println("3. Tính lợi nhuận các sản phẩm");
        System.out.println("4. Sắp xếp các sản phẩm theo lợi nhuận giảm dần");
        System.out.println("5. Thống kê các sản phẩm theo giá");
        System.out.println("6. Tìm các sản phẩm theo tên");
        System.out.println("7. Nhập sản phẩm (tăng số lượng)");
        System.out.println("8. Bán sản phẩm (giảm số lượng)");
        System.out.println("9. Cập nhật trạng thái sản phẩm");
        System.out.println("10. Thoát");
        System.out.println("*******************************************");
    }

    public static void addProduct(Scanner sc) {
        System.out.print("Nhập ID: ");
        String id = Validator.validateProductId(sc);

        System.out.print("Nhập tên sản phẩm: ");
        String name = Validator.validateProductName(sc);

        System.out.print("Nhập giá nhập: ");
        float importPrice = Validator.validateImportPrice(sc);

        System.out.print("Nhập giá xuất: ");
        float exportPrice = Validator.validateExportPrice(sc, importPrice);

        System.out.print("Nhập số lượng: ");
        int quantity = Validator.validateQuantity(sc);

        System.out.print("Nhập mô tả: ");
        String desc = sc.nextLine();

        System.out.print("Sản phẩm còn hàng không (true/false): ");
        boolean status = Boolean.parseBoolean(sc.nextLine());

        GlobalData.products.add(new Product(id, name, importPrice, exportPrice, quantity, desc, status));
        System.out.println(" Thêm sản phẩm thành công!");
    }

    public static void printAllProducts() {
        for (Product p : GlobalData.products) {
            System.out.println("ID: " + p.getProductId() + " | Name: " + p.getProductName() +
                    " | Giá nhập: " + p.getImportPrice() +
                    " | Giá xuất: " + p.getExportPrice() +
                    " | Số lượng: " + p.getQuantity() +
                    " | Profit: " + p.getProfit() +
                    " | Status: " + (p.isStatus() ? "Còn hàng" : "Hết hàng"));
        }
    }

    public static void sortByProfitDesc() {
        List<Product> list = new ArrayList<>(GlobalData.products);
        list.sort(Comparator.comparing(Product::getProfit).reversed());
        list.forEach(p -> System.out.println(p.getProductName() + " - Profit: " + p.getProfit()));
    }

    public static void countProductByPrice() {
        List<Float> priceList = new ArrayList<>();
        for (Product p : GlobalData.products) {
            float price = p.getExportPrice();
            if (!priceList.contains(price)) {
                priceList.add(price);
            }
        }

        for (float price : priceList) {
            int count = 0;
            for (Product p : GlobalData.products) {
                if (p.getExportPrice() == price) {
                    count++;
                }
            }
            System.out.println("Giá " + price + ": " + count + " sản phẩm");
        }
    }

    public static void searchProductByName(Scanner sc) {
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String name = sc.nextLine();
        boolean found = false;

        for (Product p : GlobalData.products) {
            if (p.getProductName().equalsIgnoreCase(name)) {
                System.out.println("Tìm thấy: " + p.getProductId() + " | " + p.getProductName());
                found = true;
            }
        }

        if (!found) System.out.println(" Không tìm thấy sản phẩm nào.");
    }

    public static void importProduct(Scanner sc) {
        System.out.print("Nhập ID sản phẩm cần nhập thêm: ");
        String id = sc.nextLine();
        for (Product p : GlobalData.products) {
            if (p.getProductId().equals(id)) {
                System.out.print("Nhập số lượng muốn thêm: ");
                int addQty = Integer.parseInt(sc.nextLine());
                p.setQuantity(p.getQuantity() + addQty);
                System.out.println("Nhập hàng thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm!");
    }

    public static void sellProduct(Scanner sc) {
        System.out.print("Nhập ID sản phẩm muốn bán: ");
        String id = sc.nextLine();
        for (Product p : GlobalData.products) {
            if (p.getProductId().equals(id)) {
                System.out.print("Nhập số lượng muốn bán: ");
                int sellQty = Integer.parseInt(sc.nextLine());
                if (sellQty <= p.getQuantity()) {
                    p.setQuantity(p.getQuantity() - sellQty);
                    System.out.println("Bán thành công!");
                } else {
                    System.out.println("Không đủ hàng để bán!");
                }
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm!");
    }

    public static void updateStatus(Scanner sc) {
        System.out.print("Nhập ID sản phẩm cần cập nhật trạng thái: ");
        String id = sc.nextLine();
        for (Product p : GlobalData.products) {
            if (p.getProductId().equals(id)) {
                System.out.print("Nhập trạng thái mới (true/false): ");
                boolean status = Boolean.parseBoolean(sc.nextLine());
                p.setStatus(status);
                System.out.println("Cập nhật trạng thái thành công!");
                return;
            }
        }
        System.out.println(" Không tìm thấy sản phẩm!");
    }
}
