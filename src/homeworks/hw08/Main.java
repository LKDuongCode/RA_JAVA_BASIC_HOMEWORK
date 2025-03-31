package homeworks.hw08;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(101, "Laptop Asus", 15000000));
        products.add(new Product(102, "Chuột Logitech", 500000));
        products.add(new Product(103, "Bàn phím Razer", 2000000));
        products.add(new Product(104, "Tai nghe Sony", 1200000));

        String scr = "src/homeworks/hw08/products.dat";
        
        checkAndCreateFileIfNotExists(scr);
        
        writeProductsToFile(scr, products);
        
        List<Product> readProducts = readProductsFromFile(scr);

        System.out.println("Danh sách sản phẩm:");
        readProducts.forEach(System.out::println);
    }

    static void checkAndCreateFileIfNotExists(String path) {
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
            } else {
                System.out.println("đã tồn tại.");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static void writeProductsToFile(String path, List<Product> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(list);
            System.out.println("Đã ghi danh sách sản phẩm vào file.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static List<Product> readProductsFromFile(String path) {
        List<Product> list = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            list = (List<Product>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
