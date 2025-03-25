package hw09;

import java.util.Scanner;

public class Methods {
    public static void printMenu (){
        System.out.println("-----menu-----");
        System.out.println("1. thêm sản phẩm mới");
        System.out.println("2. cập nhật số lượng");
        System.out.println("3. cập nhật giá");
        System.out.println("4. xóa 1 ");
        System.out.println("5. tổng giá trị");
        System.out.println("0. thoát");
        System.out.println("lựa chọn của bạn: ");
    }

    public static void addProduct (Scanner sc){
        System.out.println("nhập thông tin sản phẩm mới");

        System.out.println("name: ");
        String name = sc.nextLine();

        System.out.println("price:");
        double price = Double.parseDouble(sc.nextLine());

        System.out.println("quantity:");
        int quantity = Integer.parseInt(sc.nextLine());

        Product newProduct = new Product(GlobalData.countID++,name,price,quantity);
        GlobalData.products.put(newProduct.getId(), newProduct);
        System.out.println("thêm thành công");
    }

    public static void editProduct (Scanner sc, String mes){
        int id = searchProductByID(sc);
        if(mes == "quantity"){
            for (int key : GlobalData.products.keySet()){
                if(key == id){
                    System.out.println("nhập số lượng cần sửa.");
                    int quantity = Integer.parseInt(sc.nextLine());
                    GlobalData.products.get(key).setQuantity(quantity);
                }
            }
            return;
        }

        if(mes == "price"){
            for (int key : GlobalData.products.keySet()){
                if(key == id){
                    System.out.println("nhập giá cần sửa.");
                    double price = Double.parseDouble(sc.nextLine());
                    GlobalData.products.get(key).setPrice(price);
                }
            }
            return;
        }
    }

    public static int searchProductByID (Scanner sc){
        while (true){
            int id = Integer.parseInt(sc.nextLine());
            for (int key : GlobalData.products.keySet()){
                if(key == id){
                    return id;
                }
            }
            System.out.println("không thấy id, nhập lại: ");
        }
    }

    public static void deleteProduct (Scanner sc){
        int id = searchProductByID(sc);
        GlobalData.products.remove(id);
    }

    public static void calTotalPrice (){
        double total = 0;
        for (Product p : GlobalData.products.values()){
            total += (p.getPrice()*p.getQuantity());
        }
        System.out.println(total);
    }
}
