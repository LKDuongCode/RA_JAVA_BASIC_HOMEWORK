package redo_hackathon.myHackathon.services;

import redo_hackathon.myHackathon.entity.Customer;

import java.util.Scanner;

public class CustomerBusiness {
    static final int MAX_CUSTOMER = 100;
    public static Customer[] customers = new Customer[MAX_CUSTOMER];
    public static int currentCustomerIndex = 0;

    public static void printMainMenu (){
        System.out.println("----------Customer Menu----------");
        System.out.println("1. Hiển thị danh sách các khách hàng");
        System.out.println("2. Thêm mới khách hàng");
        System.out.println("3. Chỉnh sửa thông tin khách hàng");
        System.out.println("4. Xóa khách hàng");
        System.out.println("5. Tìm kiếm khách hàng");
        System.out.println("6. Sắp xếp danh sách khách hàng");
        System.out.println("0. Thoát chương trình");
        System.out.print("Lựa chọn của bạn: ");
    }

    // case 1
    public static void displayCustomers() {
        if (currentCustomerIndex == 0) {
            System.out.println("Danh sách trống");
        }else {
            for (int i = 0; i < currentCustomerIndex; i++) {
                System.out.println("customer " + (i+1) + "----------------");
                customers[i].displayData();
                System.out.println("---------------------");
            }
        }
    }



    // case 2
    public static void addCustomer(Scanner sc) {
        if (currentCustomerIndex >= MAX_CUSTOMER) {
            System.out.println("Danh sách đẩy!");
            return;
        }

        System.out.println("Nhập số khách hàng cần thêm:");
        int numCustomers = Integer.parseInt(sc.nextLine());

        if(numCustomers <= 0){
            System.out.println("Số lượng không hợp lệ!");
        }else{
            for (int i = 0; i < numCustomers; i++) {

                System.out.println("Nhập mã khách hàng (Cxxxx):");
                String id = CustomerValidator.validateCustomerId(sc);

                String lastName = CustomerValidator.validateInputString(sc, "Nhập họ khách hàng:", 1, 30,"Họ khách hàng không hợp lệ.");

                String firstName = CustomerValidator.validateInputString(sc, "Nhập tên khách hàng:", 1, 50,"Tên không hợp lệ");

                System.out.println("Nhập ngày sinh (dd/MM/yyyy):");
                String dateOfBirth = CustomerValidator.validateDate(sc);

                System.out.println("Nhập giới tính (true - Nam| false - Nữ):");
                boolean gender = CustomerValidator.validateGender(sc);

                String address = CustomerValidator.validateInputString(sc, "Nhập địa chỉ:", 1, 255, "địa chỉ không hợp lệ");

                System.out.println("Nhập email:");
                String email = CustomerValidator.validateEmail(sc);

                System.out.println("Nhập số điện thoại:");
                String phone = CustomerValidator.validatePhoneNumber(sc);

                String customerType = CustomerValidator.validateInputString(sc, "Nhập loại khách hàng:", 1, 50, "loại khách hàng không hợp lệ.");

                Customer newCustomer = new Customer(id,firstName,lastName,dateOfBirth,gender,address,phone,email,customerType);
                customers[currentCustomerIndex++] = newCustomer;
            }
            System.out.println("Thêm thành công!");
        }
    }

    //case 3
    public static void updateCustomer(Scanner sc) {
        if (currentCustomerIndex == 0) {
            System.out.println("Danh sách khách hàng trống");
            return;
        }

        String id = sc.nextLine();

        for (int i = 0; i < currentCustomerIndex; i++) {
            if (customers[i].getCustomerId().equals(id)) {
                while (true) {
                    System.out.println("\nChỉnh sửa thông tin khách hàng -----");
                    System.out.println("1. lastname: " + customers[i].getLastName());
                    System.out.println("2. firstname: " + customers[i].getFirstName());
                    System.out.println("3. date of birth: " + customers[i].getDateOfBirth());
                    System.out.println("4. gender: " + (customers[i].isGender() ? "Nam" : "Nữ"));
                    System.out.println("5. address: " + customers[i].getAddress());
                    System.out.println("6. phone: " + customers[i].getPhoneNumber());
                    System.out.println("7. email: " + customers[i].getEmail());
                    System.out.println("8. type: " + customers[i].getCustomerType());
                    System.out.println("0. Quay lại menu chính ");
                    System.out.print("Chọn thông tin cần sửa: ");

                    int choice = Integer.parseInt(sc.nextLine());

                    switch (choice) {
                        case 1:
                            String lastName = CustomerValidator.validateInputString(sc, "Nhập họ khách hàng:", 1, 30,"Họ khách hàng không hợp lệ.");
                            customers[i].setLastName(lastName);
                            break;
                        case 2:
                            String firstName = CustomerValidator.validateInputString(sc, "Nhập tên khách hàng:", 1, 50,"Tên không hợp lệ");
                            customers[i].setFirstName(firstName);
                            break;
                        case 3:
                            System.out.println("Nhập ngày sinh (dd/MM/yyyy):");
                            String dateOfBirth = CustomerValidator.validateDate(sc);
                            customers[i].setDateOfBirth(dateOfBirth);
                            break;
                        case 4:
                            System.out.println("Nhập giới tính (true - Nam| false - Nữ):");
                            boolean gender = CustomerValidator.validateGender(sc);
                            customers[i].setGender(gender);
                            break;
                        case 5:
                            String address = CustomerValidator.validateInputString(sc, "Nhập địa chỉ:", 1, 255, "địa chỉ không hợp lệ");
                            customers[i].setAddress(address);
                            break;
                        case 6:
                            System.out.println("Nhập số điện thoại:");
                            String phone = CustomerValidator.validatePhoneNumber(sc);
                            customers[i].setPhoneNumber(phone);
                            break;
                        case 7:
                            System.out.println("Nhập email:");
                            String email = CustomerValidator.validateEmail(sc);
                            customers[i].setEmail(email);
                            break;
                        case 8:
                            String customerType = CustomerValidator.validateInputString(sc, "Nhập loại khách hàng:", 1, 50, "loại khách hàng không hợp lệ.");
                            customers[i].setCustomerType(customerType);
                            break;
                        case 0:
                            System.out.println("Quay lại.");
                            return;
                        default:
                            System.out.println("Lựa chọn không hợp lệ");
                    }

                }
            }
        }
        System.out.println("Không tìm thấy khách hàng!");
    }

    //case 4
    public static void deleteCustomer(Scanner sc) {
        if (currentCustomerIndex == 0) {
            System.out.println("Danh sácg trống");
            return;
        }

        String id = sc.nextLine();

        for (int i = 0; i < currentCustomerIndex; i++) {
            if (customers[i].getCustomerId().equals(id)) {
                customers[i].displayData();
                System.out.print("Bạn có chắc chắn muốn xóa? (Y/N): ");
                String confirm = sc.nextLine().trim().toUpperCase();

                if (confirm.equals("Y")) {
                    for (int j = i; j < currentCustomerIndex - 1; j++) {
                        customers[j] = customers[j + 1];
                    }

                    customers[--currentCustomerIndex] = null;
                    System.out.println("Xóathành công!");
                } else {
                    System.out.println("Hủy xóa khách hàng.");
                }
                return;
            }
        }

        System.out.println("Không tìm thấy ID: " + id);
    }


    // case 5
    public static void searchCustomer(Scanner sc) {
        while (true) {
            System.out.println("1. Tìm kiếm theo tên khách hàng");
            System.out.println("2. Tìm kiếm theo loại khách hàng");
            System.out.println("3. Tìm kiếm theo số điện thoại");
            System.out.println("0. Quay lại");
            System.out.print("Chọn: ");

            int choice = Integer.parseInt(sc.nextLine());
            boolean found = false;

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên khách hàng: ");
                    String name = sc.nextLine();
                    for (int i = 0; i < currentCustomerIndex; i++) {
                        if (customers[i].getFirstName().equalsIgnoreCase(name)) {
                            customers[i].displayData();
                            found = true;
                        }
                    }
                    break;
                case 2:
                    System.out.print("Nhập loại khách hàng: ");
                    String type = sc.nextLine();
                    for (int i = 0; i < currentCustomerIndex; i++) {
                        if (customers[i].getCustomerType().equalsIgnoreCase(type)) {
                            customers[i].displayData();
                            found = true;
                        }
                    }
                    break;
                case 3:
                    System.out.print("Nhập số điện thoại: ");
                    String phone = sc.nextLine();
                    for (int i = 0; i < currentCustomerIndex; i++) {
                        if (customers[i].getPhoneNumber().equals(phone)) {
                            customers[i].displayData();
                            found = true;
                        }
                    }
                    break;
                case 0:
                    System.out.println("Quay lại");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }

            if (!found) {
                System.out.println("Không tìm thấy");
            }
        }
    }

    // case 6
    public static void sortCustomers(Scanner sc) {
        while (true) {
            System.out.println("1. Sắp xếp theo tên ");
            System.out.println("2. Sắp xếp theo năm sinh");
            System.out.println("0. Quay lại ");
            System.out.print("Chọn: ");

            int choice= Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    for (int i = 0; i < currentCustomerIndex - 1; i++) {
                        for (int j = 0; j < currentCustomerIndex - i - 1; j++) {
                            if (customers[j].getFirstName().compareTo(customers[j + 1].getFirstName()) > 0) {
                                Customer temp = customers[j];
                                customers[j] = customers[j + 1];
                                customers[j + 1] = temp;
                            }
                        }
                    }
                    break;

                case 2:
                    for (int i = 0; i < currentCustomerIndex - 1; i++) {
                        for (int j = 0; j < currentCustomerIndex - i - 1; j++) {
                            int year1 = extractYear(customers[j].getDateOfBirth());
                            int year2 = extractYear(customers[j + 1].getDateOfBirth());

                            if (year1 > year2) {
                                Customer temp = customers[j];
                                customers[j] = customers[j + 1];
                                customers[j + 1] = temp;
                            }
                        }
                    }
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }}

    public static int extractYear(String dateOfBirth) {
        String[] parts = dateOfBirth.split("/");
        return Integer.parseInt(parts[2]);
    }

}