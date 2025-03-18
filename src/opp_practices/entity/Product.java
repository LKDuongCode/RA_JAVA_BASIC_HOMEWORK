package opp_practices.entity;

import java.util.Scanner;

public class Product implements IApp {
     static String[] productIds = new String[100];
     static String[] productNames = new String[100];
     static int productCount = 0;

     String productId;
     String productName;
     float importPrice;
     float exportPrice;
     String title;
     String description;
     int quantity;
     String categoryId;
     int productStatus;

    public Product() {
    }

    public Product(String productId, String productName, float importPrice, float exportPrice,
                   String title, String description, int quantity, String categoryId, int productStatus) {
        setProductId(productId);
        setProductName(productName);
        setImportPrice(importPrice);
        setExportPrice(exportPrice);
        setTitle(title);
        setDescription(description);
        this.quantity = quantity;
        this.categoryId = categoryId;
        setProductStatus(productStatus);
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        if (productId == null || productId.length() != 5 || !productId.matches("[CET].{4}")) {
            throw new IllegalArgumentException("Mã sản phẩm phải có 5 ký tự và bắt đầu bằng C, E hoặc T.");
        }

        if (isDuplicateProductId(productId)) {
            throw new IllegalArgumentException("Mã sản phẩm đã tồn tại.");
        }

        if (productCount < productIds.length) {
            productIds[productCount] = productId;
        } else {
            throw new IllegalArgumentException("Danh sách mã sản phẩm đã đầy.");
        }
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        if (productName == null || productName.length() < 10 || productName.length() > 100) {
            throw new IllegalArgumentException("Tên sản phẩm phải có từ 10 đến 100 ký tự.");
        }
        if (isDuplicateProductName(productName)) {
            throw new IllegalArgumentException("Tên sản phẩm đã tồn tại.");
        }
        if (productCount < productNames.length) {
            productNames[productCount++] = productName;
        } else {
            throw new IllegalArgumentException("Danh sách tên sản phẩm đã đầy.");
        }
        this.productName = productName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        if (importPrice <= 0) {
            throw new IllegalArgumentException("Giá nhập phải lớn hơn 0.");
        }
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        if (exportPrice < importPrice * INTEREST) {
            throw new IllegalArgumentException("Giá xuất phải lớn hơn giá nhập nhân với INTEREST.");
        }
        this.exportPrice = exportPrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title != null && title.length() > 200) {
            throw new IllegalArgumentException("Tiêu đề không được vượt quá 200 ký tự.");
        }
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        if (productStatus < 0 || productStatus > 2) {
            throw new IllegalArgumentException("Trạng thái sản phẩm chỉ có thể là 0 (Đang hoạt động), 1 (Hết hàng), hoặc 2 (Không hoạt động).");
        }
        this.productStatus = productStatus;
    }

    @Override
    public void inputData(Scanner sc) {
        System.out.print("Nhập mã sản phẩm: ");
        while (true) {
            try {
                setProductId(sc.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Vui lòng nhập lại: ");
            }
        }

        System.out.print("Nhập tên sản phẩm: ");
        while (true) {
            try {
                setProductName(sc.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Vui lòng nhập lại: ");
            }
        }

        System.out.print("Nhập giá nhập sản phẩm: ");
        while (true) {
            try {
                setImportPrice(Float.parseFloat(sc.nextLine()));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Giá nhập phải là một số thực. Vui lòng nhập lại: ");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Vui lòng nhập lại: ");
            }
        }

        System.out.print("Nhập giá xuất sản phẩm: ");
        while (true) {
            try {
                setExportPrice(Float.parseFloat(sc.nextLine()));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Giá xuất phải là một số thực. Vui lòng nhập lại: ");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Vui lòng nhập lại: ");
            }
        }

        System.out.print("Nhập tiêu đề sản phẩm: ");
        setTitle(sc.nextLine());

        System.out.print("Nhập mô tả sản phẩm: ");
        setDescription(sc.nextLine());

        System.out.print("Nhập số lượng sản phẩm: ");
        setQuantity(Integer.parseInt(sc.nextLine()));

        System.out.print("Nhập mã danh mục sản phẩm thuộc về: ");
        setCategoryId(sc.nextLine());

        System.out.print("Nhập trạng thái sản phẩm (0: Đang hoạt động, 1: Hết hàng, 2: Không hoạt động): ");
        setProductStatus(Integer.parseInt(sc.nextLine()));
    }

    @Override
    public void displayData() {
        System.out.println("Mã sản phẩm: " + productId);
        System.out.println("Tên sản phẩm: " + productName);
        System.out.println("Giá nhập: " + importPrice);
        System.out.println("Giá xuất: " + exportPrice);
        System.out.println("Tiêu đề: " + (title != null ? title : "Không có"));
        System.out.println("Mô tả: " + (description != null ? description : "Không có"));
        System.out.println("Số lượng: " + quantity);
        System.out.println("Mã danh mục: " + categoryId);
        System.out.println("Trạng thái: " + (productStatus == 0 ? "Đang hoạt động" : (productStatus == 1 ? "Hết hàng" : "Không hoạt động")));
        System.out.println("--------------------------\n");
    }

    public boolean isDuplicateProductId(String id) {
        for (String existingId : productIds) {
            if (id.equals(existingId)) {
                return true;
            }
        }
        return false;
    }

    public boolean isDuplicateProductName(String name) {
        for (String existingName : productNames) {
            if (name.equals(existingName)) {
                return true;
            }
        }
        return false;
    }
}
