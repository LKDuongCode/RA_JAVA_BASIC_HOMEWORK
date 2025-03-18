package opp_practices.entity;

import java.util.Scanner;

public class Category implements IApp {
    static String[] categoryNames = new String[100];
    static int nameCount = 0;
    static int autoIncrementId = 1;

     int categoryId;
     String categoryName;
     int priority;
     String description;
     boolean categoryStatus;

    public Category() {
    }

    public Category(String categoryName, int priority, String description, boolean categoryStatus) {
        this.categoryId = autoIncrementId++;
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
        if (categoryName == null || categoryName.length() < 6 || categoryName.length() > 50) {
            throw new IllegalArgumentException("Tên danh mục phải có từ 6 đến 50 ký tự.");
        }
        if (isDuplicateCategoryName(categoryName)) {
            throw new IllegalArgumentException("Tên danh mục đã tồn tại.");
        }

        if (nameCount < categoryNames.length) {
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
        System.out.print("Nhập tên danh mục: ");
        while (true) {
            try {
                setCategoryName(sc.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Vui lòng nhập lại: ");
            }
        }

        System.out.print("Nhập độ ưu tiên: ");
        while (true) {
            try {
                setPriority(Integer.parseInt(sc.nextLine()));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập lại: ");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Vui lòng nhập lại: ");
            }
        }

        System.out.print("Nhập mô tả danh mục: ");
        setDescription(sc.nextLine());

        System.out.print("Trạng thái danh mục: ");
        this.categoryStatus = Boolean.parseBoolean(sc.nextLine());
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

     public boolean isDuplicateCategoryName(String name) {
        for (int i = 0; i < nameCount; i++) {
            if (categoryNames[i].equals(name)) {
                return true;
            }
        }
        return false;
    }
}
