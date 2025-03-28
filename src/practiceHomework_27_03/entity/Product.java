package practiceHomework_27_03.entity;

import practiceHomework_27_03.Main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Product implements IProduct{
    private int id;
    private String name;
    private double price;
    private String category;
    private LocalDate createdDate;

    public Product() {
        this.id = Main.idCounter.incrementAndGet();
    }

    public Product(String name, double price, String category, LocalDate createdDate) {
        this.id = Main.idCounter.incrementAndGet();
        this.name = name;
        this.price = price;
        this.category = category;
        this.createdDate = createdDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public void inputData(Scanner sc) {
        setId(Main.idCounter.incrementAndGet());

        System.out.println("nhập tên hàng:");
        String name;
        while(true){
            name = sc.nextLine();
            String nameCondition = name;
            if(name.length() >= 30 && name.length() <= 100 && !Main.products.stream().anyMatch(p -> p.getName().equals(nameCondition))) {
                setName(name);
                break;
            }
            System.out.println("tên trùng hoặc không hợp lệ");
        }

        System.out.println("nhập giá hàng:");
        double price;
        while(true){
            price = Double.parseDouble(sc.nextLine());
            if(price > 0){
                setPrice(price);
                break;
            }
            System.out.println("giá cần lớn hơn 0");
        }

        System.out.println("nhập danh mục:");
        String cate = sc.nextLine();
        setCategory(cate.trim().length() != 0 ? cate : "chưa có");

        LocalDate cur = LocalDate.now();
        System.out.println("thời gian tạo: " + formatDate(cur));
    }

    @Override
    public void displayData() {
        System.out.println("id = " + " | name = " + " | price = " + " | category = " + " | created = " + formatDate(this.createdDate));
    }

    public static String formatDate (LocalDate date){
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(f);
    }


}
