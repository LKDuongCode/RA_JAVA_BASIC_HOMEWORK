package ra.validate;

import ra.bussiness.CustomerBusiness;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CustomerValidator {
    public static String validateCustomerId(Scanner sc) {
        System.out.println("Nhập mã khách hàng (Cxxxx):");
        String regex = "^C\\d\\d\\d\\d$";
        while (true) {
            String input = sc.nextLine().trim();
            if (Pattern.matches(regex, input)) {
                return input;
            }
            System.out.println("Mã khách hàng không hợp lệ");
        }
    }

    public static String validateInputString(Scanner sc, String message, int min, int max) {
        System.out.println(message);
        while (true) {
            String input = sc.nextLine().trim();
            if (input.length() >= min && input.length() <= max) {
                return input;
            }
            System.out.println("Dữ liệu không hợp lệ");
        }
    }

    public static String validatePhoneNumber(Scanner sc) {
        System.out.println("Nhập số điện thoại:");
        String regex = "^0[0-9]{9}$";
        while (true) {
            String input = sc.nextLine().trim();
            if (Pattern.matches(regex, input)) {
                return input;
            }
            System.out.println("Số điện thoại không hợp lệ");
        }
    }

    public static String validateEmail(Scanner sc) {
        System.out.println("Nhập email:");
        String regex = "^[a-z0-9]+@gmail\\.com$";
        while (true) {
            String input = sc.nextLine().trim();

            if (input.matches(regex)) {
                return input;
            }
            System.out.println("Email không hợp lệ");
        }
    }

    public static String validateDate(Scanner sc) {
        System.out.println("Nhập ngày sinh (dd/MM/yyyy):");
        String regex = "^[0-3][0-9]/[0-1][0-9]/(19|20)[0-9]{2}$";
        while (true) {
            String input = sc.nextLine().trim();
            if (Pattern.matches(regex, input)) {
                return input;
            }
            System.out.println("Ngày sinh không hợp lệ");
        }
    }

    public static boolean isCustomerIdUnique(String customerId) {
        for (int i = 0; i < CustomerBusiness.currentCustomerIndex; i++) {
            if (CustomerBusiness.customers[i].getCustomerId().equals(customerId)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPhoneNumberUnique(String phoneNumber) {
        for (int i = 0; i < CustomerBusiness.currentCustomerIndex; i++) {
            if (CustomerBusiness.customers[i].getPhoneNumber().equals(phoneNumber)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEmailUnique(String email) {
        for (int i = 0; i < CustomerBusiness.currentCustomerIndex; i++) {
            if (CustomerBusiness.customers[i].getEmail().equals(email)) {
                return false;
            }
        }
        return true;
    }

}
