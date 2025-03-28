package practiceHomework_27_03;

import practiceHomework_27_03.entity.Product;
import practiceHomework_27_03.utils.Methods;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static AtomicInteger idCounter = new AtomicInteger(1);
    public static List<Product> products = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            int choice = Integer.parseInt(sc.nextLine());
            Methods.printMenu("main");

            switch (choice){
                case 1:
                    Methods.printAllProduct();
                    break;
                case 2:
                    Methods.addProduct(sc);
                    break;
                case 3:
                    Methods.updateProduct(sc);
                    break;
                case  4:
                    Methods.deleteProduct(sc);
                    break;
                case 5:
                    Methods.findProductByName(sc);
                    break;
                case 6:
                    Methods.filterProduct(sc).forEach(p -> p.displayData());
                    break;
                case 7:
                    Methods.sortProduct(sc);
                    break;
                case 8:
                    System.out.println("thoát...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("không hợp lệ");
                    break;
            }
        }while(true);
    }
}
