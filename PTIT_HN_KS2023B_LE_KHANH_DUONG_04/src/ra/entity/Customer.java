package ra.entity;

import ra.validate.CustomerValidator;

import java.util.Scanner;

public class Customer implements IApp {
    // attributes --------------------------------------------------------------
    private String customerId;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private boolean gender;
    private String address;
    private String phoneNumber;
    private String email;
    private String customerType;

    public Customer() {
    }

    // setter getter ---------------------------------------------------------------------
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Scanner sc) {
        do {
            this.customerId = CustomerValidator.validateCustomerId(sc);
            if (!CustomerValidator.isCustomerIdUnique(this.customerId)) {
                System.out.println(" ID đã tồn tại");
            }
        } while (!CustomerValidator.isCustomerIdUnique(this.customerId));
    }

    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(Scanner sc) {
        this.firstName = CustomerValidator.validateInputString(sc, "Nhập tên khách hàng:", 1, 50);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(Scanner sc) {
        this.lastName = CustomerValidator.validateInputString(sc, "Nhập họ khách hàng:", 1, 30);
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Scanner sc) {
        this.dateOfBirth = CustomerValidator.validateDate(sc);
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(Scanner sc) {
        System.out.println("Nhập giới tính (true - Nam| false - Nữ):");
        while (true) {
            if (sc.hasNextBoolean()) {
                this.gender = sc.nextBoolean();
                sc.nextLine();
                return;
            } else {
                System.out.println("Không hợp lệ");
                sc.next();
            }
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(Scanner sc) {
        this.address = CustomerValidator.validateInputString(sc, "Nhập địa chỉ:", 1, 255);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(Scanner sc) {
        do {
            this.email = CustomerValidator.validateEmail(sc);
            if (!CustomerValidator.isEmailUnique(this.email)) {
                System.out.println("Email đã tồn tạo");
            }
        } while (!CustomerValidator.isEmailUnique(this.email));
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Scanner sc) {
        do {
            this.phoneNumber = CustomerValidator.validatePhoneNumber(sc);
            if (!CustomerValidator.isPhoneNumberUnique(this.phoneNumber)) {
                System.out.println("Số đã tồn tại");
            }
        } while (!CustomerValidator.isPhoneNumberUnique(this.phoneNumber));
    }

    public String getCustomerType() {
        return customerType;
    }



    public void setCustomerType(Scanner sc) {
        this.customerType = CustomerValidator.validateInputString(sc, "Nhập loại khách hàng:", 1, 50);
    }


    // method---------------------------------------------------------------------------------
    @Override
    public void inputData(Scanner sc) {
        setCustomerId(sc);
        setLastName(sc);
        setFirstName(sc);
        setDateOfBirth(sc);
        setGender(sc);
        setAddress(sc);
        setPhoneNumber(sc);
        setEmail(sc);
        setCustomerType(sc);
    }

    @Override
    public void displayData() {
        System.out.println("ID: " + this.customerId);
        System.out.println("fullname: " + this.lastName + " " + this.firstName);
        System.out.println("date of birth: " + this.dateOfBirth);
        System.out.println("gender: " + (this.gender ? "Nam" : "Nữ"));
        System.out.println("address: " + this.address);
        System.out.println("phone: " + this.phoneNumber);
        System.out.println("email: " + this.email);
        System.out.println("type: " + this.customerType);
    }

}
