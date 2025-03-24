package redo_hackathon.myHackathon.run;

import redo_hackathon.myHackathon.services.CustomerBusiness;

import java.util.Scanner;

public class CustomerApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            CustomerBusiness.printMainMenu();

            int mainChoice = Integer.parseInt(sc.nextLine());

            switch (mainChoice) {
                case 1:
                    CustomerBusiness.displayCustomers();
                    break;
                case 2:
                    CustomerBusiness.addCustomer(sc);
                    break;
                case 3:
                    CustomerBusiness.updateCustomer(sc);
                    break;
                case 4:
                    CustomerBusiness.deleteCustomer(sc);
                    break;
                case 5:
                    CustomerBusiness.searchCustomer(sc);
                    break;
                case 6:
                    CustomerBusiness.sortCustomers(sc);
                    break;
                case 0:
                    System.out.println("Thoát chương trình!");
                    sc.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }
}