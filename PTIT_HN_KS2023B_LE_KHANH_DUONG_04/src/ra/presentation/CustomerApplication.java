package ra.presentation;

import java.util.Scanner;
import ra.bussiness.CustomerBusiness;

public class CustomerApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("----------Customer Menu----------");
            System.out.println("1. Hiển thị danh sách các khách hàng");
            System.out.println("2. Thêm mới khách hàng");
            System.out.println("3. Chỉnh sửa thông tin khách hàng");
            System.out.println("4. Xóa khách hàng");
            System.out.println("5. Tìm kiếm khách hàng");
            System.out.println("6. Sắp xếp danh sách khách hàng");
            System.out.println("0. Thoát chương trình");
            System.out.print("Lựa chọn của bạn: ");

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
