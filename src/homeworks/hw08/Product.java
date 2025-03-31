package homeworks.hw08;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("ID: %-3d | Tên: %-20s | Giá: %,.1f VND", id, name, price);
    }
}
