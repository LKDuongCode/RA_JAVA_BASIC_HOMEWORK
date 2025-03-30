package homeworks_28_3_exceptions.hw10;

import java.util.List;
import java.util.Scanner;

public class Methods {
    public static void printMenu (){
        System.out.println("menu===");
        System.out.println("1. Xem danh sách sản phẩm");
        System.out.println("2. Thêm sản phẩm vào giỏ");
        System.out.println("3. Xóa sản phẩm khỏi giỏ");
        System.out.println("4. Xem giỏ hàng");
        System.out.println("5. Hiển thị tổng tiền");
        System.out.println("0. Kết thúc.");
        System.out.print("Lựa chọn của bạn: ");
    }

    public static void exitProgram (Scanner sc){
        sc.close();
        System.out.println("thoát chương trình.");
        System.exit(0);
    }

    public static void addNewItem (Scanner sc){
        System.out.print("nhập id sản phẩm : ");
        String id = sc.nextLine();

        System.out.print("nhập tên sản phẩm: ");
        String name = sc.nextLine();

        System.out.print("nhập giá sản phẩm: ");
        double price = Double.parseDouble(sc.nextLine());

        System.out.print("nhập số lượng sản phẩm: ");
        int quantity = getValidQuantity(sc);

        Product p = new Product(id,name,price);
        Item item = new Item(p,quantity);

        Main.availableItems.add(item);
        System.out.println("thêm thành công " + name + " | quantity " + quantity);
    }

    public static void printItems (List<Item> items){
        System.out.printf("%-5s | %-30s | %-8s | %-8s \n", "ID","NAME","PRICE","QUANTITY");
        System.out.println("-------------------------------------------------------------");
        items.forEach(i -> {
            System.out.printf("%-5s | %-30s | %-8.3f | %-8d \n", i.getProduct().getId(), i.getProduct().getName(), i.getProduct().getPrice(), i.getQuantity());
        });
    }

    public static boolean checkingExistItem (List<Item> items, String id){
        return items.stream().anyMatch(i -> i.getProduct().getId().equals(id));
    }

    public static int getValidQuantity(Scanner sc) {
        while (true) {
            try {
                int quantity = Integer.parseInt(sc.nextLine());
                if (quantity <= 0) {
                    Main.logger.warning("số lượng cần lớn hơn 0.");
                } else {
                    return quantity;
                }
            } catch (NumberFormatException e) {
                Main.logger.warning("hãy nhập số nguyên hợp lệ.");
            }
        }
    }

}
