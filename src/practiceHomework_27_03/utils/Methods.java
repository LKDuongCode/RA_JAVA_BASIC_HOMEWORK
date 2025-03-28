package practiceHomework_27_03.utils;

import practiceHomework_27_03.Main;
import practiceHomework_27_03.entity.Product;

import java.util.*;
import java.util.function.Predicate;

public class Methods {
    static public void printMenu (String mes){
        if(mes.equals("main")){
            System.out.println("**************************MENU*************************");
            System.out.println("1. Danh sách sản phẩm");
            System.out.println("2. Thêm mới sản phẩm");
            System.out.println("3. Cập nhật sản phẩm");
            System.out.println("4. Xóa sản phẩm theo ID");
            System.out.println("5. Tìm sản phẩm theo tên");
            System.out.println("6. Lọc sản phẩm theo điều kiện ");
            System.out.println("7. Sắp xếp sản phẩm theo giá ");
            System.out.println("8. Thoát");
            System.out.println("Lựa chọn: ");
            return;
        }

        if(mes.equals("3")){
            System.out.println("Cập nhật gì?");
            System.out.println("1. name");
            System.out.println("2. price");
            System.out.println("3. category");
            System.out.println("4. <--");
            return;
        }

        if(mes.equals("6")){
            System.out.println("Điều kiện lọc?");
            System.out.println("1. Lọc sản phẩm có giá lớn hơn X");
            System.out.println("2. Lọc sản phẩm theo danh mục");
            System.out.println("3. <--");
            return;
        }

        if(mes.equals("7")){
            System.out.println("Sắp xếp theo giá?");
            System.out.println("1. Tăng");
            System.out.println("2. Giảm dần");
            System.out.println("3. <--");
            return;
        }

    }

    static public void printAllProduct (){
        System.out.println("danh sách sản phẩm: ");
        Main.products.forEach(p -> p.displayData());
    }

    static public void addProduct (Scanner sc){
        System.out.println("thêm mới sản phẩm:");
        Product newP = new Product();
        newP.inputData(sc);
        Main.products.add(newP);
        System.out.println("thêm thành công!");
    }

    static public void updateProduct (Scanner sc){
        System.out.println("id sản phẩm cần sửa?");
        int id = Integer.parseInt(sc.nextLine());
        Optional<Product> p = Main.products.stream()
                        .filter(o-> o.getId() == id).findFirst();
        if(!p.isPresent()){
                System.out.println("không thấy sản phẩm");
                return;
        }
        boolean exit = false;
        do {
            printMenu("3");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    System.out.println("new name: ");
                    String name = sc.nextLine(); // nếu được thì tách riêng validator trong Product ra
                    p.get().setName(name);
                    System.out.println("update: " + name);
                    break;
                case 2:
                    System.out.println("new price: ");
                    double price = Double.parseDouble(sc.nextLine());
                    p.get().setPrice(price);
                    System.out.println("update: " + price);
                    break;
                case 3:
                    System.out.println("new category: ");
                    String c = sc.nextLine();
                    p.get().setCategory(c);
                    System.out.println("update: " + c);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("không hợp lệ");
                    break;}
        }while(exit);
    }

    static public void deleteProduct (Scanner sc){
        System.out.println("id sản phẩm cần xóa?");
        int id = Integer.parseInt(sc.nextLine());
        Optional<Product> p = Main.products.stream()
                .filter(o-> o.getId() == id).findFirst();
        if(!p.isPresent()){
            System.out.println("không thấy sản phẩm");
            return;
        }
        Main.products.removeIf(pr -> pr.getId() == id);
        System.out.println("đã xóa " + p.get().getName());
    }

    static public void findProductByName (Scanner sc){
        System.out.println("tên sản phẩm cần tìm?");
        String findName = sc.nextLine();
        Optional<Product> p = Main.products.stream()
                .filter(o-> o.getName().equals(findName)).findFirst();
        if(!p.isPresent()){
            System.out.println("không thấy sản phẩm");
            return;
        }

        p.get().displayData();
    }

    static public List<Product> filterProduct (Scanner sc){
        List<Product> result = new ArrayList<>();
        boolean exit = false;
        do {
            printMenu("6");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice){
                case 1:
                    System.out.println("X?");
                    double x = Double.parseDouble(sc.nextLine());
                    ProductFilter priceMatch = p -> p.getPrice() > x;
                    result = Main.products.stream()
                            .filter(p -> priceMatch.checking(p)).toList();
                    System.out.println("đã lọc");
                    break;

                case 2:
                    System.out.println("category?");
                    String c = sc.nextLine();

                    if(!Main.products.stream().anyMatch(p -> p.getCategory().equals(c))){
                        System.out.println("danh mục không tồn tại");
                        break;
                    }
                    ProductFilter cateMatch = p -> p.getCategory().equals(c);

                    result = Main.products.stream()
                            .filter(p -> cateMatch.checking(p)).toList();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("không hợp lệ");
                    break;
            }

        }while(exit);

        return result;
    }

    static public void sortProduct (Scanner sc){
        List<Product> result = new ArrayList<>();
        boolean exit = false;
        do {
            printMenu("7");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    result = Main.products.stream()
                            .sorted(Comparator.comparing(p-> p.getPrice())).toList();
                break;
                case 2:
                    result = Main.products.stream()
                            .sorted(Comparator.comparing(p -> p.getPrice())).toList().reversed();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("không hợp lệ");
                    break;
            }

        }while(exit);

        result.forEach(p -> p.displayData());
    }
}
