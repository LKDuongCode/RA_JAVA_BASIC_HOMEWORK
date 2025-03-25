package hw10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            Methods.printMenu();
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice){
                case 1:
                    Methods.addEmployee(sc);
                    break;
                case 2:
                    Methods.displayAll();
                    break;
                case 3:
                    System.out.println(Methods.calTotalSalary());
                    break;
                case 4:
                    System.out.println(Methods.calAverageSalary());
                    break;
                case 5:
                    Methods.searchEmployee("high_salary");
                    break;
                case 6:
                    Methods.searchEmployee("low_salary");
                    break;
                case 0:
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("lựa chọn không hợp lệ");
                    break;
            }
        }while(true);
    }
}
