package redo_hackathon.hackathon01.services;

import redo_hackathon.hackathon01.entity.Student;
import redo_hackathon.myHackathon.services.CustomerBusiness;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator {
    public static String validateId(Scanner sc) {
        String regex = "^SV\\d{5}$";

        while (true) {
            String input = sc.nextLine().trim();

            if (!Pattern.matches(regex, input)) {
                System.out.println("Mã không hợp lệ!");
                continue;
            }

            if (!isCustomerIdUnique(input)) {
                System.out.println("Mã đã tồn tại! Nhập mã khác.");
                continue;
            }

            return input;
        }
    }

    public static boolean isCustomerIdUnique(String id) {
        for (Student student : StudentBusiness.students) {
            if (student.getStudentId().equals(id)) {
                return false;
            }
        }
        return true;
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

    public static String validatePhoneNumber(Scanner sc) {
        String regex = "^0[0-9]{9}$";

        while (true) {
            String input = sc.nextLine().trim();

            if (!Pattern.matches(regex, input)) {
                System.out.println("Số điện thoại không hợp lệ");
                continue;
            }

            if (!isPhoneNumberUnique(input)) {
                System.out.println("Số đã tồn tại");
                continue;
            }
            return input;
        }
    }

    public static boolean isPhoneNumberUnique(String phoneNumber) {
        for (Student student : StudentBusiness.students) {
            if (student.getPhoneNumber().equals(phoneNumber)) {
                return false;
            }
        }
        return true;
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

    public static String validateEmail(Scanner sc) {
        String regex = "^\\w+@gmail\\.com$";
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

    public static boolean isEmailUnique(String email) {
        for (Student student : StudentBusiness.students) {
            if (student.getEmail().equals(email)) {
                return false;
            }
        }
        return true;
    }

    public static float validateGPA (Scanner sc){
        while (true){
            float input = Float.parseFloat(sc.nextLine());

            if(input <0 ){
                System.out.println("gpa cần lớn hơn 0");
                continue;
            }
            return input;
        }
    }

    public static byte validateStatus (Scanner sc){
        while(true){
            byte input = Byte.parseByte(sc.nextLine());
            if(input == (byte) 1 || input == (byte) 2 || input == (byte) 3){
                return input;
            }
            System.out.println("status không hợp lệ");
        }
    }
}
