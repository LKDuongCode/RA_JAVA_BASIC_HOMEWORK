package homeworks_28_3_exceptions.hw10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    public static final Logger logger = Logger.getLogger(Main.class.getName());
    public static List<Item> availableItems = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("sản phẩm có sẵn");
        for (int i = 0; i < 3 ; i++){
            Methods.addNewItem(sc);
        }

        Methods.printItems(availableItems);
        do {
            Methods.printMenu();
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    System.out.println("danh sách sẵn có:");
                    Methods.printItems(availableItems);
                    break;
                case 2:
                    Cart.addToCart(sc);
                    break;
                case 3:
                    Cart.removeFromCart(sc);
                    break;
                case 4:
                    Cart.displayCart();
                    break;
                case 5:
                    Cart.checkout();
                    break;
                case 0:
                    Methods.exitProgram(sc);
                default:
                    System.out.println("lựa chọn không hợp lệ, vui lòng chọn lại.");
                    break;
            }
        }while(true);
    }
}
