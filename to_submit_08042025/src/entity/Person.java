package entity;

import entity.enums.Sex;
import utils.InputUtils;
import utils.ValidatePersonUtils;

import java.util.Scanner;

public class Person implements IApp{
    private String name;
    private int age;
    private String address;
    private String phone;
    private String email;
    private Sex sex;

    public Person() {
    }

    public Person(String name, int age, String address, String phone, String email, Sex sex) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public void inputData (Scanner sc){
        System.out.println("nhập tên: ");
        setName(InputUtils.validateString(sc,"tên",5,150));

        System.out.println("nhập tuổi:");
        setAge(ValidatePersonUtils.validateAge(sc));


        System.out.println("nhập địa chỉ:");
        setAddress(InputUtils.validateString(sc,"địa chỉ",5,100));

        setSex(InputUtils.validateEnum(sc, "Nhập giới tính:", Sex.class));

    }

    @Override
    public String toString() {
        return " |name: " + this.name
                + " |age: " + this.age
                + " |address: " + this.address
                + " |phone: " + this.phone
                + " |email: " + this.email
                + " |sex: " + this.sex;
    }
}
