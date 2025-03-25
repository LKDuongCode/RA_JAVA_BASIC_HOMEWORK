package hw09;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            Methods.printMenu();
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    Methods.addProduct(sc);
                    break;
                case 2:
                    Methods.editProduct(sc,"quantity");
                    break;
                case 3:
                    Methods.editProduct(sc,"price");
                    break;
                case 4:
                    Methods.deleteProduct(sc);
                    break;
                case 5:
                    Methods.calTotalPrice();
                    break;
                case 0:
                    System.out.println("thoát.");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("lựa chọn không hợp lệ");
                    break;
            }

        }while(true);
    }
}
