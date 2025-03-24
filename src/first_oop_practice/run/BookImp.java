package first_oop_practice.run;

import first_oop_practice.services.Utils;

import java.util.Scanner;

public class BookImp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            Utils.printMenu();
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice){
                case 1:
                    System.out.println("nhập số lượng sách muốn thêm.");
                    int n = Integer.parseInt(sc.nextLine());
                    if(n <=0 ){
                        System.out.println("số lượng không hợp lệ");
                        break;
                    }

                    for(int i = 0; i < n; i++) {
                        System.out.println("sách thứ " + i+1);
                        Utils.addBook(sc);
                    }
                    break;
                case 2:
                    System.out.println("tính toán lãi đã tích hợp sẵn trong case 1 khi thêm.");
                    break;
                case 3:
                    Utils.printAllBook();
                    break;
                case 4:
                    Utils.sortBook("eprice_asc");
                    break;
                case 5:
                    Utils.sortBook("interest_desc");
                case 6:
                    Utils.searchBook("name",sc);
                    break;
                case 7:
                    Utils.countBooksByYear();
                    break;
                case 8:
                    Utils.countBooksByAuthor();
                    break;
                case 9:
                    System.out.println("thoát");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("không hợp lệ");
                    break;
            }

        }while(true);
    }
}
