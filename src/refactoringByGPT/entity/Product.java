package refactoringByGPT.entity;

import java.util.Scanner;

public class Product implements IApp {
    private static final int MAX_PRODUCTS = 100;
    private static final String[] productIds = new String[MAX_PRODUCTS];
    private static final String[] productNames = new String[MAX_PRODUCTS];
    private static int productCount = 0;

    private String productId;
    private String productName;
    private float importPrice;
    private float exportPrice;
    private String title;
    private String description;
    private int quantity;
    private String categoryId;
    private int productStatus;

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
        validateProductId(productId);
        if (isDuplicate(productIds, productId, productCount)) {
            throw new IllegalArgumentException("Mã sản phẩm đã tồn tại.");
        }
        if (productCount < MAX_PRODUCTS) {
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
        validateProductName(productName);
        if (isDuplicate(productNames, productName, productCount)) {
            throw new IllegalArgumentException("Tên sản phẩm đã tồn tại.");
        }
        if (productCount < MAX_PRODUCTS) {
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
        productId = inputString(sc, "Nhập mã sản phẩm: ", this::setProductId);
        productName = inputString(sc, "Nhập tên sản phẩm: ", this::setProductName);
        importPrice = inputFloat(sc, "Nhập giá nhập sản phẩm: ", this::setImportPrice);
        exportPrice = inputFloat(sc, "Nhập giá xuất sản phẩm: ", this::setExportPrice);
        System.out.print("Nhập tiêu đề sản phẩm: ");
        setTitle(sc.nextLine());
        System.out.print("Nhập mô tả sản phẩm: ");
        setDescription(sc.nextLine());
        quantity = inputInteger(sc, "Nhập số lượng sản phẩm: ", this::setQuantity);
        categoryId = inputString(sc, "Nhập mã danh mục sản phẩm thuộc về: ", this::setCategoryId);
        productStatus = inputInteger(sc, "Nhập trạng thái sản phẩm (0: Đang hoạt động, 1: Hết hàng, 2: Không hoạt động): ", this::setProductStatus);
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
        System.out.println("Trạng thái: " + getStatusString(productStatus));
        System.out.println("--------------------------\n");
    }

    private boolean isDuplicate(String[] array, String value, int count) {
        for (int i = 0; i < count; i++) {
            if (array[i].equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }

    private void validateProductId(String productId) {
        if (productId == null || productId.length() != 5 || !productId.matches("[CET].{4}")) {
            throw new IllegalArgumentException("Mã sản phẩm phải có 5 ký tự và bắt đầu bằng C, E hoặc T.");
        }
    }

    private void validateProductName(String productName) {
        if (productName == null || productName.length() < 10 || productName.length() > 100) {
            throw new IllegalArgumentException("Tên sản phẩm phải có từ 10 đến 100 ký tự.");
        }
    }

    private String getStatusString(int status) {
        return switch (status) {
            case 0 -> "Đang hoạt động";
            case 1 -> "Hết hàng";
            case 2 -> "Không hoạt động";
            default -> "Không xác định";
        };
    }

    private String inputString(Scanner sc, String message, java.util.function.Consumer<String> setter) {
        while (true) {
            try {
                System.out.print(message);
                String input = sc.nextLine();
                setter.accept(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Vui lòng nhập lại.");
            }
        }
    }

    private float inputFloat(Scanner sc, String message, java.util.function.Consumer<Float> setter) {
        while (true) {
            try {
                System.out.print(message);
                float input = Float.parseFloat(sc.nextLine());
                setter.accept(input);
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số thực hợp lệ.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Vui lòng nhập lại.");
            }
        }
    }

    private int inputInteger(Scanner sc, String message, java.util.function.IntConsumer setter) {
        while (true) {
            try {
                System.out.print(message);
                int input = Integer.parseInt(sc.nextLine());
                setter.accept(input);
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên hợp lệ.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Vui lòng nhập lại.");
            }
        }
    }
}
