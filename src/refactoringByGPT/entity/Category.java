package refactoringByGPT.entity;
import java.util.Scanner;

public class Category implements IApp {
    private static final int MAX_CATEGORIES = 100;
    private static final String[] categoryNames = new String[MAX_CATEGORIES];
    private static int nameCount = 0;
    private static int autoIncrementId = 1;

    private int categoryId;
    private String categoryName;
    private int priority;
    private String description;
    private boolean categoryStatus;

    public Category() {
        this.categoryId = autoIncrementId++;
    }

    public Category(String categoryName, int priority, String description, boolean categoryStatus) {
        this();
        setCategoryName(categoryName);
        setPriority(priority);
        setDescription(description);
        this.categoryStatus = categoryStatus;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        validateCategoryName(categoryName);
        if (isDuplicateCategoryName(categoryName)) {
            throw new IllegalArgumentException("Tên danh mục đã tồn tại.");
        }
        if (nameCount < MAX_CATEGORIES) {
            categoryNames[nameCount++] = categoryName;
        } else {
            throw new IllegalArgumentException("Danh mục đã đầy.");
        }
        this.categoryName = categoryName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        if (priority < 0) {
            throw new IllegalArgumentException("Độ ưu tiên không thể là số âm.");
        }
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description != null && description.length() > 255) {
            throw new IllegalArgumentException("Không được vượt quá 255 ký tự.");
        }
        this.description = description;
    }

    public boolean isCategoryStatus() {
        return categoryStatus;
    }

    public void setCategoryStatus(boolean categoryStatus) {
        this.categoryStatus = categoryStatus;
    }

    @Override
    public void inputData(Scanner sc) {
        categoryName = inputString(sc, "Nhập tên danh mục: ", this::setCategoryName);
        priority = inputInteger(sc, "Nhập độ ưu tiên: ", this::setPriority);
        System.out.print("Nhập mô tả danh mục: ");
        setDescription(sc.nextLine());
        System.out.print("Trạng thái danh mục (true/false): ");
        setCategoryStatus(Boolean.parseBoolean(sc.nextLine()));
    }

    @Override
    public void displayData() {
        System.out.println("Mã danh mục: " + categoryId);
        System.out.println("Tên danh mục: " + categoryName);
        System.out.println("Độ ưu tiên: " + priority);
        System.out.println("Mô tả: " + (description != null ? description : "Không có"));
        System.out.println("Trạng thái: " + (categoryStatus ? "Hoạt động" : "Không hoạt động"));
        System.out.println("--------------------------\n");
    }

    private boolean isDuplicateCategoryName(String name) {
        for (int i = 0; i < nameCount; i++) {
            if (categoryNames[i].equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    private void validateCategoryName(String name) {
        if (name == null || name.length() < 6 || name.length() > 50) {
            throw new IllegalArgumentException("Tên danh mục phải có từ 6 đến 50 ký tự.");
        }
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

    private int inputInteger(Scanner sc, String message, java.util.function.IntConsumer setter) {
        while (true) {
            try {
                System.out.print(message);
                int input = Integer.parseInt(sc.nextLine());
                setter.accept(input);
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Vui lòng nhập lại.");
            }
        }
    }
}
