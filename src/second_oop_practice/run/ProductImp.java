package second_oop_practice.run;

import second_oop_practice.services.Utils;

import java.util.Scanner;

public class ProductImp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            Utils.printMenu();
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng sản phẩm: ");
                    int n = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < n; i++) {
                        System.out.println("Sản phẩm thứ " + (i + 1));
                        Utils.addProduct(sc);
                    }
                    break;
                case 2:
                    Utils.printAllProducts();
                    break;
                case 3:
                    System.out.println("Lợi nhuận đã tính sẵn khi thêm.");
                    break;
                case 4:
                    Utils.sortByProfitDesc();
                    break;
                case 5:
                    Utils.countProductByPrice();
                    break;
                case 6:
                    Utils.searchProductByName(sc);
                    break;
                case 7:
                    Utils.importProduct(sc);
                    break;
                case 8:
                    Utils.sellProduct(sc);
                    break;
                case 9:
                    Utils.updateStatus(sc);
                    break;
                case 10:
                    System.out.println("Thoát chương trình.");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (true);
    }
}
