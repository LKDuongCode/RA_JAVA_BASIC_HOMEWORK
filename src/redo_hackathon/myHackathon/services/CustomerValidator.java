package redo_hackathon.myHackathon.services;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CustomerValidator {
    public static String validateCustomerId(Scanner sc) {
        String regex = "^C\\d{4}$";

        while (true) {
            String input = sc.nextLine().trim();

            if (!Pattern.matches(regex, input)) {
                System.out.println("Mã khách hàng không hợp lệ!");
                continue;
            }

            if (!isCustomerIdUnique(input)) {
                System.out.println("Mã khách hàng đã tồn tại! Nhập mã khác.");
                continue;
            }

            return input;
        }
    }

    public static String validateInputString(Scanner sc, String message, int min, int max,String err) {
        System.out.println(message);
        while (true) {
            String input = sc.nextLine().trim();
            if (input.length() >= min && input.length() <= max) {
                return input;
            }
            System.out.println(err);
        }
    }

    public static String validatePhoneNumber(Scanner sc) {
        String regex = "^0[0-9]{9}$";

        while (true) {
            String input = sc.nextLine().trim();

            if (!Pattern.matches(regex, input)) {
                System.out.println("Số điện thoại không hợp lệ");
               continue;
            }

            if (!CustomerValidator.isPhoneNumberUnique(input)) {
                System.out.println("Số đã tồn tại");
                continue;
            }
            return input;
        }
    }

    public static String validateEmail(Scanner sc) {
        String regex = "^[a-z0-9]+@gmail\\.com$";
        while (true) {
            String input = sc.nextLine().trim();

            if (!input.matches(regex)) {
                System.out.println("Email không hợp lệ");
                continue;
            }

            if (!isEmailUnique(input)) {
                System.out.println("Email đã tồn tạo");
                continue;
            }
            return input;
        }
    }

    public static String validateDate(Scanner sc) {
        String regex = "^[0-3][0-9]/[0-1][0-9]/(19|20)[0-9]{2}$";
        while (true) {
            String input = sc.nextLine().trim();
            if (Pattern.matches(regex, input)) {
                return input;
            }
            System.out.println("Ngày sinh không hợp lệ");
        }
    }

    public static boolean validateGender(Scanner sc) {
        while (true) {
            System.out.print("Nhập giới tính (true/false): ");
            String input = sc.nextLine().trim().toLowerCase();

            if (input.equals("true") || input.equals("false")) {
                return Boolean.parseBoolean(input);
            } else {
                System.out.println("Không hợp lệ. Vui lòng nhập 'true' hoặc 'false'.");
            }
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