package homeworks_28_3_exceptions.hw10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cart {
    public static List<Item> carts  = new ArrayList<>();

    public static void addToCart (Scanner sc){
        System.out.println("nhập id sản phẩm bạn muốn thêm vào giỏ:");
        String id = sc.nextLine();

        System.out.println("số lượng muốn thêm vào giỏ:");
        int quantity = Methods.getValidQuantity(sc);

        if(Methods.checkingExistItem(Main.availableItems,id)) throw new IllegalArgumentException("sản phẩm không tồn tại");

        if(Methods.checkingExistItem(carts,id)) {
            Item item = carts.stream().filter(i -> i.getProduct().getId().equals(id)).findFirst().get();
            item.setQuantity((item.getQuantity()) + quantity);
            System.out.println("đã có trong giỏ +" + quantity + " sản phẩm nữa!");
            return;
        }

        Item item = Main.availableItems.stream().filter(i -> i.getProduct().getId().equals(id)).findFirst().get();
        item.setQuantity(1);

        carts.add(item);
        System.out.println("thêm sản phẩm " + item.getProduct().getName() + " vào giỏ thành công!");
    }

    public static void removeFromCart (Scanner sc){
        boolean exit = false;
        while (!exit){
            System.out.println("nhập id sản phẩm bạn muốn xóa khỏi giỏ:");
            String id = sc.nextLine();

            try {
                if(!Methods.checkingExistItem(carts,id)) {
                    throw new IllegalArgumentException("trong giỏ không có sản phẩm này!");
                }else {
                    carts.removeIf(i -> i.getProduct().getId().equals(id));
                    System.out.println("xóa thành công sản phẩm.");
                    exit = true;
                }
            }catch (IllegalArgumentException e){
                Main.logger.warning(e.getMessage());
            }
        }
    }

    public static void displayCart (){
        System.out.println("giỏ hàng hiện tại: ");
        Methods.printItems(carts);
    }

    public static void checkout (){
        System.out.println(
                carts.stream()
                        .mapToDouble(i -> i.getProduct().getPrice()* i.getQuantity()).sum()
        );
    }
}
