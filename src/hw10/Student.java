package hw10;

import java.util.Scanner;

public class Student {
    public enum Gender {
        MALE, FEMALE, OTHER;
    }

     int id;
     String name;
     int age;
     Gender gender;
     String address;
     String phoneNumber;


    public Student() {
        this.id = 0;
        this.name = "default";
        this.age = 0;
        this.gender = Gender.OTHER;
        this.phoneNumber = "default";
    }


    public Student(int id, String name, int age, Gender gender, String address, String phoneNumber){
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }


    public void inputData() {
        Scanner sc = new Scanner(System.in);

        System.out.print("id =  ");
        this.id = Integer.parseInt(sc.nextLine());

        System.out.print("name =  ");
        this.name = sc.nextLine();

        System.out.print("age =  ");
        this.age = Integer.parseInt(sc.nextLine());

        System.out.print("gender (1 - MALE, 2 - FEMALE, 3 - OTHER): ");
        int genderChoice = Integer.parseInt(sc.nextLine());

        if (genderChoice == 1) {
            this.gender = Gender.MALE;
        } else if (genderChoice == 2) {
            this.gender = Gender.FEMALE;
        } else if (genderChoice == 3) {
            this.gender = Gender.OTHER;
        } else {
            System.out.println("Giá trị không hợp lệ, mặc định giới tính là OTHER.");
            this.gender = Gender.OTHER;
        }

        System.out.print("address = ");
        this.address = sc.nextLine();

        System.out.print("phone = ");
        this.phoneNumber = sc.nextLine();
    }


    public void displayData() {
        System.out.println("\n===== Thông tin học sinh =====");
        System.out.println("Mã HS: " + id);
        System.out.println("Tên HS: " + name);
        System.out.println("Tuổi: " + age);
        System.out.println("Giới tính: " + gender);
        System.out.println("Địa chỉ: " + address);
        System.out.println("Số điện thoại: " + phoneNumber);
    }
}
