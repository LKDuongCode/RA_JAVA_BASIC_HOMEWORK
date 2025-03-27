package checkingHomeworks.business;

import checkingHomeworks.entity.Customer;
import checkingHomeworks.presentation.ShopManagement;

import java.util.Scanner;

public class CustomerBusiness {
    public static void addCustomer(Scanner sc) {
        System.out.println("Thêm khách mới:");
        Customer newCustomer = new Customer();
        newCustomer.inputData(sc);
        ShopManagement.customers.add(newCustomer);
        System.out.println("Thêm thành công");
    }

    public static void displayCustomers() {
        if (ShopManagement.customers.isEmpty()) {
            System.out.println("Danh sách khách hàng đang rỗng!");
            return;
        }

        System.out.println("Danh sách khách hàng:");
        ShopManagement.customers.forEach(System.out::println);
    }
}

